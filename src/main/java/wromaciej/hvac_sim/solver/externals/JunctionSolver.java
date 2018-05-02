package wromaciej.hvac_sim.solver.externals;

import wromaciej.hvac_sim.solver.result.SolverResult;
import wromaciej.hvac_sim.solver.result.SolverResultType;
import wromaciej.hvac_sim.thermo.generals.bonds.BondDirection;
import wromaciej.hvac_sim.thermo.generals.bonds.ParameterWithDirection;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;

import java.util.List;

/**
 *
 */

public class JunctionSolver {


    private List<ParameterWithDirection> allParameters;
    private List<ParameterWithDirection> undefinedParameters;
    private List<ParameterWithDirection> definedParameters;


    public JunctionSolver(List<ParameterWithDirection> parametersWithDirections) {
        if (parametersWithDirections != null){
            for (ParameterWithDirection parameterWithDirection : parametersWithDirections) {
                allParameters.add(parameterWithDirection);
                if (parameterWithDirection.getParameter().isDefined()) definedParameters.add(parameterWithDirection);
                else undefinedParameters.add(parameterWithDirection);
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

    private ParameterWithDirection getBalance(){
        Parameter sum = new Parameter();
        for (ParameterWithDirection parameterWithDirection : definedParameters){
            sum = sum.plus(parameterWithDirection.getParameter().times(parameterWithDirection.getDirection().balanceMultiplyer));
        }

    }



    public SolverResult solve{
        SolverResultType solverResultType;
        if (undefinedParametersNumber() == 1){
            getUndefinedParameter()=null;
        }

    }
}
