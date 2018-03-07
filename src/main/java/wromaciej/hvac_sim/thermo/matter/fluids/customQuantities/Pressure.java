package wromaciej.hvac_sim.thermo.matter.fluids.customQuantities;

import javax.measure.unit.ProductUnit;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

public interface Pressure extends FluidQuantity {

    public final static Unit<Pressure> UNIT =
            new ProductUnit<Pressure>(SI.PASCAL);
}
