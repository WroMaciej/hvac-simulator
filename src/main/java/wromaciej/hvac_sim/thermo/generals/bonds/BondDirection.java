package wromaciej.hvac_sim.thermo.generals.bonds;

public enum BondDirection {

    INLET(1),
    OUTLET(-1);

    int balanceMultiplyer;

    BondDirection(int balanceMultiplyer) {
        this.balanceMultiplyer = balanceMultiplyer;
    }
}
