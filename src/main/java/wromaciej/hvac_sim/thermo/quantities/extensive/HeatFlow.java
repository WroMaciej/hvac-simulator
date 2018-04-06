package wromaciej.hvac_sim.thermo.quantities.extensive;

import wromaciej.hvac_sim.thermo.quantities.base.EnergyFlow;

import javax.measure.unit.ProductUnit;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

public interface HeatFlow extends EnergyFlow {
    Unit<HeatFlow> UNIT = new ProductUnit(SI.JOULE.divide(SI.SECOND));
}
