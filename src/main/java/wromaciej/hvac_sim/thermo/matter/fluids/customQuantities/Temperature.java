package wromaciej.hvac_sim.thermo.matter.fluids.customQuantities;

import javax.measure.unit.ProductUnit;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

public interface Temperature extends FluidQuantity {

    public final static Unit<Temperature> UNIT =
            new ProductUnit<Temperature>(SI.KELVIN);
}