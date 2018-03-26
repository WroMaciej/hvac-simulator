package wromaciej.hvac_sim.thermo.matter.fluids.service;

import wromaciej.hvac_sim.thermo.matter.fluids.model.Air;
import wromaciej.hvac_sim.thermo.matter.fluids.model.Fluid;
import wromaciej.hvac_sim.thermo.matter.fluids.model.FluidType;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.*;
import wromaciej.hvac_sim.thermo.quantities.base.AirQuantity;
import wromaciej.hvac_sim.thermo.unitSystems.UnitSystem;

public abstract class FluidFactory {

    public static StateOfMatter setStateOfMatter(Fluid fluid){
        return StateOfMatter.UNDEFINED;
    }


    public static Fluid createFluid(FluidName fluidName, Parameter knownParameter1, Parameter knownParameter2) {
        if (fluidName==FluidName.MOIST_AIR) return createAirAtAtmospericPressure(knownParameter1, knownParameter2);
        Fluid fluid = new Fluid();
        fluid.setFluidName(fluidName);
        fluid.setFluidType(FluidType.GENERAL);
        fluid.setAbsolutePressure(ParametersData.findParameter(ParameterType.PRESSURE, fluidName, knownParameter1, knownParameter2) );
        fluid.setTemperature(ParametersData.findParameter(ParameterType.TEMPERATURE, fluidName, knownParameter1, knownParameter2));
        fluid.setDensity(ParametersData.findParameter(ParameterType.DENSITY, fluidName, knownParameter1, knownParameter2));
        fluid.setSpecificEnthalpy(ParametersData.findParameter(ParameterType.SPECIFIC_ENTHALPY, fluidName, knownParameter1, knownParameter2));
        fluid.setHeatCapacity(ParametersData.findParameter(ParameterType.HEAT_CAPACITY, fluidName, knownParameter1, knownParameter2));
        fluid.setSpecificEntropy(ParametersData.findParameter(ParameterType.SPECIFIC_ENTROPY, fluidName, knownParameter1, knownParameter2));
        fluid.setSpecificVolume(fluid.getDensity().inverse());

        fluid.setQuality(ParametersData.findParameter(ParameterType.QUALITY, fluidName, knownParameter1, knownParameter2));

        fluid.setGaugePressure(fluid.getAbsolutePressure().minus(UnitSystem.getActualUnitSystem().getAtmosphericPressure()));
        fluid.setAbsoluteTemperature();

        fluid.setStateOfMatter(setStateOfMatter(fluid));


        fluid.setCalculated(true);
        return fluid;
    }

    public static Air createAirAtAtmospericPressure(Parameter<? extends AirQuantity> parameter1, Parameter<? extends AirQuantity> parameter2){
        return createAir(parameter1, parameter2, UnitSystem.getActualUnitSystem().getAtmosphericPressure());
    }

    public static Air createAir(Parameter<? extends AirQuantity> parameter1, Parameter<? extends AirQuantity> parameter2, Parameter<? extends AirQuantity> parameter3){
        Air air= new Air();
        air.setFluidName(FluidName.MOIST_AIR);


        return air;
    }
}
