package wromaciej.hvac_sim.solver.itemSolvers;

import wromaciej.hvac_sim.solver.result.SolverResultType;
import wromaciej.hvac_sim.thermo.devices.model.basic.Heater;
import wromaciej.hvac_sim.thermo.generals.Item;

public class HeaterSolver implements ItemSolver {
    @Override
    public SolverResultType solve(Item heater) {
        heater = (Heater) heater;

        return null;
    }
}
