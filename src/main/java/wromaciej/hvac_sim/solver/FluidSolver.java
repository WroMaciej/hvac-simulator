package wromaciej.hvac_sim.solver;

import wromaciej.hvac_sim.thermo.matter.fluids.model.Air;
import wromaciej.hvac_sim.thermo.matter.fluids.model.Fluid;
import wromaciej.hvac_sim.thermo.matter.fluids.model.FluidName;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.ParameterType;
import wromaciej.hvac_sim.thermo.matter.fluids.service.FluidFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FluidSolver {

    private class KnownFluidParameters {
        public Parameter knownParameter1;
        public Parameter knownParameter2;

        public KnownFluidParameters() {
        }
    }

    private class KnownAirParameters extends KnownFluidParameters {
        public Parameter airPressure;

        public KnownAirParameters() {
        }
    }

    private FluidName fluidName;

    //private Map<ParameterType, Parameter> knownParameters;

    private List<Parameter> allParameters;

    public void setFluidName(FluidName fluidName) {
        this.fluidName = fluidName;
    }

    public FluidName getFluidName() {
        return fluidName;
    }

    public FluidSolver(FluidName fluidName, Parameter... parameters) {
        this.fluidName = fluidName;
        //this.knownParameters = new HashMap<>();
        this.allParameters = new ArrayList<>();

        for (Parameter parameter : parameters) {
            addParameter(parameter);
        }
    }

    public FluidSolver(Fluid fluid) {
        this(fluid.getFluidName(),
                fluid.getAbsoluteTemperature(),
                //fluid.getAbsolutePressure(),
                //fluid.getSpecificEnthalpy(),
                fluid.getSpecificEntropy());
                //fluid.getQuality(),
                //fluid.getHeatCapacity(),
                //fluid.getSpecificVolume(),
                //fluid.getDensity());
    }

    public FluidSolver(Air air) {
        this(air.getFluidName(),
                air.getAbsoluteTemperature(),
                air.getAbsolutePressure(),
                //air.getSpecificEnthalpy(),
                //air.getSpecificEntropy(),
                //air.getQuality(),
                //air.getHeatCapacity(),
                //air.getSpecificVolume(),
                //air.getDensity(),
                //air.getDewPointTemperature(),
                air.getMoistureContent());
                //air.getRelativeHumidity(),
                //air.getWaterFraction(),
                //air.getWaterPartialPressure(),
                //air.getWetBulbTemperature());

    }

    public void clearAllParameters() {
        //knownParameters.clear();
        allParameters.clear();
    }

    public void clearFluidName() {
        fluidName = null;
    }

//    public void clearParameter(ParameterType parameterType) {
//        //knownParameters.remove(parameterType);
//    }

    public void removeParameter(Parameter parameter) {
        //knownParameters.remove(parameter.getParameterType());
        allParameters.remove(parameter);
    }

    public void addParameter(Parameter knownParameter) {
        if ((knownParameter.getParameterType() != ParameterType.OTHER)
                && (allParameters.indexOf(knownParameter) == -1))
            //knownParameters.put(knownParameter.getParameterType(), knownParameter);
            allParameters.add(knownParameter);
    }

    private boolean isOneParameterOfGivenType(ParameterType checkingParameter) {
        char numberOfParameters = 0;
        for (Parameter parameter : allParameters) {
            if (parameter.getParameterType() == checkingParameter)
                numberOfParameters++;
            if (numberOfParameters > 1) break;
        }
        if (numberOfParameters == 1) return true;
        else return false;
    }

    private int numberOfDifferentParameters(Fluid fluid){

    }


//    public Parameter getParameterByType(ParameterType parameterType) {
//        //return knownParameters.get(parameterType);
//    }


    private int numberOfKnownParameters() {
        //return knownParameters.size();
        return allParameters.size();
    }


    public SolverResult solverResult(Fluid fluid) {
        if ((fluidName != null) && (fluid.fluidSolver.numberOfKnownParameters() == 2)) return SolverResult.GOOD_DATA
        else if (fluid.fluidSolver.numberOfKnownParameters() < 2) return SolverResult.INSUFFICIENT_DATA;
        else return SolverResult.TOO_MANY_CONSTRAINTS;
    }

    public boolean isSolvable(Fluid fluid) {
        if (fluid.fluidSolver.solverResult(fluid) == SolverResult.GOOD_DATA) return true;
        else return false;
    }

    public SolverResult isSolvable(Air air) {


    }

    private KnownFluidParameters knownFluidParameters() {
        KnownFluidParameters knownFluidParameters = new KnownFluidParameters();
        knownFluidParameters.knownParameter1 = knownParameters.
    }
1

    private KnownAirParameters knownAirParameters() {
//        KnownAirParameters knownAirParameters = new KnownAirParameters();
//        knownAirParameters.knownParameter1 = null;
//        kn
//        knownAirParameters.airPressure
    }


    public Fluid solvedFluid(Fluid fluid, FluidFactory fluidFactory) {
        if (isSolvable(fluid)) {
            fluid = fluidFactory.createFluid(fluid.fluidSolver.fluidName, );
        } else return null;
    }


}
