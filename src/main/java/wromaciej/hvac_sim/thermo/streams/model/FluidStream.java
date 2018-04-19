package wromaciej.hvac_sim.thermo.streams.model;

import wromaciej.hvac_sim.ids.IdGenerator;
import wromaciej.hvac_sim.thermo.devices.model.basic.Device;
import wromaciej.hvac_sim.thermo.devices.model.basic.bonds.Bond;
import wromaciej.hvac_sim.thermo.devices.model.basic.bonds.BondDirection;
import wromaciej.hvac_sim.thermo.devices.model.basic.bonds.InletBond;
import wromaciej.hvac_sim.thermo.devices.model.basic.bonds.OutletBond;
import wromaciej.hvac_sim.thermo.matter.fluids.model.Fluid;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.quantities.extensive.MassFlow;
import wromaciej.hvac_sim.thermo.quantities.extensive.VolumeFlow;

public final class FluidStream extends AnyStream {


    private Fluid specificParameters;
    private Parameter<MassFlow> massFlow;
    private Parameter<VolumeFlow> volumeFlow;



    public void setMassFlow(Parameter<MassFlow> massFlow) {
        this.massFlow = massFlow;
        this.volumeFlow = this.massFlow.divide(specificParameters.getDensity());
    }

    public void setVolumeFlow(Parameter<VolumeFlow> volumeFlow) {
        this.volumeFlow = volumeFlow;
        this.massFlow = this.volumeFlow.times(specificParameters.getDensity());
    }

    public FluidStream(int id, IdGenerator idGenerator, Fluid specificParameters) {
        super(id, idGenerator);
        this.specificParameters = specificParameters;
        InletBond<FluidStream, Device> fluidStreamIntletBond= new InletBond<>(idGenerator.getUniqueId(), this);
        OutletBond<FluidStream, Device> fluidStreamOutletBond= new OutletBond<>(idGenerator.getUniqueId(), this);
        this.setBonds(fluidStreamIntletBond, fluidStreamOutletBond);
    }


    @Override
    public String display() {
        return null;
    }

    @Override
    public boolean compute() {
        return false;
    }
}
