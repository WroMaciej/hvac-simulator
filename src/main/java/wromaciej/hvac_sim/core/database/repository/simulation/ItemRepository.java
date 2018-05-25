package wromaciej.hvac_sim.core.database.repository.simulation;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import wromaciej.hvac_sim.simulation.thermo.generals.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Integer> {
}
