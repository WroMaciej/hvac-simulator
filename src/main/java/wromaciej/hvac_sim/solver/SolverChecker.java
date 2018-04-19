package wromaciej.hvac_sim.solver;

import wromaciej.hvac_sim.thermo.Item;

import java.util.HashSet;
import java.util.Set;

public class SolverChecker {

    Set<Item> allItems;

    public SolverChecker(Item... items) {
        this.allItems = new HashSet<>();
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

    public Set<Item> solvedItems() {
        Set<Item> solvedItemsSet = new HashSet<>();
        for (Item item : allItems) {
            if (item.isSolved()) solvedItemsSet.add(item);
        }
        return solvedItemsSet;
    }

    public Set<Item> notSolvedItems() {
        Set<Item> notSolvedItemsSet = new HashSet<>();
        for (Item item : allItems) {
            if (!item.isSolved()) notSolvedItemsSet.add(item);
        }
        return notSolvedItemsSet;
    }

    public boolean isEverythingSolved(){
        return notSolvedItems().isEmpty();
    }
    

}
