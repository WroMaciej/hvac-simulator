package wromaciej.hvac_sim.thermo.matter.fluids.model;

import wromaciej.hvac_sim.solver.fluidSolvers.FluidDefinition;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.ParameterType;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.StateOfMatter;
import wromaciej.hvac_sim.thermo.matter.fluids.service.FluidData;
import wromaciej.hvac_sim.thermo.quantities.base.AirQuantity;
import wromaciej.hvac_sim.thermo.quantities.specific.Quality;
import wromaciej.hvac_sim.thermo.quantities.specific.Temperature;
import wromaciej.hvac_sim.thermo.unitSystems.UnitSystem;

import javax.measure.unit.NonSI;
import javax.measure.unit.SI;

public class FluidSetter {
    private final FluidData fluidData;

    public FluidSetter(FluidData fluidData) {
        this.fluidData = fluidData;
    }

    public StateOfMatter setStateOfMatter(Fluid fluid) {
        return StateOfMatter.UNDEFINED;
    }



    public void changeFluidState(Fluid fluid, FluidName fluidName, Parameter knownParameter1, Parameter knownParameter2) {
        if (fluidName == FluidName.MOIST_AIR)  changeAirStateAtAtmosphericPressure((Air) fluid, knownParameter1, knownParameter2);
        else{
            fluid.setFluidName(fluidName);
            fluid.setFluidType(FluidType.GENERAL);
            fluid.setAbsolutePressure(fluidData.findParameter(ParameterType.PRESSURE, fluidName, knownParameter1, knownParameter2));
            fluid.setTemperature(fluidData.findParameter(ParameterType.TEMPERATURE, fluidName, knownParameter1, knownParameter2));
            fluid.setDensity(fluidData.findParameter(ParameterType.DENSITY, fluidName, knownParameter1, knownParameter2));
            fluid.setSpecificEnthalpy(fluidData.findParameter(ParameterType.SPECIFIC_ENTHALPY, fluidName, knownParameter1, knownParameter2));
            fluid.setHeatCapacity(fluidData.findParameter(ParameterType.HEAT_CAPACITY, fluidName, knownParameter1, knownParameter2));
            fluid.setSpecificEntropy(fluidData.findParameter(ParameterType.SPECIFIC_ENTROPY, fluidName, knownParameter1, knownParameter2));
            fluid.setSpecificVolume(fluid.getDensity().inverse());
            fluid.setQuality(fluidData.findParameter(ParameterType.QUALITY, fluidName, knownParameter1, knownParameter2));
            if (UnitSystem.getActualUnitSystem() != null)
                fluid.setGaugePressure(fluid.getAbsolutePressure().minus(UnitSystem.getActualUnitSystem().getAtmosphericPressure()));
            else
                fluid.setGaugePressure(fluid.getAbsolutePressure().minus(new Parameter(NonSI.BAR, 1)));

            fluid.setAbsoluteTemperature(fluid.getTemperature());
            fluid.getAbsoluteTemperature().setActualUnit(SI.KELVIN.asType(Temperature.class));

            fluid.setStateOfMatter(setStateOfMatter(fluid));
            fluid.fluidDefinition = new FluidDefinition(fluidName, fluid.getFluidType(), knownParameter1, knownParameter2);
            fluid.updateParameters();
        }
    }

    public void changeAirStateAtAtmosphericPressure(Air air, Parameter<? extends AirQuantity> parameter1, Parameter<? extends AirQuantity> parameter2) {
        if (UnitSystem.getActualUnitSystem().getAtmosphericPressure() != null)
            changeAirState(air, parameter1, parameter2, UnitSystem.getActualUnitSystem().getAtmosphericPressure());
        else changeAirState(air, parameter1, parameter2, new Parameter(NonSI.BAR, 1));

    }

    public void changeAirState(Air air, Parameter<? extends AirQuantity> knownParameter1, Parameter<? extends AirQuantity> knownParameter2, Parameter<? extends AirQuantity> knownParameter3) {
        air.setFluidName(FluidName.MOIST_AIR);
        air.setFluidType(FluidType.AIR);
        air.setAbsolutePressure(fluidData.findAirParameter(ParameterType.AIR_PRESSURE, knownParameter1, knownParameter2, knownParameter3));
        air.setTemperature(fluidData.findAirParameter(ParameterType.TEMPERATURE, knownParameter1, knownParameter2, knownParameter3));
        air.setSpecificVolume(fluidData.findAirParameter(ParameterType.AIR_SPECIFIC_VOLUME, knownParameter1, knownParameter2, knownParameter3));
        air.setDensity(air.getSpecificVolume().inverse());
        air.setSpecificEnthalpy(fluidData.findAirParameter(ParameterType.SPECIFIC_ENTHALPY, knownParameter1, knownParameter2, knownParameter3));
        air.setHeatCapacity(fluidData.findAirParameter(ParameterType.HEAT_CAPACITY, knownParameter1, knownParameter2, knownParameter3));
        air.setSpecificEntropy(fluidData.findAirParameter(ParameterType.SPECIFIC_ENTROPY, knownParameter1, knownParameter2, knownParameter3));

        air.setQuality(new Parameter<>(Quality.UNIT, 1.0));
        try {
            air.setGaugePressure(air.getAbsolutePressure().minus(UnitSystem.getActualUnitSystem().getAtmosphericPressure()));
        } catch (NullPointerException e) {
            air.setGaugePressure(air.getAbsolutePressure().minus(new Parameter(NonSI.BAR, 1)));
        }
        air.setAbsoluteTemperature(air.getTemperature());
        air.getAbsoluteTemperature().setActualUnit(SI.KELVIN.asType(Temperature.class));
        air.setRelativeHumidity(fluidData.findAirParameter(ParameterType.AIR_RELATIVE_HUMIDITY, knownParameter1, knownParameter2, knownParameter3));
        air.setMoistureContent(fluidData.findAirParameter(ParameterType.AIR_MOISTURE_CONTENT, knownParameter1, knownParameter2, knownParameter3));
        air.setDewPointTemperature(fluidData.findAirParameter(ParameterType.AIR_DEW_POINT_TEMPERATURE, knownParameter1, knownParameter2, knownParameter3));
        air.setWetBulbTemperature(fluidData.findAirParameter(ParameterType.AIR_WET_BULB_TEMPERATURE, knownParameter1, knownParameter2, knownParameter3));
        air.setWaterFraction(air.getMoistureContent().divide(Parameter.ONE.plus(air.getMoistureContent())));
        air.setWaterPartialPressure(fluidData.findAirParameter(ParameterType.AIR_WATER_PARTIAL_PRESSURE, knownParameter1, knownParameter2, knownParameter3));

        air.setStateOfMatter(setStateOfMatter(air));

        air.fluidDefinition = new FluidDefinition(air.getFluidName(), air.getFluidType(), knownParameter1, knownParameter2, knownParameter3);
        air.updateParameters();
    }
}
