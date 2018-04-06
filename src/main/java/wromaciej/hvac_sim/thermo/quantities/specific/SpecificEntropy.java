package wromaciej.hvac_sim.thermo.quantities.specific;

import wromaciej.hvac_sim.thermo.quantities.base.AirQuantity;
import wromaciej.hvac_sim.thermo.quantities.base.FluidQuantity;

import javax.measure.unit.ProductUnit;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

public interface SpecificEntropy extends FluidQuantity, AirQuantity {

    Unit<SpecificEntropy> UNIT = new ProductUnit<>(SI.JOULE.divide(SI.KILOGRAM.divide(SI.KELVIN)));
}
