package wromaciej.hvac_sim.thermo.devices.model.basic;

import wromaciej.hvac_sim.ids.IdGenerator;
import wromaciej.hvac_sim.thermo.generals.bonds.InletDeviceBond;
import wromaciej.hvac_sim.thermo.generals.bonds.OutletDeviceBond;
import wromaciej.hvac_sim.thermo.generals.conservationLaw.Junction;
import wromaciej.hvac_sim.thermo.matter.Matter;

import java.util.List;

public class Mixer extends Device {
    private List<InletDeviceBond> inletBonds;
    private List<OutletDeviceBond> outletBonds;

    /**
     * Mean parameters inside the box basing on inlets
     */
    private Matter meanMatter;

    private Integer numberOfInlets;
    private Integer numberOfOutlets;

    private Junction junction;


    public Mixer(int id, IdGenerator idGenerator, List<InletDeviceBond> inletBonds, List<OutletDeviceBond> outletBonds, Integer numberOfInlets, Integer numberOfOutlets) {
        super(id, idGenerator);
        this.inletBonds = inletBonds;
        this.outletBonds = outletBonds;
        this.numberOfInlets = numberOfInlets;
        this.numberOfOutlets = numberOfOutlets;
    }

    private void putDataToJunction(){
        
    }
}
