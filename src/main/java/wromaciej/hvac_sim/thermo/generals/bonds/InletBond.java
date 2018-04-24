package wromaciej.hvac_sim.thermo.generals.bonds;


import wromaciej.hvac_sim.thermo.generals.Item;

public final class InletBond<T extends Item, K extends Item> extends Bond {


    public InletBond(int bondId, Item ownerItem) {
        super(bondId, BondDirection.INLET, ownerItem);
    }

    public void connectTo(OutletBond<K, T> outletBond) {
        this.targetBond = outletBond;
    }


}
