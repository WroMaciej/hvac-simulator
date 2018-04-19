package wromaciej.hvac_sim.thermo;

import wromaciej.hvac_sim.display.DisplayParameters;
import wromaciej.hvac_sim.display.Displayable;
import wromaciej.hvac_sim.ids.IdGenerator;
import wromaciej.hvac_sim.solver.IndividualSolver;
import wromaciej.hvac_sim.solver.SolverChecker;

import java.util.Set;

/**
 * Any object that could be treated as a part of process
 */
public abstract class Item implements Displayable, IndividualSolver {

    private final int id;
    private String name;
    private boolean isSolved;
    protected SolverChecker solverChecker;

    public boolean isSolved() {
        return isSolved;
    }

    public void setSolved(boolean solved) {
        isSolved = solved;
    }

    private DisplayParameters displayParameters;

    public Item(int id, IdGenerator idGenerator) {
        this.id = id;
        isSolved = false;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
