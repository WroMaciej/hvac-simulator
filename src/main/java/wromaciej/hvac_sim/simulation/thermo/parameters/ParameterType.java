package wromaciej.hvac_sim.simulation.thermo.parameters;

import javax.measure.unit.Unit;

/**
 * List of specific parameters which are available in fluid library
 */

public enum ParameterType {
    /**
     * Item unknown at that moment
     */
    OTHER("",""),

    /**
     * Temperature
     */
    TEMPERATURE("T","K"),
    /**
     * Absolute pressure of internals fluid
     */
    PRESSURE("P","Pa"),
    /**
     * Specific enthalpy
     */
    SPECIFIC_ENTHALPY("H","J/kg"),
    /**
     * Specific entropy
     */
    SPECIFIC_ENTROPY("S","J/(kg*K)"),
    /**
     * Quality 0-1
     */
    QUALITY("Q","kg/kg"),
    /**
     * Density
     */
    DENSITY("D","kg/m^3"),

    /**
     * Specific heat capacity in constant pressure cp
     */
    HEAT_CAPACITY("C","J/(kg*K)"),
    /**
     * Relative humidity of AIR 0-1
     */
    AIR_RELATIVE_HUMIDITY("R","Pa/Pa"),

    /**
     * absolute humidity of AIR kg_H2O/kgDRY
     */
    AIR_MOISTURE_CONTENT("W","kg/kg"),

    /**
     * wetbulb temperature of AIR
     */
    AIR_WET_BULB_TEMPERATURE("T_wb","K"),
    /**
     * dewpoint of AIR
     */
    AIR_DEW_POINT_TEMPERATURE("T_dp","K"),
    /**
     * Absolute pressure of Air
     */
    AIR_PRESSURE("P","kPa"),
    /**
     * Specific volume of Air
     */
    AIR_SPECIFIC_VOLUME("V","(m^3)/kg"),
    /**
     * Specific volume of Air
     */
    AIR_WATER_PARTIAL_PRESSURE("P_w","kPa");






    private String parameterSymbolInThermoCP;
    private String stringUnitInThermoCP;

    ParameterType(String parameterSymbolInThermoCPlibrary, String stringUnitInThermoCP) {
        this.parameterSymbolInThermoCP = parameterSymbolInThermoCPlibrary;
        this.stringUnitInThermoCP = stringUnitInThermoCP;
    }

    public String getParameterSymbolInThermoCP() {
        return parameterSymbolInThermoCP;
    }

    public String getStringUnitInThermoCP() {
        return stringUnitInThermoCP;
    }

    public Unit getUnitInThermoCP() {
        return (Unit) Unit.valueOf(stringUnitInThermoCP);
    }


}
