package wromaciej.hvac_sim.thermo.matter.fluids;



import wromaciej.hvac_sim.thermo.matter.fluids.customQuantities.FluidQuantity;
import wromaciej.hvac_sim.thermo.matter.fluids.customQuantities.SpecificEnthalpy;
import wromaciej.hvac_sim.thermo.matter.service.units.UnitSystem;

import javax.measure.Measurable;
import javax.measure.Measure;
import javax.measure.quantity.Quantity;
import javax.measure.unit.Unit;
import java.util.*;

public interface FluidParameter<T extends FluidQuantity> extends Measurable{


}
