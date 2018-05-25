package wromaciej.hvac_sim.simulation.thermo.quantities.specific;

import wromaciej.hvac_sim.simulation.thermo.quantities.base.AirQuantity;
import wromaciej.hvac_sim.simulation.thermo.quantities.base.FluidQuantity;
import wromaciej.hvac_sim.simulation.thermo.quantities.base.SolidQuantity;

import javax.measure.unit.ProductUnit;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

public interface HeatCapacity extends FluidQuantity, SolidQuantity, AirQuantity {

    Unit<HeatCapacity> UNIT =
            new ProductUnit<>(SI.JOULE.divide(SI.KILOGRAM.times(SI.KELVIN)));
}
