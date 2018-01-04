package thermoMW.fluidData;

public class Refrigerant {
    protected double pBarG; //cisnienie manometryczne
    protected double Superheat; /** przegrzanie */
    protected double Subcooling;
    protected double t_boubbles;
    protected double t_dew;
    CommonSpecific common;

    public Refrigerant(CommonSpecific common){
        this.common=common;
    }

}
