package wromaciej.hvac_sim.simulation.solver.matterSolvers;

import wromaciej.hvac_sim.thermo.matter.fluids.model.*;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;

public class FluidDefinition extends MatterDefinition {
    public FluidDefinition() {
        super();
    }

    public FluidDefinition(FluidName fluidName, MatterType fluidType, Parameter... parameters) {
        super(fluidName, fluidType, parameters);
    }



}
