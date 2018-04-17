package wromaciej.hvac_sim.thermo;

import java.util.Set;

public class Ids {

    private static int maximalId;

    public static int getUniqueId(){
        maximalId++;
        return maximalId;
    }

    public Ids() {
        maximalId=0;
    }
}
