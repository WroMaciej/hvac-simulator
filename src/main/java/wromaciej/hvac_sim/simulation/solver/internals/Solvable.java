package wromaciej.hvac_sim.simulation.solver.internals;

import wromaciej.hvac_sim.simulation.solver.result.SolverResult;

public interface Solvable {

    SolverResult solve();

    boolean isSolved();
}
