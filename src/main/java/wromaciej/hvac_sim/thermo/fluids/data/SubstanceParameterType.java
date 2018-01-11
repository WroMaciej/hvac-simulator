package wromaciej.hvac_sim.thermo.fluids.data;

import java.util.*;

public enum SubstanceParameterType {


    /**
     * Temperature in C
     */
    TEMPERATURE(Arrays.asList("T","C","%.2f"), 1),
    /**
     * Absolute pressure barA
     */
    PRESSURE(Arrays.asList("P","barA","%.2f"), 1),
    /**
     * Specific enthalpy kJ/kg
     */
    ENTHALPY(Arrays.asList("H","kJ/kg","%.2f"), 1),
    /**
     * Specific entropy kJ/kgK
     */
    ENTROPY(Arrays.asList("S","kJ/kgK","%.2f"), 1),
    /**
     * Quality 0-1
     */
    QUALITY(Arrays.asList("Q","","%.2f"), 1),
     /**
     * Density kg/m3
     */
    DENSITY(Arrays.asList("D","kg/m3","%.1f"), 1),
    /**
     * Density kg/m3
     */
    VOLUME(Arrays.asList("","m3/kg","%.3f"), 1),
    /**
     * Specific heat capacity in constant pressure cp kJ/kgK
     */
    HEAT_CAPACITY(Arrays.asList("C","kJ/kgK","%.2f"), 1),
    /**
     * Relative humidity of AIR 0-1
     */
    RELATIVE_HUMIDITY(Arrays.asList("R","%","%.1f"), 100),
    /**
     * absolute humidity of AIR kg_H2O/kgDRY
     */
    MOISTURE_CONTENT(Arrays.asList("W","","%.5f"), 1),
    /**
     * Overpressure, Pa
     */
    PRESSURE_GAUGE_PA(Arrays.asList("Unable","Pa","%.0f"), 1),
    /**
     * wetbulb temperature of AIR C
     */

    TEMPERATURE_WETBULB(Arrays.asList("Twb","","%.2f"), 1),
    /**
     * dewpoint of AIR C
     */
    TEMPERATURE_DEWPOINT(Arrays.asList("Tdp","","%.2f"), 1),
    /**
     * Subcooling of refrigerant K
     */

    SUBCOOLING(Arrays.asList("SC","K","%.2f"), 1),
    /**
     * Superheating of refrigerant K
     */
    SUPERHEATING(Arrays.asList("SH","K","%.2f"), 1),
    /**
     * Overpressure, Pa
     */
    PRESSURE_GAUGE_BARG(Arrays.asList("Unable","barG","%.2f"), 1),
    /**
     * Delta of temperature, K
     */
    DELTA_T(Arrays.asList("Unable","K","%.2f"), 1);


    private List<String> parameters;
    private double multiplyerForShowing;
    private String parameterForThermoCP;

    SubstanceParameterType(List<String> parameters, double multiplyerForShowing) {
        this.parameters = parameters;
        this.multiplyerForShowing=multiplyerForShowing;
        this.parameterForThermoCP=parameters.get(0);
    }


    private static final Map<String, SubstanceParameterType> lookup = new HashMap<>();

    //Populate the lookup table on loading time
    static
    {
        for(SubstanceParameterType substanceParameter : SubstanceParameterType.values())
        {
            lookup.put(substanceParameter.enumToString(), substanceParameter);
        }
    }



    /*SubstanceParameterType(String nameForThermoCP) {
        this.parameterForThermoCP = nameForThermoCP;
    }*/

    public String enumToString(){
        return parameterForThermoCP;
    }

    public static SubstanceParameterType stringToEnum(String name){
        return lookup.get(name);
    }

    public String getUnit(){
        return this.parameters.get(1);
    }
    public String getStringFormat(){
        return this.parameters.get(2);
    }
    public double getMultiplyerForShowing(){
        return multiplyerForShowing;
    }



}
