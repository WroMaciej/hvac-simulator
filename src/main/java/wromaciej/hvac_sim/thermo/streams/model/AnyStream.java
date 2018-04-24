package wromaciej.hvac_sim.thermo.streams.model;

import wromaciej.hvac_sim.thermo.generals.Item;
import wromaciej.hvac_sim.ids.IdGenerator;

public abstract class AnyStream extends Item {

    public AnyStream(int id, IdGenerator idGenerator) {
        super(id, idGenerator);
    }

}
