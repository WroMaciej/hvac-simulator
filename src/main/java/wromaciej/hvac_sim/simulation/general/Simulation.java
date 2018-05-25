package wromaciej.hvac_sim.simulation.general;

import wromaciej.hvac_sim.simulation.general.data.AllElements;
import wromaciej.hvac_sim.simulation.general.data.View;
import wromaciej.hvac_sim.simulation.solver.generalSolver.SimulationSolver;
import wromaciej.hvac_sim.core.domain.User;
import wromaciej.hvac_sim.simulation.thermo.devices.service.DefaultItemFactory;

public class Simulation {

    private final Integer simulationId;
    private AllElements allElements;
    private View view;
    private SimulationSolver simulationSolver;
    private User ownerUser;
    private String simulationName;
    private String simulationDescription;
    private DefaultItemFactory defaultItemFactory;
    private boolean isActive;

    public Simulation(Integer simulationId) {
        this.simulationId = simulationId;
    }

    public AllElements getAllElements() {
        return allElements;
    }

    public void setAllElements(AllElements allElements) {
        this.allElements = allElements;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public SimulationSolver getSimulationSolver() {
        return simulationSolver;
    }

    public void setSimulationSolver(SimulationSolver simulationSolver) {
        this.simulationSolver = simulationSolver;
    }

    public User getOwnerUser() {
        return ownerUser;
    }

    public void setOwnerUser(User ownerUser) {
        this.ownerUser = ownerUser;
    }

    public String getSimulationName() {
        return simulationName;
    }

    public void setSimulationName(String simulationName) {
        this.simulationName = simulationName;
    }

    public String getSimulationDescription() {
        return simulationDescription;
    }

    public void setSimulationDescription(String simulationDescription) {
        this.simulationDescription = simulationDescription;
    }

    public DefaultItemFactory getDefaultItemFactory() {
        return defaultItemFactory;
    }

    public void setDefaultItemFactory(DefaultItemFactory defaultItemFactory) {
        this.defaultItemFactory = defaultItemFactory;
    }

    public Integer getSimulationId() {
        return simulationId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
