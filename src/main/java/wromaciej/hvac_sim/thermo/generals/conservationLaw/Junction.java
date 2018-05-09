package wromaciej.hvac_sim.thermo.generals.conservationLaw;

import wromaciej.hvac_sim.solver.externals.JunctionSolver;
import wromaciej.hvac_sim.solver.internals.Solvable;
import wromaciej.hvac_sim.solver.result.SolverResult;

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
