package wromaciej.hvac_sim.thermo.generals.bonds;

import wromaciej.hvac_sim.thermo.generals.Bondable;
import wromaciej.hvac_sim.thermo.generals.Item;
import wromaciej.hvac_sim.thermo.streams.model.AnyStream;

import java.util.Objects;

public abstract class Bond<T extends AnyStream> {
    private final Integer bondId;
    /**
     * Id of the owner of the bond
     */

    /**
     * Flow direction in/out
     */
    private final BondDirection flowDirection;

    /**
     * Id of the bond
     */

    protected Item ownerItem;
    /**
     * Id of the object connected to
     */
    protected Bond targetBond;

    /**
     * Description of the bond
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Bond(Integer bondId, BondDirection flowDirection) {
        this.bondId = bondId;
        this.flowDirection = flowDirection;
    }

    public void disconnect(){
        this.targetBond =  null;
    }

    public Integer getBondId() {
        return bondId;
    }


    public Item getOwnerItem() {
        return ownerItem;
    }

    public void setOwnerItem(Item ownerItem) {
        this.ownerItem = ownerItem;
    }

    public Bond getTargetBond() {
        return targetBond;
    }

    public BondDirection getFlowDirection() {
        return flowDirection;
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
