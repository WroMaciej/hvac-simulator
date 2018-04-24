package wromaciej.hvac_sim.thermo.devices.model.basic;

import wromaciej.hvac_sim.ids.IdGenerator;
import wromaciej.hvac_sim.solver.SolverResult;
import wromaciej.hvac_sim.thermo.generals.bonds.InletBond;
import wromaciej.hvac_sim.thermo.generals.bonds.OutletBond;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.quantities.specific.PressureDifference;
import wromaciej.hvac_sim.thermo.streams.model.FluidStream;
import wromaciej.hvac_sim.thermo.streams.model.HeatStream;

public class Heater extends Device {
    public final InletBond<Device, FluidStream> fluidInletBond;
    public final OutletBond<Device, FluidStream> fluidOutletBond;
    public final InletBond<Device, HeatStream> heatInlet;
    private Parameter<PressureDifference> pressureDrop;

    public Heater(int id, IdGenerator idGenerator) {
        super(id, idGenerator);
        fluidInletBond = new InletBond<>(idGenerator.getUniqueId(), this);
        fluidOutletBond = new OutletBond<>(idGenerator.getUniqueId(), this);
        heatInlet = new InletBond<>(idGenerator.getUniqueId(), this);
    }


    @Override
    public String display() {
        return null;
    }

    @Override
    public SolverResult solve() {
        return null;
    }
}
