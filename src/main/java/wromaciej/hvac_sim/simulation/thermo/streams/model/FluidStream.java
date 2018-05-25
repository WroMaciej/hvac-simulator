package wromaciej.hvac_sim.simulation.thermo.streams.model;

import wromaciej.hvac_sim.ids.IdGenerator;
import wromaciej.hvac_sim.simulation.thermo.generals.bonds.InletStreamBond;
import wromaciej.hvac_sim.simulation.thermo.generals.bonds.OutletStreamBond;
import wromaciej.hvac_sim.simulation.thermo.matter.Matter;
import wromaciej.hvac_sim.simulation.thermo.matter.fluids.model.Fluid;

public class FluidStream extends MatterStream {

    //private Fluid specificParameters;

    public final InletStreamBond<FluidStream> inletStreamBond;
    public final OutletStreamBond<FluidStream> outletStreamBond;

    public FluidStream(int id, IdGenerator idGenerator, Fluid specificParameters, InletStreamBond<FluidStream> inletStreamBond, OutletStreamBond<FluidStream> outletStreamBond) {
        super(id, idGenerator, specificParameters, inletStreamBond, outletStreamBond);
        this.specificParameters = specificParameters;
        this.inletStreamBond = inletStreamBond;
        this.outletStreamBond = outletStreamBond;
        this.inletStreamBond.setOwnerItem(this);
        this.outletStreamBond.setOwnerItem(this);

    }

    @Override
    public Fluid getSpecificParameters() {
        return (Fluid) this.specificParameters;
    }
}
