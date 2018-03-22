package wromaciej.hvac_sim.thermo.matter.fluids.parameters;

public enum ParameterType {
    /**
     * Temperature
     */
    TEMPERATURE("T","C"),
    /**
     * Absolute pressure
     */
    PRESSURE("P","Pa"),
    /**
     * Specific enthalpy
     */
    SPECIFIC_ENTHALPY("H","kJ/kg"),
    /**
     * Specific entropy
     */
    SPECIFIC_ENTROPY("S","kJ/kgK"),
    /**
     * Quality 0-1
     */
    QUALITY("Q","1"),
    /**
     * Density
     */
    DENSITY("D","kg/m3"),

    /**
     * Specific heat capacity in constant pressure cp
     */
    HEAT_CAPACITY("C","kJ/kgK"),
    /**
     * Relative humidity of AIR 0-1
     */
    RELATIVE_HUMIDITY("R","%"),

    /**
     * absolute humidity of AIR kg_H2O/kgDRY
     */
    MOISTURE_CONTENT("W","1"),

    /**
     * wetbulb temperature of AIR
     */
    WET_BULB_TEMPERATURE("Twb","C"),
    /**
     * dewpoint of AIR
     */
    DEW_POINT_TEMPERATURE("Tdp","C");




    private String parameterSymbolInThermoCPlibrary;
    private String unitUsedInThermoCPlibrary;

    ParameterType(String parameterSymbolInThermoCPlibrary, String unitUsedInThermoCPlibrary) {
        this.parameterSymbolInThermoCPlibrary = parameterSymbolInThermoCPlibrary;
        this.unitUsedInThermoCPlibrary = unitUsedInThermoCPlibrary;
    }

}
