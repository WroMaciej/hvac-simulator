package wromaciej.hvac_sim.thermo.fluids.data;

import java.util.*;

public class SubstanceParameter {
    protected SubstanceParameterType type;
    protected double value;

    public SubstanceParameterType getType() {
        return type;
    }

    public double getValue() {
        return value;
    }

    public SubstanceParameter(SubstanceParameterType type, double value) {
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
