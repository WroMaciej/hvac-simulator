package wromaciej.hvac_sim.thermo.generals.bonds;

import wromaciej.hvac_sim.thermo.generals.Item;
import wromaciej.hvac_sim.thermo.streams.model.AnyStream;
import wromaciej.hvac_sim.thermo.streams.model.MatterStream;


public class OutletStreamBond <T extends AnyStream> extends Bond {
    public OutletStreamBond(int bondId, BondDirection flowDirection, T ownerStream) {
        super(bondId, BondDirection.OUTLET, ownerStream);
    }

    public void connectTo(InletDeviceBond<T> outletDeviceBond){
        this.targetBond = outletDeviceBond;
    }

    @Override
    public InletDeviceBond<T> getTargetBond() {
        return (InletDeviceBond<T>) targetBond;
    }

    @Override
    public T getOwnerItem() {
        return (T) super.getOwnerItem();
    }
}
