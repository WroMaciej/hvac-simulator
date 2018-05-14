package wromaciej.hvac_sim.solver.externals;

import wromaciej.hvac_sim.solver.result.SolverResult;
import wromaciej.hvac_sim.solver.result.SolverResultType;
import wromaciej.hvac_sim.thermo.generals.bonds.BondDirection;
import wromaciej.hvac_sim.thermo.generals.conservationLaw.Channel;
import wromaciej.hvac_sim.thermo.generals.conservationLaw.Junction;
import wromaciej.hvac_sim.thermo.generals.conservationLaw.ParameterWithDirection;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.ParameterType;
import wromaciej.hvac_sim.thermo.quantities.specific.Pressure;
import wromaciej.hvac_sim.thermo.quantities.specific.SpecificEnthalpy;
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
        } else {
            toSolve.getInletStream().getSpecificParameters().getMatterDefinition().addParameter(inletPressureDefinition);
        }
        if (toSolve.getOutletStream().getSpecificParameters().getAbsolutePressure().isDefined()) {
            outletPressureDefinition = toSolve.getOutletStream().getSpecificParameters().getAbsolutePressure();
        } else {
            toSolve.getOutletStream().getSpecificParameters().getMatterDefinition().addParameter(outletPressureDefinition);
        }
        parametersWithDirections.add(new ParameterWithDirection(inletPressureDefinition, BondDirection.INLET));
        parametersWithDirections.add(new ParameterWithDirection(outletPressureDefinition, BondDirection.OUTLET));
        parametersWithDirections.add(new ParameterWithDirection(toSolve.getPressureDrop(), BondDirection.OUTLET));
        return new Junction(parametersWithDirections, junctionSolver);
    }

    public Junction channelToEnergyJunction(Channel toSolve) {
        List<ParameterWithDirection> parametersWithDirections = new ArrayList<>();
        Parameter<SpecificEnthalpy> specificEnthalpyDifference = new Parameter(SI.JOULE.divide(SI.KILOGRAM));
        Parameter<SpecificEnthalpy> inletEnthalpyDefinition = new Parameter(ParameterType.SPECIFIC_ENTHALPY, SI.JOULE.divide(SI.KILOGRAM));
        Parameter<SpecificEnthalpy> outletEnthalpyDefinition = new Parameter(ParameterType.SPECIFIC_ENTHALPY, SI.JOULE.divide(SI.KILOGRAM));
        if (toSolve.getInletStream().getSpecificParameters().getSpecificEnthalpy().isDefined()) {
            inletEnthalpyDefinition = toSolve.getInletStream().getSpecificParameters().getSpecificEnthalpy();
            System.out.println(1);
        } else {
            toSolve.getInletStream().getSpecificParameters().getMatterDefinition().addParameter(inletEnthalpyDefinition);
            System.out.println(2);
        }
        if (toSolve.getOutletStream().getSpecificParameters().getSpecificEnthalpy().isDefined()) {
            outletEnthalpyDefinition = toSolve.getOutletStream().getSpecificParameters().getSpecificEnthalpy();
            System.out.println(3);
        } else {
            toSolve.getOutletStream().getSpecificParameters().getMatterDefinition().addParameter(outletEnthalpyDefinition);
            System.out.println(4);
        }

        if (toSolve.getHeatFlow().getParameter().isDefined()) {
            toSolve.calculateSpecificEnthalpyDifferenceFromHeatFlow();
            System.out.println(5);
        } else {
            System.out.println(6);
        }
        specificEnthalpyDifference = toSolve.getSpecificEnthalpyDifference();

        System.out.println(inletEnthalpyDefinition);
        System.out.println(outletEnthalpyDefinition);

        parametersWithDirections.add(new ParameterWithDirection(inletEnthalpyDefinition, BondDirection.INLET));
        parametersWithDirections.add(new ParameterWithDirection(outletEnthalpyDefinition, BondDirection.OUTLET));
        parametersWithDirections.add(new ParameterWithDirection(specificEnthalpyDifference, toSolve.getHeatFlow().getDirection()));
        return new Junction(parametersWithDirections, junctionSolver);

    }


    public SolverResult solveMassFlows(Channel channelToSolve) {
        return junctionSolver.solve(channelToMassFlowJunction(channelToSolve));
    }

    public SolverResult solvePressures(Channel channelToSolve) {
        return junctionSolver.solve(channelToPressureJunction(channelToSolve));
    }

    public SolverResult solveEnergy(Channel channelToSolve) {
        SolverResult energySolverResult = junctionSolver.solve(channelToEnergyJunction(channelToSolve));
        System.out.println("specific just after solver: " + channelToSolve.getSpecificEnthalpyDifference());
        channelToSolve.calculateHeatFlowFromSpecificEnthalpyDifference();
        return energySolverResult;
    }


    @Override
    public SolverResult solve(Channel<? extends MatterStream> channelToSolve) {
        SolverResultType solverResultType;
        SolverResult massFlowSolverResult = solveMassFlows(channelToSolve);
        SolverResult pressuresSolverResult = solvePressures(channelToSolve);
        SolverResult energySolverResult = solveEnergy(channelToSolve);

        if ((massFlowSolverResult.getResultType() == SolverResultType.SOLVED)
                && (pressuresSolverResult.getResultType() == SolverResultType.SOLVED)
                && (energySolverResult.getResultType() == SolverResultType.SOLVED))
            solverResultType = SolverResultType.SOLVED;
        else solverResultType = SolverResultType.NOT_SOLVED_NODATA;
        return new SolverResult(
                massFlowSolverResult.getMessage()
                        + pressuresSolverResult.getMessage()
                        + energySolverResult.getMessage(),
                solverResultType);
    }
}
