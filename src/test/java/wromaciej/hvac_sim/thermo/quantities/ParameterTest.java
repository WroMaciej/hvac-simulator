package wromaciej.hvac_sim.thermo.quantities;

import org.junit.Test;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.quantities.specific.Pressure;
//import wromaciej.hvac_sim.thermo.quantities.specific.Pressure;

import javax.measure.unit.ProductUnit;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class ParameterTest {


    @Test
    public void unitConversionTest(){
        //GIVEN
        Unit<Pressure> pressureUnit= SI.PASCAL;

        //WHEN

        //THEN
    }

    @Test
    public void shouldReturnSameValueAfterUnitConversion(){
        //GIVEN
        Parameter<Pressure> pressureInPa;
        pressureInPa=new Parameter<>(SI.PASCAL, 1000);
        //WHEN
        Parameter<Pressure> pressureInBar;
        pressureInBar=new Parameter<>(SI.KILO(SI.PASCAL), 1);
        pressureInBar.setActualUnit((Unit)SI.PASCAL);
        //THEN
        assertEquals(pressureInPa.getValue(), pressureInBar.getValue(),1 );


    }
}
