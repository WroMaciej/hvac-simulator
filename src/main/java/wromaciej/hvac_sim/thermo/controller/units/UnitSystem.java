package wromaciej.hvac_sim.thermo.controller.units;

import javax.measure.Measurable;
import javax.measure.quantity.*;
import javax.measure.unit.SystemOfUnits;
import javax.measure.unit.Unit;

import static javax.measure.unit.SI.*;

public class UnitSystem {
    Unit<Mass> massUnit;
    Unit<Temperature> temperatureUnit;
    Unit<Temperature> temperatureDifferenceUnit;
    Unit<Pressure> pressureUnit;
    Unit<Pressure> pressureDifferenceUnit;
    Unit<Power> heatFluxUnit;
    Unit<Power> electrialPowerUnit;
    Unit<Power> mechanicalPowerUnit;
    Unit<MassFlowRate> massFlowUnit;
    Unit<VolumetricFlowRate> volumeFlowUnit;
    Unit<VolumetricDensity> densityUnit;
    Unit<Energy> energyUnit;
    Unit<?> speficicEnthalpyUnit= energyUnit.divide(massUnit);
    Unit<?> specificEntropyUnit = speficicEnthalpyUnit.divide(temperatureDifferenceUnit);



}
