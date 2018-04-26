package wromaciej.hvac_sim.solver.fluidSolvers;

import wromaciej.hvac_sim.solver.result.SolverResultType;
import wromaciej.hvac_sim.thermo.matter.fluids.model.Fluid;
import wromaciej.hvac_sim.thermo.matter.fluids.model.FluidFactory;
import wromaciej.hvac_sim.thermo.matter.fluids.model.FluidType;

public class FluidSolver {

    private char NEEDED_GENERAL_FLUID_PARAMETERS = 2;
    private char NEEDED_AIR_PARAMETERS = 3;

    private final FluidDefinition fluidDefinition;
    private final FluidFactory fluidFactory;

    private SolverResultType solverResultType;

    public SolverResultType getSolverResultType() {
        return solverResultType;
    }

    public FluidSolver(FluidDefinition fluidDefinition, FluidFactory fluidFactory) {
        this.solverResultType = SolverResultType.NOT_SOLVED_NODATA;
        this.fluidDefinition = fluidDefinition;
        this.fluidFactory = fluidFactory;
    }

    public Fluid solve() {
        Fluid fluid = null;
        //FluidDefinition fluidDefinition;
        if ((fluidDefinition.getFluidType() != FluidType.AIR) && (fluidDefinition.getFluidName() == null))
            solverResultType = SolverResultType.NOT_SOLVED_NODATA;
        else{
            int numberOfUniqueParameters = fluidDefinition.numberOfUniqueParameters();

            if (fluidDefinition.getFluidType() == FluidType.AIR){
                if ((numberOfUniqueParameters > NEEDED_AIR_PARAMETERS) || (!fluidDefinition.hasOnlyUniqueParameters()))
                    solverResultType =  SolverResultType.NOT_SOLVED_TOO_MUCH_DATA;
                else if (numberOfUniqueParameters < NEEDED_AIR_PARAMETERS)
                    solverResultType =  SolverResultType.NOT_SOLVED_NODATA;
                else{
                    fluid = fluidFactory.createAir(
                            fluidDefinition.getDefinedParameters().get(0),
                            fluidDefinition.getDefinedParameters().get(1),
                            fluidDefinition.getDefinedParameters().get(2));
                    solverResultType =  SolverResultType.SOLVED;
                }

            }
            else if (fluidDefinition.getFluidType() != FluidType.AIR){
                if ((numberOfUniqueParameters > NEEDED_GENERAL_FLUID_PARAMETERS) || (!fluidDefinition.hasOnlyUniqueParameters()))
                    solverResultType =  SolverResultType.NOT_SOLVED_TOO_MUCH_DATA;
                else if (numberOfUniqueParameters < NEEDED_GENERAL_FLUID_PARAMETERS)
                    solverResultType =  SolverResultType.NOT_SOLVED_NODATA;
                else{
                    fluid = fluidFactory.createFluid(
                            fluidDefinition.getFluidName(),
                            fluidDefinition.getDefinedParameters().get(0),
                            fluidDefinition.getDefinedParameters().get(1));
                    solverResultType =  SolverResultType.SOLVED;
                }

            }
        }
        return fluid;
    }


}
