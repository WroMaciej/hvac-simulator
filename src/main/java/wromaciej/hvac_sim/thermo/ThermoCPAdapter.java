package wromaciej.hvac_sim.thermo;
import thermoCP.*;
import wromaciej.hvac_sim.thermo.fluids.data.Substance;
import wromaciej.hvac_sim.thermo.fluids.data.SubstanceName;
import wromaciej.hvac_sim.thermo.fluids.data.SubstanceParameter;

/**parametry termodynamiczne czynników*/
public abstract class ThermoCPAdapter {

    public static final double RO=1.18; //gestosc powietrza w war standardowych kg/m3
    public static final double T_ABS=273.15;


    //klasa przechowująca nazwe czynnika, nazwe parametru i wartość parametru po konwersji dla CoolPack
    public static class ThermoCPParameter{
        public String substanceName;
        public String substanceParameter;
        public double value;

        public ThermoParameter(String substanceName, String parameterName, double value) {
            this.substanceName = substanceName;
            this.substanceParameter = parameterName;
            this.value = value;
        }
    }

    public static class StandardParameter{
        public SubstanceName substanceName;
        public SubstanceParameter substanceParameter;
        public double value;

        public StandardParameter(SubstanceName substanceName, SubstanceParameter parameterName, double value) {
            this.substanceName = substanceName;
            this.substanceParameter = parameterName;
            this.value = value;
        }
    }

    /**
     * Conversion of enum to thermoCP library parameter string name
     * @param parameter to convert
     * @return name of parameter in thermoCP library
     */
    public static String parameterToString(SubstanceParameter parameter){
        switch(parameter){
            case TEMPERATURE: return "T"; break;
            case PRESSURE: return "P"; break;
            case ENTHALY: return "H"; break;
            case ENTROPY: return "S"; break;
            case QUALITY: return "Q"; break;
            case DENSITY: return "DMASS"; break;
            case HEAT_CAPACITY: return "C"; break;
            case RELATIVE_HUMIDITY: return "R"; break;
            case MOISTURE_CONTENT: return "W"; break;
            case TEMPERATURE_WETBULB: return "Twb"; break;
            case TEMPERATURE_DEWPOINT: return "Tdp"; break;
        }
        return "No parameter found";
    }

    /**
     * Conversion of string parameter to enum
     */
    public static SubstanceParameter stringToSubstanceParameter(String parameter){
        return SubstanceParameter.from(parameter.toLowerCase());
    }
    public static SubstanceName stringToSubstanceName(String name){
        return SubstanceName.from(name);
    }


    /**
     * Finding parameter for MoistAir

     */
    public static double findAirParameter(SubstanceParameter parameterWanted, SubstanceParameter parameter1, double value1, SubstanceParameter parameter2, double value2, double pGaugePa){

        double r= CoolProp.HAProps(
                parameterToString(parameterWanted),
                parameterToString(parameter1),
                convertParameterToThermoCP(SubstanceName.MOIST_AIR,parameter1,value1).value,
                parameterToString(parameter2),
                convertParameterToThermoCP(SubstanceName.MOIST_AIR,parameter2,value2).value,
                parameterToString(SubstanceParameter.PRESSURE),
                convertParameterToThermoCP(SubstanceName.MOIST_AIR,SubstanceParameter.PRESSURE,pGaugePa).value);

        r=convertParameterFromThermoCP()


        wantedParameter = convert("a",wantedParameter,0).parameterName;
        double r= CoolProp.HAProps(
                    wantedParameter,
                    convert("a",p1,0).parameterName, convert("a",p1,v1).value,
                    convert("a",p2,0).parameterName, convert("a",p2,v2).value,
                    "P",(pGaugePa/1000)+100);
        // consider using calculcateRBasingOn....
        switch (wantedParameter){
            case "T": r=r-T_ABS; break;
            case "Twb": r=r-T_ABS; break;
            case "Tdb": r=r-T_ABS; break;
            case "Tdp": r=r-T_ABS; break;
            case "P": r=r/100; break;
        }
        System.out.println("znaleziono parametr "+wantedParameter+" ="+r);
        return r;

    }

