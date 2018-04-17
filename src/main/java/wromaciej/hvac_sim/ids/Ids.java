package wromaciej.hvac_sim.ids;

import wromaciej.hvac_sim.display.Item;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Ids implements IdGenerator {

    private AtomicInteger maximalId;

    @Override
    public  int getUniqueId(){
        return maximalId.incrementAndGet();
    }

    public Ids() {}

}
