package wromaciej.hvac_sim.solver;

import wromaciej.hvac_sim.thermo.generals.Item;

import java.util.ArrayList;
import java.util.List;

public class SolverChecker {

    List<Item> allItems;

    public SolverChecker(Item... items) {
        this.allItems = new ArrayList<>();
        for (Item item : items) {
            this.allItems.add(item);
        }
    }

    public int notSolvedItemsNumber() {
        int notSolvedSum = 0;
        for (Item item : allItems) {
            if (item.isSolved() == false) notSolvedSum++;
        }
        return notSolvedSum;
    }

    public List<Item> solvedItems() {
        List<Item> solvedItemsSet = new ArrayList<>();
        for (Item item : allItems) {
            if (item.isSolved()) solvedItemsSet.add(item);
        }
        return solvedItemsSet;
    }

    public List<Item> notSolvedItems() {
        List<Item> notSolvedItemsSet = new ArrayList<>();
        for (Item item : allItems) {
            if (!item.isSolved()) notSolvedItemsSet.add(item);
        }
        return notSolvedItemsSet;
    }

    public boolean isEverythingSolved(){
        return notSolvedItems().isEmpty();
    }


}
