package wromaciej.hvac_sim.thermo.streams.model;

import wromaciej.hvac_sim.ids.IdGenerator;
import wromaciej.hvac_sim.thermo.devices.model.basic.Device;
import wromaciej.hvac_sim.thermo.devices.model.basic.bonds.InletBond;
import wromaciej.hvac_sim.thermo.devices.model.basic.bonds.OutletBond;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.quantities.extensive.HeatFlow;

public final class HeatStream extends AnyStream {
    private Parameter<HeatFlow> heatFlow;

    public HeatStream(int id, IdGenerator idGenerator, Parameter<HeatFlow> heatFlow) {
        super(id, idGenerator);
        this.heatFlow = heatFlow;
        InletBond<HeatStream, Device> heatStreamInletBond= new InletBond<>(idGenerator.getUniqueId(), this);
        OutletBond<HeatStream, Device> heatStreamOutletBond= new OutletBond<>(idGenerator.getUniqueId(), this);
        this.setBonds(heatStreamInletBond, heatStreamOutletBond);

    }

    @Override
    public String display() {
        return null;
    }

    @Override
    public boolean compute() {
        return false;
    }
}
