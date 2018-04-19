package wromaciej.hvac_sim.thermo.devices.model.basic;

import wromaciej.hvac_sim.thermo.Item;
import wromaciej.hvac_sim.ids.IdGenerator;

public abstract class Device extends Item {

    public Device(int id, IdGenerator idGenerator) {
        super(id, idGenerator);
    }
}
