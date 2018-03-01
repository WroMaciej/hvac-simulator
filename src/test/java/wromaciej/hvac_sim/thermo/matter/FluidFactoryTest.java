package wromaciej.hvac_sim.thermo.matter;

import wromaciej.hvac_sim.thermo.matter.fluids.*;
import wromaciej.hvac_sim.thermo.matter.model.fluids.*;

import static org.junit.jupiter.api.Assertions.*;

class FluidFactoryTest {

    static{
        //load library
        System.loadLibrary("CoolProp");
    }

    @org.junit.jupiter.api.Test
    void createGeneral() {
        Fluid generalFluid =new Fluid();
        generalFluid = FluidFactory.createGeneral(FluidName.WATER, FluidParameterType.PRESSURE,1, FluidParameterType.QUALITY,0);
        assertEquals(100, generalFluid.temperature.value,1); //water boiling point 99-101 im 1bar
    }

    @org.junit.jupiter.api.Test
    void createAir() {
        Air air=new Air();
        air= FluidFactory.createAir(FluidParameterType.TEMPERATURE,20, FluidParameterType.RELATIVE_HUMIDITY,0.5,0);
        assertEquals(0.0074,air.moistureContent.value,0.0001); //moisture content of air at 20C, 50% is 0.0074
    }
}