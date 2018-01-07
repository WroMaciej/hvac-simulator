package wromaciej.hvac_sim.thermo.fluids.data;

public class Refrigerant {
    protected double pBarG; //cisnienie manometryczne
    protected double superheat; /** przegrzanie */
    protected double subcooling;
    protected double t_bubbles;
    protected double t_dew;
    protected double gwp; //gwp100 CO2
    protected double odp; //odp OZON
    CommonSpecific common;

    public Refrigerant(CommonSpecific common){
        this.common=common;
    }

}
