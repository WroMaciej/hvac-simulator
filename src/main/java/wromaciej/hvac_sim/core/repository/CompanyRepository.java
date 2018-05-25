package wromaciej.hvac_sim.core.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import wromaciej.hvac_sim.core.user.Company;


@Repository
public interface CompanyRepository extends CrudRepository<Company, Integer> {



}
