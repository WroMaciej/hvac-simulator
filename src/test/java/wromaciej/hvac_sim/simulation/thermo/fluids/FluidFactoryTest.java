package wromaciej.hvac_sim.thermo.fluids;

import org.junit.Test;
import wromaciej.hvac_sim.thermo.matter.fluids.model.Air;
import wromaciej.hvac_sim.thermo.matter.fluids.model.Fluid;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.FluidName;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.ParameterType;
import wromaciej.hvac_sim.thermo.matter.fluids.service.FluidData;
import wromaciej.hvac_sim.thermo.matter.fluids.service.FluidFactory;
import wromaciej.hvac_sim.thermo.quantities.specific.Pressure;
import wromaciej.hvac_sim.thermo.quantities.specific.RelativeHumidity;
import wromaciej.hvac_sim.thermo.quantities.specific.Temperature;

import javax.measure.quantity.Dimensionless;
import javax.measure.unit.NonSI;
import javax.measure.unit.ProductUnit;
import javax.measure.unit.SI;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class FluidFactoryTest {


    @Test
    public void shouldReturnAbout4200JperkgKForStandardWaterHeatCapacity() {
        //GIVEN
        FluidData fluidData = new FluidData();
        fluidData.loadLibrary();
        FluidFactory fluidFactory= new FluidFactory(fluidData);
        Parameter<Temperature> temperature = new Parameter<>(ParameterType.TEMPERATURE, SI.CELSIUS.asType(Temperature.class), 20);
        Parameter<Pressure> pressure = new Parameter<>(ParameterType.PRESSURE, NonSI.BAR.asType(Pressure.class), 1.0);
        //WHEN
        Fluid fluid = fluidFactory.createFluid(FluidName.WATER, temperature, pressure);
        fluid.getHeatCapacity().setActualUnit(new ProductUnit<>(SI.JOULE.divide(SI.KILOGRAM.times(SI.KELVIN))));

        //THEN
        assertEquals(fluid.getHeatCapacity().getValue(),4200, 100);
    }

    @Test
    public void shouldReturn74gPerKgForStandardAir() {
        //GIVEN
        FluidData fluidData = new FluidData();
        fluidData.loadLibrary();
        FluidFactory fluidFactory= new FluidFactory(fluidData);
        Parameter<Temperature> temperature = new Parameter<>(ParameterType.TEMPERATURE, SI.CELSIUS.asType(Temperature.class), 20);
        Parameter<RelativeHumidity> relativeHumidity = new Parameter<>(ParameterType.AIR_RELATIVE_HUMIDITY, Dimensionless.UNIT.asType(RelativeHumidity.class), 0.5);
        Parameter<Pressure> pressure = new Parameter<>(ParameterType.AIR_PRESSURE, NonSI.BAR.asType(Pressure.class), 1);
        //WHEN
        Air air = fluidFactory.createAir(temperature, relativeHumidity, pressure);
        //THEN
        assertEquals(air.getMoistureContent().getValue(),0.0074, 0.0001);


    }
}
