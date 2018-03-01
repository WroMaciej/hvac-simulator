package wromaciej.hvac_sim.thermo.matter.fluids;

public final class Air extends Fluid {
    /**
     * RH 0-1
     */
    protected FluidParameter relativeHumidity;
    /**
     * X kgH2O/kgDRY
     */
    protected FluidParameter moistureContent;
    /**
     * T dewpoint C
     */
    protected FluidParameter dewPoint;
    /**
     * T wetbulb C
     */
    protected FluidParameter wetBulb;
    /**
     * relative pressure, Pa
     */
    protected FluidParameter pGaugePa;

    public Air(){
        super();
        relativeHumidity=new FluidParameter(FluidParameterType.RELATIVE_HUMIDITY,0);
        moistureContent=new FluidParameter(FluidParameterType.MOISTURE_CONTENT,0);
        dewPoint=new FluidParameter(FluidParameterType.TEMPERATURE_DEWPOINT,0);
        wetBulb=new FluidParameter(FluidParameterType.TEMPERATURE_WETBULB,0);
        pGaugePa=new FluidParameter(FluidParameterType.PRESSURE_GAUGE_PA,0);
    }

    @Override
    public String toString() {
        return super.toString()
                +" pGauge: "+ pGaugePa.toString() + System.lineSeparator()
                +" rh: "+ relativeHumidity.toString() + System.lineSeparator()
                +" x: "+moistureContent.toString() + System.lineSeparator();
    }

    public FluidParameter getRelativeHumidity() {
        return relativeHumidity;
    }

    public FluidParameter getMoistureContent() {
        return moistureContent;
    }

    public FluidParameter getDewPoint() {
        return dewPoint;
    }

    public FluidParameter getWetBulb() {
        return wetBulb;
    }

    public FluidParameter getpGaugePa() {
        return pGaugePa;
    }
}
