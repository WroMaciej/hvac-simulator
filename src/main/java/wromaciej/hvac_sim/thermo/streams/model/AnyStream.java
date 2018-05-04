package wromaciej.hvac_sim.thermo.streams.model;

import wromaciej.hvac_sim.thermo.generals.Item;
import wromaciej.hvac_sim.ids.IdGenerator;
import wromaciej.hvac_sim.thermo.generals.bonds.InletStreamBond;
import wromaciej.hvac_sim.thermo.generals.bonds.OutletStreamBond;

public abstract class AnyStream extends Item {

    public final InletStreamBond<? extends AnyStream> inletStreamBond;
    public final OutletStreamBond<? extends AnyStream> outletStreamBond;


    public AnyStream(int id, IdGenerator idGenerator, InletStreamBond<? extends AnyStream> inletStreamBond, OutletStreamBond<? extends AnyStream> outletStreamBond) {
        super(id, idGenerator);
        this.inletStreamBond = inletStreamBond;
        this.outletStreamBond = outletStreamBond;
        this.inletStreamBond.setOwnerItem(this);
        this.outletStreamBond.setOwnerItem(this);
    }


}
