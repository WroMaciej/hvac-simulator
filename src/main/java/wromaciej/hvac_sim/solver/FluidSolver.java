package wromaciej.hvac_sim.solver;

import wromaciej.hvac_sim.thermo.matter.fluids.model.Fluid;
import wromaciej.hvac_sim.thermo.matter.fluids.model.FluidFactory;
import wromaciej.hvac_sim.thermo.matter.fluids.model.FluidType;

public class FluidSolver {

    private char NEEDED_GENERAL_FLUID_PARAMETERS = 2;
    private char NEEDED_AIR_PARAMETERS = 3;

    private final FluidDefinition fluidDefinition;
    private final FluidFactory fluidFactory;

    public FluidSolver(FluidDefinition fluidDefinition, FluidFactory fluidFactory) {
        this.fluidDefinition = fluidDefinition;
        this.fluidFactory = fluidFactory;
    }

    public SolverResult solve(Fluid fluid) {
        FluidDefinition innerFluidDefinition = fluidDefinition;
        if ((innerFluidDefinition.getFluidType() != FluidType.AIR) && (innerFluidDefinition.getFluidName() == null))
            return SolverResult.NOT_SOLVED_NODATA;
        else{
            int numberOfUniqueParameters = innerFluidDefinition.numberOfUniqueParameters();

            if (innerFluidDefinition.getFluidType() == FluidType.AIR){
                if ((numberOfUniqueParameters > NEEDED_AIR_PARAMETERS) || (!innerFluidDefinition.hasOnlyUniqueParameters()))
                    return SolverResult.NOT_SOLVED_TOO_MUCH_DATA;
                else if (numberOfUniqueParameters < NEEDED_AIR_PARAMETERS)
                    return SolverResult.NOT_SOLVED_NODATA;
                else
                    fluid = fluidFactory.createAir(
                            innerFluidDefinition.getDefinedParameters().get(0),
                            innerFluidDefinition.getDefinedParameters().get(1),
                            innerFluidDefinition.getDefinedParameters().get(2));
            }
            else if (innerFluidDefinition.getFluidType() != FluidType.AIR){
                if ((numberOfUniqueParameters > NEEDED_GENERAL_FLUID_PARAMETERS) || (!innerFluidDefinition.hasOnlyUniqueParameters()))
                    return SolverResult.NOT_SOLVED_TOO_MUCH_DATA;
                else if (numberOfUniqueParameters < NEEDED_GENERAL_FLUID_PARAMETERS)
                    return SolverResult.NOT_SOLVED_NODATA;
                else
                    fluid = fluidFactory.createFluid(
                            innerFluidDefinition.getFluidName(),
                            innerFluidDefinition.getDefinedParameters().get(0),
                            innerFluidDefinition.getDefinedParameters().get(1));
            }
        }
        return SolverResult.SOLVED;
    }
}
