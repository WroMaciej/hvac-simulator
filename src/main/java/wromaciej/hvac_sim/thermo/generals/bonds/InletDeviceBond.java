package wromaciej.hvac_sim.thermo.generals.bonds;

import wromaciej.hvac_sim.thermo.generals.Item;
import wromaciej.hvac_sim.thermo.streams.model.MatterStream;

public class InletDeviceBond<T extends MatterStream> extends Bond {
    public InletDeviceBond(int bondId, BondDirection flowDirection, Item ownerItem) {
        super(bondId, BondDirection.INLET, ownerItem);
    }

    public void connectTo(InletStreamBond<T> inletStreamBond){
        this.targetBond = inletStreamBond;
    }
}
