package wromaciej.hvac_sim.thermo.matter.fluids.service;

import wromaciej.hvac_sim.thermo.matter.fluids.model.Air;
import wromaciej.hvac_sim.thermo.matter.fluids.model.Fluid;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.ParameterType;
import wromaciej.hvac_sim.thermo.quantities.specific.Efficiency;
import wromaciej.hvac_sim.thermo.quantities.specific.PressureDifference;
import wromaciej.hvac_sim.thermo.quantities.specific.SpecificEnthalpy;

public class RealProcess {

    private IdealProcess idealProcess;
    private FluidFactory fluidFactory;

    public RealProcess(IdealProcess idealProcess, FluidFactory fluidFactory) {
        this.idealProcess = idealProcess;
        this.fluidFactory = fluidFactory;
    }

    public Parameter<SpecificEnthalpy> getEnthalpyDifference(Fluid beforeProcess, Fluid afterProcess) {
        return afterProcess.getSpecificEnthalpy().minus(beforeProcess.getSpecificEnthalpy());
    }

    public Fluid compression(Fluid fluid, Parameter endParameter, Parameter<Efficiency> efficiency) {
        Parameter<SpecificEnthalpy> idealWork = getEnthalpyDifference(fluid, idealCompression(fluid, endParameter));
        Parameter<SpecificEnthalpy> realWork = idealWork.divide(efficiency);
        Parameter<SpecificEnthalpy> enthalpyAfterRealCompression = fluid.getSpecificEnthalpy().plus(realWork);
        enthalpyAfterRealCompression.setParameterType(ParameterType.SPECIFIC_ENTHALPY);
        return fluidFactory.createFluid(fluid.getFluidName(), endParameter, enthalpyAfterRealCompression);
    }

    public Fluid expansion(Fluid fluid, Parameter endParameter, Parameter<Efficiency> efficiency) {
        return compression(fluid, endParameter, efficiency);
    }

    public Fluid idealCompression(Fluid fluid, Parameter endParameter) {
        return idealProcess.isEntropic(fluid, endParameter);
    }

    public Fluid idealExpansion(Fluid fluid, Parameter endParameter) {
        return idealCompression(fluid, endParameter);
    }

    public Fluid throttling(Fluid fluid, Parameter endParameter) {
        return idealProcess.isEnthalpic(fluid, endParameter);
    }

    public Fluid humidification(Air air, Parameter endParameter) {
        return idealProcess.isEnthalpic(air, endParameter);
    }

    public Fluid heatExchange(Fluid fluid, Parameter endParameter, Parameter<PressureDifference> pressureLoss) {
        Fluid fluidAfterThrottling = throttling(fluid, fluid.getAbsolutePressure().minus(pressureLoss));
        return idealProcess.isoBaric(fluidAfterThrottling, endParameter);
    }


}
