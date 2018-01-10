package wromaciej.hvac_sim.thermo;
import thermoCP.*;
import wromaciej.hvac_sim.thermo.fluids.data.SubstanceName;
import wromaciej.hvac_sim.thermo.fluids.data.SubstanceParameter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Thermodynamic data for 09-01-2018
 */
// REVIEW sformatuj plik
public final class ThermoCPAdapter {

    public static final double RO=1.18; //gestosc powietrza w war standardowych kg/m3
    // REVIEW: ta stała może być private - BTW IntelliJ podświetla ci to pole na pomarańczowo - to wskazówka, że
    // można to poprawić, będąc w tym polu po wciśnięciu alt enter pokaże ci wskazówki co można poprawić automatycznie
    public static final double T_ABS=273.15;

    // REVIEW: ta klasa ma za dużo odpowiedzialności - poza konwersją argumentów łączy też stringi po to by je
    // wyświetlić w Application. Zdecydowanie lepiej umieścić tę i kolejną metodę w Application lub jakiejś innej
    // klasie typu util
    public static String getSubstancesList(){
        String list=new String();
        for(SubstanceName substanceName : SubstanceName.values()){
            // REVIEW równie dobrze mógłbyś zrobić list += substanceName.enumToString()+System.lineSeparator()
            list=list+substanceName.enumToString()+System.lineSeparator();
        }
        // REVIEW: znacznie lepsza alternatywa niz samodzielne lepienie stringów(ponadto:

        List<String> substanceNames = Arrays.stream(SubstanceName.values())
                .map(SubstanceName::enumToString)
                .collect(toList());
        list = String.join(System.lineSeparator(), substanceNames);

        return list;
    }

    public static String getParametersList(){
        // REVIEW: jeżeli już to = "" wystarcza zamiast new String ;) ale i tak polecam zabieg jak zaproponowałem
        // wyżej - choćby dla ćwiczeń
        String list=new String();
        for(SubstanceParameter substanceParameter : SubstanceParameter.values()){
            list=list+substanceParameter.enumToString()+" - "+substanceParameter.toString() +System.lineSeparator();
        }
        return list;
    }

    /**
     * Parameters ofr thermoCP library
     */
    public static class ThermoCPParameterPoint{
        public String substanceName;
        public String substanceParameter;
        public double value;

        public ThermoCPParameterPoint(String substanceName, String parameterName, double value) {
            this.substanceName = substanceName;
            this.substanceParameter = parameterName;
            this.value = value;
        }
    }

    public static class StandardParameterPoint{
        public SubstanceName substanceName;
        public SubstanceParameter substanceParameter;
        public double value;

        public StandardParameterPoint(SubstanceName substanceName, SubstanceParameter parameterName, double value) {
            this.substanceName = substanceName;
            this.substanceParameter = parameterName;
            this.value = value;
        }
    }

    // REVIEW: po co te 4 metody, skoro nie robią nic więcej co robi SubstanceParameter/Name? :)
    /**
     * Conversion of enum to thermoCP library parameter string name
     */
    public static String substanceParameterToString(SubstanceParameter parameter){
        return parameter.enumToString();
    }
    /**
     * Conversion of string parameter to enum
     */
    public static SubstanceParameter stringToSubstanceParameter(String parameter){
        return SubstanceParameter.stringToEnum(parameter);
    }
    /**
     * Conversion of enum to thermoCP library fluid name
     */
    public static String substanceNameToString(SubstanceName name){
        return name.enumToString();
    }
    /**
     * Conversion of fluid name to enum
     */
    public static SubstanceName stringToSubstanceName(String name){
        return SubstanceName.stringToEnum(name);
    }

    public static double pGaugePaTokPaAbs(double pGaugePa){
        return (pGaugePa/1000)+100;
    }

