/**
 * Repaired factory at 10-01-2018
 */
package wromaciej.hvac_sim.thermo.matter.fluids;
import wromaciej.hvac_sim.thermo.controller.FluidParameterAdapter;
import wromaciej.hvac_sim.thermo.controller.ThermoCPAdapter;
import wromaciej.hvac_sim.thermo.matter.fluids.model.Air;
import wromaciej.hvac_sim.thermo.matter.fluids.model.Fluid;
import wromaciej.hvac_sim.thermo.matter.fluids.model.Refrigerant;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.FluidName;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.FluidParameter;

/**
 * Creating of Fluid in few ways, depending on its parameterType
 */

public final class FluidFactory {

    /**
     * Create as general fluid
     *
     * @param fluidName Name
     * @param parameter1    Parmeter 1
     * @param parameter2    Parameter 2
     * @return Full point with all SPECIFIC parameters
     */

    public static Fluid createGeneral(FluidName fluidName, FluidParameter parameter1, FluidParameter parameter2) {
        return createGeneral(fluidName, parameter1.getParameterType(), parameter1.getValue(), parameter2.getParameterType(), parameter2.getValue());
    }

    public static Fluid createGeneral(FluidName fluidName, FluidParameterAdapter parameter1, double value1, FluidParameterAdapter parameter2, double value2) {
        Fluid fluid = new Fluid();
        if (fluidName != FluidName.MOIST_AIR) {
            fluid.fluidName = fluidName;
            fluid.temperature.value = ThermoCPAdapter.findParameter(FluidParameterAdapter.TEMPERATURE, fluidName, parameter1, value1, parameter2, value2);
            fluid.pressure.value = ThermoCPAdapter.findParameter(FluidParameterAdapter.PRESSURE, fluidName, parameter1, value1, parameter2, value2);
            fluid.enthalpy.value = ThermoCPAdapter.findParameter(FluidParameterAdapter.SPECIFIC_ENTHALPY, fluidName, parameter1, value1, parameter2, value2);
            fluid.entropy.value = ThermoCPAdapter.findParameter(FluidParameterAdapter.SPECIFIC_ENTROPY, fluidName, parameter1, value1, parameter2, value2);
            fluid.quality.value = ThermoCPAdapter.findParameter(FluidParameterAdapter.QUALITY, fluidName, parameter1, value1, parameter2, value2);
            fluid.heatCapacity.value = ThermoCPAdapter.findParameter(FluidParameterAdapter.HEAT_CAPACITY, fluidName, parameter1, value1, parameter2, value2);
            fluid.density.value = ThermoCPAdapter.findParameter(FluidParameterAdapter.DENSITY, fluidName, parameter1, value1, parameter2, value2);
            fluid.volume.value = 1 / fluid.density.value; //add an EXCEPTION for divided by 0
        } else {
            //create as air
            fluid = createAir(parameter1, value1, parameter2, value2, 0);
        }
        return fluid;
    }

    public static Air createAir(FluidParameter parameter1, FluidParameter parameter2, double pGaugePa) {
        return createAir(parameter1.getParameterType(), parameter1.getValue(), parameter2.getParameterType(), parameter2.getValue(), pGaugePa);
    }

    public static Air createAir(FluidParameterAdapter parameter1, double value1, FluidParameterAdapter parameter2, double value2, double pGaugePa) {
        Air air = new Air();
        air.fluidName = FluidName.MOIST_AIR;
        air.pGaugePa.value = pGaugePa;
        air.pressure.value = 1 + (pGaugePa / 100000);
        air.temperature.value = ThermoCPAdapter.findAirParameter(FluidParameterAdapter.TEMPERATURE, parameter1, value1, parameter2, value2, pGaugePa);
        //air.pressure=ThermoCPAdapter.findAirParameter(FluidParameterAdapter.PRESSURE,parameter1,value1,parameter2,value2,pGaugePa);
        air.enthalpy.value = ThermoCPAdapter.findAirParameter(FluidParameterAdapter.SPECIFIC_ENTHALPY, parameter1, value1, parameter2, value2, pGaugePa);
        air.entropy.value = ThermoCPAdapter.findAirParameter(FluidParameterAdapter.SPECIFIC_ENTROPY, parameter1, value1, parameter2, value2, pGaugePa);
        air.quality.value = 1;
        air.heatCapacity.value = ThermoCPAdapter.findAirParameter(FluidParameterAdapter.HEAT_CAPACITY, parameter1, value1, parameter2, value2, pGaugePa);
        air.density.value = ThermoCPAdapter.findAirParameter(FluidParameterAdapter.DENSITY, parameter1, value1, parameter2, value2, pGaugePa);
        air.volume.value = 1 / air.density.value;
        air.dewPoint.value = ThermoCPAdapter.findAirParameter(FluidParameterAdapter.TEMPERATURE_DEWPOINT, parameter1, value1, parameter2, value2, pGaugePa);
        air.wetBulb.value = ThermoCPAdapter.findAirParameter(FluidParameterAdapter.TEMPERATURE_WETBULB, parameter1, value1, parameter2, value2, pGaugePa);
        air.moistureContent.value = ThermoCPAdapter.findAirParameter(FluidParameterAdapter.MOISTURE_CONTENT, parameter1, value1, parameter2, value2, pGaugePa);
        air.relativeHumidity.value = ThermoCPAdapter.findAirParameter(FluidParameterAdapter.RELATIVE_HUMIDITY, parameter1, value1, parameter2, value2, pGaugePa);
        return air;
    }

