package wromaciej.hvac_sim.thermo.matter.fluids;

import wromaciej.hvac_sim.thermo.matter.fluids.customQuantities.FluidQuantity;
import wromaciej.hvac_sim.thermo.matter.fluids.customQuantities.SpecificEnthalpy;
import wromaciej.hvac_sim.thermo.matter.service.units.UnitSystem;

import javax.measure.Measurable;
import javax.measure.Measure;
import javax.measure.quantity.Quantity;
import javax.measure.unit.Unit;
import java.util.*;

public class FluidParameter<T extends FluidQuantity> {
    protected FluidParameterType parameterType;

    private Measurable<T> value;

    public double value(){
        Measurable<SpecificEnthalpy> entalpia = Measure.valueOf()
        return parameterValue.doubleValue();

    }


    protected double value;

    public FluidParameterType getParameterType() {
        return parameterType;
    }

    public double getValue() {
        return value;
    }

    public FluidParameter(FluidParameterType parameterType, double value) {
        this.parameterType = parameterType;
        this.value = value;

    }

    @Override
    public String toString() {
        double multipliedValue= parameterType.getMultiplyerForShowing()* value;
        return String.format(Locale.US,
                parameterType.getStringFormat(),
                multipliedValue)+ parameterType.getUnit();
    }
}
