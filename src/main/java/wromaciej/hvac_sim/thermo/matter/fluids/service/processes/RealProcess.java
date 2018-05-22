package wromaciej.hvac_sim.thermo.matter.fluids.service.processes;

import org.springframework.stereotype.Service;
import wromaciej.hvac_sim.thermo.matter.fluids.model.Air;
import wromaciej.hvac_sim.thermo.matter.fluids.model.Fluid;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.ParameterType;
import wromaciej.hvac_sim.thermo.matter.fluids.model.FluidFactory;
import wromaciej.hvac_sim.thermo.quantities.specific.Efficiency;
import wromaciej.hvac_sim.thermo.quantities.specific.Pressure;
import wromaciej.hvac_sim.thermo.quantities.specific.PressureDifference;
import wromaciej.hvac_sim.thermo.quantities.specific.SpecificEnthalpy;

@Service
public class RealProcess {

    private IdealProcess idealProcess;
    private FluidFactory fluidFactory;

    private final int MIN_INTERVALS = 2;
    private final int MAX_INTERVALS = 100;


    public RealProcess(IdealProcess idealProcess, FluidFactory fluidFactory) {
        this.idealProcess = idealProcess;
        this.fluidFactory = fluidFactory;
    }

    public Parameter<SpecificEnthalpy> calculateEnthalpyDifference(Fluid beforeProcess, Fluid afterProcess) {
        return afterProcess.getSpecificEnthalpy().minus(beforeProcess.getSpecificEnthalpy());
    }

    public int calculateIntervalsNumber(Fluid fluid, Parameter<PressureDifference> pressureDrop){
        Parameter<Pressure> absolutePressure =  fluid.getAbsolutePressure();
        double relativePressureDrop = absolutePressure.divide(pressureDrop).getValue();
        double intervalsFromFormula = 500.0 * relativePressureDrop;
        if (intervalsFromFormula < MIN_INTERVALS) return MIN_INTERVALS;
        else if (intervalsFromFormula > MAX_INTERVALS) return MAX_INTERVALS;
        else return (int) intervalsFromFormula;
    }

    public Fluid compression(Fluid fluid, Parameter endParameter, Parameter<Efficiency> efficiency) {
        Parameter<SpecificEnthalpy> idealWork = calculateEnthalpyDifference(fluid, idealCompression(fluid, endParameter));
        Parameter<SpecificEnthalpy> realWork = idealWork.divide(efficiency);
        Parameter<SpecificEnthalpy> enthalpyAfterRealCompression = fluid.getSpecificEnthalpy().plus(realWork);
        enthalpyAfterRealCompression.setParameterType(ParameterType.SPECIFIC_ENTHALPY);
        return fluidFactory.createFluid(fluid.getFluidName(), endParameter, enthalpyAfterRealCompression);
    }

    public Fluid expansion(Fluid fluid, Parameter endParameter, Parameter<Efficiency> efficiency) {
        return compression(fluid, endParameter, efficiency);
    }

    public Fluid idealCompression(Fluid fluid, Parameter endParameter) {
        return idealProcess.isentropic(fluid, endParameter);
    }

    public Fluid idealExpansion(Fluid fluid, Parameter endParameter) {
        return idealCompression(fluid, endParameter);
    }

    public Fluid throttling(Fluid fluid, Parameter endParameter) {
        return idealProcess.isenthalpic(fluid, endParameter);
    }

    public Fluid humidification(Air air, Parameter endParameter) {
        return idealProcess.isenthalpic(air, endParameter);
    }

    public Fluid heatExchange(Fluid fluid, Parameter endParameter, Parameter<PressureDifference> pressureDrop) {
       return heatExchangeWithPressureDrop(fluid, endParameter, pressureDrop, calculateIntervalsNumber(fluid, pressureDrop));
    }

    private Fluid heatExchangeWithoutPressureDrop(Fluid fluid, Parameter endParameter) {
        return idealProcess.isobaric(fluid, endParameter);
    }

    private Fluid heatExchangeOneStep(Fluid fluid, Parameter endParameter, Parameter<PressureDifference> pressureLoss) {
        Fluid fluidAfterThrottling = this.throttling(fluid, fluid.getAbsolutePressure().minus(pressureLoss));
        return heatExchangeWithoutPressureDrop(fluidAfterThrottling, endParameter);
    }

    private Fluid heatExchangeWithPressureDrop(Fluid fluid, Parameter endParameter, Parameter<PressureDifference> pressureDrop, int intervals) {
        Fluid fluidAfterStep = fluid; //or a copy?
        Parameter<PressureDifference> pressureDropStep = pressureDrop.divide(intervals);
        Parameter startParameter = fluid.getParameterByType(endParameter.getParameterType());
        Parameter parameterStep = endParameter.minus(startParameter).divide(intervals);
        for (int stepNumber = 0; stepNumber < intervals; stepNumber++) {
            fluidAfterStep = heatExchangeOneStep(fluidAfterStep, startParameter.plus(parameterStep), pressureDropStep);
            startParameter = fluidAfterStep.getParameterByType(endParameter.getParameterType());
        }
        return fluidAfterStep;
    }




}
