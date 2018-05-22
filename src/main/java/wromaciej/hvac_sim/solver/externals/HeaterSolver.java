package wromaciej.hvac_sim.solver.externals;

import org.springframework.stereotype.Service;
import wromaciej.hvac_sim.solver.result.SolverResult;
import wromaciej.hvac_sim.thermo.devices.model.basic.Heater;

@Service
public class HeaterSolver implements ExternalSolver<Heater> {

    @Override
    public SolverResult solve(Heater toSolve) {
        return toSolve.getMainChannel().solve();
    }
}
