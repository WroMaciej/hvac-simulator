package wromaciej.hvac_sim.thermo.fluids.data;

public final class Refrigerant extends Substance {
    /**
     * Gauge pressure, barG
     */
    private double pressureGaugeBarG;
    /**
     * Subcooling, K
     */
    private double subcooling;
    /**
     * Sperheating
     */
    private double superheating;

    public Refrigerant(){

    }

    public double getPressureGaugeBarG() {
        return pressureGaugeBarG;
    }

    public double getSubcooling() {
        return subcooling;
    }

    public double getSuperheating() {
        return superheating;
    }
}
