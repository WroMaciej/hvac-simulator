package wromaciej.hvac_sim.thermo.matter.fluids.customQuantities;

import javax.measure.quantity.Quantity;
import javax.measure.unit.ProductUnit;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

public interface SpecificEnthalpy extends Quantity {

    public final static Unit<SpecificEnthalpy> UNIT =
            new ProductUnit<SpecificEnthalpy>(SI.JOULE.divide(SI.KELVIN));
}
