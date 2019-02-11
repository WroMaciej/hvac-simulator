package wromaciej.hvac_sim.simulation.thermo.fluids;

import static org.junit.Assert.assertEquals;

import javax.measure.unit.NonSI;
import javax.measure.unit.SI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import wromaciej.hvac_sim.simulation.thermo.matter.fluids.model.Fluid;
import wromaciej.hvac_sim.simulation.thermo.matter.fluids.model.FluidFactory;
import wromaciej.hvac_sim.simulation.thermo.matter.fluids.model.FluidName;
import wromaciej.hvac_sim.simulation.thermo.matter.fluids.service.processes.IdealProcess;
import wromaciej.hvac_sim.simulation.thermo.parameters.Parameter;
import wromaciej.hvac_sim.simulation.thermo.parameters.ParameterType;
import wromaciej.hvac_sim.simulation.thermo.quantities.specific.Pressure;
import wromaciej.hvac_sim.simulation.thermo.quantities.specific.SpecificEnthalpy;
import wromaciej.hvac_sim.simulation.thermo.quantities.specific.Temperature;
import wromaciej.hvac_sim.simulation.thermo.quantities.specific.TemperatureDifference;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IdealProcessTest {

	
	FluidFactory fluidFactory;
	
	@Autowired
	IdealProcess idealProcess;

    @Test
    public void shouldReturnSameTemperatureDifferenceByIsobaricHeatingOfWaterAndEquationCalculation(){
        //GIVEN
//        FluidData fluidData = new FluidData(true);
//        FluidSolver fluidSolver = new FluidSolver(fluidSetter);
//        IdealProcess idealProcess = new IdealProcess(fluidFactory);

        Parameter<Temperature> temperatureBeforeIsobaricProcess = new Parameter<>(ParameterType.TEMPERATURE, SI.CELSIUS.asType(Temperature.class), 20);
        Parameter<Temperature> temperatureAfterIsobaricProcess = new Parameter<>(ParameterType.TEMPERATURE, SI.CELSIUS.asType(Temperature.class), 50);
        Parameter<Pressure> pressure = new Parameter<>(ParameterType.PRESSURE, NonSI.BAR.asType(Pressure.class), 1.0);
        Fluid fluidBeforeProcess = fluidFactory.createFluid(FluidName.WATER, temperatureBeforeIsobaricProcess, pressure);
        //WHEN
        Fluid fluidAfterProcess = idealProcess.samePressure(fluidBeforeProcess, temperatureAfterIsobaricProcess);
        Parameter<TemperatureDifference> deltaTempDuringProcess= fluidAfterProcess.getTemperature().minus(fluidBeforeProcess.getTemperature());
        Parameter<SpecificEnthalpy> deltaEnthalpyDuringProcess = fluidAfterProcess.getSpecificEnthalpy().minus(fluidBeforeProcess.getSpecificEnthalpy());
        Parameter<Temperature> deltaTempDuringEnthalpyCalculation = deltaEnthalpyDuringProcess.divide(fluidAfterProcess.getHeatCapacity());

        //THEN
        assertEquals(deltaTempDuringEnthalpyCalculation.getValue(), deltaTempDuringProcess.getValue(), 0.1);




    }
}
