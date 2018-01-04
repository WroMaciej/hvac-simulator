package thermoMW.fluidData;
import java.lang.Math;

public class Pipe {

    public enum PipeType{
        RECTANGLE,
        ROUND;

    }

    private PipeType pipeType;

    private double length; //dlugosc w m
    private Insulation insulation;
    private double area; //przekroj m2
    private double diameterInner; //srednica wewnetrzna rury w mm
    private double diameterOutter; //srednica zewnetrzna rury w mm
    private double widthInner; //szerokosc wewnetrzna w mm
    private double widthOutter; //szerokosc zewnetrzna w mm
    private double heightInner; //wysokosc wewnetrzna w mm
    private double heightOutter; //wysokosc zewnetrzna w mm
    private double thickness; //grubosc kanalu w mm

    private Pipe(double diameterOutter){
        pipeType=PipeType.ROUND;
        this.diameterOutter=diameterOutter;
        this.setThickness(0);
        this.setArea();
    }

    private Pipe(double widthOutter, double heightOutter){
        pipeType=PipeType.RECTANGLE;
        this.widthOutter=widthOutter;
        this.heightOutter=heightOutter;
        this.setThickness(0);
        this.setArea();
    }


    private double setArea(){
        double a=0;
        switch (pipeType){
            case ROUND: {
                a= Math.PI*(diameterInner/1000)*(diameterInner/1000)*0.25;
                break;
            }
            case RECTANGLE: {
                a= (widthInner/1000)*(widthOutter/1000);
                break;
            }
        }
        return a;

    }

    private void setThickness(double thickness) {
        this.thickness = thickness;
        switch (pipeType){
            case ROUND: {
                this.diameterInner=diameterOutter-thickness;
                break;
            }
            case RECTANGLE: {
                this.widthInner=widthOutter-thickness;
                this.heightInner=heightOutter-thickness;
                break;
            }
        }

    }


}
