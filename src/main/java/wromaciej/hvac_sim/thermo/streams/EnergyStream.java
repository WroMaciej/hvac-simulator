package wromaciej.hvac_sim.thermo.streams;

public class EnergyStream {
    private double energy; //strumien energii kW
    private enum EnergyType{
        HEAT,
        COLD,
        ELECTRICITY,
        MECHANICAL;
    }
}
