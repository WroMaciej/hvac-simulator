package wromaciej.hvac_sim.core.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wromaciej.hvac_sim.core.database.repository.core.CompanyRepository;

@Service
public class ServerService {

    private Server server;
    private CompanyRepository companyRepository;

    @Autowired
    public ServerService(Server server, CompanyRepository companyRepository) {
        this.server = server;
        this.companyRepository = companyRepository;
    }
}
