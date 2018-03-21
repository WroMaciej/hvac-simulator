package wromaciej.hvac_sim.thermo.matter.fluids.model;

import wromaciej.hvac_sim.thermo.matter.fluids.parameters.AirParameter;
import wromaciej.hvac_sim.thermo.quantities.specific.MoistureContent;
import wromaciej.hvac_sim.thermo.quantities.specific.RelativeHumidity;
import wromaciej.hvac_sim.thermo.quantities.specific.Temperature;
import wromaciej.hvac_sim.thermo.unitSystems.UnitSystem;

public final class Air extends Fluid {
    /**
     * Relative Humidity 0-1
     */
    private AirParameter<RelativeHumidity> relativeHumidity;
    /**
     * Moisture Content x kgH2O/kgDRY
     */
    private AirParameter<MoistureContent> moistureContent;
    /**
     * Temperature of Dewpoint (x=idem)
     */
    private AirParameter<Temperature> dewPointTemperature;
     /**
     * Temperature of wet bult (h=idem)
     */
    private AirParameter<Temperature> wetBulbTemperature;



    public Air(){
        super();
//        relativeHumidity=new AirParameter<>(UnitSystem.getActualUnitSystem().getRelativeHumidityUnit());
//        moistureContent=new AirParameter<>(UnitSystem.getActualUnitSystem().getMoistureContentUnit());
//        dewPointTemperature =new AirParameter<>(UnitSystem.getActualUnitSystem().getTemperatureUnit());
//        wetBulbTemperature=new AirParameter<>(UnitSystem.getActualUnitSystem().getTemperatureUnit());

    }

    @Override
    public String toString() {
        return super.toString()
                +" rh: "+ relativeHumidity.toString() + System.lineSeparator()
                +" x: "+moistureContent.toString() + System.lineSeparator();
    }


}
