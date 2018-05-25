package wromaciej.hvac_sim.simulation.general.data;

import wromaciej.hvac_sim.simulation.thermo.devices.model.basic.Device;
import wromaciej.hvac_sim.simulation.thermo.generals.Item;
import wromaciej.hvac_sim.simulation.thermo.streams.model.HeatStream;
import wromaciej.hvac_sim.simulation.thermo.streams.model.MatterStream;
import wromaciej.hvac_sim.simulation.thermo.streams.model.PowerStream;

import java.util.HashMap;
import java.util.Map;


public class AllElements {

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

    private final Map<Integer, HeatStream> allHeatStreams;

    private final Map<Integer, PowerStream> allPowerStreams;


    public AllElements(Map<Integer, Item> allItems, Map<Integer, MatterStream> allMatterStreams, Map<Integer, Device> allDevices, Map<Integer, HeatStream> allHeatStreams, Map<Integer, PowerStream> allPowerStreams) {
        this.allItems = allItems;
        this.allMatterStreams = allMatterStreams;
        this.allDevices = allDevices;
        this.allHeatStreams = allHeatStreams;
        this.allPowerStreams = allPowerStreams;
    }

    public AllElements() {
        this.allItems = new HashMap<>();
        this.allMatterStreams = new HashMap<>();
        this.allHeatStreams = new HashMap<>();
        this.allPowerStreams = new HashMap<>();
        this.allDevices = new HashMap<>();
    }

    private void addItem(Item item){
        allItems.put(item.getId(), item);
    }

    public void addDevice(Device device){
        allDevices.put(device.getId(), device);
        addItem(device);
    }

    public void addMatterStream(MatterStream matterStream){
        allMatterStreams.put(matterStream.getId(), matterStream);
        addItem(matterStream);
    }

    public void addHeatStream(HeatStream heatStream){
        allHeatStreams.put(heatStream.getId(), heatStream);
        addItem(heatStream);
    }

    public void addPowerStream(PowerStream powerStream){
        allPowerStreams.put(powerStream.getId(), powerStream);
        addItem(powerStream);
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
