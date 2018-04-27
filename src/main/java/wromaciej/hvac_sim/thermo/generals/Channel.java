package wromaciej.hvac_sim.thermo.generals;

import wromaciej.hvac_sim.solver.internals.InternalSolver;
import wromaciej.hvac_sim.solver.result.SolverResult;
import wromaciej.hvac_sim.thermo.devices.model.basic.Device;
import wromaciej.hvac_sim.thermo.generals.bonds.InletBond;
import wromaciej.hvac_sim.thermo.generals.bonds.OutletBond;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.quantities.extensive.MassFlow;
import wromaciej.hvac_sim.thermo.quantities.specific.PressureDifference;
import wromaciej.hvac_sim.thermo.streams.model.FluidStream;

public class Channel<T extends FluidStream> implements InternalSolver, Bondable {

    private final InletBond<Device, T> inletBond;
    private final OutletBond<Device, T> outletBond;
    private final Item ownerItem;
    private Parameter<PressureDifference> pressureDrop;
    private Parameter<MassFlow> massFlow;

    public Channel(InletBond<Device, T> inletBond, OutletBond<Device, T> outletBond, Item ownerItem) {
        this.inletBond = inletBond;
        this.outletBond = outletBond;
        this.ownerItem = ownerItem;
    }

    @Override
    public SolverResult solve() {
        return null;
    }

    @Override
    public boolean isSolved() {
        return false;
    }
}
