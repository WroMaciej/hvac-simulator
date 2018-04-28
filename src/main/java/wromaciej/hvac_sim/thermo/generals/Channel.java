package wromaciej.hvac_sim.thermo.generals;

import wromaciej.hvac_sim.solver.externals.ChannelSolver;
import wromaciej.hvac_sim.solver.internals.Solvable;
import wromaciej.hvac_sim.solver.result.SolverResult;
import wromaciej.hvac_sim.thermo.generals.bonds.InletDeviceBond;
import wromaciej.hvac_sim.thermo.generals.bonds.OutletDeviceBond;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.quantities.extensive.MassFlow;
import wromaciej.hvac_sim.thermo.quantities.specific.PressureDifference;
import wromaciej.hvac_sim.thermo.streams.model.MatterStream;

public class Channel<T extends MatterStream> implements Solvable, Bondable {

//    private final InletBond<Device, T> inletBond;
//    private final OutletBond<Device, T> outletBond;
private final Item ownerItem;

    private T inletStream;
    private T outletStream;

    private final InletDeviceBond<T> inletDeviceBond;
    private final OutletDeviceBond<T> outletDeviceBond;


    private Parameter<PressureDifference> pressureDrop;
    private ChannelSolver channelSolver;
    private boolean isSolved;


    public Channel(Item ownerItem, InletDeviceBond<T> inletDeviceBond, OutletDeviceBond<T> outletDeviceBond, ) {
        this.ownerItem = ownerItem;
        this.inletDeviceBond = inletDeviceBond;
        this.outletDeviceBond = outletDeviceBond;
        
        inletStream = inletDeviceBond.getTargetBond().getOwnerItem();
        outletStream = outletDeviceBond.getTargetBond().getOwnerItem();
    }

    public InletDeviceBond<T> getInletDeviceBond() {
        return inletDeviceBond;
    }

    public OutletDeviceBond<T> getOutletDeviceBond() {
        return outletDeviceBond;
    }

    public T getInletStream() {
        return inletStream;
    }

    public T getOutletStream() {
        return outletStream;
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