    /**
     * Finding parameter for MoistAir

     */
    public static double findAirParameter(SubstanceParameter parameterWanted, SubstanceParameter parameter1, double value1, SubstanceParameter parameter2, double value2, double pGaugePa){
        //calculate in thermoCP units
        double r= CoolProp.HAProps(
                substanceParameterToString(parameterWanted),
                substanceParameterToString(parameter1),
                convertParameterToThermoCP(SubstanceName.MOIST_AIR,parameter1,value1).value,
                substanceParameterToString(parameter2),
                convertParameterToThermoCP(SubstanceName.MOIST_AIR,parameter2,value2).value,
                substanceParameterToString(SubstanceParameter.PRESSURE),
                pGaugePaTokPaAbs(pGaugePa));
        //System.out.println(parameterWanted.enumToString()+" z coolPropa: "+r+" dla p=");
        //convert units to standards
        r=convertParameterFromThermoCP(
                substanceNameToString(SubstanceName.MOIST_AIR),
                substanceParameterToString(parameterWanted),r).value;
        return r;

    }

    //szukanie parametru przez CoolPack dla reszty czynnikow
    public static double findParameter(SubstanceParameter parameterWanted, SubstanceName substanceName, SubstanceParameter parameter1, double value1, SubstanceParameter parameter2, double value2) {
        //calculate in thermoCP units
        double r=0;
        if (substanceName!=SubstanceName.MOIST_AIR) {
            r = CoolProp.PropsSI(
                    substanceParameterToString(parameterWanted),
                    substanceParameterToString(parameter1),
                    convertParameterToThermoCP(substanceName, parameter1, value1).value,
                    substanceParameterToString(parameter2),
                    convertParameterToThermoCP(substanceName, parameter2, value2).value,
                    substanceNameToString(substanceName));
            //convert units to standards
            r = convertParameterFromThermoCP(
                    substanceNameToString(substanceName),
                    substanceParameterToString(parameterWanted), r).value;
        }
        else{
            r=findAirParameter(parameterWanted,parameter1,value1,parameter2,value2,0);
        }

        return r;
    }






// REVIEW - nie ma sensu komentować kodu - mozesz go bezpiecznie usunąć, zawsze w git podejrzysz go jeżeli będziesz
// chciał zobaczyć co tam kiedyś było

    /*
        try {
            if (convert(fluidName, null, 0).fluidName.equals("a")) {
                r = findAirParameter(wanted, p1, v1, p2, v2, 0); //jezeli to powietrze to licz jak dla powietrza
            } else {
                if (p1.equals("sh") || p1.equals("sc") || p2.equals("sh") || p2.equals("sc")) {
                    if (p1.equals("sh")) {
                        r = CoolProp.PropsSI("T", "Q", 1, p2, v2, fluidName); //r to temperatura nasycenia
                        r2 = CoolProp.PropsSI("P", "Q", 1, p2, v2, fluidName); //r2 to cisnienie nasycenia
                        //jesli przegrzanie>0
                        r = getR(wanted, fluidName, v1, v1, r, r2);
                    } else if (p2.equals("sh")) {
                        r = CoolProp.PropsSI("T", "Q", 1, p1, v1, fluidName); //r to temperatura nasycenia
                        r2 = CoolProp.PropsSI("P", "Q", 1, p1, v1, fluidName); //r2 to cisnienie nasycenia
                        //jesli przegrzanie>0
                        r = getR(wanted, fluidName, v1, v2, r, r2);
                    } else if (p1.equals("sc")) {
                        r = CoolProp.PropsSI("T", "Q", 0, p2, v2, fluidName); //r to temperatura nasycenia
                        r2 = CoolProp.PropsSI("P", "Q", 0, p2, v2, fluidName); //r2 to cisnienie nasycenia
                        //jesli przegrzanie>0
                        if (v1 > 0)
                            r = CoolProp.PropsSI(wanted, "T", r - v1, "P", r2, fluidName); //r to parametr poszukiwany
                        else r = CoolProp.PropsSI(wanted, "Q", 0, "P", r2, fluidName);
                    } else if (p2.equals("sc")) {
                        r = CoolProp.PropsSI("T", "Q", 0, p1, v1, fluidName); //r to temperatura nasycenia
                        r2 = CoolProp.PropsSI("P", "Q", 0, p1, v1, fluidName); //r2 to cisnienie nasycenia
                        //jesli przegrzanie>0
                        if (v1 > 0)
                            r = CoolProp.PropsSI(wanted, "T", r - v2, "P", r2, fluidName); //r to parametr poszukiwany
                        else r = CoolProp.PropsSI(wanted, "Q", 0, "P", r2, fluidName);
                    }

                } else
                    r = CoolProp.PropsSI(wanted, p1, v1, p2, v2, fluidName); //jezeli nie jest to dochlodzenie ani przegrzanie to licz normalnie
            }

        }
        catch(RuntimeException exception) {
            fluidName="water";
            p1="T";
            v1=10+T_ABS;
            p2="P";
            v2=100;
            r=CoolProp.PropsSI(wanted, p1, v1, p2, v2, fluidName); //jesli nie znaleziono plynu to uznaj ze jest to woda o temp 10C
        }

        r = calculateRBasingOnWantedParameter(wanted, r);
        return r;

    }*/


