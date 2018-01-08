package wromaciej.hvac_sim.thermo.fluids.data;

import java.util.*;

public enum SubstanceParameter {
    /**
     * Temperature in C
     */
    TEMPERATURE("T"),
    /**
     * Absolute pressure barA
     */
    PRESSURE("P"),
    /**
     * Specific enthalpy kJ/kg
     */
    ENTHALY("H"),
    /**
     * Specific entropy kJ/kgK
     */
    ENTROPY("S"),
    /**
     * Quality 0-1
     */
    QUALITY("Q"),
     /**
     * Density kg/m3
     */
    DENSITY("RO"),
    /**
     * Specific heat capacity in constant pressure cp kJ/kgK
     */
    HEAT_CAPACITY("Cp"),
    /**
     * Relative humidity of AIR 0-1
     */
    RELATIVE_HUMIDITY("R"),
    /**
     * absolute humidity of AIR kg_H2O/kgDRY
     */
    MOISTURE_CONTENT("W"),
    /**
     * wetbulb temperature of AIR C
     */
    TEMPERATURE_WETBULB("Twb"),
    /**
     * dewpoint of AIR C
     */
    TEMPERATURE_DEWPOINT("Tdp"),
    /**
     * Subcooling of refrigerant K
     */

    SUBCOOLING("SC"),
    /**
     * Superheating of refrigerant K
     */
    SUPERHEATING("SH");


    private String parameterForThermoCP;

    private static final Map<String, SubstanceParameter> lookup = new HashMap<>();

    //Populate the lookup table on loading time
    static
    {
        for(SubstanceParameter substanceParameter : SubstanceParameter.values())
        {
            lookup.put(substanceParameter.enumToString(), substanceParameter);
        }
    }

    SubstanceParameter(String nameForThermoCP) {
        this.parameterForThermoCP = nameForThermoCP;
    }

    public String enumToString(){
        return parameterForThermoCP;
    }

    public static SubstanceParameter stringToEnum(String name){
        return lookup.get(name);

    }


}
