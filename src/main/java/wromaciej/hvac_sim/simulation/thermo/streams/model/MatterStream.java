package wromaciej.hvac_sim.simulation.thermo.streams.model;

import wromaciej.hvac_sim.ids.IdGenerator;
import wromaciej.hvac_sim.simulation.thermo.generals.bonds.InletStreamBond;
import wromaciej.hvac_sim.simulation.thermo.generals.bonds.OutletStreamBond;
import wromaciej.hvac_sim.simulation.thermo.matter.Matter;
import wromaciej.hvac_sim.simulation.thermo.parameters.Parameter;
import wromaciej.hvac_sim.simulation.thermo.quantities.extensive.MassFlow;
import wromaciej.hvac_sim.simulation.thermo.quantities.extensive.VolumeFlow;

public abstract class MatterStream extends AnyStream {


    private Parameter<MassFlow> massFlow;
    private Parameter<VolumeFlow> volumeFlow;

    protected Matter specificParameters;

    public final InletStreamBond<? extends MatterStream> inletStreamBond;
    public final OutletStreamBond<? extends MatterStream> outletStreamBond;




    public void setMassFlow(Parameter<MassFlow> massFlow) {
        this.massFlow = massFlow;
        if (specificParameters.getDensity().isDefined())
        this.volumeFlow = this.massFlow.divide(specificParameters.getDensity());
    }

    public void setVolumeFlow(Parameter<VolumeFlow> volumeFlow) {
        this.volumeFlow = volumeFlow;
        if (specificParameters.getDensity().isDefined())
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
