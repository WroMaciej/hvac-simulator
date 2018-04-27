package wromaciej.hvac_sim.solver.internals;

import java.util.ArrayList;
import java.util.List;

public class SolverChecker {

    List<Solvable> solvables;

    public SolverChecker(Solvable... solvables) {
        this.solvables = new ArrayList<>();
        for (Solvable solvable : solvables) {
            this.solvables.add(solvable);
        }
    }

    public int notSolvedItemsNumber() {
        int notSolvedSum = 0;
        for (Solvable solvable : solvables) {
            if (solvable.isSolved() == false) notSolvedSum++;
        }
        return notSolvedSum;
    }

    public List<Solvable> solvedItems() {
        List<Solvable> solvedItemsList = new ArrayList<>();
        for (Solvable solvable : solvables) {
            if (solvable.isSolved()) solvedItemsList.add(solvable);
        }
        return solvedItemsList;
    }

    public List<Solvable> notSolvedItems() {
        List<Solvable> notSolvedItemsList = new ArrayList<>();
        for (Solvable solvable : solvables) {
            if (!solvable.isSolved()) notSolvedItemsList.add(solvable);
        }
        return notSolvedItemsList;
    }

    public boolean isEverythingSolved(){
        return notSolvedItems().isEmpty();
    }


}
