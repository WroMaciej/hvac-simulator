package wromaciej.hvac_sim.solver.generalSolver;

import wromaciej.hvac_sim.solver.internals.Solvable;
import wromaciej.hvac_sim.thermo.devices.model.basic.Device;
import wromaciej.hvac_sim.thermo.generals.Item;
import wromaciej.hvac_sim.thermo.matter.Matter;
import wromaciej.hvac_sim.thermo.streams.model.MatterStream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GeneralSolver {



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
