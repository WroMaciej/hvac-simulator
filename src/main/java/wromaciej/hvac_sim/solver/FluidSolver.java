package wromaciej.hvac_sim.solver;

import wromaciej.hvac_sim.thermo.matter.fluids.model.Air;
import wromaciej.hvac_sim.thermo.matter.fluids.model.Fluid;
import wromaciej.hvac_sim.thermo.matter.fluids.model.FluidName;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.ParameterType;
import wromaciej.hvac_sim.thermo.matter.fluids.service.FluidFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FluidSolver {

    private class KnownFluidParameters{
        public Parameter knownParameter1;
        public Parameter knownParameter2;

        public KnownFluidParameters() {
        }
    }

    private class KnownAirParameters extends KnownFluidParameters{
        public Parameter airPressure;

        public KnownAirParameters() {
        }
    }

    private FluidName fluidName;

    private Map<ParameterType, Parameter> knownParameters;

    private List<Parameter> allParameters;

    public FluidSolver(FluidName fluidName, Parameter... parameters) {
        this.fluidName = fluidName;
        this.knownParameters = new HashMap<>();

        for (Parameter parameter : parameters) {
            addParameter(parameter);
        }
    }

    public FluidSolver(Fluid fluid) {
        this(fluid.getFluidName(),
                fluid.getAbsoluteTemperature(),
                fluid.getAbsolutePressure(),
                fluid.getSpecificEnthalpy(),
                fluid.getSpecificEntropy(),
                fluid.getQuality(),
                fluid.getHeatCapacity(),
                fluid.getSpecificVolume(),
                fluid.getDensity());
    }

    public FluidSolver(Air air) {
        this(air.getFluidName(),
                air.getAbsoluteTemperature(),
                air.getAbsolutePressure(),
                air.getSpecificEnthalpy(),
                air.getSpecificEntropy(),
                air.getQuality(),
                air.getHeatCapacity(),
                air.getSpecificVolume(),
                air.getDensity(),
                air.getDewPointTemperature(),
                air.getMoistureContent(),
                air.getRelativeHumidity(),
                air.getWaterFraction(),
                air.getWaterPartialPressure(),
                air.getWetBulbTemperature());

    }

    public void clearParameters() {
        knownParameters.clear();
    }

    public void clearFluidName() {
        fluidName = null;
    }

    public void clearParameter(ParameterType parameterType) {
        knownParameters.remove(parameterType);
    }

    public void clearParameter(Parameter parameter) {
        knownParameters.remove(parameter.getParameterType());
    }

    public void addParameter(Parameter knownParameter) {
        if (knownParameter.getParameterType() != ParameterType.OTHER)
            knownParameters.put(knownParameter.getParameterType(), knownParameter);
    }

    public Parameter getParameterByType(ParameterType parameterType) {
        return knownParameters.get(parameterType);
    }


    private int numberOfKnownParameters() {
        return knownParameters.size();
    }


    public SolverResult isSolvable(Fluid fluid) {

        if ((fluidName != null) && (fluid.fluidSolver.numberOfKnownParameters() == 2)) return SolverResult.GOOD_DATA
        else if (fluid.fluidSolver.numberOfKnownParameters() < 2) return SolverResult.INSUFFICIENT_DATA;
        else return SolverResult.TOO_MANY_CONSTRAINTS;
    }

    public SolverResult isSolvable(Air air){


    }

    private KnownFluidParameters knownFluidParameters(){
        KnownFluidParameters knownFluidParameters = new KnownFluidParameters();
        knownFluidParameters.knownParameter1 = knownParameters.
    }
1
    private KnownAirParameters knownAirParameters(){
//        KnownAirParameters knownAirParameters = new KnownAirParameters();
//        knownAirParameters.knownParameter1 = null;
//        kn
//        knownAirParameters.airPressure
    }


    public Fluid solvedFluid(Fluid fluid, FluidFactory fluidFactory) {
        if (isSolvable(fluid)) {
            fluid = fluidFactory.createFluid(fluid.fluidSolver.fluidName,  );
        }
        else return null;
    }

    //    public int notSolvedItemsNumber() {
//        int notSolvedSum = 0;
//        for (Parameter parameter : parameters) {
//            if (parameter.isSolved() == false) notSolvedSum++;
//        }
//        return notSolvedSum;
//    }
//
//    public Set<Parameter> solvedItems() {
//        Set<Item> solvedItemsSet = new HashSet<>();
//        for (Parameter parameter : parameters) {
//            if (parameter.isSolved()) solvedItemsSet.add(parameter);
//        }
//        return solvedItemsSet;
//    }
//
//    public Set<Parameter> notSolvedItems() {
//        Set<Parameter> notSolvedItemsSet = new HashSet<>();
//        for (Parameter parameter : parameters) {
//            if (!parameter.isSolved()) notSolvedItemsSet.add(parameter);
//        }
//        return notSolvedItemsSet;
//    }
//
//    public boolean isEverythingSolved(){
//        return notSolvedItems().isEmpty();
//    }
}
