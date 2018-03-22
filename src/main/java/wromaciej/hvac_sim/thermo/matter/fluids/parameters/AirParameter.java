package wromaciej.hvac_sim.thermo.matter.fluids.parameters;

import wromaciej.hvac_sim.thermo.quantities.base.AirQuantity;

import javax.measure.unit.ProductUnit;
import javax.measure.unit.Unit;

public class AirParameter<Q extends AirQuantity> extends FluidParameter {

    public AirParameter(Unit unitInUnitSystem) {
        super(unitInUnitSystem);
    }

    public AirParameter(Unit unitInUnitSystem, double value) {
        super(unitInUnitSystem, value);
    }

    public AirParameter() {
    }
}
