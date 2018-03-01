package wromaciej.hvac_sim.thermo.matter.fluids;

public final class Refrigerant extends Fluid {
    /**
     * Gauge pressure, barG
     */
    protected FluidParameter pressureGaugeBarG;
    /**
     * Subcooling, K
     */
    protected FluidParameter subcooling;
    /**
     * Superheating K
     */
    protected FluidParameter superheating;
    /**
     * Saturated temperature C
     */
    protected FluidParameter temperatureSaturation;
    /**
     * Saturated pressure barA
     */
    protected FluidParameter pressureSaturation;
    /**
     * Saturated temperature C
     */
    protected FluidParameter temperatureBubbles;
    /**
     * Saturated pressure barA
     */
    protected FluidParameter pressureBubbles;
    /**
     * Saturated temperature C
     */
    protected FluidParameter temperatureDew;
    /**
     * Saturated pressure barA
     */
    protected FluidParameter pressureDew;
    /**
     * Saturated temperature K
     */
    protected FluidParameter temperatureSlide;
    /**
     * Saturated pressure kPa
     */
    protected FluidParameter pressureSlide;

    public Refrigerant(){
        super();
        pressureGaugeBarG= new FluidParameter(FluidParameterType.PRESSURE_GAUGE_BARG, 0);
        subcooling= new FluidParameter(FluidParameterType.DELTA_T, 0);
        superheating= new FluidParameter(FluidParameterType.DELTA_T, 0);
        temperatureSaturation= new FluidParameter(FluidParameterType.TEMPERATURE, 0);
        pressureSaturation= new FluidParameter(FluidParameterType.PRESSURE, 0);
        temperatureBubbles= new FluidParameter(FluidParameterType.TEMPERATURE, 0);
        pressureBubbles= new FluidParameter(FluidParameterType.PRESSURE, 0);
        temperatureDew= new FluidParameter(FluidParameterType.TEMPERATURE, 0);
        pressureDew = new FluidParameter(FluidParameterType.PRESSURE, 0);
        temperatureSlide = new FluidParameter(FluidParameterType.DELTA_T, 0);
        pressureSlide = new FluidParameter(FluidParameterType.PRESSURE_DROP, 0);

    }

    public FluidParameter getPressureGaugeBarG() {
        return pressureGaugeBarG;
    }
    public FluidParameter getSubcooling() {
        return subcooling;
    }
    public FluidParameter getSuperheating() {
        return superheating;
    }

    @Override
    public String toString() {
        return super.toString()
                +" Gauge pressure: "+ pressureGaugeBarG.toString() + System.lineSeparator()
                +" Subcooling: "+ subcooling.toString() + System.lineSeparator()
                +" Superheating: "+superheating.toString() + System.lineSeparator()
                +" Temperature saturation: "+temperatureSaturation.toString() + System.lineSeparator();
    }
}
