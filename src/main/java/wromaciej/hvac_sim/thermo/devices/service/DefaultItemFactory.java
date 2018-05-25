package wromaciej.hvac_sim.thermo.devices.service;

import wromaciej.hvac_sim.ids.IdGenerator;
import wromaciej.hvac_sim.simulation.general.data.AllElements;
import wromaciej.hvac_sim.simulation.general.data.AllSolvers;
import wromaciej.hvac_sim.thermo.devices.model.basic.Heater;
import wromaciej.hvac_sim.thermo.generals.Item;
import wromaciej.hvac_sim.thermo.generals.bonds.InletDeviceBond;
import wromaciej.hvac_sim.thermo.generals.bonds.InletStreamBond;
import wromaciej.hvac_sim.thermo.generals.bonds.OutletDeviceBond;
import wromaciej.hvac_sim.thermo.generals.bonds.OutletStreamBond;
import wromaciej.hvac_sim.thermo.generals.conservationLaw.Channel;
import wromaciej.hvac_sim.thermo.generals.conservationLaw.ParameterWithDirection;
import wromaciej.hvac_sim.thermo.matter.fluids.model.Fluid;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.quantities.extensive.HeatFlow;
import wromaciej.hvac_sim.thermo.quantities.specific.PressureDifference;
import wromaciej.hvac_sim.thermo.streams.model.FluidStream;
import wromaciej.hvac_sim.thermo.streams.model.HeatStream;
import wromaciej.hvac_sim.thermo.streams.model.MatterStream;
import wromaciej.hvac_sim.thermo.unitSystems.UnitSystem;

import static wromaciej.hvac_sim.thermo.generals.bonds.BondDirection.INLET;

/**
 * Creates brand new and complete devices
 */

public class DefaultItemFactory {

    private AllElements allElements;
    private UnitSystem unitSystem;
    private IdGenerator idGenerator;
    private AllSolvers allSolvers;

    public DefaultItemFactory(AllElements allElements, UnitSystem unitSystem, IdGenerator idGenerator, AllSolvers allSolvers) {
        this.allElements = allElements;
        this.unitSystem = unitSystem;
        this.idGenerator = idGenerator;
        this.allSolvers = allSolvers;
    }

    public HeatStream defaultHeatStream(){
        int uniqueId = idGenerator.getUniqueId();
        Parameter<HeatFlow> heatFlow = new Parameter<>(unitSystem.getHeatFlowUnit());
        InletStreamBond<HeatStream>  inletStreamBond = new InletStreamBond<>(idGenerator.getUniqueId());
        OutletStreamBond<HeatStream> outletStreamBond = new OutletStreamBond<>(idGenerator.getUniqueId());
        HeatStream heatStream = new HeatStream(uniqueId, idGenerator, heatFlow, inletStreamBond, outletStreamBond);
        heatStream.setName("HeatStream " + uniqueId);

        heatStream.setExternalSolver(allSolvers.getHeatStreamSolver());
        allElements.addHeatStream(heatStream);
        return heatStream;
    }

    public FluidStream defaultFluidStream(){
        int uniqueId = idGenerator.getUniqueId();
        InletStreamBond<FluidStream>  inletStreamBond = new InletStreamBond<>(idGenerator.getUniqueId());
        OutletStreamBond<FluidStream> outletStreamBond = new OutletStreamBond<>(idGenerator.getUniqueId());
        Fluid specificParameters = new Fluid(allSolvers.getFluidSolver());
        FluidStream fluidStream = new FluidStream(uniqueId, idGenerator, specificParameters, inletStreamBond, outletStreamBond);
        fluidStream.setName("FluidStream " + uniqueId);

        fluidStream.setExternalSolver(allSolvers.getMatterStreamSolver());
        allElements.addMatterStream(fluidStream);
        return fluidStream;
    }

    private Channel defaultChannel(Item ownerItem, Parameter<PressureDifference> pressureDrop, ParameterWithDirection heatFlow, ParameterWithDirection extraMassFlow){
        InletDeviceBond inletDeviceBond = new InletDeviceBond(idGenerator.getUniqueId());
        OutletDeviceBond outletDeviceBond = new OutletDeviceBond(idGenerator.getUniqueId());
        Channel channel = new Channel(ownerItem, inletDeviceBond, outletDeviceBond, pressureDrop, heatFlow, extraMassFlow);
        return channel;
    }

    public Heater defaultHeater(){
        int uniqueId = idGenerator.getUniqueId();
        Parameter<PressureDifference> pressureDrop = new Parameter<>(unitSystem.getPressureDifferenceUnit(), 0.0);
        ParameterWithDirection heatFlow = new ParameterWithDirection(new Parameter(unitSystem.getHeatFlowUnit()), INLET);
        ParameterWithDirection extraMassFlow = new ParameterWithDirection(new Parameter(unitSystem.getMassFlowUnit(), 0.0), INLET);
        InletDeviceBond<HeatStream> heatStreamInletDeviceBond= new InletDeviceBond<>(idGenerator.getUniqueId());
        Heater heater = new Heater(uniqueId, idGenerator, null, heatStreamInletDeviceBond);
        Channel<MatterStream> channel = defaultChannel(heater, pressureDrop, heatFlow, extraMassFlow);
        heater.setMainChannel(channel);
        return heater;
    }



}
