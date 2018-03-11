package wromaciej.hvac_sim.thermo.unitSystems;


import wromaciej.hvac_sim.thermo.quantities.specific.*;
import wromaciej.hvac_sim.thermo.quantities.extensive.*;
import wromaciej.hvac_sim.thermo.quantities.coefficients.*;
import javax.measure.unit.Unit;


public final class UnitSystem {

    private String unitSystemName;

    //specific units
    private Unit<AirPressureDifference> airPressureDifferenceUnit;
    private Unit<Density> densityUnit;
    private Unit<HeatCapacity> heatCapacityUnit;
    private Unit<MassHumidity> massHumidityUnit;
    private Unit<MoistureContent> moistureContentUnit;
    private Unit<Pressure> pressureUnit;
    private Unit<PressureDifference> pressureDifferenceUnit;
    private Unit<Quality> qualityUnit;
    private Unit<RelativeHumidity> relativeHumidityUnit;
    private Unit<SpecificEnthalpy> specificEnthalpyUnit;
    private Unit<SpecificEntropy> specificEntropyUnit;
    private Unit<SpecificVolume> specificVolumeUnit;
    private Unit<Temperature> temperatureUnit;
    private Unit<TemperatureDifference> temperatureDifferenceUnit;

    //extensive units
    private Unit<HeatFlow> heatFlowUnit;
    private Unit<MassFlow> massFlowUnit;
    private Unit<Power> powerUnit;
    private Unit<VolumeFlow> volumeFlowUnit;

    //coefficients
    private Unit<Velocity> velocityUnit;

    /**
     * Loading unit system from some DB or file or...
     */
    public static void loadUnitSystem(String unitSystemName){}

    public UnitSystem() {}

    public UnitSystem(String unitSystemName) {
        loadUnitSystem(unitSystemName);
    }
}