    private static double getR(String wanted, String fluidName, double v1, double v2, double r, double r2) {
        if (v1 > 0)
            r = CoolProp.PropsSI(wanted, "T", r + v2, "P", r2, fluidName); //r to parametr poszukiwany
        else r = CoolProp.PropsSI(wanted, "Q", 1, "P", r2, fluidName);
        return r;
    }


    /**
     * Conversion from standard units to thermoCP units
     */
    public static ThermoCPParameterPoint convertParameterToThermoCP(SubstanceName substanceName, SubstanceParameter substanceParameter, double value){
        double valueTemp=value;

        if (substanceName==SubstanceName.MOIST_AIR){
            // REVIEW: praca domowa na później - poczytaj o wzorcu projektowym strategy - i pomyśl jak można go użyć,
            // by pozbyć się tego długiego switch-case
            switch (substanceParameter){
                case TEMPERATURE: valueTemp=valueTemp+T_ABS; break;
                case PRESSURE: valueTemp=valueTemp*100000; break;//valueTemp=(valueTemp/1000)+100; break;
                case TEMPERATURE_WETBULB: valueTemp=valueTemp+T_ABS; break;
                case TEMPERATURE_DEWPOINT: valueTemp=valueTemp+T_ABS; break;
            }
        }
        else{
            switch (substanceParameter){
                case TEMPERATURE: valueTemp=valueTemp+T_ABS; break;
                case PRESSURE: valueTemp=valueTemp*100000; break;
                case ENTHALPY: valueTemp=valueTemp*1000; break;
                case ENTROPY: valueTemp=valueTemp*1000; break;
                case HEAT_CAPACITY: valueTemp=valueTemp*1000; break;
            }
        }
        // REVIEW nie ma potrzeby inicjalizować zmienną i ją potem zwracać w 2 liniach - zrób to w jednej
        ThermoCPParameterPoint paremeterPoint=new ThermoCPParameterPoint(substanceName.enumToString(),substanceParameter.enumToString(),valueTemp);
        return paremeterPoint;
    }

    /**
     * Conversion from thermoCP units to standard units
     */
    public static StandardParameterPoint convertParameterFromThermoCP(String substanceName, String substanceParameter, double value){
        double valueTemp=value;

        if (stringToSubstanceName(substanceName)==SubstanceName.MOIST_AIR){
            switch (stringToSubstanceParameter(substanceParameter)){
                // REVIEW można valueTemp-=T_ABS
                case TEMPERATURE: valueTemp=valueTemp-T_ABS; break;
                case PRESSURE: valueTemp=valueTemp/100000; break;//valueTemp=(valueTemp*1000)-100; break;
                // REVIEW: dla 3 case masz taki sam kod, można wtedy zrobić:
                /*
                case TEMPERATURE:
                case TEMPERATURE_WETBULB:
                case TEMPERATURE_DEWPOINT:
                    valueTemp=valueTemp-T_ABS; break;
                 */
                case TEMPERATURE_WETBULB: valueTemp=valueTemp-T_ABS; break;
                case TEMPERATURE_DEWPOINT: valueTemp=valueTemp-T_ABS; break;
            }
        }
        else{
            switch (stringToSubstanceParameter(substanceParameter)){
                case TEMPERATURE: valueTemp=valueTemp-T_ABS; break;
                case PRESSURE: valueTemp=valueTemp/100000; break;
                case ENTHALPY: valueTemp=valueTemp/1000; break;
                case ENTROPY: valueTemp=valueTemp/1000; break;
                case HEAT_CAPACITY: valueTemp=valueTemp/1000; break;
            }
        }
        StandardParameterPoint paremeterPoint=new StandardParameterPoint(stringToSubstanceName(substanceName),stringToSubstanceParameter(substanceParameter),valueTemp);
        return paremeterPoint;
    }

}
