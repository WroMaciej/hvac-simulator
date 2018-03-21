package wromaciej.hvac_sim.thermo.matter.fluids.parameters;

import wromaciej.hvac_sim.thermo.quantities.base.AirQuantity;

import javax.measure.unit.ProductUnit;
import javax.measure.unit.Unit;

public class AirParameter<Q extends AirQuantity> extends Parameter {

    public AirParameter(ProductUnit unitInUnitSystem) {
        super(unitInUnitSystem);
    }
}
