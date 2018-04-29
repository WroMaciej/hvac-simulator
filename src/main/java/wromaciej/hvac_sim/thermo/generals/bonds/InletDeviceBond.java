package wromaciej.hvac_sim.thermo.generals.bonds;

import wromaciej.hvac_sim.thermo.devices.model.basic.Device;
import wromaciej.hvac_sim.thermo.generals.Item;
import wromaciej.hvac_sim.thermo.streams.model.AnyStream;
import wromaciej.hvac_sim.thermo.streams.model.MatterStream;

public class InletDeviceBond<T extends AnyStream> extends Bond {

    public InletDeviceBond(int bondId, BondDirection flowDirection, Device ownerItem) {
        super(bondId, BondDirection.INLET, ownerItem);
    }

    public void connectTo(OutletStreamBond<T> inletStreamBond){
        this.targetBond = inletStreamBond;
    }

    @Override
    public OutletStreamBond<T> getTargetBond() {
        return (OutletStreamBond<T>) getTargetBond();
    }

    @Override
    public Device getOwnerItem() {
        return (Device) super.getOwnerItem();
    }
}
