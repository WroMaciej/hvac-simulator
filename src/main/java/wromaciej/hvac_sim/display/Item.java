package wromaciej.hvac_sim.display;

import wromaciej.hvac_sim.ids.IdGenerator;
import wromaciej.hvac_sim.thermo.devices.model.basic.Computable;

/**
 * Any object that could be treated as a part of process
 */
public abstract class Item implements Displayable, Computable {

    private final int id;
    private String name;

    private DisplayParameters displayParameters;

    public Item(int id, IdGenerator idGenerator) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
