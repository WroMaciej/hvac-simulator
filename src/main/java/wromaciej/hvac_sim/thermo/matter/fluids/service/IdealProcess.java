package wromaciej.hvac_sim.thermo.matter.fluids.service;

import wromaciej.hvac_sim.thermo.matter.fluids.model.Air;
import wromaciej.hvac_sim.thermo.matter.fluids.model.Fluid;
import wromaciej.hvac_sim.thermo.matter.fluids.model.FluidType;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;

public abstract class IdealProcess {

    public static Fluid isoThermal(Fluid fluid, Parameter endParameter){
        if (fluid.getFluidType() == FluidType.AIR) return FluidFactory.createAir(fluid.getTemperature(), endParameter, fluid.getAbsolutePressure());
        return FluidFactory.createFluid(fluid.getFluidName(), fluid.getTemperature(), endParameter);
    }

    public static Fluid isoBaric(Fluid fluid, Parameter endParameter){
        if (fluid.getFluidType() == FluidType.AIR) return FluidFactory.createAir(fluid.getAbsolutePressure(), endParameter, fluid.getAbsolutePressure());
        return FluidFactory.createFluid(fluid.getFluidName(), fluid.getAbsolutePressure(), endParameter);
    }

    public static Fluid isoChoric(Fluid fluid, Parameter endParameter){
        if (fluid.getFluidType() == FluidType.AIR) return FluidFactory.createAir(fluid.getSpecificVolume(), endParameter, fluid.getAbsolutePressure());
        return FluidFactory.createFluid(fluid.getFluidName(), fluid.getSpecificVolume(), endParameter);
    }

    public static Fluid isEntropic(Fluid fluid, Parameter endParameter){
        if (fluid.getFluidType() == FluidType.AIR) return FluidFactory.createAir(fluid.getSpecificEntropy(), endParameter, fluid.getAbsolutePressure());
        return FluidFactory.createFluid(fluid.getFluidName(), fluid.getSpecificEntropy(), endParameter);
    }
}
