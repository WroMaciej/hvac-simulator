package wromaciej.hvac_sim.thermo.fluids.data;

public class Substance {
    protected SubstanceName substanceName;
    protected double t; // temperatura C
    protected double pBarA; //cisnienie bara
    protected double h; //entalpia wlasciwa kJ/kg
    protected double s; //entropia wlasciwa kJ/kgK
    protected double q; //stan nasycenia "x"

    protected double cp; //
    protected double v;
    protected double ro;

    public Substance(SubstanceName substanceName, double t, double pBarA, double h, double s, double q, double cp, double v, double ro) {
        this.substanceName=substanceName;
        this.t = t;
        this.pBarA = pBarA;
        this.h = h;
        this.s = s;
        this.q = q;
        this.cp = cp;
        this.v = v;
        this.ro = ro;
    }

    public SubstanceName getSubstanceName() {
        return substanceName;
    }

    public double getT() {
        return t;
    }

    public double getpBarA() {
        return pBarA;
    }

    public double getH() {
        return h;
    }

    public double getS() {
        return s;
    }

    public double getQ() {
        return q;
    }

    public double getCp() {
        return cp;
    }

    public double getV() {
        return v;
    }

    public double getRo() {
        return ro;
    }
}
