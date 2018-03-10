package wromaciej.hvac_sim.thermo.matter.fluids.parameters;



import org.jscience.physics.amount.Amount;
import wromaciej.hvac_sim.thermo.quantities.base.FluidQuantity;

import javax.measure.Measurable;
import javax.measure.unit.Unit;

public class FluidParameter<Q extends FluidQuantity>{

    private Amount<Q> amount;

    private Unit<Q> unit;

    public Double getValue(){
        return amount.doubleValue(unit);
    }

    public void set(){
        amount.
    }


}
