package wromaciej.hvac_sim.simulation.solver.matterSolvers;

import wromaciej.hvac_sim.simulation.thermo.matter.fluids.model.*;
import wromaciej.hvac_sim.simulation.thermo.parameters.Parameter;

public class FluidDefinition extends MatterDefinition {
    public FluidDefinition() {
        super();
    }

    public FluidDefinition(FluidName fluidName, MatterType fluidType, Parameter... parameters) {
        super(fluidName, fluidType, parameters);
    }



}
