//package wromaciej.hvac_sim;
//
//import wromaciej.hvac_sim.thermo.controller.FluidData;
//import wromaciej.hvac_sim.thermo.matter.fluids.model.Fluid;
//import wromaciej.hvac_sim.thermo.matter.fluids.serviceOLD.FluidFactory;
//
//import java.util.Scanner;
//
//
//public class Application {
//    public static void main(String[] args) {
//        //System.out.println(System.getProperty("java.library.path"));
//        System.loadLibrary("CoolProp");
//
//
//        String substanceName;
//        String parameter1, parameter2;
//        double value1, value2;
//        Fluid fluid1;
//        Scanner in = new Scanner(System.in);
//
//
//        System.out.println("Available fluids:");
//        System.out.println(FluidData.getSubstancesList());
//        System.out.println();
//        System.out.println("Available parameters");
//        System.out.println(FluidData.getParametersList());
//
//
//        while (true) {
//            System.out.print("Set fluid name: ");
//            substanceName = in.nextLine();
//
//            System.out.print("Set parameter 1: ");
//            parameter1 = in.nextLine();
//            System.out.print("Set value of parameter 1: ");
//            value1 = Double.parseDouble(in.nextLine());
//            System.out.print("Set parameter 2: ");
//            parameter2 = in.nextLine();
//            System.out.print("Set value parameter 2: ");
//            value2 = Double.parseDouble(in.nextLine());
//
//            fluid1 = FluidFactory.createGeneral(FluidData.stringToSubstanceName(substanceName),
//                    FluidData.stringToSubstanceParameterType(parameter1),
//                    value1,
//                    FluidData.stringToSubstanceParameterType(parameter2),
//                    value2);
//            System.out.println(fluid1);
//            System.out.println("---- AS REFRIGERANT: ----");
//            fluid1 = FluidFactory.createRefrigerant(FluidData.stringToSubstanceName(substanceName),
//                    FluidData.stringToSubstanceParameterType(parameter1),
//                    value1,
//                    FluidData.stringToSubstanceParameterType(parameter2),
//                    value2);
//            System.out.println(fluid1);
//
//
//
//        }
//
//
//    }
//}
