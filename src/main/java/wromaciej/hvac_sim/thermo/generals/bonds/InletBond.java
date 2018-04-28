package wromaciej.hvac_sim.thermo.generals.bonds;


import wromaciej.hvac_sim.thermo.generals.Bondable;
import wromaciej.hvac_sim.thermo.generals.Item;

public final class InletBond<T extends Item, K extends Item> extends Bond {

    T t;
    K k;


    public InletBond(int bondId, T ownerItem) {
        super(bondId, BondDirection.INLET, ownerItem);
    }

    public void connectTo(OutletBond<K, T> outletBond) {
        this.targetBond = outletBond;
        k =
    }

    public T getT(){
        return t;

    }

    public K getK(){
        return k;
    }
}
