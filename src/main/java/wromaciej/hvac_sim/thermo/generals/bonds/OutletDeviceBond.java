package wromaciej.hvac_sim.thermo.generals.bonds;

import wromaciej.hvac_sim.thermo.generals.Item;
import wromaciej.hvac_sim.thermo.streams.model.MatterStream;

public class OutletDeviceBond<T extends MatterStream> extends Bond {
    public OutletDeviceBond(int bondId, BondDirection flowDirection, Item ownerItem) {
        super(bondId, BondDirection.OUTLET, ownerItem);
    }

    public void connectTo(InletStreamBond<T> inletStreamBond){
        this.targetBond = inletStreamBond;
    }
}
