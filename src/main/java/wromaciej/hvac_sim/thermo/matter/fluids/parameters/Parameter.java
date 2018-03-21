package wromaciej.hvac_sim.thermo.matter.fluids.parameters;


import org.jscience.physics.amount.Amount;
import wromaciej.hvac_sim.thermo.quantities.base.AnyQuantity;

import javax.measure.unit.ProductUnit;
import javax.measure.unit.Unit;


public class Parameter<Q extends AnyQuantity> {

    private Amount<Q> amount;

    private ProductUnit<Q> actualUnit;

    public Double getValue() {
        return amount.doubleValue(actualUnit);
    }

    public void setValue(double value) {
        amount = Amount.valueOf(value, actualUnit);
    }

    public Amount<Q> getAmount() {
        return amount;
    }

    public void setAmount(Amount<Q> amount) {
        this.amount = amount;
    }

    public Parameter(ProductUnit unitInUnitSystem) {
        this.actualUnit = unitInUnitSystem;
    }

    public Parameter(ProductUnit unitInUnitSystem, double value) {
        this.actualUnit = new ProductUnit(unitInUnitSystem) ;
        setValue(value);
    }

    public Unit<Q> getActualUnit() {
        return actualUnit;
    }

    public void setActualUnit(ProductUnit actualUnit) {
        this.actualUnit = actualUnit;
    }
}
