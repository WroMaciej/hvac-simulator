package wromaciej.hvac_sim.solver;

import wromaciej.hvac_sim.thermo.matter.fluids.model.Fluid;
import wromaciej.hvac_sim.thermo.matter.fluids.model.FluidFactory;
import wromaciej.hvac_sim.thermo.matter.fluids.model.FluidType;

public class FluidSolver {

    private char NEEDED_GENERAL_FLUID_PARAMETERS = 2;
    private char NEEDED_AIR_PARAMETERS = 3;

    public SolverResult solve(Fluid fluid,  FluidFactory fluidFactory) {
        if ((fluidType != FluidType.AIR) && (fluidName == null))
            return SolverResult.NOT_SOLVED_NODATA;
        else{
            int numberOfUniqueParameters = fluid.fluidDefinition.numberOfUniqueParameters();

            if (fluidType == FluidType.AIR){
                if ((numberOfUniqueParameters > NEEDED_AIR_PARAMETERS) || (!hasOnlyUniqueParameters()))
                    return SolverResult.NOT_SOLVED_TOO_MUCH_DATA;
                else if (numberOfUniqueParameters < NEEDED_AIR_PARAMETERS)
                    return SolverResult.NOT_SOLVED_NODATA;
                else
                    fluid = fluidFactory.createAir(
                            definedParameters.get(0),
                            definedParameters.get(1),
                            definedParameters.get(2));
            }
            else if (fluidType != FluidType.AIR){
                if ((numberOfUniqueParameters > NEEDED_GENERAL_FLUID_PARAMETERS) || (!hasOnlyUniqueParameters()))
                    return SolverResult.NOT_SOLVED_TOO_MUCH_DATA;
                else if (numberOfUniqueParameters < NEEDED_GENERAL_FLUID_PARAMETERS)
                    return SolverResult.NOT_SOLVED_NODATA;
                else
                    fluid = fluidFactory.createFluid(
                            fluidName,
                            definedParameters.get(0),
                            definedParameters.get(1));
            }
        }
        return SolverResult.SOLVED;
    }
}
