package wromaciej.hvac_sim.thermo.fluids.data;

import wromaciej.hvac_sim.thermo.ThermoCPAdapter;

public class FluidFactory {



    public Substance createAsCommon(String fluidName, String parameter1, double value1, String parameter2, double value2) {
        
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
    }
}
