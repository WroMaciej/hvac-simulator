package wromaciej.hvac_sim.thermo.quantities;

import org.junit.Test;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.quantities.specific.AirPressureDifference;
import wromaciej.hvac_sim.thermo.quantities.specific.SpecificEnthalpy;

import javax.measure.unit.Unit;

import static org.junit.Assert.assertThat;

public class ParameterTest {

    @Test
    public void shouldReturn1ForAirPressureDifferenceID(){
        Parameter<AirPressureDifference> airPressureDifference=new Parameter<>();
        System.out.println(SpecificEnthalpy.class.toString());
        //assertThat(,);


    }
}
