package wromaciej.hvac_sim.core.user;

import wromaciej.hvac_sim.simulation.Simulation;
import wromaciej.hvac_sim.simulation.view.PaperSheet;
import wromaciej.hvac_sim.thermo.unitSystems.UnitSystem;

import java.util.List;

public class User {
    private final int userID;
    private boolean isLogged;
    private String personalTitle;
    private String firstName;
    private String lastName;
    private CompanyData companyData;
    private Language language;
    private UnitSystem defaultUnitSystem;
    private PaperSheet defaultPaperSheet;
    private List<Simulation> allSimulations;
    private Simulation currentSimulation;

    public User(int userID, boolean isLogged, String personalTitle, String firstName, String lastName, CompanyData companyData, Language language, UnitSystem defaultUnitSystem, PaperSheet defaultPaperSheet, List<Simulation> allSimulations, Simulation currentSimulation) {
        this.userID = userID;
        this.isLogged = isLogged;
        this.personalTitle = personalTitle;
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyData = companyData;
        this.language = language;
        this.defaultUnitSystem = defaultUnitSystem;
        this.defaultPaperSheet = defaultPaperSheet;
        this.allSimulations = allSimulations;
        this.currentSimulation = currentSimulation;
    }
}
