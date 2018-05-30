package wromaciej.hvac_sim.simulation.thermo.generals.conservationLaw;

import wromaciej.hvac_sim.simulation.thermo.generals.bonds.BondDirection;
import wromaciej.hvac_sim.simulation.thermo.parameters.Parameter;

public class ParameterWithDirection {
    private Parameter parameter;
    private BondDirection direction;

    public ParameterWithDirection(Parameter parameter, BondDirection direction) {
        this.parameter = parameter;
        this.direction = direction;
    }

    public Parameter getParameter() {
        return parameter;
    }

    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }

    public BondDirection getDirection() {
        return direction;
    }

    public void setDirection(BondDirection direction) {
        this.direction = direction;
    }
}
