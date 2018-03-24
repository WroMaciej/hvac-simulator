package wromaciej.hvac_sim.thermo.matter.fluids.model;

import wromaciej.hvac_sim.thermo.matter.fluids.parameters.FluidParameter;
import wromaciej.hvac_sim.thermo.quantities.specific.Pressure;
import wromaciej.hvac_sim.thermo.quantities.specific.Temperature;

public final class Refrigerant extends Fluid {

    /**
     * Subcooling
     */
    protected FluidParameter<Temperature> subcooling;
    /**
     * Superheating
     */
    protected FluidParameter<Temperature> superheating;
    /**
     * Saturated temperature
     */
    protected FluidParameter<Temperature> temperatureSaturation;
    /**
     * Saturated pressure
     */
    protected FluidParameter<Pressure> pressureSaturation;
    /**
     * Saturated temperature
     */
    protected FluidParameter<Temperature> temperatureBubbles;
    /**
     * Saturated pressure
     */
    protected FluidParameter<Pressure> pressureBubbles;
    /**
     * Saturated temperature
     */
    protected FluidParameter<Temperature> temperatureDew;
    /**
     * Saturated pressure
     */
    protected FluidParameter<Pressure> pressureDew;
    /**
     * Saturated temperature
     */
    protected FluidParameter<Temperature> temperatureSlide;
    /**
     * Saturated pressure
     */
    protected FluidParameter<Pressure> pressureSlide;

    public Refrigerant(){
        super();
    }


    @Override
    public String toString() {
        return super.toString()
                +" Subcooling: "+ subcooling.toString() + System.lineSeparator()
                +" Superheating: "+superheating.toString() + System.lineSeparator()
                +" Temperature saturation: "+temperatureSaturation.toString() + System.lineSeparator();
    }
}
