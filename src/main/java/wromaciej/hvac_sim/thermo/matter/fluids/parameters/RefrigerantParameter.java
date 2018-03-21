package wromaciej.hvac_sim.thermo.matter.fluids.parameters;

import wromaciej.hvac_sim.thermo.quantities.base.RefrigerantQuantity;

import javax.measure.unit.ProductUnit;
import javax.measure.unit.Unit;

public class RefrigerantParameter <Q extends RefrigerantQuantity> extends Parameter {
    public RefrigerantParameter(ProductUnit unitInUnitSystem) {
        super(unitInUnitSystem);
    }

    public RefrigerantParameter(ProductUnit unitInUnitSystem, double value) {
        super(unitInUnitSystem, value);
    }
}
