package wromaciej.hvac_sim.simulation.solver.externals;

import wromaciej.hvac_sim.simulation.solver.result.SolverResult;


public interface ExternalSolver<T> {

    SolverResult solve(T toSolve);
}
