package wromaciej.hvac_sim.thermo.matter.specificQuantities;

import wromaciej.hvac_sim.thermo.matter.specificQuantities.base.AirQuantity;
import wromaciej.hvac_sim.thermo.matter.specificQuantities.base.FluidQuantity;

import javax.measure.quantity.Dimensionless;
import javax.measure.unit.ProductUnit;
import javax.measure.unit.Unit;

public interface RelativeHumidity extends AirQuantity {

    public final static Unit<RelativeHumidity> UNIT =
            new ProductUnit<RelativeHumidity>(Dimensionless.UNIT);
}
