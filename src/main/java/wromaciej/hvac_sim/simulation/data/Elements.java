package wromaciej.hvac_sim.simulation.data;

import wromaciej.hvac_sim.solver.internals.Solvable;
import wromaciej.hvac_sim.thermo.devices.model.basic.Device;
import wromaciej.hvac_sim.thermo.generals.Item;
import wromaciej.hvac_sim.thermo.streams.model.MatterStream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Elements {
    private List<Solvable> solvables;

    /**
     * Map of all items by ID as a key
     */
    private final Map<Integer, Item> allItems;
    /**
     * Map of all matter streams by ID as a key
     */
    private final Map<Integer, MatterStream> allMatterStreams;
    /**
     * Map of all devices by ID as a key
     */
    private final Map<Integer, Device> allDevices;


    public Elements() {
        this.solvables = new ArrayList<>();
        this.allItems = new HashMap<>();
        this.allMatterStreams = new HashMap<>();
        this.allDevices = new HashMap<>();
    }

    public List<Solvable> getSolvables() {
        return solvables;
    }

    public Map<Integer, Item> getAllItems() {
        return allItems;
    }

    public Map<Integer, MatterStream> getAllMatterStreams() {
        return allMatterStreams;
    }

    public Map<Integer, Device> getAllDevices() {
        return allDevices;
    }
}
