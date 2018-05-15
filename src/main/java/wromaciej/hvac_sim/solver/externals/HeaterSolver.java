package wromaciej.hvac_sim.solver.externals;

import wromaciej.hvac_sim.solver.result.SolverResult;
import wromaciej.hvac_sim.thermo.devices.model.basic.Heater;

public class HeaterSolver implements ExternalSolver<Heater> {

    @Override
    public SolverResult solve(Heater toSolve) {
        return toSolve.getMainChannel().solve();
    }
}
