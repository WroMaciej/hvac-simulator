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
    private FluidParameter<SpecificEnthalpy> specificEnthalpy;
    /**
     * Entropy
     */
    private FluidParameter<SpecificEntropy> specificEntropy;
    /**
     * Quality (x), 0-1
     */
    private FluidParameter<Quality> quality;
    /**
     * Heat capacity, kJ/kgK
     */
    private FluidParameter<HeatCapacity> heatCapacity;
    /**
     * Specific volume, m3/kg
     */
    private FluidParameter<SpecificVolume> specificVolume;
    /**
     * Density, kg/m3
     */
    private FluidParameter<Density> density;


    @Override
    public String toString() {

        return "Name: " + fluidName.enumToString() + System.lineSeparator()
                +" temperature: "+temperature.toString() + System.lineSeparator()
                + " pressure: "+absolutePressure.toString() + System.lineSeparator()
                +" enthalpy: " +specificEnthalpy.toString() + System.lineSeparator();
    }
}
