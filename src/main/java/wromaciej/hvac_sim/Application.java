package wromaciej.hvac_sim;

import wromaciej.hvac_sim.thermo.controller.ThermoCPAdapter;
import wromaciej.hvac_sim.thermo.fluids.data.Substance;
import wromaciej.hvac_sim.thermo.fluids.data.SubstanceFactory;

import java.util.Scanner;


public class Application {
    public static void main(String[] args) {
        //System.out.println(System.getProperty("java.library.path"));
        System.loadLibrary("CoolProp");


        String substanceName;
        String parameter1, parameter2;
        double value1, value2;
        Substance substance1;
        Scanner in = new Scanner(System.in);


        System.out.println("Available fluids:");
        System.out.println(ThermoCPAdapter.getSubstancesList());
        System.out.println();
        System.out.println("Available parameters");
        System.out.println(ThermoCPAdapter.getParametersList());


        while (true) {
            System.out.print("Set fluid name: ");
            substanceName = in.nextLine();

            System.out.print("Set parameter 1: ");
            parameter1 = in.nextLine();
            System.out.print("Set value of parameter 1: ");
            value1 = Double.parseDouble(in.nextLine());
            System.out.print("Set parameter 2: ");
            parameter2 = in.nextLine();
            System.out.print("Set value parameter 2: ");
            value2 = Double.parseDouble(in.nextLine());

            substance1= SubstanceFactory.createGeneral(ThermoCPAdapter.stringToSubstanceName(substanceName),
                    ThermoCPAdapter.stringToSubstanceParameterType(parameter1),
                    value1,
                    ThermoCPAdapter.stringToSubstanceParameterType(parameter2),
                    value2);
            System.out.println(substance1);
            System.out.println("---- AS REFRIGERANT: ----");
            substance1= SubstanceFactory.createRefrigerant(ThermoCPAdapter.stringToSubstanceName(substanceName),
                    ThermoCPAdapter.stringToSubstanceParameterType(parameter1),
                    value1,
                    ThermoCPAdapter.stringToSubstanceParameterType(parameter2),
                    value2);
            System.out.println(substance1);



        }


    }
}
