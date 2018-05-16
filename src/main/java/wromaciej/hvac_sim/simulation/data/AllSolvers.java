package wromaciej.hvac_sim.simulation.data;

import wromaciej.hvac_sim.solver.externals.*;
import wromaciej.hvac_sim.solver.matterSolvers.FluidSolver;

public class AllSolvers {

    private FluidSolver fluidSolver;
    private ChannelSolver channelSolver;
    private JunctionSolver junctionSolver;
    private HeaterSolver heaterSolver;
    private MatterStreamSolver matterStreamSolver;
    private HeatStreamSolver heatStreamSolver;
    private PowerStreamSolver powerStreamSolver;

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
}
