package wromaciej.hvac_sim.simulation.thermo.generals;

import wromaciej.hvac_sim.view.DisplayParameters;
import wromaciej.hvac_sim.view.Displayable;
import wromaciej.hvac_sim.ids.IdGenerator;
import wromaciej.hvac_sim.simulation.solver.internals.Solvable;
import wromaciej.hvac_sim.simulation.solver.externals.ExternalSolver;
import wromaciej.hvac_sim.simulation.solver.result.SolverResult;

import javax.persistence.*;

/**
 * Any object that could be treated as a part of process
 */

@Entity
@Table(schema = "simulation")
public abstract class Item implements Displayable, Solvable, Bondable {

    @Id
    @Column(name = "id")
    private Integer itemId;
    @Column(name = "name")
    private String name;
    @Column(name = "is_solved")
    private Boolean isSolved;

    @Transient
    private ExternalSolver externalSolver;
    @ManyToOne
    @JoinColumn(name = "display_parameters_id")
    private DisplayParameters displayParameters;

    public Item(Integer itemId, IdGenerator idGenerator) {
        this.itemId = itemId;
        isSolved = false;
    }

    public ExternalSolver getExternalSolver() {
        return externalSolver;
    }

    public void setExternalSolver(ExternalSolver externalSolver) {
        this.externalSolver = externalSolver;
    }


    public void setName(String name) {
        this.name = name;
    }

    public Integer getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public void setSolved(boolean solved) {
        isSolved = solved;
    }

    public DisplayParameters getDisplayParameters() {
        return displayParameters;
    }

    public void setDisplayParameters(DisplayParameters displayParameters) {
        this.displayParameters = displayParameters;
    }

    @Override
    public String toString() {
        return name;
    }


    @Override
    public SolverResult solve() {
        return externalSolver.solve(this);
    }

    @Override
    public boolean isSolved() {
        return isSolved;
    }

    @Override
    public String display() {
        return null;
    }
}
