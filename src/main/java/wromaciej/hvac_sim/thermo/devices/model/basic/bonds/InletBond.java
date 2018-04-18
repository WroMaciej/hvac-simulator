package wromaciej.hvac_sim.thermo.devices.model.basic.bonds;

import wromaciej.hvac_sim.display.Item;

public final class InletBond<T extends Item, K extends Item> extends Bond {

    public InletBond(BondDirection flowDirection, Item ownerItem, int bondId) {
        super(BondDirection.INLET, ownerItem, bondId);
    }

    public void connectTo(OutletBond<K, T> outletBond) {
        this.targetBond = outletBond;
    }


}
