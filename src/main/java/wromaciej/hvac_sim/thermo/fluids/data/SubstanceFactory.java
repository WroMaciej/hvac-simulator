/**
 * Repaired factory at 10-01-2018
 */
package wromaciej.hvac_sim.thermo.fluids.data;
import wromaciej.hvac_sim.thermo.ThermoCPAdapter;

/**
 * Creating of Substance in few ways, depending on its type
 */

public final class SubstanceFactory{

    /**
     * Create as general fluid
     * @param substanceName Name
     * @param parameter1 Parmeter 1
     * @param parameter2 Parameter 2
     * @return Full point with all SPECIFIC parameters
     */

    public static Substance createGeneral(SubstanceName substanceName, SubstanceParameter parameter1, SubstanceParameter parameter2){
        return createGeneral(substanceName,parameter1.getType(),parameter1.getValue(),parameter2.getType(),parameter2.getValue());
    }

    public static Substance createGeneral(SubstanceName substanceName, SubstanceParameterType parameter1, double value1, SubstanceParameterType parameter2, double value2){
        Substance substance=new Substance();
        if (substanceName!=SubstanceName.MOIST_AIR){
            substance.substanceName=substanceName;
            substance.temperature.value =ThermoCPAdapter.findParameter(SubstanceParameterType.TEMPERATURE,substanceName,parameter1,value1,parameter2,value2);
            substance.pressure.value =ThermoCPAdapter.findParameter(SubstanceParameterType.PRESSURE,substanceName,parameter1,value1,parameter2,value2);
            substance.enthalpy.value =ThermoCPAdapter.findParameter(SubstanceParameterType.ENTHALPY,substanceName,parameter1,value1,parameter2,value2);
            substance.entropy.value =ThermoCPAdapter.findParameter(SubstanceParameterType.ENTROPY,substanceName,parameter1,value1,parameter2,value2);
            substance.quality.value =ThermoCPAdapter.findParameter(SubstanceParameterType.QUALITY,substanceName,parameter1,value1,parameter2,value2);
            substance.heatCapacity.value =ThermoCPAdapter.findParameter(SubstanceParameterType.HEAT_CAPACITY,substanceName,parameter1,value1,parameter2,value2);
            substance.density.value =ThermoCPAdapter.findParameter(SubstanceParameterType.DENSITY,substanceName,parameter1,value1,parameter2,value2);
            substance.volume.value =1/substance.density.value ; //add an EXCEPTION for divided by 0
        }
        else {
            //create as air
            substance=createAir(parameter1,value1,parameter2,value2,0);
        }
        return substance;
    }

    public static Air createAir(SubstanceParameter parameter1, SubstanceParameter parameter2, double pGaugePa){
        return createAir(parameter1.getType(),parameter1.getValue(),parameter2.getType(),parameter2.getValue(),pGaugePa);
    }

    public static Air createAir(SubstanceParameterType parameter1, double value1, SubstanceParameterType parameter2, double value2, double pGaugePa){
        Air air=new Air();
        air.substanceName=SubstanceName.MOIST_AIR;
        air.pGaugePa.value =pGaugePa;
        air.pressure.value =1+(pGaugePa/100000);
        air.temperature.value =ThermoCPAdapter.findAirParameter(SubstanceParameterType.TEMPERATURE,parameter1,value1,parameter2,value2,pGaugePa);
        //air.pressure=ThermoCPAdapter.findAirParameter(SubstanceParameterType.PRESSURE,parameter1,value1,parameter2,value2,pGaugePa);
        air.enthalpy.value =ThermoCPAdapter.findAirParameter(SubstanceParameterType.ENTHALPY,parameter1,value1,parameter2,value2,pGaugePa);
        air.entropy.value =ThermoCPAdapter.findAirParameter(SubstanceParameterType.ENTROPY,parameter1,value1,parameter2,value2,pGaugePa);
        air.quality.value =1;
        air.heatCapacity.value =ThermoCPAdapter.findAirParameter(SubstanceParameterType.HEAT_CAPACITY,parameter1,value1,parameter2,value2,pGaugePa);
        air.density.value =ThermoCPAdapter.findAirParameter(SubstanceParameterType.DENSITY,parameter1,value1,parameter2,value2,pGaugePa);
        air.volume.value =1/air.density.value ;
        air.dewPoint.value =ThermoCPAdapter.findAirParameter(SubstanceParameterType.TEMPERATURE_DEWPOINT,parameter1,value1,parameter2,value2,pGaugePa);
        air.wetBulb.value =ThermoCPAdapter.findAirParameter(SubstanceParameterType.TEMPERATURE_WETBULB,parameter1,value1,parameter2,value2,pGaugePa);
        air.moistureContent.value =ThermoCPAdapter.findAirParameter(SubstanceParameterType.MOISTURE_CONTENT,parameter1,value1,parameter2,value2,pGaugePa);
        air.relativeHumidity.value =ThermoCPAdapter.findAirParameter(SubstanceParameterType.RELATIVE_HUMIDITY,parameter1,value1,parameter2,value2,pGaugePa);
        return air;
    }


    /*public Substance createAsCommon(String fluidName, String parameter1, double value1, String parameter2, double value2) {
        
        String newFluidName = ThermoCPAdapter.convert(fluidName, null, 0).fluidName;
        double t = ThermoCPAdapter.findParameter("t", fluidName, parameter1, value1, parameter2, value2);
        double pBarA = ThermoCPAdapter.findParameter("p", fluidName, parameter1, value1, parameter2, value2);
        double h = ThermoCPAdapter.findParameter("h", fluidName, parameter1, value1, parameter2, value2);
        double s = ThermoCPAdapter.findParameter("s", fluidName, parameter1, value1, parameter2, value2);
        double q;
        if (newFluidName.equals(MOIST_AIR)) q = 1;
        else q = ThermoCPAdapter.findParameter("q", fluidName, parameter1, value1, parameter2, value2);
        double cp;
        if (MOIST_AIR.equals(newFluidName)) cp = 1;
        else cp = ThermoCPAdapter.findParameter("cp", fluidName, parameter1, value1, parameter2, value2);
        double ro;
        if (newFluidName.equals(MOIST_AIR)) ro = 1.18;
        else ro = ThermoCPAdapter.findParameter("ro", fluidName, parameter1, value1, parameter2, value2);
        double v;
        if (ro > 0) v = 1 / ro;
        else v = 1;

        return new Substance(newFluidName, t, pBarA, h, s, q, cp, v, ro);
//        if (newFluidName.equals("a")) createAsAir(parameter1, value1, parameter2, value2, 0);
        }*/
}
