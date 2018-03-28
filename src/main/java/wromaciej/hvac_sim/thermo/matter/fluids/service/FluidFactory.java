package wromaciej.hvac_sim.thermo.matter.fluids.service;

import wromaciej.hvac_sim.thermo.matter.fluids.model.Air;
import wromaciej.hvac_sim.thermo.matter.fluids.model.Fluid;
import wromaciej.hvac_sim.thermo.matter.fluids.model.FluidType;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.*;
import wromaciej.hvac_sim.thermo.quantities.base.AirQuantity;
import wromaciej.hvac_sim.thermo.quantities.specific.Pressure;
import wromaciej.hvac_sim.thermo.quantities.specific.Temperature;
import wromaciej.hvac_sim.thermo.unitSystems.UnitSystem;

import javax.measure.unit.NonSI;
import javax.measure.unit.SI;

public abstract class FluidFactory {

    public static StateOfMatter setStateOfMatter(Fluid fluid) {
        return StateOfMatter.UNDEFINED;
    }


    public static Fluid createFluid(FluidName fluidName, Parameter knownParameter1, Parameter knownParameter2) {
        if (fluidName == FluidName.MOIST_AIR) return createAirAtAtmosphericPressure(knownParameter1, knownParameter2);
        Fluid fluid = new Fluid();
        fluid.setFluidName(fluidName);
        fluid.setFluidType(FluidType.GENERAL);
        fluid.setAbsolutePressure(FluidData.findParameter(ParameterType.PRESSURE, fluidName, knownParameter1, knownParameter2));
        fluid.setTemperature(FluidData.findParameter(ParameterType.TEMPERATURE, fluidName, knownParameter1, knownParameter2));
        fluid.setDensity(FluidData.findParameter(ParameterType.DENSITY, fluidName, knownParameter1, knownParameter2));
        fluid.setSpecificEnthalpy(FluidData.findParameter(ParameterType.SPECIFIC_ENTHALPY, fluidName, knownParameter1, knownParameter2));
        fluid.setHeatCapacity(FluidData.findParameter(ParameterType.HEAT_CAPACITY, fluidName, knownParameter1, knownParameter2));
        fluid.setSpecificEntropy(FluidData.findParameter(ParameterType.SPECIFIC_ENTROPY, fluidName, knownParameter1, knownParameter2));
        fluid.setSpecificVolume(fluid.getDensity().inverse());
        fluid.setQuality(FluidData.findParameter(ParameterType.QUALITY, fluidName, knownParameter1, knownParameter2));
        try {
            fluid.setGaugePressure(fluid.getAbsolutePressure().minus(UnitSystem.getActualUnitSystem().getAtmosphericPressure()));
        } catch (NullPointerException e) {
            fluid.setGaugePressure(fluid.getAbsolutePressure().minus(new Parameter(NonSI.BAR, 1)));
        }
        fluid.setAbsoluteTemperature(fluid.getTemperature());
        fluid.getAbsoluteTemperature().setActualUnit(SI.KELVIN.asType(Temperature.class));

        fluid.setStateOfMatter(setStateOfMatter(fluid));
        fluid.setCalculated(true);
        return fluid;
    }

    public static Air createAirAtAtmosphericPressure(Parameter<? extends AirQuantity> parameter1, Parameter<? extends AirQuantity> parameter2) {
        if (UnitSystem.getActualUnitSystem().getAtmosphericPressure() != null)
            return createAir(parameter1, parameter2, UnitSystem.getActualUnitSystem().getAtmosphericPressure());
        return createAir(parameter1, parameter2, new Parameter(NonSI.BAR, 1));

    }

    public static Air createAir(Parameter<? extends AirQuantity> knownParameter1, Parameter<? extends AirQuantity> knownParameter2, Parameter<? extends AirQuantity> knownParameter3) {
        Air air = new Air();
        air.setFluidName(FluidName.MOIST_AIR);
        air.setFluidType(FluidType.AIR);
        air.setAbsolutePressure(FluidData.findAirParameter(ParameterType.PRESSURE, knownParameter1, knownParameter2, knownParameter3));
        air.setTemperature(FluidData.findAirParameter(ParameterType.TEMPERATURE, knownParameter1, knownParameter2, knownParameter3));
        air.setDensity(FluidData.findAirParameter(ParameterType.DENSITY, knownParameter1, knownParameter2, knownParameter3));
        air.setSpecificEnthalpy(FluidData.findAirParameter(ParameterType.SPECIFIC_ENTHALPY, knownParameter1, knownParameter2, knownParameter3));
        air.setHeatCapacity(FluidData.findAirParameter(ParameterType.HEAT_CAPACITY, knownParameter1, knownParameter2, knownParameter3));
        air.setSpecificEntropy(FluidData.findAirParameter(ParameterType.SPECIFIC_ENTROPY, knownParameter1, knownParameter2, knownParameter3));
        air.setSpecificVolume(air.getDensity().inverse());
        air.setQuality(FluidData.findAirParameter(ParameterType.QUALITY, knownParameter1, knownParameter2, knownParameter3));
        try {
            air.setGaugePressure(air.getAbsolutePressure().minus(UnitSystem.getActualUnitSystem().getAtmosphericPressure()));
        } catch (NullPointerException e) {
            air.setGaugePressure(air.getAbsolutePressure().minus(new Parameter(NonSI.BAR, 1)));
        }
        air.setAbsoluteTemperature(air.getTemperature());
        air.getAbsoluteTemperature().setActualUnit(SI.KELVIN.asType(Temperature.class));
        air.setRelativeHumidity(FluidData.findAirParameter(ParameterType.RELATIVE_HUMIDITY, knownParameter1, knownParameter2, knownParameter3));
        air.setMoistureContent(FluidData.findAirParameter(ParameterType.MOISTURE_CONTENT, knownParameter1, knownParameter2, knownParameter3));
        air.setDewPointTemperature(FluidData.findAirParameter(ParameterType.DEW_POINT_TEMPERATURE, knownParameter1, knownParameter2, knownParameter3));
        air.setWetBulbTemperature(FluidData.findAirParameter(ParameterType.WET_BULB_TEMPERATURE, knownParameter1, knownParameter2, knownParameter3));

        air.setStateOfMatter(setStateOfMatter(air));
        air.setCalculated(true);
        return air;
    }
}
