package wromaciej.hvac_sim.solver.externals;

import wromaciej.hvac_sim.solver.result.SolverResult;
import wromaciej.hvac_sim.solver.result.SolverResultType;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;

import java.util.List;

/**
 *
 */

public class SolverBalancedJunction {

    //private int neededParameters;
    private List<Parameter> allParameters;
    private List<Parameter> undefinedParameters;
    private List<Parameter> definedParameters;

    public List<Parameter> getDefinedParameters() {
        return definedParameters;
    }

    public SolverBalancedJunction(Parameter...parameters) {
        setAllParameters(parameters);
    }

    private void setAllParameters(Parameter... parameters){
        if (parameters != null){
            for (Parameter parameter : parameters) {
                allParameters.add(parameter);
                if (parameter.isDefined()) definedParameters.add(parameter);
                else undefinedParameters.add(parameter);
            }
        }
    }



    private int allParametersNumber(){
        return allParameters.size();
    }

    private int definedParametersNumber(){
        return definedParameters.size();
    }
    private int undefinedParametersNumber(){
        return undefinedParameters.size();
    }

    private Parameter getUndefinedParameter(){
        if (undefinedParametersNumber() == 1) return undefinedParameters.get(0);
        else return null;
    }

    private void setUndefinedParameter(Parameter parameter){
        getUndefinedParameter()=null;
    }

    private Parameter getBalance(){
        Parameter sum = new Parameter();
        for (Parameter parameter : definedParameters){
            sum = sum.plus(parameter);
        }
        return sum;
    }



    public SolverResult solve{
        SolverResultType solverResultType;
        if (undefinedParametersNumber() == 1){
            getUndefinedParameter()=null;
        }

    }
}
