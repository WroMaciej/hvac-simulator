package wromaciej.hvac_sim.simulation.thermo.generals;

import wromaciej.hvac_sim.display.DisplayParameters;
import wromaciej.hvac_sim.display.Displayable;
import wromaciej.hvac_sim.ids.IdGenerator;
import wromaciej.hvac_sim.simulation.solver.internals.Solvable;
import wromaciej.hvac_sim.simulation.solver.externals.ExternalSolver;
import wromaciej.hvac_sim.simulation.solver.result.SolverResult;

/**
 * Any object that could be treated as a part of process
 */
public abstract class Item implements Displayable, Solvable, Bondable {

    private final Integer id;
    private String name;
    private boolean isSolved;
    private ExternalSolver externalSolver;
    private DisplayParameters displayParameters;

    public Item(Integer id, IdGenerator idGenerator) {
        this.id = id;
        isSolved = false;
    }

    public ExternalSolver getExternalSolver() {
        return externalSolver;
    }

    public void setExternalSolver(ExternalSolver externalSolver) {
        this.externalSolver = externalSolver;
    }


    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setSolved(boolean solved) {
        isSolved = solved;
    }

    public DisplayParameters getDisplayParameters() {
        return displayParameters;
    }

    public void setDisplayParameters(DisplayParameters displayParameters) {
        this.displayParameters = displayParameters;
    }

    @Override
    public String toString() {
        return name;
    }


    @Override
    public SolverResult solve() {
        return externalSolver.solve(this);
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
