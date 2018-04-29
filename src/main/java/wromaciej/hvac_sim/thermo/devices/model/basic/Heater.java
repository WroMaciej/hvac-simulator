package wromaciej.hvac_sim.thermo.devices.model.basic;

import wromaciej.hvac_sim.ids.IdGenerator;
import wromaciej.hvac_sim.thermo.generals.bonds.Channel;
import wromaciej.hvac_sim.thermo.generals.bonds.InletDeviceBond;
import wromaciej.hvac_sim.thermo.streams.model.HeatStream;
import wromaciej.hvac_sim.thermo.streams.model.MatterStream;

public class Heater extends Device {
    public final InletDeviceBond<HeatStream> heatInlet;

    private final Channel<MatterStream> channel;

    public Heater(int id, IdGenerator idGenerator, InletDeviceBond<HeatStream> heatInlet, Channel<MatterStream> channel) {
        super(id, idGenerator);
        this.heatInlet = heatInlet;
        this.channel = channel;
    }



}
