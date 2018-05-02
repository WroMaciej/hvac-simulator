package wromaciej.hvac_sim.solver.externals;

import wromaciej.hvac_sim.solver.result.SolverResult;
import wromaciej.hvac_sim.solver.result.SolverResultType;
import wromaciej.hvac_sim.thermo.generals.bonds.BondDirection;
import wromaciej.hvac_sim.thermo.generals.bonds.Channel;
import wromaciej.hvac_sim.thermo.generals.bonds.Junction;
import wromaciej.hvac_sim.thermo.generals.bonds.ParameterWithDirection;
import wromaciej.hvac_sim.thermo.streams.model.MatterStream;

import java.util.ArrayList;
import java.util.List;

public class ChannelSolver implements ExternalSolver<Channel<? extends MatterStream>> {

    JunctionSolver junctionSolver;

    public ChannelSolver(JunctionSolver junctionSolver) {
        this.junctionSolver = junctionSolver;
    }

    private Junction channelToMassFlowJunction(Channel toSolve){
        List<ParameterWithDirection> parametersWithDirections = new ArrayList<>();
        parametersWithDirections.add(new ParameterWithDirection(toSolve.getInletStream().getMassFlow(), BondDirection.INLET));
        parametersWithDirections.add(new ParameterWithDirection(toSolve.getOutletStream().getMassFlow(), BondDirection.OUTLET));
        parametersWithDirections.add(toSolve.getExtraMassFlow());
        return new Junction(parametersWithDirections, junctionSolver);
    }

    private Junction channelToPressureJunction(Channel toSolve){}


    private SolverResult solveMassFlows(Channel channelToSolve){
        SolverResultType solverResultType;
        final int NEEDED_PARAMETERS = 3;
        JunctionSolver junctionSolver = new JunctionSolver(
                NEEDED_PARAMETERS,
                channelToSolve.getInletStream().getMassFlow(),
                channelToSolve.getOutletStream().getMassFlow(),
                channelToSolve.getAdditionalMassFlow());
        solverResultType= junctionSolver.solverResultType();
        if (solverResultType == SolverResultType.SOLVED){
            if (channelToSolve.getAdditionalMassFlow()!=null){
                channelToSolve.setAdditionalMassFlow(); //ITS FINAL
            }


        }
        return new SolverResult(null,solverResultType);
    }

    private SolverResult solvePressures(Channel channelToSolve){


        return null;
    }



    @Override
    public SolverResult solve(Channel<? extends MatterStream> channelToSolve) {
        return null;
    }
}
