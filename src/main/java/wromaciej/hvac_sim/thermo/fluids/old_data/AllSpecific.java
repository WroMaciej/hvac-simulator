package wromaciej.hvac_sim.thermo.fluids.old_data;

import wromaciej.hvac_sim.thermo.ThermoCPAdapter;

public class AllSpecific {

    private enum FluidType {
        AIR,
        REFRIGERANT,
        LIQUID,
        OTHER;
    }

    private FluidType fluidtype;

    public Air air;
    public Refrigerant refrigerant;
    public CommonSpecific common;

    public AllSpecific() {
        common = new CommonSpecific();
        air = new Air(common);
        refrigerant = new Refrigerant(common);
    }


    public void createAsCommon(String fluidName, String parameter1, double value1, String parameter2, double value2) {
        air = null;
        refrigerant = null;
        this.fluidtype = FluidType.OTHER;
        common.fluidName = ThermoCPAdapter.convert(fluidName, null, 0).fluidName;
        common.t = ThermoCPAdapter.findParameter("t", fluidName, parameter1, value1, parameter2, value2);
        common.pBarA = ThermoCPAdapter.findParameter("p", fluidName, parameter1, value1, parameter2, value2);
        common.h = ThermoCPAdapter.findParameter("h", fluidName, parameter1, value1, parameter2, value2);
        common.s = ThermoCPAdapter.findParameter("s", fluidName, parameter1, value1, parameter2, value2);
        if (common.fluidName.equals("a")) common.q = 1;
        else common.q = ThermoCPAdapter.findParameter("q", fluidName, parameter1, value1, parameter2, value2);
        if (common.fluidName.equals("a")) common.cp = 1;
        else common.cp = ThermoCPAdapter.findParameter("cp", fluidName, parameter1, value1, parameter2, value2);
        if (common.fluidName.equals("a")) common.ro = 1.18;
        else common.ro = ThermoCPAdapter.findParameter("ro", fluidName, parameter1, value1, parameter2, value2);
        if (common.ro > 0) common.v = 1 / common.ro;
        else common.v = 1;

        if (common.fluidName.equals("a")) createAsAir(parameter1, value1, parameter2, value2, 0);
    }

    public void createAsAir(String p1, double v1, String p2, double v2, double pGaugePa) {
        this.fluidtype = FluidType.AIR;
        common.fluidName = "a";
        common.t = ThermoCPAdapter.findAirParameter("t", p1, v1, p2, v2, pGaugePa);
        common.pBarA = 1 + (pGaugePa / 100000);
        common.h = ThermoCPAdapter.findAirParameter("h", p1, v1, p2, v2, pGaugePa);
        common.s = ThermoCPAdapter.findAirParameter("s", p1, v1, p2, v2, pGaugePa);
        common.q = 1;
        common.cp = ThermoCPAdapter.findAirParameter("cp", p1, v1, p2, v2, pGaugePa);
        common.v = ThermoCPAdapter.findAirParameter("v", p1, v1, p2, v2, pGaugePa);
        if (common.v > 0) common.ro = 1 / common.v;
        else common.ro = 1;
        air = new Air(common);
        air.pGaugePa = pGaugePa;
        air.rh = ThermoCPAdapter.findAirParameter("rh", p1, v1, p2, v2, pGaugePa);
        air.x = ThermoCPAdapter.findAirParameter("x", p1, v1, p2, v2, pGaugePa);
        air.tm = ThermoCPAdapter.findAirParameter("tm", p1, v1, p2, v2, pGaugePa);
        air.tr = ThermoCPAdapter.findAirParameter("tr", p1, v1, p2, v2, pGaugePa);
        refrigerant = null;
    }

    public void createAsRefrigerant(String fluidName, String parameter1, double value1, String parameter2, double value2) {
        createAsCommon(fluidName, parameter1, value1, parameter2, value2);
        this.fluidtype = FluidType.REFRIGERANT;
        refrigerant = new Refrigerant(common);
        refrigerant.pBarG = common.pBarA - 1;
        refrigerant.t_bubbles = ThermoCPAdapter.findParameter("t", fluidName, "q", 0, "p", common.pBarA);
        refrigerant.t_dew = ThermoCPAdapter.findParameter("t", fluidName, "q", 1, "p", common.pBarA);
        refrigerant.subcooling = common.t - refrigerant.t_bubbles;
        refrigerant.superheat = common.t - refrigerant.t_dew;
    }

    public void createAsLiquid(String fluidName, double pressure, double temperature) {
        createAsCommon(fluidName, "p", pressure, "t", temperature);
        this.fluidtype = FluidType.LIQUID;
    }

    @Override
    public String toString() {
        return common.fluidName + " " + "t= " + common.t + "C " + " p= " + common.pBarA + " " + " h= " + common.h + "kJ/kg " + " s= " + common.s + "kJ/kgK " + " cp=" + common.cp + "kJ/kgK";
    }
}
