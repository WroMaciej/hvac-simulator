package wromaciej.hvac_sim.thermo.matter.fluids;

import javax.measure.Measurable;
import javax.measure.quantity.Energy;
import javax.measure.quantity.Pressure;
import javax.measure.quantity.Quantity;
import javax.measure.quantity.Temperature;
import javax.measure.unit.Unit;
import java.util.*;

public enum FluidParameterType {


    /**
     * Temperature
     */
    TEMPERATURE("T"),
    /**
     * Absolute pressure
     */
    PRESSURE(new Pressure(){}, "P"),
    /**
     * Specific enthalpy
     */
    SPECIFIC_ENTHALPY(, "H"),
    /**
     * Specific entropy
     */
    SPECIFIC_ENTROPY(new , "S"),
    /**
     * Quality 0-1
     */
    QUALITY(Arrays.asList("Q","","%.2f"), 1),
     /**
     * Density
     */
    DENSITY(Arrays.asList("D","kg/m3","%.1f"), 1),
    /**
     * Density
     */
    SPECIFIC_VOLUME(Arrays.asList("","m3/kg","%.3f"), 1),
    /**
     * Specific heat capacity in constant pressure cp
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

    SUBCOOLING(Arrays.asList("SC","K","%.1f"), 1),
    /**
     * Superheating of refrigerant K
     */
    SUPERHEATING(Arrays.asList("SH","K","%.1f"), 1),
    /**
     * Overpressure, barG
     */
    PRESSURE_GAUGE(Arrays.asList("Unable","barG","%.2f"), 1),
    /**
     * Delta of temperature, K
     */
    TEMPERATURE_DIFFERENCE(Arrays.asList("Unable","K","%.1f"), 1),
    /**
     * Delta of pressure, kPa
     */
    PRESSURE_DIFFERENCE(Arrays.asList("Unable","kPa","%.1f"), 1);


    public Quantity quantityInJScience;

    public Quantity getQuantityInJScience() {
        return quantityInJScience;
    }

    private String parameterSymbolInThermoCPlibrary;

    FluidParameterType(Quantity quantityInJScience, String parameterSymbolInThermoCPlibrary) {
        this.quantityInJScience= quantityInJScience;
        this.parameterSymbolInThermoCPlibrary=parameterSymbolInThermoCPlibrary;
    }


    private static final Map<String, FluidParameterType> lookup = new HashMap<>();

    //Populate the lookup table on loading time
    static
    {
        for(FluidParameterType substanceParameter : FluidParameterType.values())
        {
            lookup.put(substanceParameter.enumToString(), substanceParameter);
        }
    }


    public String enumToString(){
        return parameterSymbolInThermoCPlibrary;
    }

    public static FluidParameterType stringToEnum(String name){
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
