package wromaciej.hvac_sim.solver;

import wromaciej.hvac_sim.solver.result.SolverResult;
import wromaciej.hvac_sim.solver.result.SolverResultType;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.ParameterType;

import java.util.List;

/**
 *
 */

public class SolverParameters {

    private final int neededParameters;
    private List<Parameter> definedParameters;

    public List<Parameter> getDefinedParameters() {
        return definedParameters;
    }

    public SolverParameters(int neededParameters, Parameter...parameters) {
        this.neededParameters = neededParameters;
        setDefinedParameters(parameters);

    }

    private void setDefinedParameters(Parameter... parameters){
        clearDefinedParameters();
        if (parameters != null){
            for (Parameter parameter : parameters) {
                addParameter(parameter);
            }
        }

    }

    private void clearDefinedParameters() {
        definedParameters.clear();
    }

    private void addParameter(Parameter knownParameter) {
        if ((knownParameter.getParameterType() != ParameterType.OTHER)
                && (definedParameters.indexOf(knownParameter) == -1))
            definedParameters.add(knownParameter);
    }

    private int parametersNumber(){
        return definedParameters.size();
    }

    private int unknownParametersNumber(){
        return neededParameters-parametersNumber();
    }

    public SolverResultType solverResultType(){
        SolverResultType solverResultType;
        if (unknownParametersNumber()>1) solverResultType = SolverResultType.NOT_SOLVED_NODATA;
        else if (unknownParametersNumber()<1) solverResultType = SolverResultType.NOT_SOLVED_TOO_MUCH_DATA;
        else solverResultType=SolverResultType.SOLVED;
        return solverResultType;
    }
}
