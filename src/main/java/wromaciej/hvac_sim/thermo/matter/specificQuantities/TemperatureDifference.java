package wromaciej.hvac_sim.thermo.matter.specificQuantities;

import wromaciej.hvac_sim.thermo.matter.specificQuantities.base.FluidQuantity;

import javax.measure.unit.ProductUnit;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

public interface TemperatureDifference extends FluidQuantity {

    public final static Unit<TemperatureDifference> UNIT =
            new ProductUnit<TemperatureDifference>(SI.KELVIN);
}

