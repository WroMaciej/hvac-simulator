package wromaciej.hvac_sim.core.model;

import wromaciej.hvac_sim.core.user_version.Language;
import wromaciej.hvac_sim.core.user_version.LicenseVersion;
import wromaciej.hvac_sim.simulation.general.view.PaperSheet;
import wromaciej.hvac_sim.simulation.thermo.unitSystems.UnitSystem;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(schema = "public")
public class Company {

    @Id
    @Column(name = "id")
    private Integer companyID;

    @Column (name = "name")
    private String companyName;

    @Column(name = "country")
    private String country;

    @Column(name = "tax_number")
    private String taxNumber;

    @Column(name = "license_version")
    private LicenseVersion licenseVersion;

    @Column(name = "language")
    private Language language;

    @Column(name = "default_unitsystem_id")
    private int defaultUnitSystemId;

    //private final UnitSystem defaultUnitSystem;

    @Column(name = "default_papersheet_id")
    private int defaultPaperSheetId;

    //private final PaperSheet defaultPaperSheet;

    @OneToMany(mappedBy = "company")
    private Set<User> users;

    private String logo; //TODO change logo to a image file

    public Company(Integer companyID, String companyName, String country, String taxNumber, LicenseVersion licenseVersion, Language language, int defaultUnitSystemId, UnitSystem defaultUnitSystem, int defaultPaperSheetId, PaperSheet defaultPaperSheet, List<User> companyUsers, String logo) {
        this.companyID = companyID;
        this.companyName = companyName;
        this.country = country;
        this.taxNumber = taxNumber;
        this.licenseVersion = licenseVersion;
        this.language = language;
        this.defaultUnitSystemId = defaultUnitSystemId;
        this.defaultPaperSheetId = defaultPaperSheetId;
        this.logo = logo;
    }

    public Integer getCompanyID() {
        return companyID;
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

    public int getDefaultUnitSystemId() {
        return defaultUnitSystemId;
    }

    public String getLogo() {
        return logo;
    }
}
