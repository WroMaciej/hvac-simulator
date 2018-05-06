package wromaciej.hvac_sim.thermo.generals.bonds;

import wromaciej.hvac_sim.thermo.devices.model.basic.Device;
import wromaciej.hvac_sim.thermo.generals.Item;
import wromaciej.hvac_sim.thermo.streams.model.AnyStream;
import wromaciej.hvac_sim.thermo.streams.model.MatterStream;

public class OutletDeviceBond<T extends AnyStream> extends Bond {


    public void setOwnerItem(Device ownerItem) {
        this.ownerItem = ownerItem;
    }

    public OutletDeviceBond(int bondId) {
        super(bondId, BondDirection.OUTLET);


    }

    public void connectTo(InletStreamBond<T> inletStreamBond){
        this.targetBond = inletStreamBond;
        inletStreamBond.targetBond = this;
    }

    @Override
    public InletStreamBond<T> getTargetBond() {
        return (InletStreamBond<T>) this.targetBond;
    }

    @Override
    public Device getOwnerItem() {
        return (Device) this.ownerItem;
    }
}
