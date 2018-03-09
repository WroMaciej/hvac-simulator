package wromaciej.hvac_sim.thermo.matter.fluids.model;

import wromaciej.hvac_sim.thermo.controller.FluidParameterAdapter;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.FluidParameter;

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
        pressureGaugeBarG= new FluidParameter(FluidParameterAdapter.PRESSURE_GAUGE, 0);
        subcooling= new FluidParameter(FluidParameterAdapter.TEMPERATURE_DIFFERENCE, 0);
        superheating= new FluidParameter(FluidParameterAdapter.TEMPERATURE_DIFFERENCE, 0);
        temperatureSaturation= new FluidParameter(FluidParameterAdapter.TEMPERATURE, 0);
        pressureSaturation= new FluidParameter(FluidParameterAdapter.PRESSURE, 0);
        temperatureBubbles= new FluidParameter(FluidParameterAdapter.TEMPERATURE, 0);
        pressureBubbles= new FluidParameter(FluidParameterAdapter.PRESSURE, 0);
        temperatureDew= new FluidParameter(FluidParameterAdapter.TEMPERATURE, 0);
        pressureDew = new FluidParameter(FluidParameterAdapter.PRESSURE, 0);
        temperatureSlide = new FluidParameter(FluidParameterAdapter.TEMPERATURE_DIFFERENCE, 0);
        pressureSlide = new FluidParameter(FluidParameterAdapter.PRESSURE_DIFFERENCE, 0);

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
