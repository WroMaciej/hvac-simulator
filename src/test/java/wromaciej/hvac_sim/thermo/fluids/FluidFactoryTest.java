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
import javax.measure.unit.SI;

public class FluidFactoryTest {

    static {
        //load library
        FluidData.loadLibrary();
    }

    @Test
    public void shouldReturnFluidParametersAfterCreationInFactory() {
        Parameter<Temperature> temperature = new Parameter<>(ParameterType.TEMPERATURE, SI.CELSIUS.asType(Temperature.class), 20);
        Parameter<Pressure> pressure = new Parameter<>(ParameterType.PRESSURE, NonSI.BAR.asType(Pressure.class), 1.0);

        Fluid fluid = FluidFactory.createFluid(FluidName.WATER, temperature, pressure);

        System.out.println(fluid.getTemperature());
        System.out.println(fluid.getHeatCapacity());
    }

    @Test
    public void shouldReturnAirParametersAfterCreationInFactory() {
        Parameter<Temperature> temperature = new Parameter<>(ParameterType.TEMPERATURE, SI.CELSIUS.asType(Temperature.class), 20);
        Parameter<RelativeHumidity> relativeHumidity = new Parameter<>(ParameterType.RELATIVE_HUMIDITY, Dimensionless.UNIT.asType(RelativeHumidity.class), 0.5);
        Parameter<Pressure> pressure = new Parameter<>(ParameterType.AIR_PRESSURE, NonSI.BAR.asType(Pressure.class), 1);

        Air air = FluidFactory.createAir(temperature, relativeHumidity, pressure);

        System.out.println(air.getTemperature());
        System.out.println(air.getAbsolutePressure());

        System.out.println(air.getMoistureContent());
        System.out.println(air.getWetBulbTemperature());
        System.out.println(air.getDewPointTemperature());
    }
}
