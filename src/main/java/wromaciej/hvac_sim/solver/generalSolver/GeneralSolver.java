package wromaciej.hvac_sim.solver.generalSolver;

import wromaciej.hvac_sim.simulation.data.AllElements;
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

    private AllElements allElements;

    public GeneralSolver(AllElements allElements) {
        this.allElements = allElements;
    }

    public int notSolvedItemsNumber() {
        int notSolvedSum = 0;
        for (Solvable solvable : allElements.getSolvables()) {
            if (solvable.isSolved() == false) notSolvedSum++;
        }
        return notSolvedSum;
    }

    public List<Solvable> solvedItems() {
        List<Solvable> solvedItemsList = new ArrayList<>();
        for (Solvable solvable : allElements.getSolvables()) {
            if (solvable.isSolved()) solvedItemsList.add(solvable);
        }
        return solvedItemsList;
    }

    public List<Solvable> notSolvedItems() {
        List<Solvable> notSolvedItemsList = new ArrayList<>();
        for (Solvable solvable : allElements.getSolvables()) {
            if (!solvable.isSolved()) notSolvedItemsList.add(solvable);
        }
        return notSolvedItemsList;
    }

    public boolean isEverythingSolved(){
        return notSolvedItems().isEmpty();
    }


}
