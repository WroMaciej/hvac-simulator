package wromaciej.hvac_sim.thermo.devices.service;

import wromaciej.hvac_sim.ids.IdGenerator;
import wromaciej.hvac_sim.simulation.data.AllElements;
import wromaciej.hvac_sim.thermo.devices.model.basic.Heater;
import wromaciej.hvac_sim.thermo.generals.bonds.InletStreamBond;
import wromaciej.hvac_sim.thermo.generals.bonds.OutletStreamBond;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.ParameterType;
import wromaciej.hvac_sim.thermo.quantities.extensive.HeatFlow;
import wromaciej.hvac_sim.thermo.streams.model.FluidStream;
import wromaciej.hvac_sim.thermo.streams.model.HeatStream;
import wromaciej.hvac_sim.thermo.unitSystems.UnitSystem;

/**
 * Creates brand new and complete devices
 */
public class DefaultItemFactory {

    private AllElements allElements;
    private UnitSystem unitSystem;
    private IdGenerator idGenerator

    public DefaultItemFactory(AllElements allElements, UnitSystem unitSystem, IdGenerator idGenerator) {
        this.allElements = allElements;
        this.unitSystem = unitSystem;
        this.idGenerator = idGenerator;
    }

    public HeatStream createDefaultHeatStream(){
        int heatStreamId = idGenerator.getUniqueId();
        HeatStream heatStream;
        Parameter<HeatFlow> heatFlow = new Parameter<>(ParameterType.OTHER, unitSystem.getHeatFlowUnit());
        InletStreamBond<HeatStream>  inletStreamBond = new InletStreamBond<>(idGenerator.getUniqueId());
        OutletStreamBond<HeatStream> outletStreamBond = new OutletStreamBond<>(idGenerator.getUniqueId());
        heatStream = new HeatStream(heatStreamId, idGenerator, heatFlow, inletStreamBond, outletStreamBond);
        heatStream.setName("HeatStream " + heatStreamId);
        allElements.addHeatStream(heatStream);
        return heatStream;
    }

    public FluidStream createDefaultFluidStream(){}

    public Heater createDefaultHeater(){}



}
