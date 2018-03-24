package wromaciej.hvac_sim.thermo.matter.fluids.model;

import wromaciej.hvac_sim.thermo.matter.fluids.parameters.FluidParameter;
import wromaciej.hvac_sim.thermo.quantities.specific.Pressure;
import wromaciej.hvac_sim.thermo.quantities.specific.Temperature;

public final class Refrigerant extends Fluid {

    /**
     * Subcooling, K
     */
    protected FluidParameter<Temperature> subcooling;
    /**
     * Superheating K
     */
    protected FluidParameter<Temperature> superheating;
    /**
     * Saturated temperature C
     */
    protected FluidParameter<Temperature> temperatureSaturation;
    /**
     * Saturated pressure barA
     */
    protected FluidParameter<Pressure> pressureSaturation;
    /**
     * Saturated temperature C
     */
    protected FluidParameter<Temperature> temperatureBubbles;
    /**
     * Saturated pressure barA
     */
    protected FluidParameter<Pressure> pressureBubbles;
    /**
     * Saturated temperature C
     */
    protected FluidParameter<Temperature> temperatureDew;
    /**
     * Saturated pressure barA
     */
    protected FluidParameter<Pressure> pressureDew;
    /**
     * Saturated temperature K
     */
    protected FluidParameter<Temperature> temperatureSlide;
    /**
     * Saturated pressure kPa
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
