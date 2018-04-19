package wromaciej.hvac_sim.thermo.devices.model.basic;

import wromaciej.hvac_sim.ids.IdGenerator;
import wromaciej.hvac_sim.thermo.devices.model.basic.bonds.InletBond;
import wromaciej.hvac_sim.thermo.devices.model.basic.bonds.OutletBond;
import wromaciej.hvac_sim.thermo.streams.model.FluidStream;
import wromaciej.hvac_sim.thermo.streams.model.HeatStream;

public class Heater extends Device {
    private InletBond<Device, FluidStream> fluidInlet;
    private OutletBond<Device, FluidStream> fluidOutlet;
    private InletBond<Device, HeatStream> heatInlet;

    public Heater(int id, IdGenerator idGenerator) {
        super(id, idGenerator);
        fluidInlet = new InletBond<>(idGenerator.getUniqueId(), this);
        fluidOutlet = new OutletBond<>(idGenerator.getUniqueId(), this);
        heatInlet = new InletBond<>(idGenerator.getUniqueId(), this);
    }

    public InletBond<Device, FluidStream> getFluidInlet() {
        return fluidInlet;
    }

    public OutletBond<Device, FluidStream> getFluidOutlet() {
        return fluidOutlet;
    }

    public InletBond<Device, HeatStream> getHeatInlet() {
        return heatInlet;
    }

    @Override
    public String display() {
        return null;
    }

    @Override
    public boolean solve() {


        return false;
    }
}
