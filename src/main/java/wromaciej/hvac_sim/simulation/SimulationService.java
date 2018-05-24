package wromaciej.hvac_sim.simulation;

import org.springframework.stereotype.Service;
import wromaciej.hvac_sim.thermo.devices.model.basic.Heater;
import wromaciej.hvac_sim.thermo.streams.model.FluidStream;
import wromaciej.hvac_sim.thermo.streams.model.HeatStream;

public class SimulationService {

    private Simulation simulation;

    public SimulationService(Simulation simulation) {
        this.simulation = simulation;
    }

    public void addDefaultHeatStream(){
        HeatStream heatStream = simulation.getDefaultItemFactory().defaultHeatStream();
        simulation.getAllElements().addHeatStream(heatStream);
    }

    public void addDefaultFluidStream(){
        FluidStream fluidStream = simulation.getDefaultItemFactory().defaultFluidStream();
        simulation.getAllElements().addMatterStream(fluidStream);
    }

    public void addDefaultHeater(){
        Heater heater = simulation.getDefaultItemFactory().defaultHeater();
        simulation.getAllElements().addDevice(heater);
    }


}
