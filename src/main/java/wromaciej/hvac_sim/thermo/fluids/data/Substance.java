package wromaciej.hvac_sim.thermo.fluids.data;

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

    public Substance(SubstanceName substanceName, double temperature, double pressure, double enthalpy, double entropy, double quality, double heatCapacity, double volume, double density) {
        this.substanceName = substanceName;
        this.temperature = temperature;
        this.pressure = pressure;
        this.enthalpy = enthalpy;
        this.entropy = entropy;
        this.quality = quality;
        this.heatCapacity = heatCapacity;
        this.volume = volume;
        this.density = density;
    }

    public SubstanceName getSubstanceName() {
        return substanceName;
    }


}
