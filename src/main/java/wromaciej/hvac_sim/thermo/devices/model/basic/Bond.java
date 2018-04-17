package wromaciej.hvac_sim.thermo.devices.model.basic;

import wromaciej.hvac_sim.ids.Ids;

import java.util.Objects;

public class Bond {

    /**
     * Id of the bond
     */
    private final int bondId;
    /**
     * Id of the owner of the bond
     */
    private final int ownerId;
    /**
     * Id of the object connected to
     */
    private int targetId;

    public Bond(int ownerId) {
        this.bondId = Ids.getUniqueId();
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
