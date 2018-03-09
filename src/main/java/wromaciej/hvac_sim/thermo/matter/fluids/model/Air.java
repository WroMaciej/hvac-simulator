package wromaciej.hvac_sim.thermo.matter.fluids.model;

import wromaciej.hvac_sim.thermo.controller.FluidParameterAdapter;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.AirParameter;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.FluidParameter;

public final class Air extends Fluid {
    /**
     * RH 0-1
     */
    protected AirParameter relativeHumidity;
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
        relativeHumidity=new FluidParameter(FluidParameterAdapter.RELATIVE_HUMIDITY,0);
        moistureContent=new FluidParameter(FluidParameterAdapter.MOISTURE_CONTENT,0);
        dewPoint=new FluidParameter(FluidParameterAdapter.TEMPERATURE_DEWPOINT,0);
        wetBulb=new FluidParameter(FluidParameterAdapter.TEMPERATURE_WETBULB,0);
        pGaugePa=new FluidParameter(FluidParameterAdapter.PRESSURE_GAUGE_PA,0);
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
