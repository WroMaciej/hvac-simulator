package wromaciej.hvac_sim.thermo.matter.fluids.model;


import wromaciej.hvac_sim.thermo.matter.fluids.parameters.FluidName;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.FluidParameter;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.StateOfMatter;
import wromaciej.hvac_sim.thermo.quantities.base.AnyQuantity;
import wromaciej.hvac_sim.thermo.quantities.base.FluidQuantity;
import wromaciej.hvac_sim.thermo.quantities.specific.*;
import wromaciej.hvac_sim.thermo.unitSystems.UnitSystem;


public class Fluid {
    /**
     * Type of fluid
     */
    private FluidName fluidName;

    private boolean isCalculated;

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
     * Absolute temperature
     */
    private FluidParameter<Temperature> absoluteTemperature;
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
        isCalculated=false;
    }


    @Override
    public String toString() {

        return "Name: " + fluidName.enumToString() + System.lineSeparator()
                +" temperature: "+temperature.toString() + System.lineSeparator()
                + " pressure: "+absolutePressure.toString() + System.lineSeparator()
                +" enthalpy: " +specificEnthalpy.toString() + System.lineSeparator();
    }

    public FluidName getFluidName() {
        return fluidName;
    }

    public void setFluidName(FluidName fluidName) {
        this.fluidName = fluidName;
    }

    public boolean isCalculated() {
        return isCalculated;
    }

    public void setCalculated(boolean calculated) {
        isCalculated = calculated;
    }

    public StateOfMatter getStateOfMatter() {
        return stateOfMatter;
    }

    public void setStateOfMatter(StateOfMatter stateOfMatter) {
        this.stateOfMatter = stateOfMatter;
    }

    public FluidParameter<Temperature> getTemperature() {
        return temperature;
    }

    public void setTemperature(FluidParameter<Temperature> temperature) {
        this.temperature = temperature;
    }

    public FluidParameter<Temperature> getAbsoluteTemperature() {
        return absoluteTemperature;
    }

    public void setAbsoluteTemperature(FluidParameter<Temperature> absoluteTemperature) {
        this.absoluteTemperature = absoluteTemperature;
    }

    public FluidParameter<Pressure> getAbsolutePressure() {
        return absolutePressure;
    }

    public void setAbsolutePressure(FluidParameter<Pressure> absolutePressure) {
        this.absolutePressure = absolutePressure;
    }

    public FluidParameter<Pressure> getGaugePressure() {
        return gaugePressure;
    }

    public void setGaugePressure(FluidParameter<Pressure> gaugePressure) {
        this.gaugePressure = gaugePressure;
    }

    public FluidParameter<SpecificEnthalpy> getSpecificEnthalpy() {
        return specificEnthalpy;
    }

    public void setSpecificEnthalpy(FluidParameter<SpecificEnthalpy> specificEnthalpy) {
        this.specificEnthalpy = specificEnthalpy;
    }

    public FluidParameter<SpecificEntropy> getSpecificEntropy() {
        return specificEntropy;
    }

    public void setSpecificEntropy(FluidParameter<SpecificEntropy> specificEntropy) {
        this.specificEntropy = specificEntropy;
    }

    public FluidParameter<Quality> getQuality() {
        return quality;
    }

    public void setQuality(FluidParameter<Quality> quality) {
        this.quality = quality;
    }

    public FluidParameter<HeatCapacity> getHeatCapacity() {
        return heatCapacity;
    }

    public void setHeatCapacity(FluidParameter<HeatCapacity> heatCapacity) {
        this.heatCapacity = heatCapacity;
    }

    public FluidParameter<SpecificVolume> getSpecificVolume() {
        return specificVolume;
    }

    public void setSpecificVolume(FluidParameter<SpecificVolume> specificVolume) {
        this.specificVolume = specificVolume;
    }

    public FluidParameter<Density> getDensity() {
        return density;
    }

    public void setDensity(FluidParameter<Density> density) {
        this.density = density;
    }
}
