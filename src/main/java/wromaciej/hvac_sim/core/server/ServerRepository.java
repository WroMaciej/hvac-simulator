package wromaciej.hvac_sim.core.server;

import org.springframework.stereotype.Repository;
import wromaciej.hvac_sim.simulation.Simulation;

import java.util.Map;

@Repository
public class ServerRepository {

    public Map<Integer, Simulation> findActiveSimulations(){
        //TODO
        return null;
    }

}