    //szukanie parametru przez CoolPack dla reszty czynnikow
    public static double findParameter(SubstanceParameter parameterWanted, SubstanceName fluidName, SubstanceParameter parameter1, double v1, SubstanceParameter parameter2, double v2){
        wanted = convert(fluidName,wanted,0).parameterName;
        fluidName= convert(fluidName,null,0).fluidName;
        p1= convert(fluidName,p1,0).parameterName;
        v1= convert(fluidName,p1,v1).value;
        p2= convert(fluidName,p2,0).parameterName;
        v2= convert(fluidName,p2,v2).value;
        double r; //zmienne pomocnicze
        double r2;
        r=0;
        r2=0;



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

    }

    private static double calculateRBasingOnWantedParameter(String wanted, double r) {
        switch (wanted){
            case "T": r=r-T_ABS; break;
            case "Twb": r=r-T_ABS; break;
            case "Tdb": r=r-T_ABS; break;
            case "Tdp": r=r-T_ABS; break;
            case "P": r=r/100000; break;
            case "H": r=r/1000; break;
            case "S": r=r/1000; break;
            case "C": r=r/1000; break;
        }
        return r;
    }

    private static double getR(String wanted, String fluidName, double v1, double v2, double r, double r2) {
        if (v1 > 0)
            r = CoolProp.PropsSI(wanted, "T", r + v2, "P", r2, fluidName); //r to parametr poszukiwany
        else r = CoolProp.PropsSI(wanted, "Q", 1, "P", r2, fluidName);
        return r;
    }


    /**
     * Conversion from standard units to thermoCP units
     */
    public static ThermoCPParameter convertParameterToThermoCP(SubstanceName substanceName, SubstanceParameter substanceParameter, double value){
        double valueTemp=value;

        if (substanceName==SubstanceName.MOIST_AIR){
            switch (substanceParameter){
                case TEMPERATURE: valueTemp=valueTemp+T_ABS; break;
                case PRESSURE: valueTemp=(valueTemp/1000)+100; break;
                case TEMPERATURE_WETBULB: valueTemp=valueTemp+T_ABS; break;
                case TEMPERATURE_DEWPOINT: valueTemp=valueTemp+T_ABS; break;
            }
        }
        else{
            switch (substanceParameter){
                case TEMPERATURE: valueTemp=valueTemp+T_ABS; break;
                case PRESSURE: valueTemp=valueTemp*100; break;
                case ENTHALY: valueTemp=valueTemp*1000; break;
                case ENTROPY: valueTemp=valueTemp*1000; break;
                case HEAT_CAPACITY: valueTemp=valueTemp*1000; break;
            }
        }
        ThermoCPParameter paremeterPoint=new ThermoCPParameter(substanceName,substanceParameter,valueTemp);
        return paremeterPoint;
    }

    /**
     * Conversion from thermoCP units to standard units
     */
    public static StandardParameter convertParameterFromThermoCP(String substanceName, String substanceParameter, double value){
        double valueTemp=value;

        if (stringToSubstanceName(substanceName)==SubstanceName.MOIST_AIR){
            switch (stringToSubstanceParameter(substanceParameter)){
                case TEMPERATURE: valueTemp=valueTemp-T_ABS; break;
                case PRESSURE: valueTemp=(valueTemp*1000)-100; break;
                case TEMPERATURE_WETBULB: valueTemp=valueTemp-T_ABS; break;
                case TEMPERATURE_DEWPOINT: valueTemp=valueTemp-T_ABS; break;
            }
        }
        else{
            switch (stringToSubstanceParameter(substanceParameter)){
                case TEMPERATURE: valueTemp=valueTemp-T_ABS; break;
                case PRESSURE: valueTemp=valueTemp/100; break;
                case ENTHALY: valueTemp=valueTemp/1000; break;
                case ENTROPY: valueTemp=valueTemp/1000; break;
                case HEAT_CAPACITY: valueTemp=valueTemp/1000; break;
            }
        }
        StandardParameter paremeterPoint=new StandardParameter(stringToSubstanceName(substanceName),stringToSubstanceParameter(substanceParameter),valueTemp);
        return paremeterPoint;
    }

}
