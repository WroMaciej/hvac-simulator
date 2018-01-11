package wromaciej.hvac_sim.thermo.fluids.data;

import java.util.Locale;

public final class Air extends Substance {
    /**
     * RH 0-1
     */
    protected SubstanceParameter relativeHumidity;
    /**
     * X kgH2O/kgDRY
     */
    protected SubstanceParameter moistureContent;
    /**
     * T dewpoint C
     */
    protected SubstanceParameter dewPoint;
    /**
     * T wetbulb C
     */
    protected SubstanceParameter wetBulb;
    /**
     * relative pressure, Pa
     */
    protected SubstanceParameter pGaugePa;

    public Air(){
        super();
        relativeHumidity=new SubstanceParameter(SubstanceParameterType.RELATIVE_HUMIDITY,0);
        moistureContent=new SubstanceParameter(SubstanceParameterType.MOISTURE_CONTENT,0);
        dewPoint=new SubstanceParameter(SubstanceParameterType.TEMPERATURE_DEWPOINT,0);
        wetBulb=new SubstanceParameter(SubstanceParameterType.TEMPERATURE_WETBULB,0);
        pGaugePa=new SubstanceParameter(SubstanceParameterType.PRESSURE_GAUGE_PA,0);
    }

    @Override
    public String toString() {
        return super.toString()
                +" pGauge: "+ pGaugePa.toString() + System.lineSeparator()
                +" rh: "+ relativeHumidity.toString() + System.lineSeparator()
                +" x: "+moistureContent.toString() + System.lineSeparator();
    }

    public SubstanceParameter getRelativeHumidity() {
        return relativeHumidity;
    }

    public SubstanceParameter getMoistureContent() {
        return moistureContent;
    }

    public SubstanceParameter getDewPoint() {
        return dewPoint;
    }

    public SubstanceParameter getWetBulb() {
        return wetBulb;
    }

    public SubstanceParameter getpGaugePa() {
        return pGaugePa;
    }
}
