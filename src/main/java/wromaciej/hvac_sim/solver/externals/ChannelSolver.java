package wromaciej.hvac_sim.solver.externals;

import wromaciej.hvac_sim.solver.result.SolverResult;
import wromaciej.hvac_sim.thermo.generals.Channel;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.quantities.extensive.MassFlow;
import wromaciej.hvac_sim.thermo.quantities.specific.Pressure;
import wromaciej.hvac_sim.thermo.quantities.specific.PressureDifference;
import wromaciej.hvac_sim.thermo.streams.model.FluidStream;
import wromaciej.hvac_sim.thermo.streams.model.MatterStream;

import java.util.ArrayList;
import java.util.List;

public class ChannelSolver implements ExternalSolver<Channel<? extends MatterStream>> {

    private List<Parameter<MassFlow>> definedMassFlows;
    private List<Parameter<Pressure>> definedPressures;
    private Parameter<PressureDifference> definedPressureDrop;

    private boolean isMassFlowsSolvable(Channel channelToSolve){
        definedMassFlows=new ArrayList<>();


    }

    private SolverResult solveMassFlows(Channel<MatterStream> channelToSolve){
        Channel<FluidStream> fluidStreamChannel = new Channel<>(null,null,null);

        return null;
    }

    private SolverResult solvePressures(Channel<MatterStream> channelToSolve){
        definedPressures=new ArrayList<>();
        channelToSolve.

        return null;
    }



    @Override
    public SolverResult solve(Channel<? extends MatterStream> channelToSolve) {
        return null;
    }
}
