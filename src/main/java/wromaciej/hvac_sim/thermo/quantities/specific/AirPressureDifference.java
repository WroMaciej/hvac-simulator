package wromaciej.hvac_sim.thermo.quantities.specific;

import wromaciej.hvac_sim.thermo.quantities.base.AirQuantity;

import javax.measure.unit.ProductUnit;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

public interface AirPressureDifference extends AirQuantity {

    public final static Unit<AirPressureDifference> UNIT =
            new ProductUnit<AirPressureDifference>(SI.PASCAL);
}

