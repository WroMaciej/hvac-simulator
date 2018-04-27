package wromaciej.hvac_sim.thermo.generals.bonds;


import wromaciej.hvac_sim.thermo.generals.Bondable;
import wromaciej.hvac_sim.thermo.generals.Item;

public final class InletBond<T extends Bondable, K extends Bondable> extends Bond {


    public InletBond(int bondId, Bondable ownerItem) {
        super(bondId, BondDirection.INLET, ownerItem);
    }

    public void connectTo(OutletBond<K, T> outletBond) {
        this.targetBond = outletBond;
    }


}
