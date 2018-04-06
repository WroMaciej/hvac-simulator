package wromaciej.hvac_sim.thermo.quantities.extensive;

import wromaciej.hvac_sim.thermo.quantities.base.MatterFlow;

import javax.measure.unit.ProductUnit;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

public interface MassFlow extends MatterFlow {
    Unit<MassFlow> UNIT = new ProductUnit<>(SI.KILOGRAM.divide(SI.SECOND));
}
