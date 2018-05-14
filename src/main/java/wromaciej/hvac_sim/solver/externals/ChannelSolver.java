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

import static wromaciej.hvac_sim.solver.result.SolverResultType.SOLVED;

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
        } else {
            toSolve.getInletStream().getSpecificParameters().getMatterDefinition().addParameter(inletEnthalpyDefinition);
        }
        if (toSolve.getOutletStream().getSpecificParameters().getSpecificEnthalpy().isDefined()) {
            outletEnthalpyDefinition = toSolve.getOutletStream().getSpecificParameters().getSpecificEnthalpy();
        } else {
            toSolve.getOutletStream().getSpecificParameters().getMatterDefinition().addParameter(outletEnthalpyDefinition);
        }

        if (toSolve.getHeatFlow().getParameter().isDefined()) {
            toSolve.calculateSpecificEnthalpyDifferenceFromHeatFlow();
        }
        specificEnthalpyDifference = toSolve.getSpecificEnthalpyDifference();

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
        System.out.println("Heat flow dir just after energy solver: " + channelToSolve.getHeatFlow().getDirection());
        channelToSolve.calculateHeatFlowFromSpecificEnthalpyDifference();
        return energySolverResult;
    }


    @Override
    public SolverResult solve(Channel<? extends MatterStream> channelToSolve) {
        SolverResultType solverResultType;
        SolverResult massFlowSolverResult = solveMassFlows(channelToSolve);
        SolverResult pressuresSolverResult = solvePressures(channelToSolve);
        SolverResult energySolverResult = solveEnergy(channelToSolve);

        if ((massFlowSolverResult.getResultType() == SOLVED)
                && (pressuresSolverResult.getResultType() == SOLVED)
                && (energySolverResult.getResultType() == SOLVED))
            solverResultType = SOLVED;
        else solverResultType = SolverResultType.NOT_SOLVED_NODATA;
        return new SolverResult(
                massFlowSolverResult.getMessage()
                        + pressuresSolverResult.getMessage()
                        + energySolverResult.getMessage(),
                solverResultType);
    }
}
