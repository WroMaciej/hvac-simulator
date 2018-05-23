package wromaciej.hvac_sim.ids;


import java.util.concurrent.atomic.AtomicInteger;

public class Ids implements IdGenerator {

    private AtomicInteger maximalId;

    public Ids() {
        maximalId = new AtomicInteger();
    }

    @Override
    public int getUniqueId(){
        return maximalId.incrementAndGet();
    }



}
