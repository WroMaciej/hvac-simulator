package wromaciej.hvac_sim.simulation.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import wromaciej.hvac_sim.solver.externals.*;
import wromaciej.hvac_sim.solver.matterSolvers.FluidSolver;
import wromaciej.hvac_sim.thermo.matter.fluids.model.FluidFactory;

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

    public void setFluidSolver(FluidSolver fluidSolver) {
        this.fluidSolver = fluidSolver;
    }

    public ChannelSolver getChannelSolver() {
        return channelSolver;
    }

    public void setChannelSolver(ChannelSolver channelSolver) {
        this.channelSolver = channelSolver;
    }

    public JunctionSolver getJunctionSolver() {
        return junctionSolver;
    }

    public void setJunctionSolver(JunctionSolver junctionSolver) {
        this.junctionSolver = junctionSolver;
    }

    public HeaterSolver getHeaterSolver() {
        return heaterSolver;
    }

    public void setHeaterSolver(HeaterSolver heaterSolver) {
        this.heaterSolver = heaterSolver;
    }

    public MatterStreamSolver getMatterStreamSolver() {
        return matterStreamSolver;
    }

    public void setMatterStreamSolver(MatterStreamSolver matterStreamSolver) {
        this.matterStreamSolver = matterStreamSolver;
    }

    public HeatStreamSolver getHeatStreamSolver() {
        return heatStreamSolver;
    }

    public void setHeatStreamSolver(HeatStreamSolver heatStreamSolver) {
        this.heatStreamSolver = heatStreamSolver;
    }

    public PowerStreamSolver getPowerStreamSolver() {
        return powerStreamSolver;
    }

    public void setPowerStreamSolver(PowerStreamSolver powerStreamSolver) {
        this.powerStreamSolver = powerStreamSolver;
    }

    public FluidFactory getFluidFactory() {
        return fluidFactory;
    }

    public void setFluidFactory(FluidFactory fluidFactory) {
        this.fluidFactory = fluidFactory;
    }
}
