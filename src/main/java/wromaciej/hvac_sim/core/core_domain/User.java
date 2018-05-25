package wromaciej.hvac_sim.core.core_domain;

import wromaciej.hvac_sim.simulation.general.Simulation;
import wromaciej.hvac_sim.simulation.general.view.PaperSheet;
import wromaciej.hvac_sim.thermo.unitSystems.UnitSystem;

import java.util.Map;

public class User {
    private final Integer userID;
    private boolean isLogged;
    private String personalTitle;
    private String firstName;
    private String lastName;
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
