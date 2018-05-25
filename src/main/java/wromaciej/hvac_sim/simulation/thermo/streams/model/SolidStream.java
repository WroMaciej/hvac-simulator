package wromaciej.hvac_sim.simulation.thermo.streams.model;

import wromaciej.hvac_sim.ids.IdGenerator;
import wromaciej.hvac_sim.simulation.thermo.generals.bonds.InletStreamBond;
import wromaciej.hvac_sim.simulation.thermo.generals.bonds.OutletStreamBond;
import wromaciej.hvac_sim.simulation.thermo.matter.fluids.model.Fluid;

public class SolidStream extends MatterStream {
    public final InletStreamBond<SolidStream> inletStreamBond;
    public final OutletStreamBond<SolidStream> outletStreamBond;

    public SolidStream(int id, IdGenerator idGenerator, Fluid specificParameters, InletStreamBond<SolidStream> inletStreamBond, OutletStreamBond<SolidStream> outletStreamBond) {
        super(id, idGenerator, specificParameters, inletStreamBond, outletStreamBond);
        this.inletStreamBond = inletStreamBond;
        this.outletStreamBond = outletStreamBond;
        this.inletStreamBond.setOwnerItem(this);
        this.outletStreamBond.setOwnerItem(this);
    }
}
