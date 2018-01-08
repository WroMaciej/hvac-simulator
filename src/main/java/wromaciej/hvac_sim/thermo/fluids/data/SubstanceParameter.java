package wromaciej.hvac_sim.thermo.fluids.data;

public enum SubstanceParameter {
    /**
     * Temperature in C
     */
    TEMPERATURE,
    /**
     * Absolute pressure barA
     */
    PRESSURE,
    /**
     * Specific enthalpy kJ/kg
     */
    ENTHALY,
    /**
     * Specific entropy kJ/kgK
     */
    ENTROPY,
    /**
     * Quality 0-1
     */
    QUALITY,
    /**
     * Specific volume m3/kg
     */
    VOLUME,
    /**
     * Density kg/m3
     */
    DENSITY,
    /**
     * Specific heat capacity in constant pressure cp kJ/kgK
     */
    HEAT_CAPACITY,
    /**
     * Relative humidity of AIR 0-1
     */
    RELATIVE_HUMIDITY,
    /**
     * absolute humidity of AIR kg_H2O/kgDRY
     */
    MOISTURE_CONTENT,
    /**
     * wetbulb temperature of AIR C
     */
    TEMPERATURE_WETBULB,
    /**
     * dewpoint of AIR C
     */
    TEMPERATURE_DEWPOINT,
    /**
     * Subcooling of refrigerant K
     */

    SUBCOOLING,
    /**
     * Superheating of refrigerant K
     */
    SUPERHEATING;


    public static SubstanceParameter from(String name) {
        return SubstanceParameter.valueOf(name.toUpperCase());
    }
}
