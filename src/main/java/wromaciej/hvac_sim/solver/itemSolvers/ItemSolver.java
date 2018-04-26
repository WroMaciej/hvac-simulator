package wromaciej.hvac_sim.solver.itemSolvers;

import wromaciej.hvac_sim.solver.result.SolverResultType;
import wromaciej.hvac_sim.thermo.generals.Item;

public interface ItemSolver {

    SolverResultType solve(Item item);
}
