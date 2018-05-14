package wromaciej.hvac_sim.thermo.solvers;

import org.junit.Test;
import wromaciej.hvac_sim.solver.externals.ChannelSolver;
import wromaciej.hvac_sim.solver.externals.JunctionSolver;
import wromaciej.hvac_sim.thermo.generals.bonds.*;
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

import javax.measure.unit.SI;

import static wromaciej.hvac_sim.thermo.generals.bonds.BondDirection.INLET;
import static wromaciej.hvac_sim.thermo.generals.bonds.BondDirection.OUTLET;

public class ChannelSolverTest {

    @Test
    public void shouldReturnOutletPressureWithInletAndPressureDropDefined(){
        //GIVEN
        Parameter<MassFlow> inletMassFlow = new Parameter<>(SI.KILOGRAM.divide(SI.SECOND).asType(MassFlow.class),100.0);
        Parameter<MassFlow> outletMassFlow = new Parameter<>(SI.KILOGRAM.divide(SI.SECOND).asType(MassFlow.class),95.0);
        Parameter<MassFlow> extraMassFlow = new Parameter<>(SI.KILOGRAM.divide(SI.SECOND).asType(MassFlow.class));
        ParameterWithDirection extraMassFlowWithDirection = new ParameterWithDirection(extraMassFlow, INLET);

        Parameter<Pressure> inletPressure = new Parameter(ParameterType.PRESSURE, SI.PASCAL.asType(Pressure.class),300);
        Parameter<Pressure> outletPressure = new Parameter(ParameterType.PRESSURE, SI.PASCAL.asType(Pressure.class));
        Parameter<PressureDifference> pressureDrop = new Parameter<>(SI.PASCAL.asType(PressureDifference.class),250);
        Fluid inletFluid = new Fluid(null);
        Fluid outletFluid = new Fluid(null);
        inletFluid.setAbsolutePressure(inletPressure);
        inletFluid.setSpecificEnthalpy(new Parameter<SpecificEnthalpy>(ParameterType.SPECIFIC_ENTHALPY, SI.JOULE.divide(SI.KILOGRAM).asType(SpecificEnthalpy.class), 80.0));
        outletFluid.setAbsolutePressure(outletPressure);
        outletFluid.setSpecificEnthalpy(new Parameter<SpecificEnthalpy>(ParameterType.SPECIFIC_ENTHALPY, SI.JOULE.divide(SI.KILOGRAM).asType(SpecificEnthalpy.class), 20.0));


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

        ParameterWithDirection heatFlow = new ParameterWithDirection(new Parameter(SI.JOULE.divide(SI.SECOND)), OUTLET);



        Channel<FluidStream> channel = new Channel<>(null, inletDeviceBond, outletDeviceBond, pressureDrop, heatFlow, extraMassFlowWithDirection);


        inletFluidStream.outletStreamBond.connectTo(channel.getInletDeviceBond());
        outletFluidStream.inletStreamBond.connectTo(channel.getOutletDeviceBond());

        JunctionSolver junctionSolver = new JunctionSolver();
        ChannelSolver channelSolver = new ChannelSolver(junctionSolver);
        channel.setChannelSolver(channelSolver);

        //WHEN
        channel.solve();

        System.out.println("extra mass flow" + channel.getExtraMassFlow().getParameter() + channel.getExtraMassFlow().getDirection());
        System.out.println("outlet pressure: " + channel.getOutletStream().getSpecificParameters().getMatterDefinition());
        System.out.println("heat flow: " + channel.getHeatFlow().getParameter() + heatFlow.getDirection());
        System.out.println("specific enthalpy difference: " + channel.getSpecificEnthalpyDifference());


        //THEN
        //Assert.assertEquals(junction.getAllParameters().get(2).getParameter().getValue(),80,0.1);
       // Assert.assertEquals(junction.getAllParameters().get(2).getDirection(), INLET);
    }
}
