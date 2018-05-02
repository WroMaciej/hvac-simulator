package wromaciej.hvac_sim.thermo.generals.bonds;

import wromaciej.hvac_sim.solver.externals.ChannelSolver;
import wromaciej.hvac_sim.solver.internals.Solvable;
import wromaciej.hvac_sim.solver.result.SolverResult;
import wromaciej.hvac_sim.thermo.generals.Bondable;
import wromaciej.hvac_sim.thermo.generals.Item;
import wromaciej.hvac_sim.thermo.generals.bonds.InletDeviceBond;
import wromaciej.hvac_sim.thermo.generals.bonds.OutletDeviceBond;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.quantities.extensive.MassFlow;
import wromaciej.hvac_sim.thermo.quantities.specific.PressureDifference;
import wromaciej.hvac_sim.thermo.streams.model.AnyStream;
import wromaciej.hvac_sim.thermo.streams.model.MatterStream;

public class Channel<T extends MatterStream> implements Solvable, Bondable {


    private final Item ownerItem;
    private final InletDeviceBond<T> inletDeviceBond;
    private final OutletDeviceBond<T> outletDeviceBond;

    private T inletStream;
    private T outletStream;

    /**
     * Pressure loss through the channel
     */
    private Parameter<PressureDifference> pressureDrop;
    /**
     * Additional mass flow in/out
     */

    private ParameterWithDirection extraMassFlow;

    private ChannelSolver channelSolver;
    private boolean isSolved;

    public Channel(Item ownerItem, InletDeviceBond<T> inletDeviceBond, OutletDeviceBond<T> outletDeviceBond, Parameter<PressureDifference> pressureDrop, ParameterWithDirection extraMassFlow) {
        this.ownerItem = ownerItem;
        this.inletDeviceBond = inletDeviceBond;
        this.outletDeviceBond = outletDeviceBond;
        this.pressureDrop = pressureDrop;
        this.extraMassFlow = extraMassFlow;

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


    public ChannelSolver getChannelSolver() {
        return channelSolver;
    }

    public void setChannelSolver(ChannelSolver channelSolver) {
        this.channelSolver = channelSolver;
    }

    public void setSolved(boolean solved) {
        isSolved = solved;
    }

    public ParameterWithDirection getExtraMassFlow() {
        return extraMassFlow;
    }

    public void setExtraMassFlow(ParameterWithDirection extraMassFlow) {
        this.extraMassFlow = extraMassFlow;
    }

    public Parameter<PressureDifference> getPressureDrop() {
        return pressureDrop;
    }

    public void setPressureDrop(Parameter<PressureDifference> pressureDrop) {
        this.pressureDrop = pressureDrop;
    }

    @Override
    public SolverResult solve() {

        return channelSolver.solve(this);
    }

    @Override
    public boolean isSolved() {
        return false;
    }
}
