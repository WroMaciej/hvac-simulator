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

    @Column(name = "is_logged")
    private boolean isLogged;
    @Column(name = "personal_title")
    private String personalTitle;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @Column(name = "language_id")
    private int languageId;
    @Column(name = "default_unitsystem_id")
    private int defaultUnitSystemId;
    @Column(name = "default_papersheet_id")
    private int defaultPaperSheetId;

    @Column(name = "current_simulation_id")
    private int currentSimulationId;


    public User(Integer userID, boolean isLogged, String personalTitle, String firstName, String lastName, Company company, Language language, UnitSystem defaultUnitSystem, PaperSheet defaultPaperSheet, int currentSimulationId) {
        this.userID = userID;
        this.isLogged = isLogged;
        this.personalTitle = personalTitle;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.language = language;
        this.defaultUnitSystem = defaultUnitSystem;
        this.defaultPaperSheet = defaultPaperSheet;
        this.currentSimulationId = currentSimulationId;
    }
}
