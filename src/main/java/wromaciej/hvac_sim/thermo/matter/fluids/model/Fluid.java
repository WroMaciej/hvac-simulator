package wromaciej.hvac_sim.thermo.matter.fluids.model;


import wromaciej.hvac_sim.solver.externals.ExternalSolver;
import wromaciej.hvac_sim.solver.matterSolvers.FluidDefinition;
import wromaciej.hvac_sim.solver.matterSolvers.MatterDefinition;
import wromaciej.hvac_sim.thermo.matter.Matter;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.ParameterType;
import wromaciej.hvac_sim.thermo.quantities.specific.*;

import java.util.HashMap;
import java.util.Objects;


public class Fluid extends Matter{



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


    /**
     * Entropy
     */
    private Parameter<SpecificEntropy> specificEntropy;
    /**
     * Quality (x), 0-1
     */
    private Parameter<Quality> quality;

    @Override
    protected void clearAllParameters() {
        super.clearAllParameters();
        specificEntropy= new Parameter<>(ParameterType.SPECIFIC_ENTROPY);
        quality = new Parameter<>(ParameterType.QUALITY);
    }

    public Fluid(ExternalSolver<? extends Fluid> fluidSolver) {
        super(fluidSolver);
        clearAllParameters();
        matterDefinition = new FluidDefinition(null, null, null);
        parametersByType = new HashMap<>();
    }



    public void updateParameters(){
        super.updateParameters();
        addParameter(specificEntropy);
        addParameter(quality);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fluid fluid = (Fluid) o;
        return matterType == fluid.matterType &&
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

        return Objects.hash(matterType, fluidName, stateOfMatter, temperature, absoluteTemperature, absolutePressure, gaugePressure, specificEnthalpy, specificEntropy, quality, heatCapacity, specificVolume, density);
    }

    public FluidName getFluidName() {
        return fluidName;
    }

    public void setFluidName(FluidName fluidName) {
        this.fluidName = fluidName;
    }

    public Parameter<SpecificEntropy> getSpecificEntropy() {
        return specificEntropy;
    }

    public void setSpecificEntropy(Parameter<SpecificEntropy> specificEntropy) {
        this.specificEntropy = specificEntropy;
    }

    public Parameter<Quality> getQuality() {
        return quality;
    }

    public void setQuality(Parameter<Quality> quality) {
        this.quality = quality;
    }

    @Override
    public FluidDefinition getMatterDefinition() {
        return this.getMatterDefinition();
    }

    @Override
    public void setMatterDefinition(MatterDefinition matterDefinition) {
        this.matterDefinition = matterDefinition;
    }

    @Override
    public String toString() {
        return "Fluid{" +
                "matterType=" + matterType +
                ", fluidName=" + fluidName +
                ", stateOfMatter=" + stateOfMatter +
                ", temperature=" + temperature +
                ", absoluteTemperature=" + absoluteTemperature +
                ", absolutePressure=" + absolutePressure +
                ", gaugePressure=" + gaugePressure +
                ", specificEnthalpy=" + specificEnthalpy +
                ", specificEntropy=" + specificEntropy +
                ", quality=" + quality +
                ", heatCapacity=" + heatCapacity +
                ", specificVolume=" + specificVolume +
                ", density=" + density +
                '}';
    }




}
