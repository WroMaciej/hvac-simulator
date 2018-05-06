package wromaciej.hvac_sim.thermo.generals.bonds;

import wromaciej.hvac_sim.thermo.generals.Item;
import wromaciej.hvac_sim.thermo.streams.model.AnyStream;
import wromaciej.hvac_sim.thermo.streams.model.MatterStream;

public class InletStreamBond<T extends AnyStream> extends Bond {


    public InletStreamBond(int bondId) {
        super(bondId, BondDirection.INLET);
    }


    public void setOwnerItem(T ownerItem) {
        this.ownerItem = ownerItem;
    }

    public void connectTo(OutletDeviceBond<T> outletDeviceBond){
        this.targetBond = outletDeviceBond;
        outletDeviceBond.targetBond = this;
    }

    @Override
    public OutletDeviceBond<T> getTargetBond() {
        return (OutletDeviceBond<T>) this.targetBond;
    }

    @Override
    public T getOwnerItem() {
        return (T) this.ownerItem;
    }
}
