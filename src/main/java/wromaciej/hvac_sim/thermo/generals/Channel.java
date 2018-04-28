package wromaciej.hvac_sim.thermo.generals;

import wromaciej.hvac_sim.solver.externals.ChannelSolver;
import wromaciej.hvac_sim.solver.internals.Solvable;
import wromaciej.hvac_sim.solver.result.SolverResult;
import wromaciej.hvac_sim.thermo.devices.model.basic.Device;
import wromaciej.hvac_sim.thermo.generals.bonds.InletBond;
import wromaciej.hvac_sim.thermo.generals.bonds.OutletBond;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.quantities.extensive.MassFlow;
import wromaciej.hvac_sim.thermo.quantities.specific.PressureDifference;
import wromaciej.hvac_sim.thermo.streams.model.MatterStream;

public class Channel<T extends MatterStream> implements Solvable, Bondable {

    private final InletBond<Device, T> inletBond;
    private final OutletBond<Device, T> outletBond;
    private T inletStream;
    private T outletStream;
    private final Item ownerItem;
    private Parameter<PressureDifference> pressureDrop;
    private ChannelSolver channelSolver;
    private boolean isSolved;

    public Channel(InletBond<Device, T> inletBond, OutletBond<Device, T> outletBond, T inletStream, T outletStream, Item ownerItem) {
        this.inletBond = inletBond;
        this.outletBond = outletBond;
        this.inletStream = inletStream;
        this.outletStream = outletStream;
        this.ownerItem = ownerItem;
        inletStream = inletBond.getK();
    }

    public InletBond<Device, T> getInletBond() {
        return inletBond;
    }

    public OutletBond<Device, T> getOutletBond() {
        return outletBond;
    }

    public Item getOwnerItem() {
        return ownerItem;
    }

    public Parameter<PressureDifference> getPressureDrop() {
        return pressureDrop;
    }

    public void setPressureDrop(Parameter<PressureDifference> pressureDrop) {
        this.pressureDrop = pressureDrop;
    }

    public ChannelSolver getChannelSolver() {
        return channelSolver;
    }

    public void setChannelSolver(ChannelSolver channelSolver) {
        this.channelSolver = channelSolver;
    }

    public void setSolved(boolean solved) {
        isSolved = solved;
    }

    public Parameter<MassFlow> getAdditionalMassFlow() {
        return additionalMassFlow;
    }

    public void setAdditionalMassFlow(Parameter<MassFlow> additionalMassFlow) {
        this.additionalMassFlow = additionalMassFlow;
    }

    /**
     * Additional mass flow >0 when it comes from the outside
     */
    private Parameter<MassFlow> additionalMassFlow;




    @Override
    public SolverResult solve() {
        return channelSolver.solve(this);
    }

    @Override
    public boolean isSolved() {
        return false;
    }
}
