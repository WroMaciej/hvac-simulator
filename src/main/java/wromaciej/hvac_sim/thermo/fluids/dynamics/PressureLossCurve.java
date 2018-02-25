package wromaciej.hvac_sim.thermo.fluids.dynamics;

import java.util.Collections;
import java.util.List;

public class PressureLossCurve {
    private double coefficientToPowerOf3;
    private double coefficientToPowerOf2;
    private double coefficientToPowerOf1;
    private double relativeErrorOfInterpolation;

    private List<PressurePoint> installationCurvePoints;

    private int numberOfKnownPoints() {
        return installationCurvePoints.size();
    }

    public PressureLossCurve(List<PressurePoint> installationCurvePoints) {
        Collections.sort(installationCurvePoints); //sort collection from lowest to highest pressure
        coefficientToPowerOf1 = 0;
        coefficientToPowerOf2 = 0;
        coefficientToPowerOf3 = 0;
        //utworz tablice z punktem 0,0

        if (numberOfKnownPoints() == 1) //jesli podano tylko 1 punkt to wyznacz funkcje kwadratowa
        {
            coefficientToPowerOf2 =
                    installationCurvePoints.get(0).getPressure() / (Math.pow(installationCurvePoints.get(0).getFlow(), 2));
        }


    }

    public double getFlow(double pressureDrop) {
        return 0; //???
    }

    public double getPressureDrop(double flow) {
        return coefficientToPowerOf3 * Math.pow(flow, 3)
                + coefficientToPowerOf2 * Math.pow(flow, 2)
                + coefficientToPowerOf1 * Math.pow(flow, 1);
    }


}
