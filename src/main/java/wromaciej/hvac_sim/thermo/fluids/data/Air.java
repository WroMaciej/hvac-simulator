package wromaciej.hvac_sim.thermo.fluids.data;



public class Air  {

    /**
     * nadciśnienie w Pa względem 1bar
     */
    protected double pGaugePa;

    protected double rh; //wilgotność względna 0-1
    protected double x; //wilgotność bezwzględna

    protected double tm; //temperatura termometru mokrego
    protected double tr; //temperatura punktu rosy
    private CommonSpecific common;

    public AirProcess airProcess;



    public Air(CommonSpecific common){
        this.common=common;
    }

    @Override
    public String toString() {
        return "Powietrze "+ "pGaugePa="+pGaugePa+" Pa t="+common.t+"C rh="+rh+" x="+x+"kg/kg h="+common.h+"kJ/kg tm="+tm+"C tr="+tr+" cp="+common.cp+"kJ/kgK";
    }




    public abstract class AirProcess{
        public AirHumidify humidify;
        public AirHeating airHeating;
        public AirCooling airCooling;
        public AirMixing airMixing;

        public abstract class AirHumidify{
            public void dt(double dt){

            }
            public void dx(double dx){

            }
            public void t2(double t2){

            }
            public void x2(double x2){

            }
            public void rh2(double rh2){

            }
            public void max(){
                rh2(1);
            }
        }

        public abstract class AirHeating{
            public void dt(double dt){}
            public void t2(double t2){}
        }

        public abstract class AirCooling{
            public void dt(double dt){}
            public void t2(double t2){}
            public void surfaceTemp(double tSurface){}


        }

        public abstract class AirMixing{
            public void mixWithPoint(AllSpecific secondPoint, double secondPointFraction){}
        }


    }




}


