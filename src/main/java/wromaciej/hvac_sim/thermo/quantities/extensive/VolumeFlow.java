package wromaciej.hvac_sim.thermo.quantities.extensive;

import wromaciej.hvac_sim.thermo.quantities.base.MatterFlow;

import javax.measure.unit.ProductUnit;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

public interface VolumeFlow extends MatterFlow {
    Unit<VolumeFlow> UNIT = new ProductUnit<>(SI.CUBIC_METRE.divide(SI.SECOND));
}
