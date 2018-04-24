package wromaciej.hvac_sim.thermo.generals.bonds;

import wromaciej.hvac_sim.thermo.generals.Item;

public final class OutletBond <T extends Item, K extends Item> extends Bond {

    public OutletBond(int bondId, Item ownerItem) {
        super(bondId, BondDirection.OUTLET, ownerItem);
    }

    public void connectTo(InletBond<K, T> inletBond) {
        this.targetBond = inletBond;
    }
}
