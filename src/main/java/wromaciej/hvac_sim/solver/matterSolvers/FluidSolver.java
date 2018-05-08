package wromaciej.hvac_sim.solver.matterSolvers;

import wromaciej.hvac_sim.solver.externals.ExternalSolver;
import wromaciej.hvac_sim.solver.result.SolverResult;
import wromaciej.hvac_sim.solver.result.SolverResultType;
import wromaciej.hvac_sim.thermo.matter.fluids.model.*;

public class FluidSolver extends MatterSolver implements ExternalSolver<Fluid> {

    private char NEEDED_GENERAL_FLUID_PARAMETERS = 2;
    private char NEEDED_AIR_PARAMETERS = 3;

    //private final FluidDefinition matterDefinition;
    private final FluidSetter fluidSetter;

    //private SolverResultType solverResultType;

//    public SolverResultType getSolverResultType() {
//        return solverResultType;
//    }
//
//    public FluidSolver(FluidDefinition matterDefinition, FluidSetter fluidSetter) {
//        this.solverResultType = SolverResultType.NOT_SOLVED_NODATA;
//        this.matterDefinition = matterDefinition;
//        this.fluidSetter = fluidSetter;
//    }

    public FluidSolver(FluidSetter fluidSetter) {
        this.fluidSetter = fluidSetter;
    }



    @Override
    public SolverResult solve(Fluid fluidToSolve) {
        SolverResultType solverResultType=SolverResultType.NOT_SOLVED_NODATA;
        String message = "No message";

        if ((fluidToSolve.matterDefinition.getFluidType() != MatterType.AIR) && (fluidToSolve.matterDefinition.getFluidName() == null))
            solverResultType = SolverResultType.NOT_SOLVED_NODATA;
        else{
            int numberOfUniqueParameters = fluidToSolve.matterDefinition.numberOfUniqueParameters();

            if (fluidToSolve.matterDefinition.getFluidType() == MatterType.AIR){
                if ((numberOfUniqueParameters > NEEDED_AIR_PARAMETERS) || (!fluidToSolve.matterDefinition.hasOnlyUniqueParameters()))
                    solverResultType =  SolverResultType.NOT_SOLVED_TOO_MUCH_DATA;
                else if (numberOfUniqueParameters < NEEDED_AIR_PARAMETERS)
                    solverResultType =  SolverResultType.NOT_SOLVED_NODATA;
                else{
                    fluidSetter.changeAirState(
                            (Air) fluidToSolve,
                            fluidToSolve.matterDefinition.getDefinedParameters().get(0),
                            fluidToSolve.matterDefinition.getDefinedParameters().get(1),
                            fluidToSolve.matterDefinition.getDefinedParameters().get(2));
                    solverResultType =  SolverResultType.SOLVED;
                }

            }
            else if (fluidToSolve.matterDefinition.getFluidType() != MatterType.AIR){
                if ((numberOfUniqueParameters > NEEDED_GENERAL_FLUID_PARAMETERS) || (!fluidToSolve.matterDefinition.hasOnlyUniqueParameters()))
                    solverResultType =  SolverResultType.NOT_SOLVED_TOO_MUCH_DATA;
                else if (numberOfUniqueParameters < NEEDED_GENERAL_FLUID_PARAMETERS)
                    solverResultType =  SolverResultType.NOT_SOLVED_NODATA;
                else{
                    fluidSetter.changeFluidState (
                            fluidToSolve,
                            fluidToSolve.matterDefinition.getFluidName(),
                            fluidToSolve.matterDefinition.getDefinedParameters().get(0),
                            fluidToSolve.matterDefinition.getDefinedParameters().get(1));
                    solverResultType =  SolverResultType.SOLVED;
                }

            }
        }
        return new SolverResult(message, solverResultType);


    }


}
