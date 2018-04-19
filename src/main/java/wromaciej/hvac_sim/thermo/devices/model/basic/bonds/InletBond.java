package wromaciej.hvac_sim.thermo.devices.model.basic.bonds;

import wromaciej.hvac_sim.thermo.Item;

public final class InletBond<T extends Item, K extends Item> extends Bond {


    public InletBond(int bondId, Item ownerItem) {
        super(bondId, BondDirection.INLET, ownerItem);
    }

    public void connectTo(OutletBond<K, T> outletBond) {
        this.targetBond = outletBond;
    }


}
