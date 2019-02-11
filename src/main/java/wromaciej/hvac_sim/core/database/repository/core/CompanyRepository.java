package wromaciej.hvac_sim.core.database.repository.core;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import wromaciej.hvac_sim.core.model.Company;


@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {



}
