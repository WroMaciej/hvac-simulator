package wromaciej.hvac_sim.thermo.quantities.specific;

import wromaciej.hvac_sim.thermo.quantities.base.FluidQuantity;
import javax.measure.unit.ProductUnit;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

public interface PressureDifference extends FluidQuantity {

    public final static Unit<PressureDifference> UNIT =
            new ProductUnit<PressureDifference>(SI.PASCAL);
}
