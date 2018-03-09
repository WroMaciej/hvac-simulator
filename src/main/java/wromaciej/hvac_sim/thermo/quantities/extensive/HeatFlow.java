package wromaciej.hvac_sim.thermo.quantities.extensive;

import wromaciej.hvac_sim.thermo.quantities.base.EnergyFlow;
import wromaciej.hvac_sim.thermo.quantities.specific.AirPressureDifference;

import javax.measure.unit.ProductUnit;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

public interface HeatFlow extends EnergyFlow {
    public final static Unit<HeatFlow> UNIT =
            new ProductUnit<HeatFlow>(SI.WATT);
}
