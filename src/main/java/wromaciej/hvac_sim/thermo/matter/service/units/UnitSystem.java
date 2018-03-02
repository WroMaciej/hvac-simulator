package wromaciej.hvac_sim.thermo.matter.service.units;

import javax.measure.quantity.*;
import javax.measure.unit.Unit;

public final class UnitSystem {
    private static Unit<Mass> massUnit;
    private static Unit<Temperature> temperatureUnit;
    private static Unit<Temperature> temperatureDifferenceUnit;
    private static Unit<Pressure> pressureUnit;
    private static Unit<Pressure> pressureDifferenceUnit;
    private static Unit<Power> heatFluxUnit;
    private static Unit<Power> electrialPowerUnit;
    private static Unit<Power> mechanicalPowerUnit;
    private static Unit<MassFlowRate> massFlowUnit;
    private static Unit<VolumetricFlowRate> volumeFlowUnit;
    private static Unit<VolumetricDensity> densityUnit;
    private static Unit<Energy> energyUnit;
    private static Unit<?> speficicEnthalpyUnit = energyUnit.divide(massUnit);
    private static Unit<?> specificEntropyUnit = speficicEnthalpyUnit.divide(temperatureDifferenceUnit);

    /**
     * Loading unit system from some DB or file or...
     */
    public static void loadUnitSystem(){}

    public static Unit<Mass> getMassUnit() {
        return massUnit;
    }

    public static Unit<Temperature> getTemperatureUnit() {
        return temperatureUnit;
    }

    public static Unit<Temperature> getTemperatureDifferenceUnit() {
        return temperatureDifferenceUnit;
    }

    public static Unit<Pressure> getPressureUnit() {
        return pressureUnit;
    }

    public static Unit<Pressure> getPressureDifferenceUnit() {
        return pressureDifferenceUnit;
    }

    public static Unit<Power> getHeatFluxUnit() {
        return heatFluxUnit;
    }

    public static Unit<Power> getElectrialPowerUnit() {
        return electrialPowerUnit;
    }

    public static Unit<Power> getMechanicalPowerUnit() {
        return mechanicalPowerUnit;
    }

    public static Unit<MassFlowRate> getMassFlowUnit() {
        return massFlowUnit;
    }

    public static Unit<VolumetricFlowRate> getVolumeFlowUnit() {
        return volumeFlowUnit;
    }

    public static Unit<VolumetricDensity> getDensityUnit() {
        return densityUnit;
    }

    public static Unit<Energy> getEnergyUnit() {
        return energyUnit;
    }

    public static Unit<?> getSpeficicEnthalpyUnit() {
        return speficicEnthalpyUnit;
    }

    public static Unit<?> getSpecificEntropyUnit() {
        return specificEntropyUnit;
    }
}
