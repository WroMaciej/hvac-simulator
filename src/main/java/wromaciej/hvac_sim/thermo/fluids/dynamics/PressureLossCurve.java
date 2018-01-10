package wromaciej.hvac_sim.thermo.fluids.dynamics;

public class PressureLossCurve {
    private double x3;
    private double x2;
    private double x1;
    private double r2; //r2

    // REVIEW: użyj kolekcji, w tym przypadku listy
    private PressurePoint allPoints[];

    public PressureLossCurve(PressurePoint... points){
        x1=0;
        x2=0;
        x3=0;
        //utworz tablice z punktem 0,0

        if (points.length==1) //jesli podano tylko 1 punkt to wyznacz funkcje kwadratowa
        {}
        else{
            // REVIEW: a jeżeli już się uparłeś to w bibliotece Guava masz ObjectArrays.concat i moglbys zrobic
            // prepend po porstu ;)
            allPoints=new PressurePoint[points.length+1];
            allPoints[0]=new PressurePoint(0,0);


            //skopiuj punkty powyzej punktu 0,0
            for (int i=points.length-1;i>1;i--){
                allPoints[i]=points[i-1];
            }

            //!!!!!  interpolacja wielomianowa (wstawic algorytm)!!!!!
            //for (int i=0 to )
        }


    }

    public double getV(double dp){
        return 0; //dopracowac funkcje odwrotna
    }

    public double getDp(double v){
        return x3*v*v*v+x2*v*v+x1*v;
    }


}
