package wromaciej.hvac_sim.thermo.quantities;

import org.junit.Test;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.quantities.extensive.HeatFlow;
import wromaciej.hvac_sim.thermo.quantities.extensive.MassFlow;
import wromaciej.hvac_sim.thermo.quantities.extensive.Power;
import wromaciej.hvac_sim.thermo.quantities.extensive.VolumeFlow;
import wromaciej.hvac_sim.thermo.quantities.specific.*;

import javax.measure.unit.SI;
import javax.measure.unit.Unit;

import static org.junit.Assert.assertEquals;


public class ParameterTest {


    @Test
    public void shouldReturnTrueForEqualityOfSameParametersDiffersOnlyInUnit() {
        //GIVEN
        Unit<SpecificEnthalpy> joulePerKilogram = SI.JOULE.divide(SI.KILOGRAM).asType(SpecificEnthalpy.class);
        Unit<SpecificEnthalpy> kiloJoulePerKilogram = SI.KILO(SI.JOULE).divide(SI.KILOGRAM).asType(SpecificEnthalpy.class);
        //WHEN
        Parameter<SpecificEnthalpy> specificEnthalpyJoule = new Parameter(joulePerKilogram, 1000.0);
        Parameter<SpecificEnthalpy> specificEnthalpyKiloJoule = new Parameter(kiloJoulePerKilogram, 1.0);
        //THEN
        assertEquals(specificEnthalpyJoule, specificEnthalpyKiloJoule);
    }

    @Test
    public void shouldReturnHeatFlowForMassFlowTimesSpecificEnthalpy() {
        //GIVEN
        Unit<SpecificEnthalpy> kiloJoulePerKilogram = SI.KILO(SI.JOULE).divide(SI.KILOGRAM).asType(SpecificEnthalpy.class);
        Unit<MassFlow> kilogramPerSecond = SI.KILOGRAM.divide(SI.SECOND).asType(MassFlow.class);
        Parameter<SpecificEnthalpy> specificEnthalpy = new Parameter(kiloJoulePerKilogram, 5.0);
        Parameter<MassFlow> massFlow = new Parameter<>(kilogramPerSecond, 2.0);

        Unit<HeatFlow> wattUnit = SI.WATT.asType(HeatFlow.class);
        Parameter<HeatFlow> definedHeatFlow = new Parameter<>(wattUnit, 10000);
        //WHEN
        Parameter<HeatFlow> resultingHeatFlow;
        resultingHeatFlow = specificEnthalpy.times(massFlow);
        //THEN
        assertEquals(resultingHeatFlow, definedHeatFlow);
    }

    @Test
    public void shouldReturn10KelvinsFor5KTimes2() {
        //GIVEN
        Parameter<TemperatureDifference> temperatureDifferenceDefinedAs5K = new Parameter(SI.KELVIN.asType(TemperatureDifference.class), 5);
        Parameter<TemperatureDifference> temperatureDifferenceDefinedAs10K = new Parameter(SI.KELVIN.asType(TemperatureDifference.class), 10);
        //WHEN
        Parameter<TemperatureDifference> temperatureDifferenceAfter2TimesMultiplication = temperatureDifferenceDefinedAs5K.times(2.0);
        //THEN
        assertEquals(temperatureDifferenceAfter2TimesMultiplication, temperatureDifferenceDefinedAs10K);
    }

    @Test
    public void shouldReturnPressureSumForFewPressurePoints() {
        //GIVEN
        Parameter<Pressure> pressureOnPoint1 = new Parameter<>(SI.PASCAL.asType(Pressure.class), 100);
        Parameter<Pressure> pressureOnPoint2 = new Parameter<>(SI.PASCAL.asType(Pressure.class), 200);
        Parameter<Pressure> pressureOnPoint3 = new Parameter<>(SI.PASCAL.asType(Pressure.class), 300);
        Parameter<Pressure> pressureOnPoint4 = new Parameter<>(SI.PASCAL.asType(Pressure.class), 400);
        //WHEN
        Parameter<Pressure> totalPressure = pressureOnPoint1.plus(pressureOnPoint2).plus(pressureOnPoint3).plus(pressureOnPoint4);
        //THEN
        assertEquals(totalPressure.getValue(),1000.0,0.01);
    }

    @Test
    public void shouldReturn200WCompressorPowerForHeatSourceMinusHeatBath(){
        //GIVEN
        Parameter<HeatFlow> heatSource = new Parameter<>(SI.KILO(SI.WATT).asType(HeatFlow.class),1);
        Parameter<HeatFlow> heatBath = new Parameter<>(SI.WATT.asType(HeatFlow.class),800);
        //WHEN
        Parameter<Power> compressorPower = heatSource.minus(heatBath);
        compressorPower.setActualUnit(SI.WATT.asType(Power.class));
        //THEN
        assertEquals(compressorPower.getValue(),200,0.01);
    }

    @Test
    public void shouldReturnDensityForMassFlowDividedByVolumeFlow(){
        //GIVEN
        Parameter<MassFlow> massFlow = new Parameter(SI.KILOGRAM.divide(SI.SECOND).asType(MassFlow.class),100);
        Parameter<VolumeFlow> volumeFlow = new Parameter(SI.CUBIC_METRE.divide(SI.SECOND).asType(VolumeFlow.class),200);
        //WHEN
        Parameter<Density> density = massFlow.divide(volumeFlow);
        density.setActualUnit(SI.GRAM.divide(SI.CUBIC_METRE).asType(Density.class));
        //THEN
        assertEquals(density.getValue(),500,0.01);
    }

    @Test
    public void shouldReturnHeatFlowFromMassFlowAndEnthalpyDifference(){
        //GIVEN
        Parameter<HeatFlow> definedHeatFlow = new Parameter<>(SI.WATT.asType(HeatFlow.class), 50);
        Parameter<HeatFlow> heatFlowWithDefinedUnit = new Parameter<>(SI.KILO(SI.WATT).asType(HeatFlow.class));
        Parameter<MassFlow> massFlow= new Parameter<>(SI.KILOGRAM.divide(SI.SECOND).asType(MassFlow.class),25);
        Parameter<SpecificEnthalpy> specificEnthalpyDifference = new Parameter<>(SI.JOULE.divide(SI.KILOGRAM).asType(SpecificEnthalpy.class), 2);

        //WHEN
        heatFlowWithDefinedUnit.calculate(massFlow.times(specificEnthalpyDifference));

        //THEN

        System.out.println(heatFlowWithDefinedUnit);

    }
}
