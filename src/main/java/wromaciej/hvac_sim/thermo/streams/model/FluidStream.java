package wromaciej.hvac_sim.thermo.streams.model;

import wromaciej.hvac_sim.display.Item;
import wromaciej.hvac_sim.ids.IdGenerator;
import wromaciej.hvac_sim.thermo.devices.model.basic.Bond;
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
        intletBond = new Bond(idGenerator.getUniqueId(), id);
        outletBond = new Bond(idGenerator.getUniqueId(), id);
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
