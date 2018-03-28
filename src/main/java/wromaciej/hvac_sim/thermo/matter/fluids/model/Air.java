package wromaciej.hvac_sim.thermo.matter.fluids.model;

import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.quantities.specific.MoistureContent;
import wromaciej.hvac_sim.thermo.quantities.specific.RelativeHumidity;
import wromaciej.hvac_sim.thermo.quantities.specific.Temperature;

public final class Air extends Fluid {
    /**
     * Relative Humidity 0-1
     */
    private Parameter<RelativeHumidity> relativeHumidity;
    /**
     * Moisture Content x kgH2O/kgDRY
     */
    private Parameter<MoistureContent> moistureContent;
    /**
     * Temperature of Dewpoint (x=idem)
     */
    private Parameter<Temperature> dewPointTemperature;
     /**
     * Temperature of wet bult (h=idem)
     */
    private Parameter<Temperature> wetBulbTemperature;



    public Air(){
        super();
//        relativeHumidity=new AirParameter<>(UnitSystem.getActualUnitSystem().getRelativeHumidityUnit());
//        moistureContent=new AirParameter<>(UnitSystem.getActualUnitSystem().getMoistureContentUnit());
//        dewPointTemperature =new AirParameter<>(UnitSystem.getActualUnitSystem().getTemperatureUnit());
//        wetBulbTemperature=new AirParameter<>(UnitSystem.getActualUnitSystem().getTemperatureUnit());
    }

    public Parameter<RelativeHumidity> getRelativeHumidity() {
        return relativeHumidity;
    }

    public void setRelativeHumidity(Parameter<RelativeHumidity> relativeHumidity) {
        this.relativeHumidity = relativeHumidity;
    }

    public Parameter<MoistureContent> getMoistureContent() {
        return moistureContent;
    }

    public void setMoistureContent(Parameter<MoistureContent> moistureContent) {
        this.moistureContent = moistureContent;
    }

    public Parameter<Temperature> getDewPointTemperature() {
        return dewPointTemperature;
    }

    public void setDewPointTemperature(Parameter<Temperature> dewPointTemperature) {
        this.dewPointTemperature = dewPointTemperature;
    }

    public Parameter<Temperature> getWetBulbTemperature() {
        return wetBulbTemperature;
    }

    public void setWetBulbTemperature(Parameter<Temperature> wetBulbTemperature) {
        this.wetBulbTemperature = wetBulbTemperature;
    }

    @Override
    public String toString() {
        return super.toString()
                +" rh: "+ relativeHumidity.toString() + System.lineSeparator()
                +" x: "+moistureContent.toString() + System.lineSeparator();
    }


}
