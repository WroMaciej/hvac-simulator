package wromaciej.hvac_sim.simulation.general;

import wromaciej.hvac_sim.simulation.general.data.AllElements;
import wromaciej.hvac_sim.simulation.general.data.View;
import wromaciej.hvac_sim.simulation.solver.generalSolver.SimulationSolver;
import wromaciej.hvac_sim.core.model.User;
import wromaciej.hvac_sim.simulation.thermo.devices.service.DefaultItemFactory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "public")
public class Simulation {

    @Id
    @Column(name = "id")
    private Integer simulationId;


    //private AllElements allElements;

    @Column(name = "view_id")
    private Integer viewId;

    @Column(name = "solver_id")
    private Integer simulationSolverId;

    @Column(name = "ownet_user_id")
    private Integer ownerUser;

    @Column(name = "name")
    private String simulationName;

    @Column(name = "description")
    private String simulationDescription;

    @Column(name = "default_item_factory_id")
    private Integer defaultItemFactoryId;

    @Column(name = "is_active")
    private Boolean isActive;


    public Integer getSimulationId() {
        return simulationId;
    }

    public void setSimulationId(Integer simulationId) {
        this.simulationId = simulationId;
    }

    public Integer getViewId() {
        return viewId;
    }

    public void setViewId(Integer viewId) {
        this.viewId = viewId;
    }

    public Integer getSimulationSolverId() {
        return simulationSolverId;
    }

    public void setSimulationSolverId(Integer simulationSolverId) {
        this.simulationSolverId = simulationSolverId;
    }

    public Integer getOwnerUser() {
        return ownerUser;
    }

    public void setOwnerUser(Integer ownerUser) {
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

    public Integer getDefaultItemFactoryId() {
        return defaultItemFactoryId;
    }

    public void setDefaultItemFactoryId(Integer defaultItemFactoryId) {
        this.defaultItemFactoryId = defaultItemFactoryId;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
