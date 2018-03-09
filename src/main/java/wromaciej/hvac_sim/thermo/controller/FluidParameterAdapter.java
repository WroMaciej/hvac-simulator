package wromaciej.hvac_sim.thermo.controller;

import javax.measure.quantity.Quantity;
import java.util.*;

public enum FluidParameterAdapter {


    /**
     * Temperature
     */
    TEMPERATURE("T"),
    /**
     * Absolute pressure
     */
    PRESSURE("P"),
    /**
     * Specific enthalpy
     */
    SPECIFIC_ENTHALPY("H"),
    /**
     * Specific entropy
     */
    SPECIFIC_ENTROPY("S"),
    /**
     * Quality 0-1
     */
    QUALITY("Q"),
     /**
     * Density
     */
    DENSITY("D"),

    /**
     * Specific heat capacity in constant pressure cp
     */
    HEAT_CAPACITY("C","kJ/kgK"),
    /**
     * Relative humidity of AIR 0-1
     */
    RELATIVE_HUMIDITY("R","%")),
    /**
     * absolute humidity of AIR kg_H2O/kgDRY
     */
    FluidParameterAdapter("W"), 1),

    /**
     * wetbulb temperature of AIR C
     */
    FluidParameterAdapter("Twb","C"),
    /**
     * dewpoint of AIR C
     */
    FluidParameterAdapter("Tdp","C"),
    /**
     * Subcooling of refrigerant K
     */

    FluidParameterAdapter(Arrays.asList("SC","K","%.1f"), 1),
    /**
     * Superheating of refrigerant K
     */
    FluidParameterAdapter(Arrays.asList("SH","K","%.1f"), 1),
    /**
     * Overpressure, barG
     */
    FluidParameterAdapter(Arrays.asList("Unable","barG","%.2f"), 1),
    /**
     * Delta of temperature, K
     */
    FluidParameterAdapter(Arrays.asList("Unable","K","%.1f"), 1),
    /**
     * Delta of pressure, kPa
     */
    FluidParameterAdapter(Arrays.asList("Unable","kPa","%.1f"), 1);


    public Quantity quantityInJScience;

    public Quantity getQuantityInJScience() {
        return quantityInJScience;
    }

    private String parameterSymbolInThermoCPlibrary;

    FluidParameterAdapter(Quantity quantityInJScience, String parameterSymbolInThermoCPlibrary) {
        this.quantityInJScience= quantityInJScience;
        this.parameterSymbolInThermoCPlibrary=parameterSymbolInThermoCPlibrary;
    }


    private static final Map<String, FluidParameterAdapter> lookup = new HashMap<>();

    //Populate the lookup table on loading time
    static
    {
        for(FluidParameterAdapter substanceParameter : FluidParameterAdapter.values())
        {
            lookup.put(substanceParameter.enumToString(), substanceParameter);
        }
    }


    public String enumToString(){
        return parameterSymbolInThermoCPlibrary;
    }

    public static FluidParameterAdapter stringToEnum(String name){
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
