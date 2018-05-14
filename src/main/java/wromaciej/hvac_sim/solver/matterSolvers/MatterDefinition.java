package wromaciej.hvac_sim.solver.matterSolvers;

import wromaciej.hvac_sim.thermo.matter.Matter;
import wromaciej.hvac_sim.thermo.matter.fluids.model.FluidName;
import wromaciej.hvac_sim.thermo.matter.fluids.model.MatterType;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.ParameterType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class MatterDefinition {

    protected FluidName fluidName;
    protected MatterType matterType;
    protected List<Parameter> definedParameters;

    public MatterDefinition() {
        definedParameters = new ArrayList<>();
    }

    public MatterDefinition(FluidName fluidName, MatterType matterType, Parameter... parameters) {
        this();
        this.fluidName = fluidName;
        this.matterType = matterType;

        setDefinedParameters(parameters);
    }



    public void setFluidName(FluidName fluidName) {
        this.fluidName = fluidName;
    }

    public FluidName getFluidName() {
        return fluidName;
    }

    public MatterType getMatterType() {
        return matterType;
    }

    public void setMatterType(MatterType matterType) {
        this.matterType = matterType;
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

    public void putOnlyUserDefinedParameters(Matter matter){
        clearDefinedParameters();
        for (Map.Entry<ParameterType, Parameter> entry : matter.getParametersByType().entrySet()){
            if (entry.getValue().isUserDefined()) addParameter(entry.getValue());
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
                && ((!definedParameters.isEmpty())
                || (definedParameters.indexOf(knownParameter) == -1))){
            definedParameters.add(knownParameter);
            System.out.println("added: " + knownParameter);
        }
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

    @Override
    public String toString() {
        StringBuilder definedParametersStringBuilder = new StringBuilder();
        if (definedParameters!=null){
            for (Parameter parameter: definedParameters){
                definedParametersStringBuilder.append(parameter);
            }
        }


        return "MatterDefinition{" +
                "fluidName=" + fluidName +
                ", matterType=" + matterType +
                ", definedParameters=" + definedParametersStringBuilder.toString() +
                '}';
    }
}
