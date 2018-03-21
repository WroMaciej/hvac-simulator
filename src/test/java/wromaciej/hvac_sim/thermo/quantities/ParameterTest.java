package wromaciej.hvac_sim.thermo.quantities;

import org.junit.Test;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.quantities.base.EnergyFlow;
import wromaciej.hvac_sim.thermo.quantities.extensive.HeatFlow;
import wromaciej.hvac_sim.thermo.quantities.extensive.MassFlow;
import wromaciej.hvac_sim.thermo.quantities.specific.MoistureContent;
import wromaciej.hvac_sim.thermo.quantities.specific.SpecificEnthalpy;
import wromaciej.hvac_sim.thermo.quantities.specific.Temperature;
import wromaciej.hvac_sim.thermo.quantities.specific.TemperatureDifference;

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
    public void shouldReturn10kWHeatFlowForMassFlowTimesSpecificEnthalpy(){
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

    @Test
    public void shoudReturn10KelvinsFor5Ktimes2(){
        //GIVEN
        Parameter<TemperatureDifference> temperatureDifferenceDefinedAs5K= new Parameter(SI.KELVIN.asType(TemperatureDifference.class),5);
        Parameter<TemperatureDifference> temperatureDifferenceDefinedAs10K= new Parameter(SI.KELVIN.asType(TemperatureDifference.class),10);

        //WHEN
        Parameter<TemperatureDifference> temperatureDifferenceAfter2TimesMultiplication= temperatureDifferenceDefinedAs5K.times(2.0);

        //THEN
        assertEquals(temperatureDifferenceAfter2TimesMultiplication,temperatureDifferenceDefinedAs10K);

    }
}
