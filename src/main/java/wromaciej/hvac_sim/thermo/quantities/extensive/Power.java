package wromaciej.hvac_sim.thermo.quantities.extensive;

import wromaciej.hvac_sim.thermo.quantities.base.EnergyFlow;

import javax.measure.unit.ProductUnit;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

public interface Power extends EnergyFlow {
    public final static Unit<Power> UNIT = (Unit) SI.WATT;
}
