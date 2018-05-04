package wromaciej.hvac_sim.thermo.streams.model;

import wromaciej.hvac_sim.ids.IdGenerator;
import wromaciej.hvac_sim.thermo.devices.model.basic.Device;
import wromaciej.hvac_sim.thermo.generals.bonds.InletStreamBond;
import wromaciej.hvac_sim.thermo.generals.bonds.OutletStreamBond;
import wromaciej.hvac_sim.thermo.matter.fluids.model.Fluid;
import wromaciej.hvac_sim.thermo.matter.Matter;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.quantities.extensive.MassFlow;
import wromaciej.hvac_sim.thermo.quantities.extensive.VolumeFlow;

public abstract class MatterStream extends AnyStream {


    private Parameter<MassFlow> massFlow;
    private Parameter<VolumeFlow> volumeFlow;

    private Matter specificParameters;

    public final InletStreamBond<? extends MatterStream> inletStreamBond;
    public final OutletStreamBond<? extends MatterStream> outletStreamBond;




    public void setMassFlow(Parameter<MassFlow> massFlow) {
        this.massFlow = massFlow;
        this.volumeFlow = this.massFlow.divide(specificParameters.getDensity());
    }

    public void setVolumeFlow(Parameter<VolumeFlow> volumeFlow) {
        this.volumeFlow = volumeFlow;
        this.massFlow = this.volumeFlow.times(specificParameters.getDensity());
    }

    public MatterStream(int id, IdGenerator idGenerator, Matter specificParameters, InletStreamBond<? extends MatterStream> inletStreamBond, OutletStreamBond<? extends MatterStream> outletStreamBond) {
        super(id, idGenerator, inletStreamBond, outletStreamBond);
        this.specificParameters = specificParameters;
        this.inletStreamBond = inletStreamBond;
        this.outletStreamBond = outletStreamBond;
        this.inletStreamBond.setOwnerItem(this);
        this.outletStreamBond.setOwnerItem(this);
    }

    public Matter getSpecificParameters() {
        return specificParameters;
    }

    public Parameter<MassFlow> getMassFlow() {
        return massFlow;
    }

    public Parameter<VolumeFlow> getVolumeFlow() {
        return volumeFlow;
    }


    @Override
    public String display() {
        return null;
    }


}
