package wromaciej.hvac_sim.core.database.repository.core;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import wromaciej.hvac_sim.core.domain.Company;


@Repository
public interface CompanyRepository extends CrudRepository<Company, Integer> {



}
