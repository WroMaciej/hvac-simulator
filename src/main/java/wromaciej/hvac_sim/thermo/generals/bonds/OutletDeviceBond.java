package wromaciej.hvac_sim.thermo.generals.bonds;

import wromaciej.hvac_sim.thermo.devices.model.basic.Device;
import wromaciej.hvac_sim.thermo.generals.Item;
import wromaciej.hvac_sim.thermo.streams.model.MatterStream;

public class OutletDeviceBond<T extends MatterStream> extends Bond {
    public OutletDeviceBond(int bondId, BondDirection flowDirection, Device ownerItem) {
        super(bondId, BondDirection.OUTLET, ownerItem);
    }

    public void connectTo(InletStreamBond<T> inletStreamBond){
        this.targetBond = inletStreamBond;
    }

    @Override
    public InletStreamBond<T> getTargetBond() {
        return (InletStreamBond<T>) getTargetBond();
    }

    @Override
    public Device getOwnerItem() {
        return (Device) super.getOwnerItem();
    }
}