    public static Refrigerant createRefrigerant(FluidName fluidName, FluidParameter parameter1, FluidParameter parameter2) {
        return createRefrigerant(fluidName, parameter1.getParameterType(), parameter1.getValue(), parameter2.getParameterType(), parameter2.getValue());
    }

    public static Refrigerant createRefrigerant(FluidName fluidName, FluidParameterAdapter parameter1, double value1, FluidParameterAdapter parameter2, double value2) {
        Fluid refrigerantGeneral = createGeneral(fluidName, parameter1, value1, parameter2, value2);
        Refrigerant refrigerant = new Refrigerant();
        refrigerant.fluidName = refrigerantGeneral.fluidName;
        refrigerant.temperature = refrigerantGeneral.temperature;
        refrigerant.pressure = refrigerantGeneral.pressure;
        refrigerant.enthalpy = refrigerantGeneral.enthalpy;
        refrigerant.entropy = refrigerantGeneral.entropy;
        refrigerant.quality = refrigerantGeneral.quality;
        refrigerant.heatCapacity = refrigerantGeneral.heatCapacity;
        refrigerant.density = refrigerantGeneral.density;
        refrigerant.volume = refrigerantGeneral.volume;
        refrigerant.pressureGaugeBarG.value = refrigerant.pressure.value - 1;
        refrigerant.temperatureSaturation.value = ThermoCPAdapter.findParameter(FluidParameterAdapter.TEMPERATURE, fluidName, FluidParameterAdapter.PRESSURE,refrigerant.pressure.value, FluidParameterAdapter.QUALITY,0.5);
        refrigerant.pressureSaturation.value = ThermoCPAdapter.findParameter(FluidParameterAdapter.PRESSURE, fluidName, FluidParameterAdapter.TEMPERATURE,refrigerant.pressure.value, FluidParameterAdapter.QUALITY,0.5);
        refrigerant.temperatureBubbles.value = ThermoCPAdapter.findParameter(FluidParameterAdapter.TEMPERATURE, fluidName, FluidParameterAdapter.PRESSURE,refrigerant.pressure.value, FluidParameterAdapter.QUALITY,0);
        refrigerant.pressureBubbles.value = ThermoCPAdapter.findParameter(FluidParameterAdapter.PRESSURE, fluidName, FluidParameterAdapter.TEMPERATURE,refrigerant.pressure.value, FluidParameterAdapter.QUALITY,0);
        refrigerant.temperatureDew.value = ThermoCPAdapter.findParameter(FluidParameterAdapter.TEMPERATURE, fluidName, FluidParameterAdapter.PRESSURE,refrigerant.pressure.value, FluidParameterAdapter.QUALITY,1);
        refrigerant.pressureDew.value = ThermoCPAdapter.findParameter(FluidParameterAdapter.PRESSURE, fluidName, FluidParameterAdapter.TEMPERATURE,refrigerant.pressure.value, FluidParameterAdapter.QUALITY,1);
        refrigerant.temperatureSlide.value=refrigerant.temperatureDew.value-refrigerant.temperatureBubbles.value;
        refrigerant.pressureSlide.value=(refrigerant.pressureDew.value-refrigerant.pressureBubbles.value)*100;
        refrigerant.superheating.value = refrigerant.temperature.value-refrigerant.temperatureDew.value;
        refrigerant.subcooling.value = refrigerant.temperatureBubbles.value-refrigerant.temperature.value;

        return refrigerant;
    }



}