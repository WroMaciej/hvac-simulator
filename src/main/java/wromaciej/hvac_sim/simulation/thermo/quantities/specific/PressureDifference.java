package wromaciej.hvac_sim.simulation.thermo.quantities.specific;

import wromaciej.hvac_sim.simulation.thermo.quantities.base.AirQuantity;
import wromaciej.hvac_sim.simulation.thermo.quantities.base.FluidQuantity;

import javax.measure.unit.ProductUnit;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

public interface PressureDifference extends FluidQuantity, AirQuantity {

    Unit<PressureDifference> UNIT = (Unit) SI.PASCAL;
}
