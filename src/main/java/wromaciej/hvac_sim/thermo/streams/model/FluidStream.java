package wromaciej.hvac_sim.thermo.streams.model;

import wromaciej.hvac_sim.thermo.matter.fluids.model.Fluid;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.quantities.extensive.MassFlow;
import wromaciej.hvac_sim.thermo.quantities.extensive.VolumeFlow;

public class FluidStream {
    private Fluid specificParameters;
    private Parameter<MassFlow> massFlow;
    private Parameter<VolumeFlow> volumeFlow;
}
