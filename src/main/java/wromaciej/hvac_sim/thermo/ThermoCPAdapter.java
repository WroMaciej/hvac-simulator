package wromaciej.hvac_sim.thermo;
import thermoCP.*;
import wromaciej.hvac_sim.thermo.fluids.data.SubstanceName;
import wromaciej.hvac_sim.thermo.fluids.data.SubstanceParameterType;

/**
 * Thermodynamic data for 09-01-2018
 */
public final class ThermoCPAdapter {

    public static final double RO=1.18; //gestosc powietrza w war standardowych kg/m3
    public static final double T_ABS=273.15;

    public static String getSubstancesList(){
        String list=new String();
        for(SubstanceName substanceName : SubstanceName.values()){
            list=list+substanceName.enumToString()+System.lineSeparator();
        }
        return list;
    }

    public static String getParametersList(){
        String list=new String();
        for(SubstanceParameterType substanceParameterType : SubstanceParameterType.values()){
            list=list+substanceParameterType.enumToString()+" - "+substanceParameterType.toString() +System.lineSeparator();
        }
        return list;
    }

    /**
     * Parameters ofr thermoCP library
     */
    public static class ThermoCPParameterPoint{
        public String substanceName;
        public String substanceParameterType;
        public double value;

        public ThermoCPParameterPoint(String substanceName, String parameterName, double value) {
            this.substanceName = substanceName;
            this.substanceParameterType = parameterName;
            this.value = value;
        }
    }

    public static class StandardParameterPoint{
        public SubstanceName substanceName;
        public SubstanceParameterType substanceParameterType;
        public double value;

        public StandardParameterPoint(SubstanceName substanceName, SubstanceParameterType parameterName, double value) {
            this.substanceName = substanceName;
            this.substanceParameterType = parameterName;
            this.value = value;
        }
    }

    /**
     * Conversion of enum to thermoCP library parameter string name
     */
    public static String substanceParameterTypeToString(SubstanceParameterType parameter){
        return parameter.enumToString();
    }
    /**
     * Conversion of string parameter to enum
     */
    public static SubstanceParameterType stringToSubstanceParameterType(String parameter){
        return SubstanceParameterType.stringToEnum(parameter);
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
    public static double findAirParameter(SubstanceParameterType parameterWanted, SubstanceParameterType parameter1, double value1, SubstanceParameterType parameter2, double value2, double pGaugePa){
        //calculate in thermoCP units
        double r= CoolProp.HAProps(
                substanceParameterTypeToString(parameterWanted),
                substanceParameterTypeToString(parameter1),
                convertParameterToThermoCP(SubstanceName.MOIST_AIR,parameter1,value1).value,
                substanceParameterTypeToString(parameter2),
                convertParameterToThermoCP(SubstanceName.MOIST_AIR,parameter2,value2).value,
                substanceParameterTypeToString(SubstanceParameterType.PRESSURE),
                pGaugePaTokPaAbs(pGaugePa));
        //System.out.println(parameterWanted.enumToString()+" z coolPropa: "+r+" dla p=");
        //convert units to standards
        r=convertParameterFromThermoCP(
                substanceNameToString(SubstanceName.MOIST_AIR),
                substanceParameterTypeToString(parameterWanted),r).value;
        return r;

    }

    //szukanie parametru przez CoolPack dla reszty czynnikow
    public static double findParameter(SubstanceParameterType parameterWanted, SubstanceName substanceName, SubstanceParameterType parameter1, double value1, SubstanceParameterType parameter2, double value2) {
        //calculate in thermoCP units
        double r=0;
        if (substanceName!=SubstanceName.MOIST_AIR) {
            r = CoolProp.PropsSI(
                    substanceParameterTypeToString(parameterWanted),
                    substanceParameterTypeToString(parameter1),
                    convertParameterToThermoCP(substanceName, parameter1, value1).value,
                    substanceParameterTypeToString(parameter2),
                    convertParameterToThermoCP(substanceName, parameter2, value2).value,
                    substanceNameToString(substanceName));
            //convert units to standards
            r = convertParameterFromThermoCP(
                    substanceNameToString(substanceName),
                    substanceParameterTypeToString(parameterWanted), r).value;
        }
        else{
            r=findAirParameter(parameterWanted,parameter1,value1,parameter2,value2,0);
        }

        return r;
    }








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
    public static ThermoCPParameterPoint convertParameterToThermoCP(SubstanceName substanceName, SubstanceParameterType substanceParameter, double value){
        double valueTemp=value;

        if (substanceName==SubstanceName.MOIST_AIR){
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
        ThermoCPParameterPoint paremeterPoint=new ThermoCPParameterPoint(substanceName.enumToString(),substanceParameter.enumToString(),valueTemp);
        return paremeterPoint;
    }

    /**
     * Conversion from thermoCP units to standard units
     */
    public static StandardParameterPoint convertParameterFromThermoCP(String substanceName, String substanceParameter, double value){
        double valueTemp=value;

        if (stringToSubstanceName(substanceName)==SubstanceName.MOIST_AIR){
            switch (stringToSubstanceParameterType(substanceParameter)){
                case TEMPERATURE: valueTemp=valueTemp-T_ABS; break;
                case PRESSURE: valueTemp=valueTemp/100000; break;//valueTemp=(valueTemp*1000)-100; break;
                case TEMPERATURE_WETBULB: valueTemp=valueTemp-T_ABS; break;
                case TEMPERATURE_DEWPOINT: valueTemp=valueTemp-T_ABS; break;
            }
        }
        else{
            switch (stringToSubstanceParameterType(substanceParameter)){
                case TEMPERATURE: valueTemp=valueTemp-T_ABS; break;
                case PRESSURE: valueTemp=valueTemp/100000; break;
                case ENTHALPY: valueTemp=valueTemp/1000; break;
                case ENTROPY: valueTemp=valueTemp/1000; break;
                case HEAT_CAPACITY: valueTemp=valueTemp/1000; break;
            }
        }
        StandardParameterPoint paremeterPoint=new StandardParameterPoint(stringToSubstanceName(substanceName),stringToSubstanceParameterType(substanceParameter),valueTemp);
        return paremeterPoint;
    }

}
