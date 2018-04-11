package wromaciej.hvac_sim.thermo.matter.fluids.service;

import wromaciej.hvac_sim.thermo.matter.fluids.model.Fluid;
import wromaciej.hvac_sim.thermo.matter.fluids.model.FluidType;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;

public class IdealProcess {

    private FluidFactory fluidFactory;

    public IdealProcess(FluidFactory fluidFactory) {
        this.fluidFactory = fluidFactory;
    }

    public Fluid isoThermal(Fluid fluid, Parameter endParameter){
        if (fluid.getFluidType() == FluidType.AIR) return fluidFactory.createAir(fluid.getTemperature(), endParameter, fluid.getAbsolutePressure());
        return fluidFactory.createFluid(fluid.getFluidName(), fluid.getTemperature(), endParameter);
    }

    public Fluid isoBaric(Fluid fluid, Parameter endParameter){
        if (fluid.getFluidType() == FluidType.AIR) return fluidFactory.createAir(fluid.getAbsolutePressure(), endParameter, fluid.getAbsolutePressure());
        return fluidFactory.createFluid(fluid.getFluidName(), fluid.getAbsolutePressure(), endParameter);
    }

    public Fluid isoChoric(Fluid fluid, Parameter endParameter){
        if (fluid.getFluidType() == FluidType.AIR) return fluidFactory.createAir(fluid.getSpecificVolume(), endParameter, fluid.getAbsolutePressure());
        return fluidFactory.createFluid(fluid.getFluidName(), fluid.getSpecificVolume(), endParameter);
    }

    public Fluid isEntropic(Fluid fluid, Parameter endParameter){
        if (fluid.getFluidType() == FluidType.AIR) return fluidFactory.createAir(fluid.getSpecificEntropy(), endParameter, fluid.getAbsolutePressure());
        return fluidFactory.createFluid(fluid.getFluidName(), fluid.getSpecificEntropy(), endParameter);
    }

    public Fluid isEnthalpic(Fluid fluid, Parameter endParameter){
        if (fluid.getFluidType() == FluidType.AIR) return fluidFactory.createAir(fluid.getSpecificEnthalpy(), endParameter, fluid.getAbsolutePressure());
        return fluidFactory.createFluid(fluid.getFluidName(), fluid.getSpecificEnthalpy(), endParameter);
    }
}
