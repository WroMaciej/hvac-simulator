package wromaciej.hvac_sim.simulation.general.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wromaciej.hvac_sim.simulation.solver.externals.*;
import wromaciej.hvac_sim.simulation.solver.matterSolvers.FluidSolver;
import wromaciej.hvac_sim.simulation.thermo.matter.fluids.model.FluidFactory;

@Component
public class AllSolvers {

    @Autowired
    private FluidSolver fluidSolver;
    @Autowired
    private ChannelSolver channelSolver;
    @Autowired
    private JunctionSolver junctionSolver;
    @Autowired
    private HeaterSolver heaterSolver;
    @Autowired
    private MatterStreamSolver matterStreamSolver;
    @Autowired
    private HeatStreamSolver heatStreamSolver;
    @Autowired
    private PowerStreamSolver powerStreamSolver;
    @Autowired
    private FluidFactory fluidFactory;

    public AllSolvers() {
    }

    public FluidSolver getFluidSolver() {
        return fluidSolver;
    }
    public ChannelSolver getChannelSolver() {
        return channelSolver;
    }
    public JunctionSolver getJunctionSolver() {
        return junctionSolver;
    }
    public HeaterSolver getHeaterSolver() {
        return heaterSolver;
    }
    public MatterStreamSolver getMatterStreamSolver() {
        return matterStreamSolver;
    }
    public HeatStreamSolver getHeatStreamSolver() {
        return heatStreamSolver;
    }
    public PowerStreamSolver getPowerStreamSolver() {
        return powerStreamSolver;
    }
    public FluidFactory getFluidFactory() {
        return fluidFactory;
    }

}
