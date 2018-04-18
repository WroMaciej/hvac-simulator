package wromaciej.hvac_sim.thermo.devices.model.basic.bonds;

import wromaciej.hvac_sim.display.Item;

public final class OutletBond <T extends Item, K extends Item> extends Bond {

    public OutletBond(Item ownerItem, int bondId) {
        super(BondDirection.OUTLET, ownerItem, bondId);
    }

    public void connectTo(InletBond<K, T> inletBond) {
        this.targetBond = inletBond;
    }
}
