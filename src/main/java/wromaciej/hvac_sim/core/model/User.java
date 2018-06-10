package wromaciej.hvac_sim.core.model;

import wromaciej.hvac_sim.core.user_version.Language;
import wromaciej.hvac_sim.simulation.general.Simulation;
import wromaciej.hvac_sim.simulation.general.view.PaperSheet;
import wromaciej.hvac_sim.simulation.thermo.unitSystems.UnitSystem;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(schema = "public")
public class User {
    @Id
    @Column(name = "id")
    private Integer userID;
    private boolean isLogged;
    private String personalTitle;
    private String firstName;
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
    private Language language;
    private UnitSystem defaultUnitSystem;
    private PaperSheet defaultPaperSheet;
    private Simulation currentSimulation;

    public User(Integer userID, boolean isLogged, String personalTitle, String firstName, String lastName, Company company, Language language, UnitSystem defaultUnitSystem, PaperSheet defaultPaperSheet, Map<Integer, Simulation> allSimulations) {
        this.userID = userID;
        this.isLogged = isLogged;
        this.personalTitle = personalTitle;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.language = language;
        this.defaultUnitSystem = defaultUnitSystem;
        this.defaultPaperSheet = defaultPaperSheet;
        this.currentSimulation = currentSimulation;
    }
}
