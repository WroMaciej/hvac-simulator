package wromaciej.hvac_sim.thermo.matter.fluids.service;

import wromaciej.hvac_sim.thermo.matter.fluids.model.Air;
import wromaciej.hvac_sim.thermo.matter.fluids.model.Fluid;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.ParameterType;
import wromaciej.hvac_sim.thermo.quantities.specific.Efficiency;
import wromaciej.hvac_sim.thermo.quantities.specific.PressureDifference;
import wromaciej.hvac_sim.thermo.quantities.specific.SpecificEnthalpy;

public class RealProcess {

    public static Parameter<SpecificEnthalpy> getEnthalpyDifference(Fluid beforeProcess, Fluid afterProcess) {
        return afterProcess.getSpecificEnthalpy().minus(beforeProcess.getSpecificEnthalpy());
    }

    public static Fluid compression(Fluid fluid, Parameter endParameter, Parameter<Efficiency> efficiency) {
        Parameter<SpecificEnthalpy> idealWork = getEnthalpyDifference(fluid, idealCompression(fluid, endParameter));
        Parameter<SpecificEnthalpy> realWork = idealWork.divide(efficiency);
        Parameter<SpecificEnthalpy> enthalpyAfterRealCompression = fluid.getSpecificEnthalpy().plus(realWork);
        enthalpyAfterRealCompression.setParameterType(ParameterType.SPECIFIC_ENTHALPY);
        return FluidFactory.createFluid(fluid.getFluidName(), endParameter, enthalpyAfterRealCompression);
    }

    public static Fluid expansion(Fluid fluid, Parameter endParameter, Parameter<Efficiency> efficiency) {
        return compression(fluid, endParameter, efficiency);
    }

    public static Fluid idealCompression(Fluid fluid, Parameter endParameter) {
        return IdealProcess.isEntropic(fluid, endParameter);
    }

    public static Fluid idealExpansion(Fluid fluid, Parameter endParameter) {
        return idealCompression(fluid, endParameter);
    }

    public static Fluid throttling(Fluid fluid, Parameter endParameter) {
        return IdealProcess.isEnthalpic(fluid, endParameter);
    }

    public static Fluid humidification(Air air, Parameter endParameter) {
        return IdealProcess.isEnthalpic(air, endParameter);
    }

    public static Fluid heatExchange(Fluid fluid, Parameter endParameter, Parameter<PressureDifference> pressureLoss) {
        Fluid fluidAfterThrottling = throttling(fluid, fluid.getAbsolutePressure().minus(pressureLoss));
        return IdealProcess.isoBaric(fluidAfterThrottling, endParameter);
    }


}
