package wromaciej.hvac_sim.thermo.generals.bonds;

import wromaciej.hvac_sim.thermo.devices.model.basic.Device;
import wromaciej.hvac_sim.thermo.generals.Item;
import wromaciej.hvac_sim.thermo.streams.model.AnyStream;
import wromaciej.hvac_sim.thermo.streams.model.MatterStream;

public class InletDeviceBond<T extends AnyStream> extends Bond {


    public InletDeviceBond(int bondId) {
        super(bondId, BondDirection.INLET);
    }


    public void setOwnerItem(Device ownerItem) {
        this.ownerItem = ownerItem;
    }

    public void connectTo(OutletStreamBond<T> outletStreamBond){
        this.targetBond = outletStreamBond;
        outletStreamBond.targetBond = this;
    }

    @Override
    public OutletStreamBond<T> getTargetBond() {
        return (OutletStreamBond<T>) this.targetBond;
    }

    @Override
    public Device getOwnerItem() {
        return (Device) this.ownerItem;
    }
}
