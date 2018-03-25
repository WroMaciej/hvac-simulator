package wromaciej.hvac_sim.thermo.matter.fluids.parameters;

import wromaciej.hvac_sim.thermo.quantities.base.FluidQuantity;

import javax.measure.unit.ProductUnit;
import javax.measure.unit.Unit;

public class FluidParameter<Q extends FluidQuantity> extends Parameter {

    public FluidParameter() {
    }

    public FluidParameter(ParameterType parameterType) {
        super(parameterType);
    }

    public FluidParameter(ParameterType parameterType, Unit unitInUnitSystem) {
        super(parameterType, unitInUnitSystem);
    }

    public FluidParameter(ParameterType parameterType, Unit unitInUnitSystem, double value) {
        super(parameterType, unitInUnitSystem, value);
    }

    public FluidParameter(Unit unitInUnitSystem) {
        super(unitInUnitSystem);
    }

    public FluidParameter(Unit unitInUnitSystem, double value) {
        super(unitInUnitSystem, value);
    }
}
