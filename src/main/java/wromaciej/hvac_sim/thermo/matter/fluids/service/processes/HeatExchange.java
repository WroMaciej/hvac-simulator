package wromaciej.hvac_sim.thermo.matter.fluids.service.processes;

import wromaciej.hvac_sim.thermo.matter.fluids.model.Fluid;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.matter.fluids.service.FluidFactory;
import wromaciej.hvac_sim.thermo.quantities.specific.PressureDifference;

public class HeatExchange {

    private IdealProcess idealProcess;
    private RealProcess realProcess;
    private FluidFactory fluidFactory;

    public HeatExchange(IdealProcess idealProcess, RealProcess realProcess, FluidFactory fluidFactory) {
        this.idealProcess = idealProcess;
        this.realProcess = realProcess;
        this.fluidFactory = fluidFactory;
    }

    public Fluid heatExchangeOneStep(Fluid fluid, Parameter endParameter, Parameter<PressureDifference> pressureLoss) {
        Fluid fluidAfterThrottling = realProcess.throttling(fluid, fluid.getAbsolutePressure().minus(pressureLoss));
        return idealProcess.isobaric(fluidAfterThrottling, endParameter);
    }

    public Fluid pressureDropProcess(Fluid fluid, Parameter endParameter, Parameter<PressureDifference> pressureDrop, int intervals) {
        Fluid fluidAfterStep = fluid; //or a copy?
        Parameter<PressureDifference> pressureDropStep = pressureDrop.divide(intervals);
        Parameter startParameter = fluid.fluidSolver.getParameterByType(endParameter.getParameterType());
        Parameter parameterStep = endParameter.minus(startParameter).divide(intervals);

        for (int stepNumber = 0; stepNumber < intervals; stepNumber++) {
            fluidAfterStep = heatExchangeOneStep(fluidAfterStep,   )
        }

    }



}
