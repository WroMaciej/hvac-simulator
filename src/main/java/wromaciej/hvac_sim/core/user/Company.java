package wromaciej.hvac_sim.core.user;

import wromaciej.hvac_sim.simulation.view.PaperSheet;
import wromaciej.hvac_sim.thermo.unitSystems.UnitSystem;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private final int companyID;
    private final String companyName;
    private final String country;
    private final String taxNumber;
    private final LicenseVersion licenseVersion;
    private final Language language;
    private final UnitSystem defaultUnitSystem;
    private final PaperSheet defaultPaperSheet;
    private List<User> companyUsers;
    private String logo; //TODO change logo to a image file

    public Company(int companyID, String companyName, String country, String taxNumber, LicenseVersion licenseVersion, Language language, UnitSystem defaultUnitSystem, PaperSheet defaultPaperSheet) {
        this.companyID = companyID;
        this.companyName = companyName;
        this.country = country;
        this.taxNumber = taxNumber;
        this.licenseVersion = licenseVersion;
        this.language = language;
        this.defaultUnitSystem = defaultUnitSystem;
        this.defaultPaperSheet = defaultPaperSheet;
        this.companyUsers = new ArrayList<>();
    }

    public List<User> getCompanyUsers() {
        return companyUsers;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCountry() {
        return country;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public LicenseVersion getLicenseVersion() {
        return licenseVersion;
    }

    public Language getLanguage() {
        return language;
    }

    public UnitSystem getDefaultUnitSystem() {
        return defaultUnitSystem;
    }

    public PaperSheet getDefaultPaperSheet() {
        return defaultPaperSheet;
    }
}
