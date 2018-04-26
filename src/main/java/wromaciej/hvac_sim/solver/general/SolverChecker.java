package wromaciej.hvac_sim.solver.general;

import wromaciej.hvac_sim.thermo.generals.Item;

import java.util.ArrayList;
import java.util.List;

public class SolverChecker {

    List<InternalSolver> internalSolvers;

    public SolverChecker(InternalSolver... internalSolvers) {
        this.internalSolvers = new ArrayList<>();
        for (InternalSolver internalSolver : internalSolvers) {
            this.internalSolvers.add(internalSolver);
        }
    }

    public int notSolvedItemsNumber() {
        int notSolvedSum = 0;
        for (InternalSolver internalSolver : internalSolvers) {
            if (internalSolver.isSolved() == false) notSolvedSum++;
        }
        return notSolvedSum;
    }

    public List<InternalSolver> solvedItems() {
        List<InternalSolver> solvedItemsList = new ArrayList<>();
        for (InternalSolver internalSolver : internalSolvers) {
            if (internalSolver.isSolved()) solvedItemsList.add(internalSolver);
        }
        return solvedItemsList;
    }

    public List<InternalSolver> notSolvedItems() {
        List<InternalSolver> notSolvedItemsList = new ArrayList<>();
        for (InternalSolver internalSolver : internalSolvers) {
            if (!internalSolver.isSolved()) notSolvedItemsList.add(internalSolver);
        }
        return notSolvedItemsList;
    }

    public boolean isEverythingSolved(){
        return notSolvedItems().isEmpty();
    }


}
