package wromaciej.hvac_sim.solver.externals;

import wromaciej.hvac_sim.solver.result.SolverResult;


public interface ExternalSolver<T> {

    SolverResult solve(T toSolve);
}
