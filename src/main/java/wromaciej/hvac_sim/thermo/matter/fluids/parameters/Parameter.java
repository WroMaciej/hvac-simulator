package wromaciej.hvac_sim.thermo.matter.fluids.parameters;



import org.jscience.physics.amount.Amount;
import wromaciej.hvac_sim.thermo.quantities.base.FluidQuantity;
import wromaciej.hvac_sim.thermo.quantities.specific.SpecificEnthalpy;
import wromaciej.hvac_sim.thermo.quantities.specific.SpecificVolume;
import wromaciej.hvac_sim.thermo.unitSystems.UnitSystem;

import javax.measure.Measurable;
import javax.measure.Measure;
import javax.measure.quantity.Quantity;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;


public class Parameter <Q extends Quantity>{



    private Amount<Q> amount;

    private Unit<Q> unit;

    public Double getValue(){
        return amount.doubleValue(unit);
    }

    public void setValue(double value){
        amount=Amount.valueOf(value, unit);
    }

    public Amount<Q> getAmount() {
        return amount;
    }

    public void setAmount(Amount<Q> amount) {
        this.amount = amount;
    }



    public Parameter() {
        UnitSystem unitSystem=new UnitSystem();
        unit=unitSystem.getUnitOfQuantity(Q);
        amount=Amount.valueOf(20,unit);
    }

    public Unit<Q> getUnit() {
        return unit;
    }

    public void setUnit(Unit<Q> unit) {
        this.unit = unit;
    }
}
