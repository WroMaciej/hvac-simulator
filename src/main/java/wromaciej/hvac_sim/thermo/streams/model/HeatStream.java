package wromaciej.hvac_sim.thermo.streams.model;

import wromaciej.hvac_sim.ids.IdGenerator;
import wromaciej.hvac_sim.thermo.devices.model.basic.Device;
import wromaciej.hvac_sim.thermo.devices.model.basic.bonds.InletBond;
import wromaciej.hvac_sim.thermo.devices.model.basic.bonds.OutletBond;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.quantities.extensive.HeatFlow;

public final class HeatStream extends AnyStream {
    private Parameter<HeatFlow> heatFlow;
    private final InletBond<FluidStream, Device> inletBond;
    private final OutletBond<FluidStream, Device> outletBond;



    public HeatStream(int id, IdGenerator idGenerator, Parameter<HeatFlow> heatFlow) {
        super(id, idGenerator);
        this.heatFlow = heatFlow;
        inletBond = new InletBond<>(idGenerator.getUniqueId(), this);
        outletBond = new OutletBond<>(idGenerator.getUniqueId(), this);
    }

    public Parameter<HeatFlow> getHeatFlow() {
        return heatFlow;
    }

    public InletBond<FluidStream, Device> getInletBond() {
        return inletBond;
    }

    public OutletBond<FluidStream, Device> getOutletBond() {
        return outletBond;
    }

    @Override
    public String display() {
        return null;
    }

    @Override
    public boolean solve() {
        return false;
    }
}
