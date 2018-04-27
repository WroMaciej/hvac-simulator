package wromaciej.hvac_sim.thermo.generals.bonds;

import wromaciej.hvac_sim.thermo.generals.Bondable;
import wromaciej.hvac_sim.thermo.generals.Item;

public final class OutletBond <T extends Bondable, K extends Bondable> extends Bond {

    public OutletBond(int bondId, Bondable ownerItem) {
        super(bondId, BondDirection.OUTLET, ownerItem);
    }

    public void connectTo(InletBond<K, T> inletBond) {
        this.targetBond = inletBond;
    }
}
