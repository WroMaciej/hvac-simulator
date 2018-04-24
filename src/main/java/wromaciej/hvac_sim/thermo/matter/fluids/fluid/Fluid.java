package wromaciej.hvac_sim.thermo.matter.fluids.fluid;


import wromaciej.hvac_sim.solver.FluidSolver;
import wromaciej.hvac_sim.solver.IndividualSolver;
import wromaciej.hvac_sim.solver.SolverResult;
import wromaciej.hvac_sim.thermo.matter.fluids.model.FluidName;
import wromaciej.hvac_sim.thermo.matter.fluids.model.FluidType;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.ParameterType;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.StateOfMatter;
import wromaciej.hvac_sim.thermo.quantities.specific.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class Fluid implements IndividualSolver {

    /**
     * Tool for dealing with solving fluid
     */
    public FluidSolver fluidSolver;
    protected FluidFactory fluidFactory;
    protected Map<ParameterType, Parameter> parametersByType;


    /**
     * Type of fluid
     */
    private FluidType fluidType;

    /**
     * Name of chemical formula
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
    private Parameter<Temperature> temperature;
    /**
     * Absolute temperature
     */
    private Parameter<Temperature> absoluteTemperature;
    /**
     * Pressure (absolute)
     */
    private Parameter<Pressure> absolutePressure;
    /**
     * Pressure (gauge)
     */
    private Parameter<Pressure> gaugePressure;
    /**
     * Enthalpy
     */
    private Parameter<SpecificEnthalpy> specificEnthalpy;
    /**
     * Entropy
     */
    private Parameter<SpecificEntropy> specificEntropy;
    /**
     * Quality (x), 0-1
     */
    private Parameter<Quality> quality;
    /**
     * Heat capacity
     */
    private Parameter<HeatCapacity> heatCapacity;
    /**
     * Specific volume
     */
    private Parameter<SpecificVolume> specificVolume;
    /**
     * Density
     */
    private Parameter<Density> density;

    public Fluid(FluidFactory fluidFactory) {
        this.fluidFactory = fluidFactory;
        fluidSolver = new FluidSolver(null, null, null);
        parametersByType = new HashMap<>();
    }

    public Parameter getParameterByType(ParameterType parameterType){
        updateParameters();
        return parametersByType.get(parameterType);
    }

    protected void addParameter(Parameter parameter){
        if (parameter.getParameterType()!= ParameterType.OTHER){
            parametersByType.put(parameter.getParameterType(), parameter);
        }
    }

    public void updateParameters(){
        parametersByType.clear();
        addParameter(absoluteTemperature);
        addParameter(absolutePressure);
        addParameter(specificEnthalpy);
        addParameter(specificEntropy);
        addParameter(quality);
        addParameter(density);
        addParameter(heatCapacity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fluid fluid = (Fluid) o;
        return fluidType == fluid.fluidType &&
                fluidName == fluid.fluidName &&
                stateOfMatter == fluid.stateOfMatter &&
                Objects.equals(temperature, fluid.temperature) &&
                Objects.equals(absoluteTemperature, fluid.absoluteTemperature) &&
                Objects.equals(absolutePressure, fluid.absolutePressure) &&
                Objects.equals(gaugePressure, fluid.gaugePressure) &&
                Objects.equals(specificEnthalpy, fluid.specificEnthalpy) &&
                Objects.equals(specificEntropy, fluid.specificEntropy) &&
                Objects.equals(quality, fluid.quality) &&
                Objects.equals(heatCapacity, fluid.heatCapacity) &&
                Objects.equals(specificVolume, fluid.specificVolume) &&
                Objects.equals(density, fluid.density);
    }

    @Override
    public int hashCode() {

        return Objects.hash(fluidType, fluidName, stateOfMatter, temperature, absoluteTemperature, absolutePressure, gaugePressure, specificEnthalpy, specificEntropy, quality, heatCapacity, specificVolume, density);
    }

    public FluidType getFluidType() {
        return fluidType;
    }

    protected void setFluidType(FluidType fluidType) {
        this.fluidType = fluidType;
    }

    public FluidName getFluidName() {
        return fluidName;
    }

    protected void setFluidName(FluidName fluidName) {
        this.fluidName = fluidName;
    }

    public StateOfMatter getStateOfMatter() {
        return stateOfMatter;
    }

    protected void setStateOfMatter(StateOfMatter stateOfMatter) {
        this.stateOfMatter = stateOfMatter;
    }

    public Parameter<Temperature> getTemperature() {
        return temperature;
    }

    protected void setTemperature(Parameter<Temperature> temperature) {
        this.temperature = temperature;
    }

    public Parameter<Temperature> getAbsoluteTemperature() {
        return absoluteTemperature;
    }

    protected void setAbsoluteTemperature(Parameter<Temperature> absoluteTemperature) {
        this.absoluteTemperature = absoluteTemperature;
    }

    public Parameter<Pressure> getAbsolutePressure() {
        return absolutePressure;
    }

    protected void setAbsolutePressure(Parameter<Pressure> absolutePressure) {
        this.absolutePressure = absolutePressure;
    }

    public Parameter<Pressure> getGaugePressure() {
        return gaugePressure;
    }

    protected void setGaugePressure(Parameter<Pressure> gaugePressure) {
        this.gaugePressure = gaugePressure;
    }

    public Parameter<SpecificEnthalpy> getSpecificEnthalpy() {
        return specificEnthalpy;
    }

    protected void setSpecificEnthalpy(Parameter<SpecificEnthalpy> specificEnthalpy) {
        this.specificEnthalpy = specificEnthalpy;
    }

    public Parameter<SpecificEntropy> getSpecificEntropy() {
        return specificEntropy;
    }

    protected void setSpecificEntropy(Parameter<SpecificEntropy> specificEntropy) {
        this.specificEntropy = specificEntropy;
    }

    public Parameter<Quality> getQuality() {
        return quality;
    }

    protected void setQuality(Parameter<Quality> quality) {
        this.quality = quality;
    }

    public Parameter<HeatCapacity> getHeatCapacity() {
        return heatCapacity;
    }

    protected void setHeatCapacity(Parameter<HeatCapacity> heatCapacity) {
        this.heatCapacity = heatCapacity;
    }

    public Parameter<SpecificVolume> getSpecificVolume() {
        return specificVolume;
    }

    protected void setSpecificVolume(Parameter<SpecificVolume> specificVolume) {
        this.specificVolume = specificVolume;
    }

    public Parameter<Density> getDensity() {
        return density;
    }

    protected void setDensity(Parameter<Density> density) {
        this.density = density;
    }



    @Override
    public SolverResult solve() {
        return fluidSolver.solve(this, fluidFactory);
    }
}
