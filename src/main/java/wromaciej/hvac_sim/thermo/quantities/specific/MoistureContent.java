package wromaciej.hvac_sim.thermo.quantities.specific;

import wromaciej.hvac_sim.thermo.quantities.base.AirQuantity;
import wromaciej.hvac_sim.thermo.quantities.base.FluidQuantity;

import javax.measure.quantity.Dimensionless;
import javax.measure.unit.ProductUnit;
import javax.measure.unit.Unit;

public interface MoistureContent extends AirQuantity {

    Unit<MoistureContent> UNIT = new ProductUnit<>(Dimensionless.UNIT);
}
