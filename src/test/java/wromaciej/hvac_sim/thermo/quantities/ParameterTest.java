package wromaciej.hvac_sim.thermo.quantities;

import org.junit.Test;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.quantities.specific.Pressure;
import wromaciej.hvac_sim.thermo.quantities.specific.SpecificEnthalpy;
import wromaciej.hvac_sim.thermo.quantities.specific.Temperature;

import javax.measure.quantity.Acceleration;
import javax.measure.quantity.Velocity;
import javax.measure.unit.AlternateUnit;
import javax.measure.unit.ProductUnit;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

import static javax.measure.unit.SI.KELVIN;
import static javax.measure.unit.SI.SECOND;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class ParameterTest {


    @Test
    public void unitConversionTest(){
        //GIVEN
        //Unit<Velocity> velocityUnit= SI.METER.divide(SI.SECOND).asType(Velocity.class);

        Unit<?> anyUnit = SI.KILO(SI.JOULE).divide(SI.KILOGRAM);

        Unit<SpecificEnthalpy> specificEnthalpyUnit = anyUnit.asType(SpecificEnthalpy.class);

        //Unit<Temperature> unitTest= new ProductUnit(KELVIN);



        Parameter<SpecificEnthalpy> specificEnthalpy= new Parameter(new ProductUnit(SI.JOULE.divide(SI.METER)) ,20.0);

        //WHEN

        //THEN
    }

    @Test
    public void shouldReturnSameValueAfterUnitConversion(){
//        //GIVEN
//        Parameter<Pressure> pressureInPa;
//        pressureInPa=new Parameter<>(SI.PASCAL, 1000);
//        //WHEN
//        Parameter<Pressure> pressureInBar;
//        pressureInBar=new Parameter<>(SI.KILO(SI.PASCAL), 1);
//        //pressureInBar.setActualUnit(SI.PASCAL);
//        //THEN
//        assertEquals(pressureInPa.getValue(), pressureInBar.getValue(),1 );


    }
}
