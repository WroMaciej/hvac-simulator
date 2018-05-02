package wromaciej.hvac_sim.thermo.matter;

import wromaciej.hvac_sim.solver.externals.ExternalSolver;
import wromaciej.hvac_sim.solver.matterSolvers.FluidDefinition;
import wromaciej.hvac_sim.solver.internals.Solvable;
import wromaciej.hvac_sim.solver.matterSolvers.MatterSolver;
import wromaciej.hvac_sim.solver.result.SolverResult;
import wromaciej.hvac_sim.thermo.matter.fluids.model.MatterType;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.ParameterType;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.StateOfMatter;
import wromaciej.hvac_sim.thermo.quantities.specific.*;

import java.util.Map;

public abstract class Matter implements Solvable {

    /**
     * Tool for dealing with solving fluid
     */
    public FluidDefinition fluidDefinition;
    //private MatterSolver actualMatterSolver;
    private ExternalSolver actualMatterSolver;
    private boolean isSolved;

    protected Map<ParameterType, Parameter> parametersByType;


    /**
     * Type of matter
     */
    protected MatterType matterType;

    protected StateOfMatter stateOfMatter;

    /**
     * Temperature
     */
    protected Parameter<Temperature> temperature;
    /**
     * Absolute temperature
     */
    protected Parameter<Temperature> absoluteTemperature;
    /**
     * Pressure (absolute)
     */
    protected Parameter<Pressure> absolutePressure;
    /**
     * Pressure (gauge)
     */
    protected Parameter<Pressure> gaugePressure;
    /**
     * Enthalpy
     */
    protected Parameter<SpecificEnthalpy> specificEnthalpy;

    /**
     * Heat capacity
     */
    protected Parameter<HeatCapacity> heatCapacity;
    /**
     * Specific volume
     */
    protected Parameter<SpecificVolume> specificVolume;
    /**
     * Density
     */
    protected Parameter<Density> density;

    protected void clearAllParameters(){
        temperature = new Parameter<>();
        absoluteTemperature = new Parameter<>(ParameterType.TEMPERATURE);
        absolutePressure = new Parameter<>(ParameterType.PRESSURE);
        gaugePressure = new Parameter<>();
        specificEnthalpy = new Parameter<>(ParameterType.SPECIFIC_ENTHALPY);
        heatCapacity = new Parameter<>(ParameterType.HEAT_CAPACITY);
        specificVolume = new Parameter<>();
        density = new Parameter<>(ParameterType.DENSITY);
    }

    public Matter() {
        clearAllParameters();
    }

    public FluidDefinition getFluidDefinition() {
        return fluidDefinition;
    }

    public void setFluidDefinition(FluidDefinition fluidDefinition) {
        this.fluidDefinition = fluidDefinition;
    }

    public Map<ParameterType, Parameter> getParametersByType() {
        return parametersByType;
    }

    public void setParametersByType(Map<ParameterType, Parameter> parametersByType) {
        this.parametersByType = parametersByType;
    }

    public MatterType getMatterType() {
        return matterType;
    }

    public void setMatterType(MatterType matterType) {
        this.matterType = matterType;
    }

    public StateOfMatter getStateOfMatter() {
        return stateOfMatter;
    }

    public void setStateOfMatter(StateOfMatter stateOfMatter) {
        this.stateOfMatter = stateOfMatter;
    }

    public Parameter<Temperature> getTemperature() {
        return temperature;
    }

    public void setTemperature(Parameter<Temperature> temperature) {
        this.temperature = temperature;
    }

    public Parameter<Temperature> getAbsoluteTemperature() {
        return absoluteTemperature;
    }

    public void setAbsoluteTemperature(Parameter<Temperature> absoluteTemperature) {
        this.absoluteTemperature = absoluteTemperature;
    }

    public Parameter<Pressure> getAbsolutePressure() {
        return absolutePressure;
    }

    public void setAbsolutePressure(Parameter<Pressure> absolutePressure) {
        this.absolutePressure = absolutePressure;
    }

    public Parameter<Pressure> getGaugePressure() {
        return gaugePressure;
    }

    public void setGaugePressure(Parameter<Pressure> gaugePressure) {
        this.gaugePressure = gaugePressure;
    }

    public Parameter<SpecificEnthalpy> getSpecificEnthalpy() {
        return specificEnthalpy;
    }

    public void setSpecificEnthalpy(Parameter<SpecificEnthalpy> specificEnthalpy) {
        this.specificEnthalpy = specificEnthalpy;
    }

    public Parameter<HeatCapacity> getHeatCapacity() {
        return heatCapacity;
    }

    public void setHeatCapacity(Parameter<HeatCapacity> heatCapacity) {
        this.heatCapacity = heatCapacity;
    }

    public Parameter<SpecificVolume> getSpecificVolume() {
        return specificVolume;
    }

    public void setSpecificVolume(Parameter<SpecificVolume> specificVolume) {
        this.specificVolume = specificVolume;
    }

    public Parameter<Density> getDensity() {
        return density;
    }

    public void setDensity(Parameter<Density> density) {
        this.density = density;
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
        addParameter(density);
        addParameter(heatCapacity);
    }

    @Override
    public SolverResult solve() {
        return actualMatterSolver.solve(this);
    }

    @Override
    public boolean isSolved() {
        return isSolved;
    }
}
