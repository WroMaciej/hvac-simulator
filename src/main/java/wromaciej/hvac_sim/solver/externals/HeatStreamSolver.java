package wromaciej.hvac_sim.solver.externals;

import wromaciej.hvac_sim.solver.result.SolverResult;
import wromaciej.hvac_sim.solver.result.SolverResultType;
import wromaciej.hvac_sim.thermo.streams.model.HeatStream;

public class HeatStreamSolver implements ExternalSolver<HeatStream>  {
    @Override
    public SolverResult solve(HeatStream toSolve) {
        return new SolverResult(null, SolverResultType.SOLVED);
    }
}
