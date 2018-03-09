package wromaciej.hvac_sim.thermo.quantities.extensive;

import wromaciej.hvac_sim.thermo.quantities.base.MatterFlow;

import javax.measure.unit.ProductUnit;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

public interface MassFlow extends MatterFlow {
    public final static Unit<MassFlow> UNIT =
            new ProductUnit<MassFlow>(SI.KILOGRAM.divide(SI.SECOND));
}
