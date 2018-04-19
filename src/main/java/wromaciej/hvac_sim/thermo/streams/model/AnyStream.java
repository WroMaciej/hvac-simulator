package wromaciej.hvac_sim.thermo.streams.model;

import wromaciej.hvac_sim.display.Item;
import wromaciej.hvac_sim.ids.IdGenerator;
import wromaciej.hvac_sim.thermo.devices.model.basic.Device;
import wromaciej.hvac_sim.thermo.devices.model.basic.bonds.Bond;
import wromaciej.hvac_sim.thermo.devices.model.basic.bonds.InletBond;
import wromaciej.hvac_sim.thermo.devices.model.basic.bonds.OutletBond;

public abstract class AnyStream extends Item {
    private  InletBond<? extends AnyStream, Device> inletBond;
    private  OutletBond<? extends AnyStream, Device> outletBond;

    public AnyStream(int id, IdGenerator idGenerator) {
        super(id, idGenerator);
    }

    protected void setBonds(InletBond<? extends AnyStream, Device> inletBond, OutletBond<? extends AnyStream, Device> outletBond){
        this.inletBond = inletBond;
        this.outletBond = outletBond;
    }

    public InletBond<? extends AnyStream, Device> getInletBond() {
        return inletBond;
    }

    public OutletBond<? extends AnyStream, Device> getOutletBond() {
        return outletBond;
    }
}
