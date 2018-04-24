package wromaciej.hvac_sim.solver;

import wromaciej.hvac_sim.thermo.matter.fluids.model.Fluid;

public class FluidSolverResult {
    final SolverResult solverResult;
    final Fluid solvedFluid;

    public FluidSolverResult(SolverResult solverResult, Fluid solvedFluid) {
        this.solverResult = solverResult;
        this.solvedFluid = solvedFluid;
    }

    public SolverResult getSolverResult() {
        return solverResult;
    }

    public Fluid getSolvedFluid() {
        return solvedFluid;
    }
}
