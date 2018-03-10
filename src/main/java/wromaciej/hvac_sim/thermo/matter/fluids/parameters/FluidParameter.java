package wromaciej.hvac_sim.thermo.matter.fluids.parameters;



import org.jscience.physics.amount.Amount;
import wromaciej.hvac_sim.thermo.quantities.base.FluidQuantity;
import wromaciej.hvac_sim.thermo.quantities.specific.SpecificEnthalpy;
import wromaciej.hvac_sim.thermo.quantities.specific.SpecificVolume;

import javax.measure.Measurable;
import javax.measure.Measure;
import javax.measure.quantity.Quantity;
import javax.measure.unit.Unit;

public class FluidParameter<Q extends FluidQuantity>{

    private Amount<Q> amount;

    private Measure<Double,Q> measure;

    private Unit<Q> unit;

    public Double getValue(){
        return amount.doubleValue(unit);
    }

    public Amount<Q> getAmount() {
        return amount;
    }

    public void setAmount(Amount<Q> amount) {
        this.amount = amount;
    }

    public void setValue(double value){
        amount=Amount.valueOf(value,unit);
    }

    public FluidParameter() {
        unit=Q.
    }
}
