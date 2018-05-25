package wromaciej.hvac_sim.simulation.thermo.matter.fluids.service.processes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wromaciej.hvac_sim.simulation.thermo.matter.fluids.model.Fluid;
import wromaciej.hvac_sim.simulation.thermo.matter.fluids.model.MatterType;
import wromaciej.hvac_sim.simulation.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.simulation.thermo.matter.fluids.model.FluidFactory;

@Service
public class IdealProcess {

    private FluidFactory fluidFactory;

    public IdealProcess(FluidFactory fluidFactory) {
        this.fluidFactory = fluidFactory;
    }

    /**
     * Isothermal process
     */
    public Fluid sameTemperature(Fluid fluid, Parameter endParameter){
        if (fluid.getMatterType() == MatterType.AIR) return fluidFactory.createAir(fluid.getTemperature(), endParameter, fluid.getAbsolutePressure());
        return fluidFactory.createFluid(fluid.getFluidName(), fluid.getTemperature(), endParameter);
    }
    /**
     * Isobaric process
     */
    public Fluid samePressure(Fluid fluid, Parameter endParameter){
        if (fluid.getMatterType() == MatterType.AIR) return fluidFactory.createAir(fluid.getAbsolutePressure(), endParameter, fluid.getAbsolutePressure());
        return fluidFactory.createFluid(fluid.getFluidName(), fluid.getAbsolutePressure(), endParameter);
    }
    /**
     * Isochoric process
     */
    public Fluid sameVolume(Fluid fluid, Parameter endParameter){
        if (fluid.getMatterType() == MatterType.AIR) return fluidFactory.createAir(fluid.getSpecificVolume(), endParameter, fluid.getAbsolutePressure());
        return fluidFactory.createFluid(fluid.getFluidName(), fluid.getSpecificVolume(), endParameter);
    }
    /**
     * Isentropic process
     */
    public Fluid sameEntropy(Fluid fluid, Parameter endParameter){
        if (fluid.getMatterType() == MatterType.AIR) return fluidFactory.createAir(fluid.getSpecificEntropy(), endParameter, fluid.getAbsolutePressure());
        return fluidFactory.createFluid(fluid.getFluidName(), fluid.getSpecificEntropy(), endParameter);
    }
    /**
     * Isenthalpic process
     */
    public Fluid sameEnthalpy(Fluid fluid, Parameter endParameter){
        if (fluid.getMatterType() == MatterType.AIR) return fluidFactory.createAir(fluid.getSpecificEnthalpy(), endParameter, fluid.getAbsolutePressure());
        return fluidFactory.createFluid(fluid.getFluidName(), fluid.getSpecificEnthalpy(), endParameter);
    }
}
