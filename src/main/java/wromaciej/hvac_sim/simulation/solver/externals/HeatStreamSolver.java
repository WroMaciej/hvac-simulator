package wromaciej.hvac_sim.simulation.solver.externals;

import org.springframework.stereotype.Service;
import wromaciej.hvac_sim.simulation.solver.result.SolverResult;
import wromaciej.hvac_sim.simulation.solver.result.SolverResultType;
import wromaciej.hvac_sim.thermo.streams.model.HeatStream;

@Service
public class HeatStreamSolver implements ExternalSolver<HeatStream>  {
    @Override
    public SolverResult solve(HeatStream toSolve) {
        return new SolverResult(null, SolverResultType.SOLVED);
    }
}
