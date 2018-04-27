package wromaciej.hvac_sim.thermo.matter.fluids.model;

import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.quantities.specific.Pressure;
import wromaciej.hvac_sim.thermo.quantities.specific.Temperature;

public final class Refrigerant extends Fluid {

    /**
     * Subcooling
     */
    private Parameter<Temperature> subcooling;
    /**
     * Superheating
     */
    private Parameter<Temperature> superheating;
    /**
     * Saturated temperature
     */
    private Parameter<Temperature> temperatureSaturation;
    /**
     * Saturated pressure
     */
    private Parameter<Pressure> pressureSaturation;
    /**
     * Saturated temperature
     */
    private Parameter<Temperature> temperatureBubbles;
    /**
     * Saturated pressure
     */
    private Parameter<Pressure> pressureBubbles;
    /**
     * Saturated temperature
     */
    private Parameter<Temperature> temperatureDew;
    /**
     * Saturated pressure
     */
    private Parameter<Pressure> pressureDew;
    /**
     * Saturated temperature
     */
    private Parameter<Temperature> temperatureSlide;
    /**
     * Saturated pressure
     */
    private Parameter<Pressure> pressureSlide;

    public Refrigerant(FluidFactory fluidFactory){
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
