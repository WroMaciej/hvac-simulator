package wromaciej.hvac_sim.thermo.devices.model.basic;

import wromaciej.hvac_sim.ids.IdGenerator;
import wromaciej.hvac_sim.thermo.generals.Channel;
import wromaciej.hvac_sim.thermo.generals.bonds.InletBond;
import wromaciej.hvac_sim.thermo.streams.model.HeatStream;
import wromaciej.hvac_sim.thermo.streams.model.FluidStream;

public class Heater extends Device {
    //public final InletBond<Device, MatterStream> fluidInletBond;
    //public final OutletBond<Device, MatterStream> fluidOutletBond;
    public final InletBond<Device, HeatStream> heatInlet;

    private final Channel<FluidStream> channel;

    public Heater(int id, IdGenerator idGenerator, InletBond<Device, HeatStream> heatInlet, Channel<FluidStream> channel) {
        super(id, idGenerator);
        this.heatInlet = heatInlet;
        this.channel = channel;
    }

    @Override
    public String display() {
        return null;
    }


}
