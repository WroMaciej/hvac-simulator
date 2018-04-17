package wromaciej.hvac_sim.thermo.streams.model;

import wromaciej.hvac_sim.thermo.Ids;
import wromaciej.hvac_sim.thermo.devices.model.basic.Bond;
import wromaciej.hvac_sim.thermo.matter.fluids.model.Fluid;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.quantities.extensive.MassFlow;
import wromaciej.hvac_sim.thermo.quantities.extensive.VolumeFlow;

public class FluidStream {
    private final int id;
    private final Fluid specificParameters;
    private Parameter<MassFlow> massFlow;
    private Parameter<VolumeFlow> volumeFlow;

    private Bond intletBond;
    private Bond outletBond;

    public void setMassFlow(Parameter<MassFlow> massFlow) {
        this.massFlow = massFlow;
        this.volumeFlow = this.massFlow.divide(specificParameters.getDensity());
    }

    public void setVolumeFlow(Parameter<VolumeFlow> volumeFlow) {
        this.volumeFlow = volumeFlow;
        this.massFlow = this.volumeFlow.times(specificParameters.getDensity());
    }

    public FluidStream(int id, Fluid specificParameters) {
        this.id = id;
        this.specificParameters = specificParameters;
        intletBond = new Bond(Ids.getUniqueId(), id);
        outletBond = new Bond(Ids.getUniqueId(), id);
    }
}
