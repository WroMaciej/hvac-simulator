package wromaciej.hvac_sim.thermo.solvers;

import org.junit.Test;
import wromaciej.hvac_sim.solver.FluidSolver;
import wromaciej.hvac_sim.thermo.matter.fluids.fluid.Fluid;
import wromaciej.hvac_sim.thermo.matter.fluids.fluid.FluidFactory;
import wromaciej.hvac_sim.thermo.matter.fluids.model.FluidName;
import wromaciej.hvac_sim.thermo.matter.fluids.model.FluidType;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.ParameterType;
import wromaciej.hvac_sim.thermo.matter.fluids.service.FluidData;
import wromaciej.hvac_sim.thermo.quantities.specific.Pressure;
import wromaciej.hvac_sim.thermo.quantities.specific.Temperature;

import javax.measure.unit.NonSI;
import javax.measure.unit.SI;

public class FluidSolverTest {

    @Test
    public void shouldReturnWaterForTemperatureAndPressure(){
        FluidData fluidData = new FluidData(true);
        FluidFactory fluidFactory = new FluidFactory(fluidData);
        Fluid water = new Fluid(fluidFactory);
        Parameter<Temperature> temperature = new Parameter(ParameterType.TEMPERATURE, SI.CELSIUS.asType(Temperature.class), 20);
        Parameter<Pressure> pressure = new Parameter(ParameterType.PRESSURE, NonSI.BAR.asType(Pressure.class), 1);
        FluidSolver fluidSolver = new FluidSolver(FluidName.WATER, FluidType.GENERAL, temperature, pressure);
        //fluidSolver.solve(water, fluidFactory);

        water.fluidSolver=fluidSolver;
        water.fluidSolver.solve(water, fluidFactory);

        System.out.println(water);
    }
}
