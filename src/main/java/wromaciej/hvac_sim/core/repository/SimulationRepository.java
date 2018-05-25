package wromaciej.hvac_sim.core.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import wromaciej.hvac_sim.simulation.Simulation;

@Repository
public interface SimulationRepository extends CrudRepository<Simulation, Integer> {
}
