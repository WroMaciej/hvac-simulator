package wromaciej.hvac_sim.simulation.thermo.quantities.specific;

import wromaciej.hvac_sim.simulation.thermo.quantities.base.SolidQuantity;

import javax.measure.quantity.Dimensionless;
import javax.measure.unit.ProductUnit;
import javax.measure.unit.Unit;

public interface MassHumidity extends SolidQuantity {

    Unit<MoistureContent> UNIT = new ProductUnit<>(Dimensionless.UNIT);
}
