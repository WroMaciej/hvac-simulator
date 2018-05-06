package wromaciej.hvac_sim.thermo.generals.bonds;

import wromaciej.hvac_sim.thermo.generals.Item;
import wromaciej.hvac_sim.thermo.streams.model.AnyStream;
import wromaciej.hvac_sim.thermo.streams.model.MatterStream;


public class OutletStreamBond <T extends AnyStream> extends Bond {
    public OutletStreamBond(int bondId) {
        super(bondId, BondDirection.OUTLET);
    }

    public void setOwnerItem(T ownerItem) {
        this.ownerItem = ownerItem;
    }

    public void connectTo(InletDeviceBond<T> inletDeviceBond){
        this.targetBond = inletDeviceBond;
        inletDeviceBond.targetBond = this;
    }

    @Override
    public InletDeviceBond<T> getTargetBond() {
        return (InletDeviceBond<T>) this.targetBond;
    }

    @Override
    public T getOwnerItem() {
        return (T) this.ownerItem;
    }
}
