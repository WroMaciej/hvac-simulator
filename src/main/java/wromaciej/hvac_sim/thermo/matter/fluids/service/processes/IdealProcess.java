package wromaciej.hvac_sim.thermo.matter.fluids.service.processes;

import wromaciej.hvac_sim.thermo.matter.fluids.model.Fluid;
import wromaciej.hvac_sim.thermo.matter.fluids.model.MatterType;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.matter.fluids.model.FluidFactory;

public class IdealProcess {

    private FluidFactory fluidFactory;

    public IdealProcess(FluidFactory fluidFactory) {
        this.fluidFactory = fluidFactory;
    }

    public Fluid isothermal(Fluid fluid, Parameter endParameter){
        if (fluid.getMatterType() == MatterType.AIR) return fluidFactory.createAir(fluid.getTemperature(), endParameter, fluid.getAbsolutePressure());
        return fluidFactory.createFluid(fluid.getFluidName(), fluid.getTemperature(), endParameter);
    }

    public Fluid isobaric(Fluid fluid, Parameter endParameter){
        if (fluid.getMatterType() == MatterType.AIR) return fluidFactory.createAir(fluid.getAbsolutePressure(), endParameter, fluid.getAbsolutePressure());
        return fluidFactory.createFluid(fluid.getFluidName(), fluid.getAbsolutePressure(), endParameter);
    }

    public Fluid isochoric(Fluid fluid, Parameter endParameter){
        if (fluid.getMatterType() == MatterType.AIR) return fluidFactory.createAir(fluid.getSpecificVolume(), endParameter, fluid.getAbsolutePressure());
        return fluidFactory.createFluid(fluid.getFluidName(), fluid.getSpecificVolume(), endParameter);
    }

    public Fluid isentropic(Fluid fluid, Parameter endParameter){
        if (fluid.getMatterType() == MatterType.AIR) return fluidFactory.createAir(fluid.getSpecificEntropy(), endParameter, fluid.getAbsolutePressure());
        return fluidFactory.createFluid(fluid.getFluidName(), fluid.getSpecificEntropy(), endParameter);
    }

    public Fluid isenthalpic(Fluid fluid, Parameter endParameter){
        if (fluid.getMatterType() == MatterType.AIR) return fluidFactory.createAir(fluid.getSpecificEnthalpy(), endParameter, fluid.getAbsolutePressure());
        return fluidFactory.createFluid(fluid.getFluidName(), fluid.getSpecificEnthalpy(), endParameter);
    }
}
