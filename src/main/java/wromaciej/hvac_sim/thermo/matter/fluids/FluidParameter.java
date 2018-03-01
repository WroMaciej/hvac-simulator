package wromaciej.hvac_sim.thermo.matter.fluids;

import java.util.*;

public class FluidParameter {
    protected FluidParameterType type;
    protected double value;

    public FluidParameterType getType() {
        return type;
    }

    public double getValue() {
        return value;
    }

    public FluidParameter(FluidParameterType type, double value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        double multipliedValue=type.getMultiplyerForShowing()* value;
        return String.format(Locale.US,
                type.getStringFormat(),
                multipliedValue)+ type.getUnit();
    }
}
