package wromaciej.hvac_sim.solver.externals;

import wromaciej.hvac_sim.solver.SolverParameters;
import wromaciej.hvac_sim.solver.result.SolverResult;
import wromaciej.hvac_sim.solver.result.SolverResultType;
import wromaciej.hvac_sim.thermo.generals.bonds.Channel;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.quantities.extensive.MassFlow;
import wromaciej.hvac_sim.thermo.quantities.specific.Pressure;
import wromaciej.hvac_sim.thermo.quantities.specific.PressureDifference;
import wromaciej.hvac_sim.thermo.streams.model.FluidStream;
import wromaciej.hvac_sim.thermo.streams.model.MatterStream;

import java.util.ArrayList;
import java.util.List;

public class ChannelSolver implements ExternalSolver<Channel<? extends MatterStream>> {


    private SolverResult solveMassFlows(Channel<MatterStream> channelToSolve){
        SolverResultType solverResultType;
        final int NEEDED_PARAMETERS = 3;
        SolverParameters solverParameters = new SolverParameters(
                NEEDED_PARAMETERS,
                channelToSolve.getInletStream().getMassFlow(),
        channelToSolve.getOutletStream().getMassFlow(),
        channelToSolve.getAdditionalMassFlow());
        solverResultType=solverParameters.solverResultType();
        if (solverResultType== SolverResultType.SOLVED){
            if (channelToSolve.getAdditionalMassFlow()!=null){
                channelToSolve.getAdditionalMassFlow() = //ITS FINAL
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
