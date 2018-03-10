package wromaciej.hvac_sim.thermo.quantities.specific;

import wromaciej.hvac_sim.thermo.quantities.base.SolidQuantity;

import javax.measure.quantity.Dimensionless;
import javax.measure.unit.ProductUnit;
import javax.measure.unit.Unit;

public interface MassHumidity extends SolidQuantity {

    public final static Unit<MoistureContent> UNIT =
            new ProductUnit<MoistureContent>(Dimensionless.UNIT);
}