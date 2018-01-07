package wromaciej.hvac_sim.thermo.fluids.data;

public class Air extends Substance {

    public Air(String fluidName, double t, double pBarA, double h, double s, double q, double cp, double v, double ro) {
        super(fluidName, t, pBarA, h, s, q, cp, v, ro);
    }
}
