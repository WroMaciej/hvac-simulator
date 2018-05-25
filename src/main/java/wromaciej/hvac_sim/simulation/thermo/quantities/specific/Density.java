package wromaciej.hvac_sim.simulation.thermo.quantities.specific;

import wromaciej.hvac_sim.simulation.thermo.quantities.base.AirQuantity;
import wromaciej.hvac_sim.simulation.thermo.quantities.base.FluidQuantity;
import wromaciej.hvac_sim.simulation.thermo.quantities.base.SolidQuantity;

import javax.measure.unit.ProductUnit;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

public interface Density extends FluidQuantity, SolidQuantity, AirQuantity {

    Unit<Density> UNIT = new ProductUnit<>(SI.KILOGRAM.divide(SI.CUBIC_METRE));
}

