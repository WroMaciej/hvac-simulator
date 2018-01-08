package wromaciej.hvac_sim;

import wromaciej.hvac_sim.thermo.ThermoCPAdapter;
import wromaciej.hvac_sim.thermo.fluids.data.Substance;
import wromaciej.hvac_sim.thermo.fluids.data.SubstanceName;
import wromaciej.hvac_sim.thermo.fluids.data.SubstanceParameter;
import wromaciej.hvac_sim.thermo.fluids.old_data.AllSpecific;

import java.util.Scanner;


public class Application {
    public static void main(String[] args) {
        //System.out.println(System.getProperty("java.library.path"));
        System.loadLibrary("CoolProp");

        AllSpecific fluid;
        String fluidName;
        String s1, s2;
        double v1, v2;
        Scanner in = new Scanner(System.in);


        while (true) {
            System.out.print("Podaj nazwę płynu: ");
            fluidName = in.nextLine();

            System.out.print("Podaj parametr 1: ");
            s1 = in.nextLine();
            System.out.print("Podaj wartość parametru 1: ");
            v1 = Double.parseDouble(in.nextLine());
            System.out.print("Podaj parametr 2: ");
            s2 = in.nextLine();
            System.out.print("Podaj wartość parametru 2: ");
            v2 = Double.parseDouble(in.nextLine());



        }


    }
}
