package wromaciej.hvac_sim.thermo.generals;

import wromaciej.hvac_sim.display.DisplayParameters;
import wromaciej.hvac_sim.display.Displayable;
import wromaciej.hvac_sim.ids.IdGenerator;
import wromaciej.hvac_sim.solver.itemSolvers.ItemSolver;
import wromaciej.hvac_sim.solver.general.SolverChecker;
import wromaciej.hvac_sim.solver.result.SolverResultType;

/**
 * Any object that could be treated as a part of process
 */
public abstract class Item implements Displayable {

    private final int id;
    private String name;
    private boolean isSolved;
    protected SolverChecker solverChecker;
    private ItemSolver actualItemSolver;

    public ItemSolver getActualItemSolver() {
        return actualItemSolver;
    }

    public void setActualItemSolver(ItemSolver actualItemSolver) {
        this.actualItemSolver = actualItemSolver;
    }

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


    public SolverResultType solve() {
        return actualItemSolver.solve(this);
    }
}
