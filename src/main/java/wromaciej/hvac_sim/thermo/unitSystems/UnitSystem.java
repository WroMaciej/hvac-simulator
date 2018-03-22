package wromaciej.hvac_sim.thermo.unitSystems;


import wromaciej.hvac_sim.thermo.matter.fluids.model.Fluid;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.FluidParameter;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.quantities.specific.*;
import wromaciej.hvac_sim.thermo.quantities.extensive.*;
import wromaciej.hvac_sim.thermo.quantities.coefficients.*;

import javax.measure.unit.Unit;


public final class UnitSystem {

    private String unitSystemName;

    /**
     * Returns actual unit system
     */
    private static UnitSystem actualUnitSystem;

    //specific units
    private Unit<PressureDifference> airPressureDifferenceUnit;
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

    //default values
    private Fluid atmosphere;

    public Fluid getAtmosphere() {
        return atmosphere;
    }

    public void setAtmosphere(Fluid atmosphere) {
        this.atmosphere = atmosphere;
    }

    public FluidParameter<Pressure> getAtmosphericPressure() {
        return atmosphere.getAbsolutePressure();
    }


    public FluidParameter<Temperature> getAtmosphericTemperature() {
        return atmosphere.getTemperature();
    }


    /**
     * Loading unit system from some DB or file or...
     */
    public static void loadUnitSystem(String unitSystemName) {
    }

    public UnitSystem() {
    }

    public UnitSystem(String unitSystemName) {
        loadUnitSystem(unitSystemName);
    }

    public static UnitSystem getActualUnitSystem() {
        return actualUnitSystem;
    }

    public static void setActualUnitSystem(UnitSystem newActualUnitSystem) {
        UnitSystem.actualUnitSystem = newActualUnitSystem;
    }


    public Unit<Density> getDensityUnit() {
        return densityUnit;
    }

    public void setDensityUnit(Unit<Density> densityUnit) {
        this.densityUnit = densityUnit;
    }

    public Unit<HeatCapacity> getHeatCapacityUnit() {
        return heatCapacityUnit;
    }

    public void setHeatCapacityUnit(Unit<HeatCapacity> heatCapacityUnit) {
        this.heatCapacityUnit = heatCapacityUnit;
    }

    public Unit<MassHumidity> getMassHumidityUnit() {
        return massHumidityUnit;
    }

    public void setMassHumidityUnit(Unit<MassHumidity> massHumidityUnit) {
        this.massHumidityUnit = massHumidityUnit;
    }

    public Unit<MoistureContent> getMoistureContentUnit() {
        return moistureContentUnit;
    }

    public void setMoistureContentUnit(Unit<MoistureContent> moistureContentUnit) {
        this.moistureContentUnit = moistureContentUnit;
    }

    public Unit<Pressure> getPressureUnit() {
        return pressureUnit;
    }

    public void setPressureUnit(Unit<Pressure> pressureUnit) {
        this.pressureUnit = pressureUnit;
    }

    public Unit<PressureDifference> getPressureDifferenceUnit() {
        return pressureDifferenceUnit;
    }

    public void setPressureDifferenceUnit(Unit<PressureDifference> pressureDifferenceUnit) {
        this.pressureDifferenceUnit = pressureDifferenceUnit;
    }

    public Unit<Quality> getQualityUnit() {
        return qualityUnit;
    }

    public void setQualityUnit(Unit<Quality> qualityUnit) {
        this.qualityUnit = qualityUnit;
    }

    public Unit<RelativeHumidity> getRelativeHumidityUnit() {
        return relativeHumidityUnit;
    }

    public void setRelativeHumidityUnit(Unit<RelativeHumidity> relativeHumidityUnit) {
        this.relativeHumidityUnit = relativeHumidityUnit;
    }

    public Unit<SpecificEnthalpy> getSpecificEnthalpyUnit() {
        return specificEnthalpyUnit;
    }

    public void setSpecificEnthalpyUnit(Unit<SpecificEnthalpy> specificEnthalpyUnit) {
        this.specificEnthalpyUnit = specificEnthalpyUnit;
    }

    public Unit<SpecificEntropy> getSpecificEntropyUnit() {
        return specificEntropyUnit;
    }

    public void setSpecificEntropyUnit(Unit<SpecificEntropy> specificEntropyUnit) {
        this.specificEntropyUnit = specificEntropyUnit;
    }

    public Unit<SpecificVolume> getSpecificVolumeUnit() {
        return specificVolumeUnit;
    }

    public void setSpecificVolumeUnit(Unit<SpecificVolume> specificVolumeUnit) {
        this.specificVolumeUnit = specificVolumeUnit;
    }

    public Unit<Temperature> getTemperatureUnit() {
        return temperatureUnit;
    }

    public void setTemperatureUnit(Unit<Temperature> temperatureUnit) {
        this.temperatureUnit = temperatureUnit;
    }

    public Unit<TemperatureDifference> getTemperatureDifferenceUnit() {
        return temperatureDifferenceUnit;
    }

    public void setTemperatureDifferenceUnit(Unit<TemperatureDifference> temperatureDifferenceUnit) {
        this.temperatureDifferenceUnit = temperatureDifferenceUnit;
    }

    public Unit<HeatFlow> getHeatFlowUnit() {
        return heatFlowUnit;
    }

    public void setHeatFlowUnit(Unit<HeatFlow> heatFlowUnit) {
        this.heatFlowUnit = heatFlowUnit;
    }

    public Unit<MassFlow> getMassFlowUnit() {
        return massFlowUnit;
    }

    public void setMassFlowUnit(Unit<MassFlow> massFlowUnit) {
        this.massFlowUnit = massFlowUnit;
    }

    public Unit<Power> getPowerUnit() {
        return powerUnit;
    }

    public void setPowerUnit(Unit<Power> powerUnit) {
        this.powerUnit = powerUnit;
    }

    public Unit<VolumeFlow> getVolumeFlowUnit() {
        return volumeFlowUnit;
    }

    public void setVolumeFlowUnit(Unit<VolumeFlow> volumeFlowUnit) {
        this.volumeFlowUnit = volumeFlowUnit;
    }

    public Unit<Velocity> getVelocityUnit() {
        return velocityUnit;
    }

    public void setVelocityUnit(Unit<Velocity> velocityUnit) {
        this.velocityUnit = velocityUnit;
    }

    public Unit<PressureDifference> getAirPressureDifferenceUnit() {
        return airPressureDifferenceUnit;
    }

    public void setAirPressureDifferenceUnit(Unit<PressureDifference> airPressureDifferenceUnit) {
        this.airPressureDifferenceUnit = airPressureDifferenceUnit;
    }
}
