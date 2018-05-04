package wromaciej.hvac_sim.thermo.streams.model;

import wromaciej.hvac_sim.ids.IdGenerator;
import wromaciej.hvac_sim.thermo.generals.bonds.InletStreamBond;
import wromaciej.hvac_sim.thermo.generals.bonds.OutletStreamBond;
import wromaciej.hvac_sim.thermo.matter.fluids.model.Fluid;

public class FluidStream extends MatterStream {

    private Fluid specificParameters;

    public final InletStreamBond<FluidStream> inletStreamBond;
    public final OutletStreamBond<FluidStream> outletStreamBond;

    public FluidStream(int id, IdGenerator idGenerator, Fluid specificParameters, InletStreamBond<FluidStream> inletStreamBond, OutletStreamBond<FluidStream> outletStreamBond) {
        super(id, idGenerator, specificParameters, inletStreamBond, outletStreamBond);
        this.inletStreamBond = inletStreamBond;
        this.outletStreamBond = outletStreamBond;
        this.inletStreamBond.setOwnerItem(this);
        this.outletStreamBond.setOwnerItem(this);

    }
}
