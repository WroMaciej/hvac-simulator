package wromaciej.hvac_sim.thermo.matter.fluids.service;

import wromaciej.hvac_sim.thermo.matter.fluids.model.Fluid;
import wromaciej.hvac_sim.thermo.matter.fluids.model.FluidType;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;

public class RealProcess {

    public static Fluid compression(Fluid fluid, Parameter endParameter, double efficiency){
        if (fluid.getFluidType() == FluidType.AIR) return FluidFactory.createAir(fluid.getTemperature(), endParameter, fluid.getAbsolutePressure());
        return FluidFactory.createFluid(fluid.getFluidName(), fluid.getTemperature(), endParameter);
    }

    public static Fluid expansion(Fluid fluid, Parameter endParameter, double efficiency){
        if (fluid.getFluidType() == FluidType.AIR) return FluidFactory.createAir(fluid.getTemperature(), endParameter, fluid.getAbsolutePressure());
        return FluidFactory.createFluid(fluid.getFluidName(), fluid.getTemperature(), endParameter);
    }

    public static Fluid throttling(Fluid fluid, Parameter endParameter){
        if (fluid.getFluidType() == FluidType.AIR) return FluidFactory.createAir(fluid.getTemperature(), endParameter, fluid.getAbsolutePressure());
        return FluidFactory.createFluid(fluid.getFluidName(), fluid.getTemperature(), endParameter);
    }

    public static Fluid throttling(Fluid fluid, Parameter endParameter){
        if (fluid.getFluidType() == FluidType.AIR) return FluidFactory.createAir(fluid.getTemperature(), endParameter, fluid.getAbsolutePressure());
        return FluidFactory.createFluid(fluid.getFluidName(), fluid.getTemperature(), endParameter);
    }
}
