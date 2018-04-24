package wromaciej.hvac_sim.thermo.matter.fluids.model;

import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.quantities.specific.Pressure;
import wromaciej.hvac_sim.thermo.quantities.specific.Temperature;

public final class Refrigerant extends Fluid {

    /**
     * Subcooling
     */
    protected Parameter<Temperature> subcooling;
    /**
     * Superheating
     */
    protected Parameter<Temperature> superheating;
    /**
     * Saturated temperature
     */
    protected Parameter<Temperature> temperatureSaturation;
    /**
     * Saturated pressure
     */
    protected Parameter<Pressure> pressureSaturation;
    /**
     * Saturated temperature
     */
    protected Parameter<Temperature> temperatureBubbles;
    /**
     * Saturated pressure
     */
    protected Parameter<Pressure> pressureBubbles;
    /**
     * Saturated temperature
     */
    protected Parameter<Temperature> temperatureDew;
    /**
     * Saturated pressure
     */
    protected Parameter<Pressure> pressureDew;
    /**
     * Saturated temperature
     */
    protected Parameter<Temperature> temperatureSlide;
    /**
     * Saturated pressure
     */
    protected Parameter<Pressure> pressureSlide;

    public Refrigerant(FluidFactory fluidFactory){
        super(fluidFactory);
    }


    @Override
    public String toString() {
        return super.toString()
                +" Subcooling: "+ subcooling.toString() + System.lineSeparator()
                +" Superheating: "+superheating.toString() + System.lineSeparator()
                +" Temperature saturation: "+temperatureSaturation.toString() + System.lineSeparator();
    }
}
