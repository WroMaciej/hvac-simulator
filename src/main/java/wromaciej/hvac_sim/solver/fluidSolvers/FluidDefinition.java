package wromaciej.hvac_sim.solver.fluidSolvers;

import wromaciej.hvac_sim.thermo.matter.fluids.model.Fluid;
import wromaciej.hvac_sim.thermo.matter.fluids.model.*;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.ParameterType;
import wromaciej.hvac_sim.thermo.matter.fluids.model.FluidFactory;

import java.util.ArrayList;
import java.util.List;

public class FluidDefinition {

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

    public  FluidDefinition(){
        this.definedParameters = new ArrayList<>();
    }

    public FluidDefinition(FluidName fluidName, FluidType fluidType, Parameter... parameters) {
        this();
        this.fluidName = fluidName;
        this.fluidType = fluidType;

        setDefinedParameters(parameters);

    }

    public List<Parameter> getDefinedParameters() {
        return definedParameters;
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
        //knownParameters.clear();
        definedParameters.clear();
    }

    public void clearFluidName() {
        fluidName = null;
    }


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
