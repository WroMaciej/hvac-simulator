package wromaciej.hvac_sim.thermo.matter.fluids.parameters;

import wromaciej.hvac_sim.thermo.quantities.base.RefrigerantQuantity;

import javax.measure.unit.Unit;

public class RefrigerantParameter <Q extends RefrigerantQuantity> extends Parameter {
    public RefrigerantParameter(Unit unitInUnitSystem) {
        super(unitInUnitSystem);
    }

    public RefrigerantParameter(Unit unitInUnitSystem, double value) {
        super(unitInUnitSystem, value);
    }
}
