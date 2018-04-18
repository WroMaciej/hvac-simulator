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

public class FluidStream extends AnyStream {


    private final Fluid specificParameters;
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


    public FluidStream(int id, Fluid specificParameters, IdGenerator idGenerator) {
        super(id);
        this.specificParameters = specificParameters;
        inletBond = new Bond(idGenerator.getUniqueId(), id);
        outletBond = new Bond(idGenerator.getUniqueId(), id);
    }

    public FluidStream(int id, IdGenerator idGenerator, Fluid specificParameters) {
        super(id, idGenerator, new InletBond<FluidStream, Device>(BondDirection.INLET, ,  ), outletBond);
        this.specificParameters = specificParameters;
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
