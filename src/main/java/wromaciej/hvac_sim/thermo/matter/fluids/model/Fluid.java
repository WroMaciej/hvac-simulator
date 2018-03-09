package wromaciej.hvac_sim.thermo.matter.fluids.model;


import wromaciej.hvac_sim.thermo.matter.fluids.parameters.FluidName;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.FluidParameter;
import wromaciej.hvac_sim.thermo.quantities.specific.*;


public class Fluid {
    /**
     * Type of fluid
     */
    private FluidName fluidName;

    /**
     * Temperature
     */
    private FluidParameter<Temperature> temperature;
    /**
     * Pressure (absolute)
     */
    private FluidParameter<Pressure> absolutePressure;
    /**
     * Pressure (gauge)
     */
    private FluidParameter<Pressure> gaugePressure;
    /**
     * Enthalpy
     */
    protected FluidParameter<SpecificEnthalpy> specificEnthalpy;
    /**
     * Entropy
     */
    protected FluidParameter<SpecificEntropy> specificEntropy;
    /**
     * Quality (x), 0-1
     */
    protected FluidParameter<Quality> quality;
    /**
     * Heat capacity, kJ/kgK
     */
    protected FluidParameter<HeatCapacity> heatCapacity;
    /**
     * Specific volume, m3/kg
     */
    protected FluidParameter<SpecificVolume> specificVolume;
    /**
     * Density, kg/m3
     */
    protected FluidParameter<Density> density;


    @Override
    public String toString() {
        return "Name: " + fluidName.enumToString() + System.lineSeparator()
                +" temperature: "+temperature.toString() + System.lineSeparator()
                + " pressure: "+absolutePressure.toString() + System.lineSeparator()
                +" enthalpy: " +specificEnthalpy.toString() + System.lineSeparator();
    }
}
