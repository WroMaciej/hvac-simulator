package wromaciej.hvac_sim.thermo.matter.fluids.model;

import wromaciej.hvac_sim.thermo.matter.fluids.parameters.FluidParameter;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.RefrigerantParameter;
import wromaciej.hvac_sim.thermo.quantities.specific.Pressure;
import wromaciej.hvac_sim.thermo.quantities.specific.Temperature;

public final class Refrigerant extends Fluid {

    /**
     * Subcooling, K
     */
    protected RefrigerantParameter<Temperature> subcooling;
    /**
     * Superheating K
     */
    protected RefrigerantParameter<Temperature> superheating;
    /**
     * Saturated temperature C
     */
    protected RefrigerantParameter<Temperature> temperatureSaturation;
    /**
     * Saturated pressure barA
     */
    protected RefrigerantParameter<Pressure> pressureSaturation;
    /**
     * Saturated temperature C
     */
    protected RefrigerantParameter<Temperature> temperatureBubbles;
    /**
     * Saturated pressure barA
     */
    protected RefrigerantParameter<Pressure> pressureBubbles;
    /**
     * Saturated temperature C
     */
    protected RefrigerantParameter<Temperature> temperatureDew;
    /**
     * Saturated pressure barA
     */
    protected RefrigerantParameter<Pressure> pressureDew;
    /**
     * Saturated temperature K
     */
    protected RefrigerantParameter<Temperature> temperatureSlide;
    /**
     * Saturated pressure kPa
     */
    protected RefrigerantParameter<Pressure> pressureSlide;

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
