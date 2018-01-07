package wromaciej.hvac_sim.thermo.fluids.data;

import wromaciej.hvac_sim.thermo.Thermo;

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
        common.fluidName = Thermo.con(fluidName, null, 0).fluidName;
        common.t = Thermo.findParameter("t", fluidName, parameter1, value1, parameter2, value2);
        common.pBarA = Thermo.findParameter("p", fluidName, parameter1, value1, parameter2, value2);
        common.h = Thermo.findParameter("h", fluidName, parameter1, value1, parameter2, value2);
        common.s = Thermo.findParameter("s", fluidName, parameter1, value1, parameter2, value2);
        if (common.fluidName.equals("a")) common.q = 1;
        else common.q = Thermo.findParameter("q", fluidName, parameter1, value1, parameter2, value2);
        if (common.fluidName.equals("a")) common.cp = 1;
        else common.cp = Thermo.findParameter("cp", fluidName, parameter1, value1, parameter2, value2);
        if (common.fluidName.equals("a")) common.ro = 1.18;
        else common.ro = Thermo.findParameter("ro", fluidName, parameter1, value1, parameter2, value2);
        if (common.ro > 0) common.v = 1 / common.ro;
        else common.v = 1;

        if (common.fluidName.equals("a")) createAsAir(parameter1, value1, parameter2, value2, 0);
    }

    public void createAsAir(String p1, double v1, String p2, double v2, double pGaugePa) {
        this.fluidtype = FluidType.AIR;
        common.fluidName = "a";
        common.t = Thermo.findAirParameter("t", p1, v1, p2, v2, pGaugePa);
        common.pBarA = 1 + (pGaugePa / 100000);
        common.h = Thermo.findAirParameter("h", p1, v1, p2, v2, pGaugePa);
        common.s = Thermo.findAirParameter("s", p1, v1, p2, v2, pGaugePa);
        common.q = 1;
        common.cp = Thermo.findAirParameter("cp", p1, v1, p2, v2, pGaugePa);
        common.v = Thermo.findAirParameter("v", p1, v1, p2, v2, pGaugePa);
        if (common.v > 0) common.ro = 1 / common.v;
        else common.ro = 1;
        air = new Air(common);
        air.pGaugePa = pGaugePa;
        air.rh = Thermo.findAirParameter("rh", p1, v1, p2, v2, pGaugePa);
        air.x = Thermo.findAirParameter("x", p1, v1, p2, v2, pGaugePa);
        air.tm = Thermo.findAirParameter("tm", p1, v1, p2, v2, pGaugePa);
        air.tr = Thermo.findAirParameter("tr", p1, v1, p2, v2, pGaugePa);
        refrigerant = null;
    }

    public void createAsRefrigerant(String fluidName, String parameter1, double value1, String parameter2, double value2) {
        createAsCommon(fluidName, parameter1, value1, parameter2, value2);
        this.fluidtype = FluidType.REFRIGERANT;
        refrigerant = new Refrigerant(common);
        refrigerant.pBarG = common.pBarA - 1;
        refrigerant.t_bubbles = Thermo.findParameter("t", fluidName, "q", 0, "p", common.pBarA);
        refrigerant.t_dew = Thermo.findParameter("t", fluidName, "q", 1, "p", common.pBarA);
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
