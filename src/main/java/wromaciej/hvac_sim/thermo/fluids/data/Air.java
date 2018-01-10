package wromaciej.hvac_sim.thermo.fluids.data;

public class Air extends Substance {
    /**
     * RH 0-1
     */
    protected double relativeHumidity;
    /**
     * X kgH2O/kgDRY
     */
    protected double moistureContent;
    /**
     * T dewpoint C
     */
    protected double dewPoint;
    /**
     * T wetbulb C
     */
    protected double wetBulb;
    /**
     * relative pressure, Pa
     */
    protected double pGaugePa;

    public Air(){
    }

    @Override
    public String toString() {
        return super.toString()
                +" pGauge: "+ pGaugePa
                +"Pa rh: "+ relativeHumidity
                +" x: "+moistureContent;
    }
}
