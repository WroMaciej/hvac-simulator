package wromaciej.hvac_sim.thermo.fluids.dynamics;

public class PressurePoint implements Comparable<PressurePoint> {
    private double flow;
    private double pressure;

    public PressurePoint(double flow, double pressure){
        this.flow = flow;
        this.pressure = pressure;
    }

    public double getFlow() {
        return flow;
    }

    public double getPressure() {
        return pressure;
    }

    @Override
    public int compareTo(PressurePoint o) {
        if (this.flow==o.flow) return 0;
        else if (this.flow<o.flow) return -1;
        else if (this.flow>o.flow) return 1;
        return 0;
    }
}
