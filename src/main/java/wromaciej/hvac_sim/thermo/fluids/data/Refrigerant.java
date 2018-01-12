package wromaciej.hvac_sim.thermo.fluids.data;

public final class Refrigerant extends Substance {
    /**
     * Gauge pressure, barG
     */
    protected SubstanceParameter pressureGaugeBarG;
    /**
     * Subcooling, K
     */
    protected SubstanceParameter subcooling;
    /**
     * Superheating K
     */
    protected SubstanceParameter superheating;
    /**
     * Saturated temperature C
     */
    protected SubstanceParameter temperatureSaturation;
    /**
     * Saturated pressure barA
     */
    protected SubstanceParameter pressureSaturation;
    /**
     * Saturated temperature C
     */
    protected SubstanceParameter temperatureBubbles;
    /**
     * Saturated pressure barA
     */
    protected SubstanceParameter pressureBubbles;
    /**
     * Saturated temperature C
     */
    protected SubstanceParameter temperatureDew;
    /**
     * Saturated pressure barA
     */
    protected SubstanceParameter pressureDew;
    /**
     * Saturated temperature K
     */
    protected SubstanceParameter temperatureSlide;
    /**
     * Saturated pressure kPa
     */
    protected SubstanceParameter pressureSlide;

    public Refrigerant(){
        super();
        pressureGaugeBarG= new SubstanceParameter(SubstanceParameterType.PRESSURE_GAUGE_BARG, 0);
        subcooling= new SubstanceParameter(SubstanceParameterType.DELTA_T, 0);
        superheating= new SubstanceParameter(SubstanceParameterType.DELTA_T, 0);
        temperatureSaturation= new SubstanceParameter(SubstanceParameterType.TEMPERATURE, 0);
        pressureSaturation= new SubstanceParameter(SubstanceParameterType.PRESSURE, 0);
        temperatureBubbles= new SubstanceParameter(SubstanceParameterType.TEMPERATURE, 0);
        pressureBubbles= new SubstanceParameter(SubstanceParameterType.PRESSURE, 0);
        temperatureDew= new SubstanceParameter(SubstanceParameterType.TEMPERATURE, 0);
        pressureDew = new SubstanceParameter(SubstanceParameterType.PRESSURE, 0);
        temperatureSlide = new SubstanceParameter(SubstanceParameterType.DELTA_T, 0);
        pressureSlide = new SubstanceParameter(SubstanceParameterType.PRESSURE_DROP, 0);

    }

    public SubstanceParameter getPressureGaugeBarG() {
        return pressureGaugeBarG;
    }
    public SubstanceParameter getSubcooling() {
        return subcooling;
    }
    public SubstanceParameter getSuperheating() {
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
