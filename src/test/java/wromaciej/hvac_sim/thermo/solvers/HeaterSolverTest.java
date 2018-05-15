package wromaciej.hvac_sim.thermo.solvers;

import org.junit.Test;
import wromaciej.hvac_sim.solver.externals.ChannelSolver;
import wromaciej.hvac_sim.solver.externals.HeaterSolver;
import wromaciej.hvac_sim.solver.externals.JunctionSolver;
import wromaciej.hvac_sim.thermo.devices.model.basic.Heater;
import wromaciej.hvac_sim.thermo.generals.bonds.InletDeviceBond;
import wromaciej.hvac_sim.thermo.generals.bonds.InletStreamBond;
import wromaciej.hvac_sim.thermo.generals.bonds.OutletDeviceBond;
import wromaciej.hvac_sim.thermo.generals.bonds.OutletStreamBond;
import wromaciej.hvac_sim.thermo.generals.conservationLaw.Channel;
import wromaciej.hvac_sim.thermo.generals.conservationLaw.ParameterWithDirection;
import wromaciej.hvac_sim.thermo.matter.fluids.model.Fluid;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.ParameterType;
import wromaciej.hvac_sim.thermo.quantities.extensive.MassFlow;
import wromaciej.hvac_sim.thermo.quantities.specific.Pressure;
import wromaciej.hvac_sim.thermo.quantities.specific.PressureDifference;
import wromaciej.hvac_sim.thermo.quantities.specific.SpecificEnthalpy;
import wromaciej.hvac_sim.thermo.streams.model.FluidStream;
import wromaciej.hvac_sim.thermo.streams.model.HeatStream;

import javax.measure.unit.SI;

import static wromaciej.hvac_sim.thermo.generals.bonds.BondDirection.INLET;

public class HeaterSolverTest {

    @Test
    public void shouldReturnSolvedHeated(){
        //GIVEN
        Parameter<MassFlow> inletMassFlow = new Parameter<>(SI.KILOGRAM.divide(SI.SECOND).asType(MassFlow.class));
        Parameter<MassFlow> outletMassFlow = new Parameter<>(SI.KILOGRAM.divide(SI.SECOND).asType(MassFlow.class), 2.0);
        Parameter<MassFlow> extraMassFlow = new Parameter<>(SI.KILOGRAM.divide(SI.SECOND).asType(MassFlow.class));
        ParameterWithDirection extraMassFlowWithDirection = new ParameterWithDirection(extraMassFlow, INLET);

        Parameter<Pressure> inletPressure = new Parameter(ParameterType.PRESSURE, SI.PASCAL.asType(Pressure.class),300);
        Parameter<Pressure> outletPressure = new Parameter(ParameterType.PRESSURE, SI.PASCAL.asType(Pressure.class));
        Parameter<PressureDifference> pressureDrop = new Parameter<>(SI.PASCAL.asType(PressureDifference.class),250);
        Fluid inletFluid = new Fluid(null);
        Fluid outletFluid = new Fluid(null);
        inletFluid.setAbsolutePressure(inletPressure);
        inletFluid.setSpecificEnthalpy(new Parameter<SpecificEnthalpy>(ParameterType.SPECIFIC_ENTHALPY, SI.JOULE.divide(SI.KILOGRAM).asType(SpecificEnthalpy.class), 10.0));
        outletFluid.setAbsolutePressure(outletPressure);
        outletFluid.setSpecificEnthalpy(new Parameter<SpecificEnthalpy>(ParameterType.SPECIFIC_ENTHALPY, SI.JOULE.divide(SI.KILOGRAM).asType(SpecificEnthalpy.class), 50.0));

        InletDeviceBond<FluidStream> inletDeviceBond = new InletDeviceBond<>(1);
        OutletDeviceBond<FluidStream> outletDeviceBond = new OutletDeviceBond<>(2);
        InletStreamBond<FluidStream> inletOfInletStreamBond = new InletStreamBond<>(3);
        OutletStreamBond<FluidStream> outletOfInletStreamBond = new OutletStreamBond<>(4);
        InletStreamBond<FluidStream> inletOfIOutletStreamBond = new InletStreamBond<>(5);
        OutletStreamBond<FluidStream> outletOfOutletStreamBond = new OutletStreamBond<>(6);

        FluidStream inletFluidStream = new FluidStream(7, null, inletFluid, inletOfInletStreamBond, outletOfInletStreamBond);
        inletFluidStream.setMassFlow(inletMassFlow);
        FluidStream outletFluidStream = new FluidStream(8, null, outletFluid, inletOfIOutletStreamBond, outletOfOutletStreamBond);
        outletFluidStream.setMassFlow(outletMassFlow);

        ParameterWithDirection heatFlow = new ParameterWithDirection(new Parameter(SI.JOULE.divide(SI.SECOND)), INLET);

        Channel<FluidStream> channel =
                new Channel<>(null, inletDeviceBond, outletDeviceBond, pressureDrop, heatFlow, extraMassFlowWithDirection);

        inletFluidStream.outletStreamBond.connectTo(channel.getInletDeviceBond());
        outletFluidStream.inletStreamBond.connectTo(channel.getOutletDeviceBond());

        JunctionSolver junctionSolver = new JunctionSolver();
        ChannelSolver channelSolver = new ChannelSolver(junctionSolver);
        channel.setChannelSolver(channelSolver);

        InletDeviceBond<HeatStream> heatInletBond = new InletDeviceBond<>(0);

        InletStreamBond<HeatStream> inletHeatStreamBond = new InletStreamBond<>(0);
        OutletStreamBond<HeatStream> outletHeatStreamBond = new OutletStreamBond<>(0);

        HeatStream heatStream = new HeatStream(0, null, heatFlow.getParameter(), inletHeatStreamBond, outletHeatStreamBond);


        //WHEN
        Heater heater = new Heater(99, null, channel, heatInletBond);
        HeaterSolver heaterSolver = new HeaterSolver();
        heater.setExternalSolver(heaterSolver);
        heatStream.outletStreamBond.connectTo(heater.getHeatStreamInletDeviceBond());
        heater.update();
        heater.solve();

        System.out.println(heater.getMainChannel().getHeatFlow().getParameter());
        System.out.println(heater.getMainChannel().getOutletStream().getSpecificParameters().getMatterDefinition());
        System.out.println(heatStream.getHeatFlow());
        System.out.println(heater.getMainChannel().getExtraMassFlow().getParameter());
        System.out.println(heater.getMainChannel().getInletStream().getMassFlow());



    }
}
