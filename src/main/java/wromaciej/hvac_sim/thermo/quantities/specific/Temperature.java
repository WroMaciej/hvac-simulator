package wromaciej.hvac_sim.thermo.quantities.specific;

import wromaciej.hvac_sim.thermo.quantities.base.FluidQuantity;

import javax.measure.unit.ProductUnit;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

public interface Temperature extends FluidQuantity {

    public final static Unit<Temperature> UNIT =
            new ProductUnit<Temperature>(SI.KELVIN);
}
