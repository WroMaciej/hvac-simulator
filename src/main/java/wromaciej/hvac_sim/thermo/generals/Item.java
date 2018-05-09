package wromaciej.hvac_sim.thermo.generals;

import wromaciej.hvac_sim.display.DisplayParameters;
import wromaciej.hvac_sim.display.Displayable;
import wromaciej.hvac_sim.ids.IdGenerator;
import wromaciej.hvac_sim.solver.internals.Solvable;
import wromaciej.hvac_sim.solver.externals.ExternalSolver;
import wromaciej.hvac_sim.solver.result.SolverResult;

/**
 * Any object that could be treated as a part of process
 */
public abstract class Item implements Displayable, Solvable, Bondable {

    private final int id;
    private String name;
    private boolean isSolved;
    private ExternalSolver actualExternalSolver;

    public ExternalSolver getActualExternalSolver() {
        return actualExternalSolver;
    }

    public void setActualExternalSolver(ExternalSolver actualExternalSolver) {
        this.actualExternalSolver = actualExternalSolver;
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


    @Override
    public SolverResult solve() {
        return actualExternalSolver.solve(this);
    }

    @Override
    public boolean isSolved() {
        return isSolved;
    }

    @Override
    public String display() {
        return null;
    }
}
