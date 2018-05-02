package wromaciej.hvac_sim.solver.externals;

import wromaciej.hvac_sim.solver.result.SolverResult;
import wromaciej.hvac_sim.solver.result.SolverResultType;
import wromaciej.hvac_sim.thermo.generals.bonds.BondDirection;
import wromaciej.hvac_sim.thermo.generals.bonds.Channel;
import wromaciej.hvac_sim.thermo.generals.bonds.Junction;
import wromaciej.hvac_sim.thermo.generals.bonds.ParameterWithDirection;
import wromaciej.hvac_sim.thermo.streams.model.MatterStream;

import java.util.ArrayList;
import java.util.List;

public class ChannelSolver implements ExternalSolver<Channel<? extends MatterStream>> {

    JunctionSolver junctionSolver;

    public ChannelSolver(JunctionSolver junctionSolver) {
        this.junctionSolver = junctionSolver;
    }

    private Junction channelToMassFlowJunction(Channel toSolve){
        List<ParameterWithDirection> parametersWithDirections = new ArrayList<>();
        parametersWithDirections.add(new ParameterWithDirection(toSolve.getInletStream().getMassFlow(), BondDirection.INLET));
        parametersWithDirections.add(new ParameterWithDirection(toSolve.getOutletStream().getMassFlow(), BondDirection.OUTLET));
        parametersWithDirections.add(toSolve.getExtraMassFlow());
        return new Junction(parametersWithDirections, junctionSolver);
    }

    private Junction channelToPressureJunction(Channel toSolve){
        List<ParameterWithDirection> parametersWithDirections = new ArrayList<>();
        parametersWithDirections.add(new ParameterWithDirection(toSolve.getInletStream().getSpecificParameters().getAbsolutePressure(), BondDirection.INLET));
        parametersWithDirections.add(new ParameterWithDirection(toSolve.getOutletStream().getSpecificParameters().getAbsolutePressure(), BondDirection.OUTLET));
        parametersWithDirections.add(new ParameterWithDirection(toSolve.getPressureDrop(), BondDirection.OUTLET));
        return new Junction(parametersWithDirections, junctionSolver);
    }


    private SolverResult solveMassFlows(Channel channelToSolve){
        return junctionSolver.solve(channelToMassFlowJunction(channelToSolve));
    }

    private SolverResult solvePressures(Channel channelToSolve){
        return junctionSolver.solve(channelToPressureJunction(channelToSolve));
    }



    @Override
    public SolverResult solve(Channel<? extends MatterStream> channelToSolve) {
        SolverResultType solverResultType;
        SolverResult massFlowSolverResult = solveMassFlows(channelToSolve);
        SolverResult pressuresSolverResult = solvePressures(channelToSolve);

        if (massFlowSolverResult.getResultType() == SolverResultType.SOLVED) solverResultType = SolverResultType.SOLVED;
        else solverResultType = SolverResultType.NOT_SOLVED_NODATA;
        return new SolverResult(massFlowSolverResult.getMessage()+pressuresSolverResult.getMessage(), solverResultType);
    }
}
