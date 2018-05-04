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
        super.setOwnerItem(ownerItem);
    }

    public void connectTo(OutletStreamBond<T> inletStreamBond){
        this.targetBond = inletStreamBond;
    }

    @Override
    public OutletStreamBond<T> getTargetBond() {
        return (OutletStreamBond<T>) super.getTargetBond();
    }

    @Override
    public Device getOwnerItem() {
        return (Device) super.getOwnerItem();
    }
}
