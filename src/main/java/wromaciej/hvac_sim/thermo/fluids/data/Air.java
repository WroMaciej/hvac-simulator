package wromaciej.hvac_sim.thermo.fluids.data;

public class Air extends Substance {

protected double relativeHumidity;
protected double moistureContent;
protected double dewPoint;
protected double wetBulb;

    public Air(SubstanceName substanceName, double temperature, double pressure, double enthalpy, double entropy, double quality, double heatCapacity, double volume, double density) {
        super(substanceName, temperature, pressure, enthalpy, entropy, quality, heatCapacity, volume, density);
    }



}
