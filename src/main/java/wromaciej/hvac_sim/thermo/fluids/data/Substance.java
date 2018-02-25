package wromaciej.hvac_sim.thermo.fluids.data;



public class Substance {
    /**
     * Type of substance
     */
    protected SubstanceName substanceName;
    /**
     * Temperature, C
     */
    protected SubstanceParameter temperature; // temperatura C
    /**
     * Pressure (absolute), barA
     */
    protected SubstanceParameter pressure; //cisnienie bara
    /**
     * Enthalpy, kJ/kg
     */
    protected SubstanceParameter enthalpy; //entalpia wlasciwa kJ/kg
    /**
     * Entropy, kJ/kgK
     */
    protected SubstanceParameter entropy; //entropia wlasciwa kJ/kgK
    /**
     * Quality (x), 0-1
     */
    protected SubstanceParameter quality; //stan nasycenia "x"
    /**
     * Heat capacity, kJ/kgK
     */
    protected SubstanceParameter heatCapacity; //
    /**
     * Specific volume, m3/kg
     */
    protected SubstanceParameter volume;
    /**
     * Density, kg/m3
     */
    protected SubstanceParameter density;

    public Substance(){


        temperature=new SubstanceParameter(SubstanceParameterType.TEMPERATURE,0);
        pressure=new SubstanceParameter(SubstanceParameterType.PRESSURE,0);
        enthalpy=new SubstanceParameter(SubstanceParameterType.ENTHALPY,0);
        entropy=new SubstanceParameter(SubstanceParameterType.ENTROPY,0);
        quality=new SubstanceParameter(SubstanceParameterType.QUALITY,0);
        heatCapacity=new SubstanceParameter(SubstanceParameterType.HEAT_CAPACITY,0);
        volume=new SubstanceParameter(SubstanceParameterType.VOLUME,1);
        density=new SubstanceParameter(SubstanceParameterType.DENSITY,1);
        /*temperature.type=SubstanceParameterType.TEMPERATURE;
        pressure.type=SubstanceParameterType.PRESSURE;
        enthalpy.type=SubstanceParameterType.ENTHALPY;
        entropy.type=SubstanceParameterType.ENTROPY;
        quality.type=SubstanceParameterType.QUALITY;
        heatCapacity.type=SubstanceParameterType.HEAT_CAPACITY;
        volume.type=SubstanceParameterType.VOLUME;
        density.type=SubstanceParameterType.DENSITY;*/
    }

    @Override
    public String toString() {
        return "Name: " + substanceName.enumToString() + System.lineSeparator()
                +" temperature: "+temperature.toString() + System.lineSeparator()
                + " pressure: "+pressure.toString() + System.lineSeparator()
                +" enthalpy: " +enthalpy.toString() + System.lineSeparator();
    }
}
