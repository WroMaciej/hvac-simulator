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
@Table(schema = "core")
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

    @ManyToOne
    @JoinColumn(name = "default_unitsystem_id")
    private UnitSystem defaultUnitSystem;


    @ManyToOne
    @JoinColumn(name = "default_papersheet_id", nullable = false)
    private PaperSheet defaultPaperSheet;

    @OneToMany(mappedBy = "company")
    private Set<User> users;

    @Transient
    private String logo; //TODO change logo to a image file

    public Company() {
    }

    public Company(Integer companyID, String companyName, String country, String taxNumber, LicenseVersion licenseVersion, Language language, UnitSystem defaultUnitSystem, PaperSheet defaultPaperSheet, Set<User> users, String logo) {
        this.companyID = companyID;
        this.companyName = companyName;
        this.country = country;
        this.taxNumber = taxNumber;
        this.licenseVersion = licenseVersion;
        this.language = language;
        this.defaultUnitSystem = defaultUnitSystem;
        this.defaultPaperSheet = defaultPaperSheet;
        this.users = users;
        this.logo = logo;
    }

    public Integer getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Integer companyID) {
        this.companyID = companyID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public LicenseVersion getLicenseVersion() {
        return licenseVersion;
    }

    public void setLicenseVersion(LicenseVersion licenseVersion) {
        this.licenseVersion = licenseVersion;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public UnitSystem getDefaultUnitSystem() {
        return defaultUnitSystem;
    }

    public void setDefaultUnitSystem(UnitSystem defaultUnitSystem) {
        this.defaultUnitSystem = defaultUnitSystem;
    }

    public PaperSheet getDefaultPaperSheet() {
        return defaultPaperSheet;
    }

    public void setDefaultPaperSheet(PaperSheet defaultPaperSheet) {
        this.defaultPaperSheet = defaultPaperSheet;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
