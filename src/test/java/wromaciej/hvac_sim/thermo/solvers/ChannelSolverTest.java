package wromaciej.hvac_sim.thermo.solvers;

import org.junit.Assert;
import org.junit.Test;
import wromaciej.hvac_sim.solver.externals.ChannelSolver;
import wromaciej.hvac_sim.solver.externals.JunctionSolver;
import wromaciej.hvac_sim.solver.matterSolvers.FluidSolver;
import wromaciej.hvac_sim.thermo.generals.bonds.*;
import wromaciej.hvac_sim.thermo.matter.fluids.model.Fluid;
import wromaciej.hvac_sim.thermo.matter.fluids.model.FluidFactory;
import wromaciej.hvac_sim.thermo.matter.fluids.model.FluidSetter;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.matter.fluids.service.FluidData;
import wromaciej.hvac_sim.thermo.quantities.extensive.MassFlow;
import wromaciej.hvac_sim.thermo.quantities.specific.Pressure;
import wromaciej.hvac_sim.thermo.quantities.specific.PressureDifference;
import wromaciej.hvac_sim.thermo.streams.model.FluidStream;

import javax.measure.unit.SI;
import java.util.ArrayList;
import java.util.List;

import static wromaciej.hvac_sim.thermo.generals.bonds.BondDirection.INLET;

public class ChannelSolverTest {

    @Test
    public void shouldReturnOutletPressureWithInletAndPressureDropDefined(){
        //GIVEN
        Parameter<MassFlow> inletMassFlow = new Parameter<>(SI.KILOGRAM.divide(SI.SECOND).asType(MassFlow.class),75.0);
        Parameter<MassFlow> outletMassFlow = new Parameter<>(SI.KILOGRAM.divide(SI.SECOND).asType(MassFlow.class),100.0);
        Parameter<MassFlow> extraMassFlow = new Parameter<>(SI.KILOGRAM.divide(SI.SECOND).asType(MassFlow.class));
        ParameterWithDirection extraMassFlowWithDirection = new ParameterWithDirection(extraMassFlow, INLET);

        Parameter<Pressure> inletPressure = new Parameter(SI.PASCAL.asType(Pressure.class),300);
        Parameter<PressureDifference> pressureDrop = new Parameter<>(SI.PASCAL.asType(PressureDifference.class),250);
        Fluid inletFluid = new Fluid(null);
        Fluid outletFluid = new Fluid(null);
        inletFluid.setAbsolutePressure(inletPressure);

        InletDeviceBond<FluidStream> inletDeviceBond = new InletDeviceBond<>(1);
        OutletDeviceBond<FluidStream> outletDeviceBond = new OutletDeviceBond<>(2);
        InletStreamBond<FluidStream> inletOfInletStreamBond = new InletStreamBond<>(3);
        OutletStreamBond<FluidStream> outletOfInletStreamBond = new OutletStreamBond<>(4);
        InletStreamBond<FluidStream> inletOfIOutletStreamBond = new InletStreamBond<>(5);
        OutletStreamBond<FluidStream> outletOfOutletStreamBond = new OutletStreamBond<>(6);

        FluidStream inletFluidStream = new FluidStream(7, null, inletFluid, inletOfInletStreamBond, outletOfInletStreamBond);
        FluidStream outletFluidStream = new FluidStream(8, null, inletFluid, inletOfIOutletStreamBond, outletOfOutletStreamBond);


        Channel<FluidStream> channel = new Channel<>(null, inletDeviceBond, outletDeviceBond, pressureDrop, extraMassFlowWithDirection);


        inletFluidStream.outletStreamBond.connectTo(channel.getInletDeviceBond());
        outletFluidStream.inletStreamBond.connectTo(channel.getOutletDeviceBond());

       // FluidData fluidData = new FluidData(true);

        //FluidFactory fluidFactory = new FluidFactory(fluidData, new FluidSolver(new FluidSetter(fluidData)));
        //Fluid inletFluid = fluidFactory.createFluid();





        JunctionSolver junctionSolver = new JunctionSolver();
        ChannelSolver channelSolver = new ChannelSolver(junctionSolver);
        channel.setChannelSolver(channelSolver);

        //WHEN
        channel.solve();
        System.out.println(channel.getOutletStream().getSpecificParameters().getAbsolutePressure());

        //THEN
        //Assert.assertEquals(junction.getAllParameters().get(2).getParameter().getValue(),80,0.1);
       // Assert.assertEquals(junction.getAllParameters().get(2).getDirection(), INLET);
    }
}
