package wromaciej.hvac_sim.thermo.generals.bonds;

import wromaciej.hvac_sim.thermo.generals.Item;
import wromaciej.hvac_sim.thermo.streams.model.AnyStream;
import wromaciej.hvac_sim.thermo.streams.model.MatterStream;

public class InletStreamBond<T extends AnyStream> extends Bond {

    public InletStreamBond(int bondId, BondDirection flowDirection, T ownerStream) {
        super(bondId, BondDirection.INLET, ownerStream);
    }

    public void connectTo(OutletDeviceBond<T> outletDeviceBond){
        this.targetBond = outletDeviceBond;
    }

    @Override
    public OutletDeviceBond<T> getTargetBond() {
        return (OutletDeviceBond<T>) targetBond;
    }

    @Override
    public T getOwnerItem() {
        return (T) super.getOwnerItem();
    }
}
