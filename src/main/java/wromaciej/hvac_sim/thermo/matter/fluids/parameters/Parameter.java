package wromaciej.hvac_sim.thermo.matter.fluids.parameters;



import org.jscience.physics.amount.Amount;
import wromaciej.hvac_sim.thermo.quantities.base.AnyQuantity;
import wromaciej.hvac_sim.thermo.unitSystems.UnitSystem;

import javax.measure.unit.Unit;


public class Parameter <Q extends AnyQuantity>{

    private Amount<Q> amount;

    private Unit<Q> actualUnit;

    public Double getValue(){
        return amount.doubleValue(actualUnit);
    }

    public void setValue(double value){
        amount=Amount.valueOf(value, actualUnit);
    }

    public Amount<Q> getAmount() {
        return amount;
    }

    public void setAmount(Amount<Q> amount) {
        this.amount = amount;
    }

    public Parameter(Unit unitInUnitSystem) {
        this.actualUnit=unitInUnitSystem;
    }

    public Unit<Q> getActualUnit() {
        return actualUnit;
    }

    public void setActualUnit(Unit<Q> actualUnit) {
        this.actualUnit = actualUnit;
    }
}
