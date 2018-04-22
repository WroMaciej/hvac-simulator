package wromaciej.hvac_sim.solver;

import wromaciej.hvac_sim.thermo.matter.fluids.model.*;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.ParameterType;
import wromaciej.hvac_sim.thermo.matter.fluids.service.FluidFactory;

import java.util.ArrayList;
import java.util.List;

public class FluidSolver {



    private char NEEDED_GENERAL_FLUID_PARAMETERS = 2;
    private char NEEDED_AIR_PARAMETERS = 3;

    private FluidName fluidName;
    private FluidType fluidType;

    //private Map<ParameterType, Parameter> knownParameters;

    private List<Parameter> definedParameters;

    public void setFluidName(FluidName fluidName) {
        this.fluidName = fluidName;
    }

    public FluidName getFluidName() {
        return fluidName;
    }

    public FluidType getFluidType() {
        return fluidType;
    }

    public void setFluidType(FluidType fluidType) {
        this.fluidType = fluidType;
    }

    private List<Parameter> userDefinedParameters(Fluid fluid){
        List<Parameter> userDefinedParametersList = new ArrayList<>();
        for (Parameter parameter : fluid.fluidSolver.definedParameters){
            if (parameter.isUserDefined()) userDefinedParametersList.add(parameter);
        }
        return userDefinedParametersList;
    }

    public FluidSolver(FluidName fluidName, FluidType fluidType, Parameter... parameters) {
        this.fluidName = fluidName;
        this.fluidType = fluidType;
        //this.knownParameters = new HashMap<>();
        this.definedParameters = new ArrayList<>();

        for (Parameter parameter : parameters) {
            addParameter(parameter);
        }
    }


    public void clearDefinedParameters() {
        //knownParameters.clear();
        definedParameters.clear();
    }

    public void clearFluidName() {
        fluidName = null;
    }

//    public void clearParameter(ParameterType parameterType) {
//        //knownParameters.remove(parameterType);
//    }

    public void removeParameter(Parameter parameter) {
        //knownParameters.remove(parameter.getParameterType());
        definedParameters.remove(parameter);
    }

    public void removeParameter(ParameterType parameterType) {
        for (Parameter parameter : definedParameters){
            if (parameter.getParameterType() == parameterType)
                removeParameter(parameter);
        }
    }

    public void addParameter(Parameter knownParameter) {
        if ((knownParameter.getParameterType() != ParameterType.OTHER)
                && (definedParameters.indexOf(knownParameter) == -1))
            //knownParameters.put(knownParameter.getParameterType(), knownParameter);
            definedParameters.add(knownParameter);
    }

    private boolean isOnlyOneParameterOfGivenType(ParameterType checkingParameter) {
        char numberOfParameters = 0;
        for (Parameter parameter : definedParameters) {
            if (parameter.getParameterType() == checkingParameter)
                numberOfParameters++;
            if (numberOfParameters > 1) break;
        }
        if (numberOfParameters == 1) return true;
        else return false;
    }


    private int numberOfUniqueParameters() {
        int sumOfUniqueParameters = 0;
        for (Parameter parameter : definedParameters){
            if (isOnlyOneParameterOfGivenType(parameter.getParameterType())) sumOfUniqueParameters++;
        }
        return sumOfUniqueParameters;
    }

    private boolean hasOnlyUniqueParameters(){
        if (numberOfUniqueParameters() == definedParameters.size()) return true;
        else return false;
    }



//    public SolverResult solverResult(Fluid fluid) {
//        if (fluid.getClass() == Fluid.class){
//
//        }
//
//        if ((fluidName != null) && (fluid.fluidSolver.numberOfUniqueParameters() == NEEDED_FLUID_PARAMETERS)) return SolverResult.GOOD_DATA
//        else if (fluid.fluidSolver.numberOfUniqueParameters() < NEEDED_FLUID_PARAMETERS) return SolverResult.INSUFFICIENT_DATA;
//        else return SolverResult.TOO_MANY_CONSTRAINTS;
//    }
//
//
//
//    public boolean isSolvable(Fluid fluid) {
//        if (fluid.fluidSolver.solverResult(fluid) == SolverResult.GOOD_DATA) return true;
//        else return false;
//    }




    public SolverResult solve(Fluid fluid, FluidFactory fluidFactory) {
        if ((fluid.fluidSolver.fluidType != FluidType.AIR) && (fluid.fluidSolver.fluidName == null))
            return SolverResult.INSUFFICIENT_DATA;
        else{
            int numberOfUniqueParameters = fluid.fluidSolver.numberOfUniqueParameters();

            if (fluid.fluidSolver.fluidType == FluidType.AIR){
                if ((numberOfUniqueParameters > NEEDED_AIR_PARAMETERS) || (!hasOnlyUniqueParameters()))
                    return SolverResult.TOO_MANY_CONSTRAINTS;
                else if (numberOfUniqueParameters < NEEDED_AIR_PARAMETERS)
                    return SolverResult.INSUFFICIENT_DATA;
                else
                    fluid = fluidFactory.createAir(
                            definedParameters.get(1),
                            definedParameters.get(2),
                            definedParameters.get(3));
            }
            else if (fluid.fluidSolver.fluidType == FluidType.GENERAL){
                if ((numberOfUniqueParameters > NEEDED_GENERAL_FLUID_PARAMETERS) || (!hasOnlyUniqueParameters()))
                    return SolverResult.TOO_MANY_CONSTRAINTS;
                else if (numberOfUniqueParameters < NEEDED_GENERAL_FLUID_PARAMETERS)
                    return SolverResult.INSUFFICIENT_DATA;
                else
                    fluid = fluidFactory.createFluid(
                            fluid.fluidSolver.fluidName,
                            definedParameters.get(1),
                            definedParameters.get(2));
            }
        }
        return null; //there is no that case
    }


}
