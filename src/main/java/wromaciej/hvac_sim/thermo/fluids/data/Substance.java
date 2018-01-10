package wromaciej.hvac_sim.thermo.fluids.data;

import java.util.Locale;

public class Substance {
    /**
     * Type of substance
     */
    protected SubstanceName substanceName;
    /**
     * Temperature, C
     */
    protected double temperature; // temperatura C
    /**
     * Pressure (absolute), barA
     */
    protected double pressure; //cisnienie bara
    /**
     * Enthalpy, kJ/kg
     */
    protected double enthalpy; //entalpia wlasciwa kJ/kg
    /**
     * Entropy, kJ/kgK
     */
    protected double entropy; //entropia wlasciwa kJ/kgK
    /**
     * Quality (x), 0-1
     */
    protected double quality; //stan nasycenia "x"
    /**
     * Heat capacity, kJ/kgK
     */
    protected double heatCapacity; //
    /**
     * Specific volume, m3/kg
     */
    protected double volume;
    /**
     * Density, kg/m3
     */
    protected double density;

    public Substance(){

    }

    @Override
    public String toString() {
        return "Name: " + substanceName.enumToString()
                +" temperature: "+String.format(Locale.US, "%.2f",temperature)
                + " pressure: "+String.format(Locale.US, "%.2f",pressure)
                +" enthalpy: " +String.format(Locale.US, "%.2f",enthalpy);
    }
}
