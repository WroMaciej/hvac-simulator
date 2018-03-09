package wromaciej.hvac_sim.thermo.quantities.specific;

import wromaciej.hvac_sim.thermo.quantities.base.FluidQuantity;
import wromaciej.hvac_sim.thermo.quantities.base.SolidQuantity;

import javax.measure.unit.ProductUnit;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

public interface SpecificVolume extends FluidQuantity, SolidQuantity {

    public final static Unit<SpecificVolume> UNIT =
            new ProductUnit<SpecificVolume>(SI.CUBIC_METRE.divide(SI.KILOGRAM));
}

