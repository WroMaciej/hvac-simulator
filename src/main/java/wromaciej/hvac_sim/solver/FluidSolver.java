package wromaciej.hvac_sim.solver;

import wromaciej.hvac_sim.thermo.matter.fluids.model.Fluid;
import wromaciej.hvac_sim.thermo.matter.fluids.model.FluidFactory;
import wromaciej.hvac_sim.thermo.matter.fluids.model.FluidType;

public class FluidSolver {

    private char NEEDED_GENERAL_FLUID_PARAMETERS = 2;
    private char NEEDED_AIR_PARAMETERS = 3;

    private final FluidDefinition fluidDefinition;
    private final FluidFactory fluidFactory;

    private SolverResult solverResult;

    public SolverResult getSolverResult() {
        return solverResult;
    }

    public FluidSolver(FluidDefinition fluidDefinition, FluidFactory fluidFactory) {
        this.solverResult = SolverResult.NOT_SOLVED_NODATA;
        this.fluidDefinition = fluidDefinition;
        this.fluidFactory = fluidFactory;
    }

    public Fluid solve() {
        Fluid fluid = null;
        FluidDefinition innerFluidDefinition = fluidDefinition;
        if ((innerFluidDefinition.getFluidType() != FluidType.AIR) && (innerFluidDefinition.getFluidName() == null))
            solverResult = SolverResult.NOT_SOLVED_NODATA;
        else{
            int numberOfUniqueParameters = innerFluidDefinition.numberOfUniqueParameters();

            if (innerFluidDefinition.getFluidType() == FluidType.AIR){
                if ((numberOfUniqueParameters > NEEDED_AIR_PARAMETERS) || (!innerFluidDefinition.hasOnlyUniqueParameters()))
                    solverResult =  SolverResult.NOT_SOLVED_TOO_MUCH_DATA;
                else if (numberOfUniqueParameters < NEEDED_AIR_PARAMETERS)
                    solverResult =  SolverResult.NOT_SOLVED_NODATA;
                else{
                    fluid = fluidFactory.createAir(
                            innerFluidDefinition.getDefinedParameters().get(0),
                            innerFluidDefinition.getDefinedParameters().get(1),
                            innerFluidDefinition.getDefinedParameters().get(2));
                    solverResult =  SolverResult.SOLVED;
                }

            }
            else if (innerFluidDefinition.getFluidType() != FluidType.AIR){
                if ((numberOfUniqueParameters > NEEDED_GENERAL_FLUID_PARAMETERS) || (!innerFluidDefinition.hasOnlyUniqueParameters()))
                    solverResult =  SolverResult.NOT_SOLVED_TOO_MUCH_DATA;
                else if (numberOfUniqueParameters < NEEDED_GENERAL_FLUID_PARAMETERS)
                    solverResult =  SolverResult.NOT_SOLVED_NODATA;
                else{
                    fluid = fluidFactory.createFluid(
                            innerFluidDefinition.getFluidName(),
                            innerFluidDefinition.getDefinedParameters().get(0),
                            innerFluidDefinition.getDefinedParameters().get(1));
                    solverResult =  SolverResult.SOLVED;
                }

            }
        }
        return fluid;
    }
}
