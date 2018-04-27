package wromaciej.hvac_sim.solver.internals;

import wromaciej.hvac_sim.solver.result.SolverResult;

public interface InternalSolver {

    SolverResult solve();

    boolean isSolved();
}
