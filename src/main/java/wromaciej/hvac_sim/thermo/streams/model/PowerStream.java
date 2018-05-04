package wromaciej.hvac_sim.thermo.streams.model;

import wromaciej.hvac_sim.ids.IdGenerator;
import wromaciej.hvac_sim.solver.result.SolverResult;
import wromaciej.hvac_sim.solver.result.SolverResultType;
import wromaciej.hvac_sim.thermo.devices.model.basic.Device;
import wromaciej.hvac_sim.thermo.generals.bonds.InletStreamBond;
import wromaciej.hvac_sim.thermo.generals.bonds.OutletStreamBond;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.quantities.extensive.Power;

public class PowerStream extends AnyStream {
    private Parameter<Power> powerStream;
    public final InletStreamBond<PowerStream> inletStreamBond;
    public final OutletStreamBond<PowerStream> outletStreamBond;

    public PowerStream(int id, IdGenerator idGenerator, Parameter<Power> powerStream, InletStreamBond<PowerStream> inletStreamBond, OutletStreamBond<PowerStream> outletStreamBond) {
        super(id, idGenerator, inletStreamBond, outletStreamBond);
        this.powerStream = powerStream;
        this.inletStreamBond = inletStreamBond;
        this.outletStreamBond = outletStreamBond;
        this.inletStreamBond.setOwnerItem(this);
        this.outletStreamBond.setOwnerItem(this);
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
