package wromaciej.hvac_sim.display;

/**
 * Any object that could be treated as a part of process
 */
public class Item {

    private final int id;
    private final Displayable object;
    private String name;
    private double scale;

    private double positionX;
    private double positionY;

    public Item(int id, Displayable object) {
        this.id = id;
        this.object = object;
    }
}
