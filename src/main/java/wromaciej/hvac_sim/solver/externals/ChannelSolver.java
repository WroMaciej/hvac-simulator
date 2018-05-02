package wromaciej.hvac_sim.solver.externals;

import wromaciej.hvac_sim.solver.result.SolverResult;
import wromaciej.hvac_sim.solver.result.SolverResultType;
import wromaciej.hvac_sim.thermo.generals.bonds.Channel;
import wromaciej.hvac_sim.thermo.streams.model.MatterStream;

public class ChannelSolver implements ExternalSolver<Channel<? extends MatterStream>> {


    private SolverResult solveMassFlows(Channel<MatterStream> channelToSolve){
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

    private SolverResult solvePressures(Channel<MatterStream> channelToSolve){


        return null;
    }



    @Override
    public SolverResult solve(Channel<? extends MatterStream> channelToSolve) {
        return null;
    }
}
