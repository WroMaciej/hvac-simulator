package wromaciej.hvac_sim.thermo.matter.fluids.customQuantities;

import wromaciej.hvac_sim.thermo.matter.fluids.Fluid;

import javax.measure.quantity.Quantity;
import javax.measure.unit.ProductUnit;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

public interface Temperature extends FluidQuantity {

    public final static Unit<SpecificEnthalpy> UNIT =
            new ProductUnit<SpecificEnthalpy>(SI.KELVIN);
}
