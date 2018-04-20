package wromaciej.hvac_sim.solver;

import wromaciej.hvac_sim.thermo.Item;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.ParameterType;
import wromaciej.hvac_sim.thermo.quantities.specific.Temperature;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FluidSolver {

    Set<Parameter> parameters;
    Map<ParameterType, Parameter> parametersByTypeMap;

    public FluidSolver(Parameter... parameters) {
        this.parameters = new HashSet<>();
        this.parametersByTypeMap = new HashMap<>();

        for (Parameter parameter : parameters) {
            this.parameters.add(parameter);
            this.parametersByTypeMap.put(parameter.getParameterType(), parameter);
        }
    }

    public Parameter getParameterByType(ParameterType parameterType){
        return parametersByTypeMap.get(parameterType);
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
