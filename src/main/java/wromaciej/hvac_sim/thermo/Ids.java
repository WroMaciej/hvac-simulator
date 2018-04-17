package wromaciej.hvac_sim.thermo;

import wromaciej.hvac_sim.display.Item;

import java.util.HashMap;
import java.util.Set;

public class Ids {

    private static HashMap<Integer, Item> items;

    private static int maximalId;


    public static int getUniqueId(){
        maximalId++;
        return maximalId;
    }

    public Ids() {
        maximalId=0;
        items = new HashMap<>();
    }

    public Item getItem(){

    }
}
