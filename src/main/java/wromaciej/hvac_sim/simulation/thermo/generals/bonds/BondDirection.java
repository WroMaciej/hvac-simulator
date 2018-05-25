package wromaciej.hvac_sim.simulation.thermo.generals.bonds;

public enum BondDirection {

    INLET(1),
    OUTLET(-1);

    public int balanceMultiplyer;

    BondDirection(int balanceMultiplyer) {
        this.balanceMultiplyer = balanceMultiplyer;
    }
}
