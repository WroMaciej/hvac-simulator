package wromaciej.hvac_sim.thermo.matter.fluids.parameters;

import javax.measure.unit.Unit;

public enum ParameterType {
    /**
     * Parameter unknown at that moment
     */
    OTHER("",""),

    /**
     * Temperature
     */
    TEMPERATURE("T","K"),
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
    SPECIFIC_ENTROPY("S","kJ/(kg*K)"),
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
    HEAT_CAPACITY("C","kJ/(kg*K)"),
    /**
     * Relative humidity of AIR 0-1
     */
    RELATIVE_HUMIDITY("R","%"),

    /**
     * absolute humidity of AIR kg_H2O/kgDRY
     */
    MOISTURE_CONTENT("W","kg/kg"),

    /**
     * wetbulb temperature of AIR
     */
    WET_BULB_TEMPERATURE("Twb","K"),
    /**
     * dewpoint of AIR
     */
    DEW_POINT_TEMPERATURE("Tdp","K");




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
        System.out.println("s:"+stringUnitInThermoCP);
        System.out.println("u:"+ (Unit) Unit.valueOf(stringUnitInThermoCP));
        return (Unit) Unit.valueOf(stringUnitInThermoCP);
    }


}
