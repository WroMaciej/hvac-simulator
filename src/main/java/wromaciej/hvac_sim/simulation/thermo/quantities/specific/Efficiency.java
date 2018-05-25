package wromaciej.hvac_sim.simulation.thermo.quantities.specific;

import wromaciej.hvac_sim.simulation.thermo.quantities.base.AirQuantity;
import wromaciej.hvac_sim.simulation.thermo.quantities.base.AnyQuantity;

import javax.measure.quantity.Dimensionless;
import javax.measure.unit.ProductUnit;
import javax.measure.unit.Unit;

public interface Efficiency extends AnyQuantity {

    Unit<Efficiency> UNIT = new ProductUnit<>(Dimensionless.UNIT);

}
