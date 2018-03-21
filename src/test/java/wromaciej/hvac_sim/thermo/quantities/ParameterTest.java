package wromaciej.hvac_sim.thermo.quantities;

import org.junit.Test;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.quantities.base.EnergyFlow;
import wromaciej.hvac_sim.thermo.quantities.extensive.HeatFlow;
import wromaciej.hvac_sim.thermo.quantities.extensive.MassFlow;
import wromaciej.hvac_sim.thermo.quantities.specific.MoistureContent;
import wromaciej.hvac_sim.thermo.quantities.specific.SpecificEnthalpy;

import javax.measure.quantity.Energy;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;
import static org.junit.Assert.assertEquals;


public class ParameterTest {


    @Test
    public void shouldReturnTrueForEqualityOfSameParametersDiffersOnlyInUnit(){
        //GIVEN
        Unit<SpecificEnthalpy> joulePerKilogram = SI.JOULE.divide(SI.KILOGRAM).asType(SpecificEnthalpy.class);
        Unit<SpecificEnthalpy> kiloJoulePerKilogram = SI.KILO(SI.JOULE).divide(SI.KILOGRAM).asType(SpecificEnthalpy.class);

        //WHEN
        Parameter<SpecificEnthalpy> specificEnthalpyJoule= new Parameter(joulePerKilogram ,1000.0);
        Parameter<SpecificEnthalpy> specificEnthalpyKiloJoule = new Parameter(kiloJoulePerKilogram, 1.0);

        //THEN
        assertEquals(specificEnthalpyJoule,specificEnthalpyKiloJoule);
    }

    @Test
    public void shouldReturnHeatFlowForMassFlowTimesSpecificEnthalpy(){
        //GIVEN
        Unit<SpecificEnthalpy> kiloJoulePerKilogram = SI.KILO(SI.JOULE).divide(SI.KILOGRAM).asType(SpecificEnthalpy.class);
        Unit<MassFlow> kilogramPerSecond= SI.KILOGRAM.divide(SI.SECOND).asType(MassFlow.class);
        Parameter<SpecificEnthalpy> specificEnthalpy = new Parameter(kiloJoulePerKilogram, 5.0);
        Parameter<MassFlow> massFlow = new Parameter<>(kilogramPerSecond, 2.0);

        Unit<HeatFlow> wattUnit= SI.WATT.asType(HeatFlow.class);
        Parameter<HeatFlow> definedHeatFlow=new Parameter<>(wattUnit, 10000);

        //WHEN
        Parameter<HeatFlow> resultingHeatFlow;
        resultingHeatFlow = specificEnthalpy.times(massFlow);

        //THEN
        assertEquals(resultingHeatFlow, definedHeatFlow);
    }
}
