package wromaciej.hvac_sim.thermo.solvers;

import org.junit.Assert;
import org.junit.Test;
import wromaciej.hvac_sim.solver.externals.ChannelSolver;
import wromaciej.hvac_sim.solver.externals.JunctionSolver;
import wromaciej.hvac_sim.solver.matterSolvers.FluidSolver;
import wromaciej.hvac_sim.thermo.generals.bonds.*;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.quantities.extensive.MassFlow;
import wromaciej.hvac_sim.thermo.quantities.specific.PressureDifference;
import wromaciej.hvac_sim.thermo.streams.model.FluidStream;

import javax.measure.unit.SI;
import java.util.ArrayList;
import java.util.List;

public class ChannelSolverTest {

    @Test
    public void shouldReturnOutletPressureWithInletAndPressureDropDefined(){
        //GIVEN
        Parameter<MassFlow> inletMassFlow = new Parameter<>(SI.KILOGRAM.divide(SI.SECOND).asType(MassFlow.class),100.0);
        Parameter<MassFlow> outletMassFlow = new Parameter<>(SI.KILOGRAM.divide(SI.SECOND).asType(MassFlow.class),100.0);
        Parameter<MassFlow> extraMassFlow = new Parameter<>(SI.KILOGRAM.divide(SI.SECOND).asType(MassFlow.class));

        InletDeviceBond<FluidStream> inletDeviceBond = new InletDeviceBond<>(1, null);
        OutletDeviceBond<FluidStream> outletDeviceBond = new OutletDeviceBond<>(2, null);
        InletStreamBond<FluidStream> inletStreamBond = new InletStreamBond<>(3, )

        FluidStream inletFluidStream = new FluidStream(3, null, null, inletBond, outletBond);



        Parameter<PressureDifference> pressureDrop = new Parameter<>(SI.PASCAL.asType(PressureDifference.class),250);
        Channel<FluidStream> channel = new Channel<>(null, inletDeviceBond, outletDeviceBond, pressureDrop, extraMassFlow);
        JunctionSolver junctionSolver = new JunctionSolver();
        ChannelSolver channelSolver = new ChannelSolver(junctionSolver);


        parametersWithDirections.add(new ParameterWithDirection(inletMassFlow, BondDirection.INLET));
        parametersWithDirections.add(new ParameterWithDirection(outletMassFlow, BondDirection.OUTLET));
        parametersWithDirections.add(new ParameterWithDirection(extraMassFlow, BondDirection.OUTLET));
        Junction junction = new Junction(parametersWithDirections, junctionSolver);

        //WHEN
        junction.solve();

        //THEN
        Assert.assertEquals(junction.getAllParameters().get(2).getParameter().getValue(),80,0.1);
        Assert.assertEquals(junction.getAllParameters().get(2).getDirection(), BondDirection.INLET);
    }
}
