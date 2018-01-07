package wromaciej.hvac_sim.thermo.fluids.dynamics;

public class PressurePoint {
    private double v;
    private double dp;

    public PressurePoint(double v, double dp){
        this.v=v;
        this.dp=dp;
    }

    public double getV() {
        return v;
    }

    public double getDp() {
        return dp;
    }
}
