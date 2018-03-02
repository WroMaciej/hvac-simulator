package wromaciej.hvac_sim.thermo.matter.fluids;

import wromaciej.hvac_sim.thermo.matter.service.units.UnitSystem;

import javax.measure.Measurable;
import javax.measure.unit.Unit;
import java.util.*;

public class FluidParameter {
    protected FluidParameterType parameterType;

    private Measurable<?> value;

    public double value(){
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
