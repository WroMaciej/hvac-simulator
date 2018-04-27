package wromaciej.hvac_sim.thermo.solvers;

import org.junit.Test;
import wromaciej.hvac_sim.solver.matterSolvers.FluidDefinition;
import wromaciej.hvac_sim.solver.matterSolvers.FluidSolver;
import wromaciej.hvac_sim.thermo.matter.fluids.model.Fluid;
import wromaciej.hvac_sim.thermo.matter.fluids.model.FluidFactory;
import wromaciej.hvac_sim.thermo.matter.fluids.model.FluidName;
import wromaciej.hvac_sim.thermo.matter.fluids.model.MatterType;
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
        Fluid water; //= new Fluid();
        Parameter<Temperature> temperature = new Parameter(ParameterType.TEMPERATURE, SI.CELSIUS.asType(Temperature.class), 20);
        Parameter<Pressure> pressure = new Parameter(ParameterType.PRESSURE, NonSI.BAR.asType(Pressure.class), 1);
        FluidDefinition fluidDefinition = new FluidDefinition(FluidName.WATER, MatterType.GENERAL_FLUID, temperature, pressure);
        FluidSolver fluidSolver = new FluidSolver(fluidDefinition, fluidFactory);

        water = fluidSolver.solve();

        System.out.println(water);
        System.out.println(fluidSolver.getSolverResultType());
    }

    @Test
    public void shouldReturnWaterFromFluid(){
        FluidData fluidData = new FluidData(true);
        FluidFactory fluidFactory = new FluidFactory(fluidData);
        Fluid water = new Fluid();
        Parameter<Temperature> temperature = new Parameter(ParameterType.TEMPERATURE, SI.CELSIUS.asType(Temperature.class), 20);
        Parameter<Pressure> pressure = new Parameter(ParameterType.PRESSURE, NonSI.BAR.asType(Pressure.class), 1);
        water.fluidDefinition = new FluidDefinition(FluidName.WATER, MatterType.GENERAL_FLUID, temperature, pressure);
        FluidSolver fluidSolver = new FluidSolver(water.fluidDefinition, fluidFactory);

        water = fluidSolver.solve();

        System.out.println(water);
        System.out.println(fluidSolver.getSolverResultType());
    }
}
