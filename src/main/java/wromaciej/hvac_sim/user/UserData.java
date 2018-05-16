package wromaciej.hvac_sim.user;

import wromaciej.hvac_sim.simulation.Simulation;
import wromaciej.hvac_sim.simulation.view.PaperSheet;
import wromaciej.hvac_sim.thermo.unitSystems.UnitSystem;

import java.util.List;

public class UserData {
    private final int userID;
    private String personalTitle;
    private String firstName;
    private String lastName;
    private CompanyData companyData;
    private Language language;
    private UnitSystem defaultUnitSystem;
    private PaperSheet defaultPaperSheet;
    private List<Simulation> allSimulations;
    private Simulation currentSimulation;

    public UserData(int userID, String personalTitle, String firstName, String lastName, CompanyData companyData, Language language, UnitSystem defaultUnitSystem, PaperSheet defaultPaperSheet) {
        this.userID = userID;
        this.personalTitle = personalTitle;
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyData = companyData;
        this.language = language;
        this.defaultUnitSystem = defaultUnitSystem;
        this.defaultPaperSheet = defaultPaperSheet;
    }
}
