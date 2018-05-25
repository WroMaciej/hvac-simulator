package wromaciej.hvac_sim.simulation.thermo.quantities.extensive;

import wromaciej.hvac_sim.simulation.thermo.quantities.base.EnergyFlow;

import javax.measure.unit.ProductUnit;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

public interface Power extends EnergyFlow {
    Unit<Power> UNIT = (Unit) SI.WATT;
}
