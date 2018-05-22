package wromaciej.hvac_sim.solver.externals;

import org.springframework.stereotype.Service;
import wromaciej.hvac_sim.solver.result.SolverResult;
import wromaciej.hvac_sim.thermo.streams.model.MatterStream;

@Service
public class MatterStreamSolver implements ExternalSolver<MatterStream> {


    @Override
    public SolverResult solve(MatterStream toSolve) {
        return toSolve.getSpecificParameters().solve();
    }
}
