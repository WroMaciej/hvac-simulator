package wromaciej.hvac_sim.core.model;

import wromaciej.hvac_sim.core.user_version.Language;
import wromaciej.hvac_sim.simulation.general.Simulation;
import wromaciej.hvac_sim.simulation.general.view.PaperSheet;
import wromaciej.hvac_sim.simulation.thermo.unitSystems.UnitSystem;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(schema = "core")
public class User {
    @Id
    @Column(name = "id")
    private Integer userID;

    @Column(name = "is_logged")
    private Boolean isLogged;
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
    private Integer languageId;
    @Column(name = "default_unitsystem_id")
    private Integer defaultUnitSystemId;
    @Column(name = "default_papersheet_id")
    private Integer defaultPaperSheetId;

    @Column(name = "current_simulation_id")
    private Integer currentSimulationId;


    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Boolean getLogged() {
        return isLogged;
    }

    public void setLogged(Boolean logged) {
        isLogged = logged;
    }

    public String getPersonalTitle() {
        return personalTitle;
    }

    public void setPersonalTitle(String personalTitle) {
        this.personalTitle = personalTitle;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    public Integer getDefaultUnitSystemId() {
        return defaultUnitSystemId;
    }

    public void setDefaultUnitSystemId(Integer defaultUnitSystemId) {
        this.defaultUnitSystemId = defaultUnitSystemId;
    }

    public Integer getDefaultPaperSheetId() {
        return defaultPaperSheetId;
    }

    public void setDefaultPaperSheetId(Integer defaultPaperSheetId) {
        this.defaultPaperSheetId = defaultPaperSheetId;
    }

    public Integer getCurrentSimulationId() {
        return currentSimulationId;
    }

    public void setCurrentSimulationId(Integer currentSimulationId) {
        this.currentSimulationId = currentSimulationId;
    }
}
