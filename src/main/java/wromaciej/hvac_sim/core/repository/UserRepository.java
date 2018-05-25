package wromaciej.hvac_sim.core.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import wromaciej.hvac_sim.core.user.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
