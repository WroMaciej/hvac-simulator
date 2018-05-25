package wromaciej.hvac_sim.simulation.thermo.generals.conservationLaw;

import wromaciej.hvac_sim.simulation.solver.externals.JunctionSolver;
import wromaciej.hvac_sim.simulation.solver.internals.Solvable;
import wromaciej.hvac_sim.simulation.solver.result.SolverResult;

import java.util.List;

public class Junction implements Solvable{

    private JunctionSolver junctionSolver;

    private List<ParameterWithDirection> allParameters;

    public List<ParameterWithDirection> getAllParameters() {
        return allParameters;
    }

    public Junction(List<ParameterWithDirection> allParameters, JunctionSolver junctionSolver) {
        this.allParameters = allParameters;
        this.junctionSolver = junctionSolver;
    }

    @Override
    public SolverResult solve() {
        return junctionSolver.solve(this);
    }

    @Override
    public boolean isSolved() {
        return false;
    }
}
