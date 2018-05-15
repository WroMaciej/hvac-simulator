package wromaciej.hvac_sim.thermo.devices.model.basic;

import wromaciej.hvac_sim.ids.IdGenerator;
import wromaciej.hvac_sim.solver.externals.ExternalSolver;
import wromaciej.hvac_sim.solver.externals.HeaterSolver;
import wromaciej.hvac_sim.thermo.generals.bonds.BondDirection;
import wromaciej.hvac_sim.thermo.generals.bonds.OutletDeviceBond;
import wromaciej.hvac_sim.thermo.generals.conservationLaw.Channel;
import wromaciej.hvac_sim.thermo.generals.bonds.InletDeviceBond;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.quantities.extensive.MassFlow;
import wromaciej.hvac_sim.thermo.quantities.specific.PressureDifference;
import wromaciej.hvac_sim.thermo.streams.model.HeatStream;
import wromaciej.hvac_sim.thermo.streams.model.MatterStream;

import javax.measure.unit.SI;

public class Heater extends Device {
    public final InletDeviceBond<HeatStream> heatInlet;

    private final Channel<MatterStream> mainChannel;

    public Heater(int id, IdGenerator idGenerator, ExternalSolver<Heater> externalSolver, Channel<MatterStream> mainChannel, InletDeviceBond<HeatStream> heatInlet) {
        super(id, idGenerator, externalSolver);
        this.mainChannel = mainChannel;
        this.heatInlet = heatInlet;
        mainChannel.getHeatFlow().setDirection(BondDirection.INLET);
        mainChannel.getHeatFlow().setParameter(heatInlet.getTargetBond().getOwnerItem().getHeatFlow());
        mainChannel.getExtraMassFlow().setParameter(new Parameter (SI.KILOGRAM.divide(SI.SECOND).asType(MassFlow.class), 0.0));

    }







}
