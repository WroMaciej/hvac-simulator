package wromaciej.hvac_sim.core.server;

import org.springframework.stereotype.Component;
import wromaciej.hvac_sim.core.model.User;
import wromaciej.hvac_sim.simulation.general.Simulation;

import java.util.Map;

@Component
public class Server {

    private Map<Integer, User> activeUsers;
    private Map<Integer, Simulation> activeSimulations;


    public Map<Integer, User> getActiveUsers() {
        return activeUsers;
    }

    public void setActiveUsers(Map<Integer, User> activeUsers) {
        this.activeUsers = activeUsers;
    }

    public Map<Integer, Simulation> getActiveSimulations() {
        return activeSimulations;
    }

    public void setActiveSimulations(Map<Integer, Simulation> activeSimulations) {
        this.activeSimulations = activeSimulations;
    }
}
