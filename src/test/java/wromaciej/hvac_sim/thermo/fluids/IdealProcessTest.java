package wromaciej.hvac_sim.thermo.fluids;

import org.junit.Test;
import wromaciej.hvac_sim.thermo.matter.fluids.model.Fluid;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.FluidName;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.ParameterType;
import wromaciej.hvac_sim.thermo.matter.fluids.service.FluidData;
import wromaciej.hvac_sim.thermo.matter.fluids.service.FluidFactory;
import wromaciej.hvac_sim.thermo.matter.fluids.service.IdealProcess;
import wromaciej.hvac_sim.thermo.quantities.specific.Pressure;
import wromaciej.hvac_sim.thermo.quantities.specific.SpecificEnthalpy;
import wromaciej.hvac_sim.thermo.quantities.specific.Temperature;
import wromaciej.hvac_sim.thermo.quantities.specific.TemperatureDifference;

import javax.measure.unit.NonSI;
import javax.measure.unit.SI;

import static org.junit.Assert.assertEquals;

public class IdealProcessTest {



    @Test
    public void shouldReturnSameTemperatureDifferenceByIsobaricHeatingOfWaterAndEquationCalculation(){
        //GIVEN
        FluidData fluidData = new FluidData();
        fluidData.loadLibrary();
        FluidFactory fluidFactory= new FluidFactory(fluidData);
        IdealProcess idealProcess = new IdealProcess(fluidFactory);

        Parameter<Temperature> temperatureBeforeIsobaricProcess = new Parameter<>(ParameterType.TEMPERATURE, SI.CELSIUS.asType(Temperature.class), 20);
        Parameter<Temperature> temperatureAfterIsobaricProcess = new Parameter<>(ParameterType.TEMPERATURE, SI.CELSIUS.asType(Temperature.class), 50);
        Parameter<Pressure> pressure = new Parameter<>(ParameterType.PRESSURE, NonSI.BAR.asType(Pressure.class), 1.0);
        Fluid fluidBeforeProcess = fluidFactory.createFluid(FluidName.WATER, temperatureBeforeIsobaricProcess, pressure);
        //WHEN
        Fluid fluidAfterProcess = idealProcess.isobaric(fluidBeforeProcess, temperatureAfterIsobaricProcess);
        Parameter<TemperatureDifference> deltaTempDuringProcess= fluidAfterProcess.getTemperature().minus(fluidBeforeProcess.getTemperature());
        Parameter<SpecificEnthalpy> deltaEnthalpyDuringProcess = fluidAfterProcess.getSpecificEnthalpy().minus(fluidBeforeProcess.getSpecificEnthalpy());
        Parameter<Temperature> deltaTempDuringEnthalpyCalculation = deltaEnthalpyDuringProcess.divide(fluidAfterProcess.getHeatCapacity());

        //THEN
        assertEquals(deltaTempDuringEnthalpyCalculation.getValue(), deltaTempDuringProcess.getValue(), 0.1);




    }
}
