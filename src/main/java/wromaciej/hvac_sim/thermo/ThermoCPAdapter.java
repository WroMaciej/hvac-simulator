package wromaciej.hvac_sim.thermo;
import thermoCP.*;
import wromaciej.hvac_sim.thermo.fluids.data.SubstanceName;
import wromaciej.hvac_sim.thermo.fluids.data.SubstanceParameter;

/**parametry termodynamiczne czynników*/
public abstract class ThermoCPAdapter {

    public static final double RO=1.18; //gestosc powietrza w war standardowych kg/m3
    public static final double T_ABS=273.15;


    //klasa przechowująca nazwe czynnika, nazwe parametru i wartość parametru po konwersji dla CoolPack
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
                convertParameterToThermoCP(SubstanceName.MOIST_AIR,SubstanceParameter.PRESSURE,pGaugePa).value);
        //convert units to standards
        r=convertParameterFromThermoCP(
                substanceNameToString(SubstanceName.MOIST_AIR),
                substanceParameterToString(parameterWanted),r).value;
        return r;

    }

    //szukanie parametru przez CoolPack dla reszty czynnikow
    public static double findParameter(SubstanceParameter parameterWanted, SubstanceName substanceName, SubstanceParameter parameter1, double value1, SubstanceParameter parameter2, double value2) {
        //calculate in thermoCP units
        double r = CoolProp.PropsSI(
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
    public static ThermoCPParameterPoint convertParameterToThermoCP(SubstanceName substanceName, SubstanceParameter substanceParameter, double value){
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
        StandardParameterPoint paremeterPoint=new StandardParameterPoint(stringToSubstanceName(substanceName),stringToSubstanceParameter(substanceParameter),valueTemp);
        return paremeterPoint;
    }

}
