package wromaciej.hvac_sim.thermo.streams.model;

import wromaciej.hvac_sim.display.Item;
import wromaciej.hvac_sim.thermo.devices.model.basic.Bond;

public abstract class AnyStream extends Item {
    private Bond intletBond;
    private Bond outletBond;

    public AnyStream(int id, Bond intletBond, Bond outletBond) {
        super(id);
        this.intletBond = intletBond;
        this.outletBond = outletBond;
    }

    public Bond getIntletBond() {
        return intletBond;
    }

    public Bond getOutletBond() {
        return outletBond;
    }
}
