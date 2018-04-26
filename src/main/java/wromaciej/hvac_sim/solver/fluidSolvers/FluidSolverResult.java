package wromaciej.hvac_sim.solver.fluidSolvers;

import wromaciej.hvac_sim.solver.result.SolverResultType;
import wromaciej.hvac_sim.thermo.matter.fluids.model.Fluid;

public class FluidSolverResult {
    final SolverResultType solverResultType;
    final Fluid solvedFluid;

    public FluidSolverResult(SolverResultType solverResultType, Fluid solvedFluid) {
        this.solverResultType = solverResultType;
        this.solvedFluid = solvedFluid;
    }

    public SolverResultType getSolverResultType() {
        return solverResultType;
    }

    public Fluid getSolvedFluid() {
        return solvedFluid;
    }
}
