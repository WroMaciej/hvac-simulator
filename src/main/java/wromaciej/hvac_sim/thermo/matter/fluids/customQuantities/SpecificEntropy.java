package wromaciej.hvac_sim.thermo.matter.fluids.customQuantities;

import javax.measure.unit.ProductUnit;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

public interface SpecificEntropy extends FluidQuantity {

    public final static Unit<SpecificEntropy> UNIT =
            new ProductUnit<SpecificEntropy>(SI.JOULE.divide(SI.KILOGRAM.divide(SI.KELVIN)));
}
