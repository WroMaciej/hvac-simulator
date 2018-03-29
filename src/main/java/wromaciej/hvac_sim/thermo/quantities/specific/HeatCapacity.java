package wromaciej.hvac_sim.thermo.quantities.specific;

import wromaciej.hvac_sim.thermo.quantities.base.AirQuantity;
import wromaciej.hvac_sim.thermo.quantities.base.FluidQuantity;
import wromaciej.hvac_sim.thermo.quantities.base.SolidQuantity;

import javax.measure.unit.ProductUnit;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

public interface HeatCapacity extends FluidQuantity, SolidQuantity, AirQuantity {

    public final static Unit<HeatCapacity> UNIT =
            new ProductUnit<HeatCapacity>(SI.JOULE.divide(SI.KILOGRAM.times(SI.KELVIN)));
}
