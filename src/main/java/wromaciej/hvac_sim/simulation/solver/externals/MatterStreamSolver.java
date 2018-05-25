package wromaciej.hvac_sim.simulation.solver.externals;

import org.springframework.stereotype.Service;
import wromaciej.hvac_sim.simulation.solver.result.SolverResult;
import wromaciej.hvac_sim.thermo.streams.model.MatterStream;

@Service
public class MatterStreamSolver implements ExternalSolver<MatterStream> {


    @Override
    public SolverResult solve(MatterStream toSolve) {
        return toSolve.getSpecificParameters().solve();
    }
}
