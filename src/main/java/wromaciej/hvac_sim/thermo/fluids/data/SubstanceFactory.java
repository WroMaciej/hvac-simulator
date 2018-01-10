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
     * @param value1 Value of parameter 2
     * @param parameter2 Parameter 2
     * @param value2 Value of parameter 2
     * @return Full point with all SPECIFIC parameters
     */

    public static Substance createGeneral(SubstanceName substanceName, SubstanceParameter parameter1, double value1, SubstanceParameter parameter2, double value2){
        Substance substance=new Substance();
        if (substanceName!=SubstanceName.MOIST_AIR){
            substance.substanceName=substanceName;
            substance.temperature=ThermoCPAdapter.findParameter(SubstanceParameter.TEMPERATURE,substanceName,parameter1,value1,parameter2,value2);
            substance.pressure=ThermoCPAdapter.findParameter(SubstanceParameter.PRESSURE,substanceName,parameter1,value1,parameter2,value2);
            substance.enthalpy=ThermoCPAdapter.findParameter(SubstanceParameter.ENTHALPY,substanceName,parameter1,value1,parameter2,value2);
            substance.entropy=ThermoCPAdapter.findParameter(SubstanceParameter.ENTROPY,substanceName,parameter1,value1,parameter2,value2);
            substance.quality=ThermoCPAdapter.findParameter(SubstanceParameter.QUALITY,substanceName,parameter1,value1,parameter2,value2);
            substance.heatCapacity=ThermoCPAdapter.findParameter(SubstanceParameter.HEAT_CAPACITY,substanceName,parameter1,value1,parameter2,value2);
            substance.density=ThermoCPAdapter.findParameter(SubstanceParameter.DENSITY,substanceName,parameter1,value1,parameter2,value2);
            substance.volume=1/substance.density; //add an EXCEPTION for divided by 0
        }
        else {
            //create as air
            substance=createAir(parameter1,value1,parameter2,value2,0);
        }
        return substance;
    }

    public static Air createAir(SubstanceParameter parameter1, double value1, SubstanceParameter parameter2, double value2, double pGaugePa){
        Air air=new Air();
        air.substanceName=SubstanceName.MOIST_AIR;
        air.pGaugePa=pGaugePa;
        air.pressure=1+(pGaugePa/100000);
        air.temperature=ThermoCPAdapter.findAirParameter(SubstanceParameter.TEMPERATURE,parameter1,value1,parameter2,value2,pGaugePa);
        //air.pressure=ThermoCPAdapter.findAirParameter(SubstanceParameter.PRESSURE,parameter1,value1,parameter2,value2,pGaugePa);
        air.enthalpy=ThermoCPAdapter.findAirParameter(SubstanceParameter.ENTHALPY,parameter1,value1,parameter2,value2,pGaugePa);
        air.entropy=ThermoCPAdapter.findAirParameter(SubstanceParameter.ENTROPY,parameter1,value1,parameter2,value2,pGaugePa);
        air.quality=1;
        air.heatCapacity=ThermoCPAdapter.findAirParameter(SubstanceParameter.HEAT_CAPACITY,parameter1,value1,parameter2,value2,pGaugePa);
        air.density=ThermoCPAdapter.findAirParameter(SubstanceParameter.DENSITY,parameter1,value1,parameter2,value2,pGaugePa);
        air.volume=1/air.density;
        air.dewPoint=ThermoCPAdapter.findAirParameter(SubstanceParameter.TEMPERATURE_DEWPOINT,parameter1,value1,parameter2,value2,pGaugePa);
        air.wetBulb=ThermoCPAdapter.findAirParameter(SubstanceParameter.TEMPERATURE_WETBULB,parameter1,value1,parameter2,value2,pGaugePa);
        air.moistureContent=ThermoCPAdapter.findAirParameter(SubstanceParameter.MOISTURE_CONTENT,parameter1,value1,parameter2,value2,pGaugePa);
        air.relativeHumidity=ThermoCPAdapter.findAirParameter(SubstanceParameter.RELATIVE_HUMIDITY,parameter1,value1,parameter2,value2,pGaugePa);
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
