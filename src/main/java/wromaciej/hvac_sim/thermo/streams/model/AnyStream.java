package wromaciej.hvac_sim.thermo.streams.model;

import wromaciej.hvac_sim.display.Item;
import wromaciej.hvac_sim.ids.IdGenerator;
import wromaciej.hvac_sim.thermo.devices.model.basic.Device;
import wromaciej.hvac_sim.thermo.devices.model.basic.bonds.Bond;
import wromaciej.hvac_sim.thermo.devices.model.basic.bonds.InletBond;
import wromaciej.hvac_sim.thermo.devices.model.basic.bonds.OutletBond;

public abstract class AnyStream extends Item {
    protected final InletBond<? extends AnyStream, Device> inletBond;
    protected final OutletBond<? extends AnyStream, Device> outletBond;

    public AnyStream(int id, IdGenerator idGenerator, InletBond<? extends AnyStream, Device> inletBond, OutletBond<? extends AnyStream, Device> outletBond) {
        super(id, idGenerator);
        this.inletBond = inletBond;
        this.outletBond = outletBond;
    }
}
