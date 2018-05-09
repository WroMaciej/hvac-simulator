package wromaciej.hvac_sim.solver.externals;

import wromaciej.hvac_sim.solver.result.SolverResult;
import wromaciej.hvac_sim.solver.result.SolverResultType;
import wromaciej.hvac_sim.thermo.generals.bonds.BondDirection;
import wromaciej.hvac_sim.thermo.generals.bonds.Channel;
import wromaciej.hvac_sim.thermo.generals.bonds.Junction;
import wromaciej.hvac_sim.thermo.generals.bonds.ParameterWithDirection;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.ParameterType;
import wromaciej.hvac_sim.thermo.quantities.specific.Pressure;
import wromaciej.hvac_sim.thermo.streams.model.MatterStream;

import javax.measure.unit.SI;
import java.util.ArrayList;
import java.util.List;

public class ChannelSolver implements ExternalSolver<Channel<? extends MatterStream>> {

    private JunctionSolver junctionSolver;

    public ChannelSolver(JunctionSolver junctionSolver) {
        this.junctionSolver = junctionSolver;
    }

    public Junction channelToMassFlowJunction(Channel toSolve) {
        List<ParameterWithDirection> parametersWithDirections = new ArrayList<>();
        parametersWithDirections.add(new ParameterWithDirection(toSolve.getInletStream().getMassFlow(), BondDirection.INLET));
        parametersWithDirections.add(new ParameterWithDirection(toSolve.getOutletStream().getMassFlow(), BondDirection.OUTLET));
        parametersWithDirections.add(toSolve.getExtraMassFlow());
        return new Junction(parametersWithDirections, junctionSolver);
    }

    public Junction channelToPressureJunction(Channel toSolve) {
        List<ParameterWithDirection> parametersWithDirections = new ArrayList<>();
        Parameter<Pressure> inletPressureDefinition = new Parameter(ParameterType.PRESSURE, SI.PASCAL);
        Parameter<Pressure> outletPressureDefinition = new Parameter(ParameterType.PRESSURE, SI.PASCAL);;
        if (toSolve.getInletStream().getSpecificParameters().getAbsolutePressure().isDefined()) {
            inletPressureDefinition = toSolve.getInletStream().getSpecificParameters().getAbsolutePressure();
            System.out.println(1);
        } else {
            System.out.println(2);
            toSolve.getInletStream().getSpecificParameters().getMatterDefinition().addParameter(inletPressureDefinition);
        }
        if (toSolve.getOutletStream().getSpecificParameters().getAbsolutePressure().isDefined()) {
            System.out.println(3);
            outletPressureDefinition = toSolve.getOutletStream().getSpecificParameters().getAbsolutePressure();
        } else {
            System.out.println(4);
            toSolve.getOutletStream().getSpecificParameters().getMatterDefinition().addParameter(outletPressureDefinition);
        }
        parametersWithDirections.add(new ParameterWithDirection(inletPressureDefinition, BondDirection.INLET));
        parametersWithDirections.add(new ParameterWithDirection(outletPressureDefinition, BondDirection.OUTLET));
        parametersWithDirections.add(new ParameterWithDirection(toSolve.getPressureDrop(), BondDirection.OUTLET));
        return new Junction(parametersWithDirections, junctionSolver);
    }


    public SolverResult solveMassFlows(Channel channelToSolve) {
        return junctionSolver.solve(channelToMassFlowJunction(channelToSolve));
    }

    public SolverResult solvePressures(Channel channelToSolve) {
        return junctionSolver.solve(channelToPressureJunction(channelToSolve));
    }


    @Override
    public SolverResult solve(Channel<? extends MatterStream> channelToSolve) {
        SolverResultType solverResultType;
        SolverResult massFlowSolverResult = solveMassFlows(channelToSolve);
        SolverResult pressuresSolverResult = solvePressures(channelToSolve);

        if ((massFlowSolverResult.getResultType() == SolverResultType.SOLVED) && (pressuresSolverResult.getResultType() == SolverResultType.SOLVED))
            solverResultType = SolverResultType.SOLVED;
        else solverResultType = SolverResultType.NOT_SOLVED_NODATA;
        return new SolverResult(massFlowSolverResult.getMessage() + pressuresSolverResult.getMessage(), solverResultType);
    }
}
