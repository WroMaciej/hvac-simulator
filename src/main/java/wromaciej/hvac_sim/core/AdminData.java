package wromaciej.hvac_sim.core;

import org.springframework.stereotype.Service;
import wromaciej.hvac_sim.core.user.User;
import wromaciej.hvac_sim.simulation.Simulation;

import java.util.Map;

@Service
public class AdminData {

    private Map<Integer, User> users;
    private Map<Integer, Simulation> simulations;
}
