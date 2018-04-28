package wromaciej.hvac_sim.thermo.generals.bonds;

import wromaciej.hvac_sim.thermo.generals.Item;
import wromaciej.hvac_sim.thermo.streams.model.MatterStream;

public class InletStreamBond<T extends MatterStream> extends Bond {

    public InletStreamBond(int bondId, BondDirection flowDirection, Item ownerItem) {
        super(bondId, BondDirection.INLET, ownerItem);
    }

    public void connectTo(OutletDeviceBond<T> outletDeviceBond){
        this.targetBond = outletDeviceBond;
    }
}
