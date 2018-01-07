package wromaciej.hvac_sim.thermo.fluids.data;

public enum SubstanceParameter {
    T,
    P,
    H;


    public static SubstanceParameter from(String name) {
        return SubstanceParameter.valueOf(name.toUpperCase());
    }
}
