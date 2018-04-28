package wromaciej.hvac_sim.thermo.generals.bonds;

import wromaciej.hvac_sim.thermo.generals.Item;
import wromaciej.hvac_sim.thermo.streams.model.MatterStream;


public class OutletStreamBond <T extends MatterStream> extends Bond {
    public OutletStreamBond(int bondId, BondDirection flowDirection, Item ownerItem) {
        super(bondId, BondDirection.OUTLET, ownerItem);
    }

    public void connectTo(InletDeviceBond<T> outletDeviceBond){
        this.targetBond = outletDeviceBond;
    }
}
