package wromaciej.hvac_sim.core.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServerService {

    private Server server;
    private ServerRepository serverRepository;

    @Autowired
    public ServerService(Server server, ServerRepository serverRepository) {
        this.server = server;
        this.serverRepository = serverRepository;
    }
}
