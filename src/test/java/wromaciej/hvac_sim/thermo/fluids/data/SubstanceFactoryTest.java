package wromaciej.hvac_sim.thermo.fluids.data;

import static org.junit.jupiter.api.Assertions.*;

class SubstanceFactoryTest {

    static{
        //load library
        System.loadLibrary("CoolProp");
    }

    @org.junit.jupiter.api.Test
    void createGeneral() {
        Substance generalSubstance=new Substance();
        generalSubstance=SubstanceFactory.createGeneral(SubstanceName.WATER,SubstanceParameterType.PRESSURE,1,SubstanceParameterType.QUALITY,0);
        assertEquals(100,generalSubstance.temperature.value,1); //water boiling point 99-101 im 1bar
    }

    @org.junit.jupiter.api.Test
    void createAir() {
        Air air=new Air();
        air=SubstanceFactory.createAir(SubstanceParameterType.TEMPERATURE,20,SubstanceParameterType.RELATIVE_HUMIDITY,0.5,0);
        assertEquals(0.0074,air.moistureContent.value,0.0001); //moisture content of air at 20C, 50% is 0.0074
    }
}