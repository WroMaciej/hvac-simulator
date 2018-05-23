package wromaciej.hvac_sim.solver.matterSolvers;

import wromaciej.hvac_sim.thermo.matter.fluids.model.*;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.ParameterType;
import wromaciej.hvac_sim.thermo.quantities.base.MatterFlow;

import java.util.ArrayList;
import java.util.List;

public class FluidDefinition extends MatterDefinition {
    public FluidDefinition() {
        super();
    }

    public FluidDefinition(FluidName fluidName, MatterType fluidType, Parameter... parameters) {
        super(fluidName, fluidType, parameters);
    }



}
