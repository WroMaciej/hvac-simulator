package wromaciej.hvac_sim.thermo.quantities.specific;

import wromaciej.hvac_sim.thermo.quantities.base.FluidQuantity;
import wromaciej.hvac_sim.thermo.quantities.base.SolidQuantity;

import javax.measure.unit.ProductUnit;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

public interface HeatCapacity extends FluidQuantity, SolidQuantity {

    public final static Unit<HeatCapacity> UNIT =
            new ProductUnit<HeatCapacity>(SI.JOULE.divide(SI.KILOGRAM.divide(SI.KELVIN)));
}
