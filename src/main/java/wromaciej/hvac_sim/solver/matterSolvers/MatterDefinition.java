package wromaciej.hvac_sim.solver.matterSolvers;

import wromaciej.hvac_sim.thermo.matter.fluids.model.FluidName;
import wromaciej.hvac_sim.thermo.matter.fluids.model.MatterType;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.ParameterType;

import java.util.ArrayList;
import java.util.List;

public abstract class MatterDefinition {

    private FluidName fluidName;
    private MatterType fluidType;



    private List<Parameter> definedParameters;

    public void setFluidName(FluidName fluidName) {
        this.fluidName = fluidName;
    }

    public FluidName getFluidName() {
        return fluidName;
    }

    public MatterType getFluidType() {
        return fluidType;
    }

    public void setFluidType(MatterType fluidType) {
        this.fluidType = fluidType;
    }


    public List<Parameter> getDefinedParameters() {
        return definedParameters;
    }

    public Parameter getParameterByType(ParameterType parameterType) {
        Parameter searchingParameter = new Parameter();
        for (Parameter parameter : definedParameters){
            if (parameter.getParameterType() == parameterType) searchingParameter = parameter;
        }

        return searchingParameter;
    }

    public void setDefinedParameters(Parameter... parameters){
        clearDefinedParameters();
        if (parameters != null){
            for (Parameter parameter : parameters) {
                addParameter(parameter);
            }
        }

    }


    public void clearDefinedParameters() {
        definedParameters.clear();
    }

    public void clearFluidName() {
        fluidName = null;
    }


    public void removeParameter(Parameter parameter) {
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


    public int numberOfUniqueParameters() {
        int sumOfUniqueParameters = 0;
        for (Parameter parameter : definedParameters){
            if (isOnlyOneParameterOfGivenType(parameter.getParameterType())) sumOfUniqueParameters++;
        }
        return sumOfUniqueParameters;
    }

    public boolean hasOnlyUniqueParameters(){
        if (numberOfUniqueParameters() == definedParameters.size()) return true;
        else return false;
    }
}
