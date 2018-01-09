/**
 * Repaired factory at 09-01-2018
 */
package wromaciej.hvac_sim.thermo.fluids.data;

import wromaciej.hvac_sim.thermo.ThermoCPAdapter;

public class SubstanceFactory{


    public static Substance createGeneral(SubstanceName substanceName, SubstanceParameter parameter1, double value1, SubstanceParameter parameter2, double value2){
        Substance substance=new Substance();
        if (substanceName!=SubstanceName.MOIST_AIR){
            substance.substanceName=substanceName;
            substance.temperature=ThermoCPAdapter.findParameter(SubstanceParameter.TEMPERATURE,substanceName,parameter1,value1,parameter2,value2);
            substance.pressure=ThermoCPAdapter.findParameter(SubstanceParameter.PRESSURE,substanceName,parameter1,value1,parameter2,value2);
            substance.enthalpy=ThermoCPAdapter.findParameter(SubstanceParameter.ENTHALY,substanceName,parameter1,value1,parameter2,value2);
            substance.entropy=ThermoCPAdapter.findParameter(SubstanceParameter.ENTROPY,substanceName,parameter1,value1,parameter2,value2);
            substance.quality=ThermoCPAdapter.findParameter(SubstanceParameter.QUALITY,substanceName,parameter1,value1,parameter2,value2);
            substance.heatCapacity=ThermoCPAdapter.findParameter(SubstanceParameter.HEAT_CAPACITY,substanceName,parameter1,value1,parameter2,value2);
            substance.density=ThermoCPAdapter.findParameter(SubstanceParameter.DENSITY,substanceName,parameter1,value1,parameter2,value2);
            substance.volume=1/substance.density; //add an try catch for divided by 0
        }
        else {
            //create as air
            substance=createAir(parameter1,value1,parameter2,value2,0);
        }
        return substance;
    }

    public static Air createAir(SubstanceParameter parameter1, double value1, SubstanceParameter parameter2, double value2, double pGaugePa){
        
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
