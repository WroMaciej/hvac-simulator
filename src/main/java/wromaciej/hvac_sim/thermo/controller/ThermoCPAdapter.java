package wromaciej.hvac_sim.thermo.controller;
import thermoCP.*;
import wromaciej.hvac_sim.thermo.matter.fluids.FluidName;
import wromaciej.hvac_sim.thermo.matter.fluids.FluidParameterType;

/**
 * Thermodynamic data for 09-01-2018
 */
public final class ThermoCPAdapter {

    public static final double RO=1.18; //gestosc powietrza w war standardowych kg/m3
    public static final double T_ABS=273.15;

    public static String getSubstancesList(){
        String list=new String();
        for(FluidName fluidName : FluidName.values()){
            list=list+ fluidName.enumToString()+System.lineSeparator();
        }
        return list;
    }

    public static String getParametersList(){
        String list=new String();
        for(FluidParameterType fluidParameterType : FluidParameterType.values()){
            list=list+ fluidParameterType.enumToString()+" - "+ fluidParameterType.toString() +System.lineSeparator();
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
        public FluidName fluidName;
        public FluidParameterType fluidParameterType;
        public double value;

        public StandardParameterPoint(FluidName fluidName, FluidParameterType parameterName, double value) {
            this.fluidName = fluidName;
            this.fluidParameterType = parameterName;
            this.value = value;
        }
    }

    /**
     * Conversion of enum to thermoCP library parameter string name
     */
    public static String substanceParameterTypeToString(FluidParameterType parameter){
        return parameter.enumToString();
    }
    /**
     * Conversion of string parameter to enum
     */
    public static FluidParameterType stringToSubstanceParameterType(String parameter){
        return FluidParameterType.stringToEnum(parameter);
    }
    /**
     * Conversion of enum to thermoCP library fluid name
     */
    public static String substanceNameToString(FluidName name){
        return name.enumToString();
    }
    /**
     * Conversion of fluid name to enum
     */
    public static FluidName stringToSubstanceName(String name){
        return FluidName.stringToEnum(name);
    }

    public static double pGaugePaTokPaAbs(double pGaugePa){
        return (pGaugePa/1000)+100;
    }

    /**
     * Finding parameter for MoistAir

     */
    public static double findAirParameter(FluidParameterType parameterWanted, FluidParameterType parameter1, double value1, FluidParameterType parameter2, double value2, double pGaugePa){
        //calculate in thermoCP units
        double r= CoolProp.HAProps(
                substanceParameterTypeToString(parameterWanted),
                substanceParameterTypeToString(parameter1),
                convertParameterToThermoCP(FluidName.MOIST_AIR,parameter1,value1).value,
                substanceParameterTypeToString(parameter2),
                convertParameterToThermoCP(FluidName.MOIST_AIR,parameter2,value2).value,
                substanceParameterTypeToString(FluidParameterType.PRESSURE),
                pGaugePaTokPaAbs(pGaugePa));
        //System.out.println(parameterWanted.enumToString()+" z coolPropa: "+r+" dla p=");
        //convert units to standards
        r=convertParameterFromThermoCP(
                substanceNameToString(FluidName.MOIST_AIR),
                substanceParameterTypeToString(parameterWanted),r).value;
        return r;

    }

    //szukanie parametru przez CoolPack dla reszty czynnikow
    public static double findParameter(FluidParameterType parameterWanted, FluidName fluidName, FluidParameterType parameter1, double value1, FluidParameterType parameter2, double value2) {
        //calculate in thermoCP units
        double r=0;
        if (fluidName != FluidName.MOIST_AIR) {
            r = CoolProp.PropsSI(
                    substanceParameterTypeToString(parameterWanted),
                    substanceParameterTypeToString(parameter1),
                    convertParameterToThermoCP(fluidName, parameter1, value1).value,
                    substanceParameterTypeToString(parameter2),
                    convertParameterToThermoCP(fluidName, parameter2, value2).value,
                    substanceNameToString(fluidName));
            //convert units to standards
            r = convertParameterFromThermoCP(
                    substanceNameToString(fluidName),
                    substanceParameterTypeToString(parameterWanted), r).value;
        }
        else{
            r=findAirParameter(parameterWanted,parameter1,value1,parameter2,value2,0);
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
    public static ThermoCPParameterPoint convertParameterToThermoCP(FluidName fluidName, FluidParameterType substanceParameter, double value){
        double valueTemp=value;

        if (fluidName == FluidName.MOIST_AIR){
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
        ThermoCPParameterPoint paremeterPoint=new ThermoCPParameterPoint(fluidName.enumToString(),substanceParameter.enumToString(),valueTemp);
        return paremeterPoint;
    }

    /**
     * Conversion from thermoCP units to standard units
     */
    public static StandardParameterPoint convertParameterFromThermoCP(String substanceName, String substanceParameter, double value){
        double valueTemp=value;

        if (stringToSubstanceName(substanceName)== FluidName.MOIST_AIR){
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
