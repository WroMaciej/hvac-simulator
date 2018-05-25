package wromaciej.hvac_sim.simulation.thermo.solvers;

import org.junit.Assert;
import org.junit.Test;
import wromaciej.hvac_sim.simulation.solver.externals.JunctionSolver;
import wromaciej.hvac_sim.simulation.thermo.generals.bonds.BondDirection;
import wromaciej.hvac_sim.simulation.thermo.generals.conservationLaw.Junction;
import wromaciej.hvac_sim.simulation.thermo.generals.conservationLaw.ParameterWithDirection;
import wromaciej.hvac_sim.simulation.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.simulation.thermo.quantities.extensive.MassFlow;

import javax.measure.unit.SI;
import java.util.ArrayList;
import java.util.List;

public class JunctionSolverTest {

    @Test
    public void shouldReturnExtraMassFlowForGivenInletAndOutlet(){
        //GIVEN
        JunctionSolver junctionSolver = new JunctionSolver();
        List<ParameterWithDirection> parametersWithDirections = new ArrayList<>();
        Parameter<MassFlow> inletMassFlow = new Parameter<>(SI.KILOGRAM.divide(SI.SECOND).asType(MassFlow.class),20.0);
        Parameter<MassFlow> outletMassFlow = new Parameter<>(SI.KILOGRAM.divide(SI.SECOND).asType(MassFlow.class),100.0);
        Parameter<MassFlow> extraMassFlow = new Parameter<>(SI.KILOGRAM.divide(SI.SECOND).asType(MassFlow.class));

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
