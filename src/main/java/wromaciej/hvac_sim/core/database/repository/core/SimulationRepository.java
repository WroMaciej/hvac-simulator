package wromaciej.hvac_sim.core.database.repository.core;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import wromaciej.hvac_sim.simulation.general.Simulation;

@Repository
public interface SimulationRepository extends CrudRepository<Simulation, Integer> {
}
