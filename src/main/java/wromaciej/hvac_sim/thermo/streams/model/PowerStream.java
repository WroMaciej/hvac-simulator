package wromaciej.hvac_sim.thermo.streams.model;

import wromaciej.hvac_sim.ids.IdGenerator;
import wromaciej.hvac_sim.solver.result.SolverResultType;
import wromaciej.hvac_sim.thermo.devices.model.basic.Device;
import wromaciej.hvac_sim.thermo.generals.bonds.InletBond;
import wromaciej.hvac_sim.thermo.generals.bonds.OutletBond;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.quantities.extensive.Power;

public class PowerStream extends AnyStream {
    private Parameter<Power> powerStream;
    public final InletBond<FluidStream, Device> inletBond;
    public final OutletBond<FluidStream, Device> outletBond;

    public PowerStream(int id, IdGenerator idGenerator, Parameter<Power> powerStream) {
        super(id, idGenerator);
        this.powerStream = powerStream;
        inletBond = new InletBond<>(idGenerator.getUniqueId(), this);
        outletBond = new OutletBond<>(idGenerator.getUniqueId(), this);
    }


    @Override
    public String display() {
        return null;
    }


    @Override
    public SolverResultType solve() {
        return null;
    }
}
