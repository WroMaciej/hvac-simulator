package wromaciej.hvac_sim.thermo.devices.model.basic;

import java.util.Objects;

public class Bond {

    private final int bondId;
    private final int ownerId;
    private int targetId;

    public Bond(int bondId, int ownerId) {
        this.bondId = bondId;
        this.ownerId = ownerId;
    }

    public void connectTo(int targetId){
        this.targetId = targetId;
    }

    public int getBondId() {
        return bondId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public int getConnectedToId() {
        return targetId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bond bond = (Bond) o;
        return bondId == bond.bondId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(bondId);
    }
}
