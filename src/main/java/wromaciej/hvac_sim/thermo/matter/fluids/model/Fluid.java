package wromaciej.hvac_sim.thermo.matter.fluids.model;


import wromaciej.hvac_sim.thermo.matter.fluids.parameters.FluidName;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.FluidParameter;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.StateOfMatter;
import wromaciej.hvac_sim.thermo.quantities.specific.*;
import wromaciej.hvac_sim.thermo.unitSystems.UnitSystem;


public class Fluid {
    /**
     * Type of fluid
     */
    private FluidName fluidName;

    /**
     * State of matter:
     * GAS,
     * LIQUID,
     * GAS_LIQUID,
     * LIQUID_SOLID,
     * OVERCRITICAL,
     * SOLID,
     * UNDEFINED;
     */

    private StateOfMatter stateOfMatter;

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
     * Heat capacity
     */
    private FluidParameter<HeatCapacity> heatCapacity;
    /**
     * Specific volume
     */
    private FluidParameter<SpecificVolume> specificVolume;
    /**
     * Density
     */
    private FluidParameter<Density> density;


    public Fluid() {
    }

    @Override
    public String toString() {

        return "Name: " + fluidName.enumToString() + System.lineSeparator()
                +" temperature: "+temperature.toString() + System.lineSeparator()
                + " pressure: "+absolutePressure.toString() + System.lineSeparator()
                +" enthalpy: " +specificEnthalpy.toString() + System.lineSeparator();
    }
}
