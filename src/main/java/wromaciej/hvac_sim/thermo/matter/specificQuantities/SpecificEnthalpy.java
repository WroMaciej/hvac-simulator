package wromaciej.hvac_sim.thermo.matter.specificQuantities;

import wromaciej.hvac_sim.thermo.matter.specificQuantities.base.FluidQuantity;

import javax.measure.unit.ProductUnit;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

public interface SpecificEnthalpy extends FluidQuantity {

    public final static Unit<SpecificEnthalpy> UNIT =
            new ProductUnit<SpecificEnthalpy>(SI.JOULE.divide(SI.KILOGRAM));
}
