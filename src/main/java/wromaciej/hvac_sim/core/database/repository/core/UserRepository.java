package wromaciej.hvac_sim.core.database.repository.core;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import wromaciej.hvac_sim.core.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
