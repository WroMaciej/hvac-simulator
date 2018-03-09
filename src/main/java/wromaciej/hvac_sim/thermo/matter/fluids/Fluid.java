package wromaciej.hvac_sim.thermo.matter.fluids;


import wromaciej.hvac_sim.thermo.quantities.specific.Temperature;

import javax.measure.quantity.Pressure;

public class Fluid {
    /**
     * Type of substance
     */
    protected FluidName fluidName;


    /**
     * Temperature, C
     */
    protected FluidParameter<Temperature> temperature; // temperatura C
    /**
     * Pressure (absolute), barA
     */
    protected FluidParameter<Pressure> pressure; //cisnienie bara
    /**
     * Enthalpy, kJ/kg
     */
    protected FluidParameter enthalpy; //entalpia wlasciwa kJ/kg
    /**
     * Entropy, kJ/kgK
     */
    protected FluidParameter entropy; //entropia wlasciwa kJ/kgK
    /**
     * Quality (x), 0-1
     */
    protected FluidParameter quality; //stan nasycenia "x"
    /**
     * Heat capacity, kJ/kgK
     */
    protected FluidParameter heatCapacity; //
    /**
     * Specific volume, m3/kg
     */
    protected FluidParameter volume;
    /**
     * Density, kg/m3
     */
    protected FluidParameter density;

    public Fluid(){

        entalpiaTest.


        temperature=new FluidParameter(FluidParameterType.TEMPERATURE,0);
        pressure=new FluidParameter(FluidParameterType.PRESSURE,0);
        enthalpy=new FluidParameter(FluidParameterType.SPECIFIC_ENTHALPY,0);
        entropy=new FluidParameter(FluidParameterType.SPECIFIC_ENTROPY,0);
        quality=new FluidParameter(FluidParameterType.QUALITY,0);
        heatCapacity=new FluidParameter(FluidParameterType.HEAT_CAPACITY,0);
        volume=new FluidParameter(FluidParameterType.SPECIFIC_VOLUME,1);
        density=new FluidParameter(FluidParameterType.DENSITY,1);

    }

    @Override
    public String toString() {
        return "Name: " + fluidName.enumToString() + System.lineSeparator()
                +" temperature: "+temperature.toString() + System.lineSeparator()
                + " pressure: "+pressure.toString() + System.lineSeparator()
                +" enthalpy: " +enthalpy.toString() + System.lineSeparator();
    }
}
