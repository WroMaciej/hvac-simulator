package thermoMW.fluidData;
import thermoMW.Thermo;

public class Air  {
    
    
    protected double pGaugePa; //nadciśnienie w Pa względem 1bar

    protected double rh; //wilgotność względna 0-1
    protected double x; //wilgotność bezwzględna

    protected double tm; //temperatura termometru mokrego
    protected double tr; //temperatura punktu rosy
    CommonSpecific common;

    public AirProcess airProcess;

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





    
    


    public Air(CommonSpecific common){
        this.common=common;
    }



}


