package wromaciej.hvac_sim.thermo.devices.model.basic;

import java.util.Collection;

public abstract class Device {

    private final int id;
    private final Collection<Bond> bonds;


    public Device(int id, Collection<Bond> bonds) {
        this.id = id;
        this.bonds = bonds;
    }
}
