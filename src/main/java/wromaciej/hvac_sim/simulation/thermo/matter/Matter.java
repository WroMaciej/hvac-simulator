package wromaciej.hvac_sim.simulation.thermo.matter;

import wromaciej.hvac_sim.simulation.solver.externals.ExternalSolver;
import wromaciej.hvac_sim.simulation.solver.internals.Solvable;
import wromaciej.hvac_sim.simulation.solver.matterSolvers.MatterDefinition;
import wromaciej.hvac_sim.simulation.solver.result.SolverResult;
import wromaciej.hvac_sim.simulation.thermo.generals.NeedUpdates;
import wromaciej.hvac_sim.simulation.thermo.matter.fluids.model.MatterType;
import wromaciej.hvac_sim.simulation.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.simulation.thermo.matter.fluids.parameters.ParameterType;
import wromaciej.hvac_sim.simulation.thermo.matter.fluids.parameters.StateOfMatter;
import wromaciej.hvac_sim.simulation.thermo.quantities.specific.*;

import java.util.Map;

public abstract class Matter implements Solvable, NeedUpdates {

    /**
     * Tool for dealing with solving fluid
     */
    public MatterDefinition matterDefinition;
    //private MatterSolver matterSolver;
    private ExternalSolver matterSolver;
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

    public Matter(ExternalSolver matterSolver) {
        this.matterSolver = matterSolver;
        clearAllParameters();
    }

    public MatterDefinition getMatterDefinition() {
        return matterDefinition;
    }

    public void setMatterDefinition(MatterDefinition matterDefinition) {
        this.matterDefinition = matterDefinition;
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
        update();
        return parametersByType.get(parameterType);
    }

    protected void addParameter(Parameter parameter){
        if (parameter.getParameterType()!= ParameterType.OTHER){
            parametersByType.put(parameter.getParameterType(), parameter);
        }
    }

    @Override
    public void update(){
        parametersByType.clear();
        addParameter(absoluteTemperature);
        addParameter(absolutePressure);
        addParameter(specificEnthalpy);
        addParameter(density);
        addParameter(heatCapacity);
    }

    @Override
    public String toString() {
        return "Matter{" +
                "matterType=" + matterType +
                ", stateOfMatter=" + stateOfMatter +
                ", temperature=" + temperature +
                ", absoluteTemperature=" + absoluteTemperature +
                ", absolutePressure=" + absolutePressure +
                ", gaugePressure=" + gaugePressure +
                ", specificEnthalpy=" + specificEnthalpy +
                ", heatCapacity=" + heatCapacity +
                ", specificVolume=" + specificVolume +
                ", density=" + density +
                '}';
    }

    @Override
    public SolverResult solve() {
        return matterSolver.solve(this);
    }

    @Override
    public boolean isSolved() {
        return isSolved;
    }
}
