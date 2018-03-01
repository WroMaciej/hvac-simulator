package wromaciej.hvac_sim.thermo.matter.fluids;



public class Fluid {
    /**
     * Type of substance
     */
    protected FluidName fluidName;
    /**
     * Temperature, C
     */
    protected FluidParameter temperature; // temperatura C
    /**
     * Pressure (absolute), barA
     */
    protected FluidParameter pressure; //cisnienie bara
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


        temperature=new FluidParameter(FluidParameterType.TEMPERATURE,0);
        pressure=new FluidParameter(FluidParameterType.PRESSURE,0);
        enthalpy=new FluidParameter(FluidParameterType.ENTHALPY,0);
        entropy=new FluidParameter(FluidParameterType.ENTROPY,0);
        quality=new FluidParameter(FluidParameterType.QUALITY,0);
        heatCapacity=new FluidParameter(FluidParameterType.HEAT_CAPACITY,0);
        volume=new FluidParameter(FluidParameterType.VOLUME,1);
        density=new FluidParameter(FluidParameterType.DENSITY,1);
        /*temperature.type=FluidParameterType.TEMPERATURE;
        pressure.type=FluidParameterType.PRESSURE;
        enthalpy.type=FluidParameterType.ENTHALPY;
        entropy.type=FluidParameterType.ENTROPY;
        quality.type=FluidParameterType.QUALITY;
        heatCapacity.type=FluidParameterType.HEAT_CAPACITY;
        volume.type=FluidParameterType.VOLUME;
        density.type=FluidParameterType.DENSITY;*/
    }

    @Override
    public String toString() {
        return "Name: " + fluidName.enumToString() + System.lineSeparator()
                +" temperature: "+temperature.toString() + System.lineSeparator()
                + " pressure: "+pressure.toString() + System.lineSeparator()
                +" enthalpy: " +enthalpy.toString() + System.lineSeparator();
    }
}
