package wromaciej.hvac_sim.simulation.general.view;

import wromaciej.hvac_sim.core.model.Company;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(schema = "simulation")
public class PaperSheet {

    @Id
    @Column(name = "id")
    private Integer paperSheetId;
    @Column(name = "size")
    private PaperSheetSize paperSheetSize;
    @Column(name = "orientation")
    private PaperSheetOrientation paperSheetOrientation;

    @OneToMany(mappedBy = "company")
    private Set<Company> companies;

    /**
     * How many pixels represents 1mm
     */
    private double scale;

    public PaperSheet(Integer paperSheetId, PaperSheetSize paperSheetSize, PaperSheetOrientation paperSheetOrientation, Set<Company> companies, double scale) {
        this.paperSheetId = paperSheetId;
        this.paperSheetSize = paperSheetSize;
        this.paperSheetOrientation = paperSheetOrientation;
        this.companies = companies;
        this.scale = scale;
    }

    public double getPaperWidth() {
        if (paperSheetOrientation == PaperSheetOrientation.HORIZONTAL) return paperSheetSize.getWidth();
        else return paperSheetSize.getHeight();
    }

    public double getPaperHeight() {
        if (paperSheetOrientation == PaperSheetOrientation.HORIZONTAL) return paperSheetSize.getHeight();
        else return paperSheetSize.getHeight();
    }

    public double getPaperWidthWithScale() {
        return getPaperWidth() * scale;
    }

    public double getPaperHeightWithScale() {
        return getPaperHeight() * scale;
    }

    public PaperSheetSize getPaperSheetSize() {
        return paperSheetSize;
    }

    public PaperSheetOrientation getPaperSheetOrientation() {
        return paperSheetOrientation;
    }

    public double getScale() {
        return scale;
    }

    public Integer getPaperSheetId() {
        return paperSheetId;
    }

    public void setPaperSheetId(Integer paperSheetId) {
        this.paperSheetId = paperSheetId;
    }

    public void setPaperSheetSize(PaperSheetSize paperSheetSize) {
        this.paperSheetSize = paperSheetSize;
    }

    public void setPaperSheetOrientation(PaperSheetOrientation paperSheetOrientation) {
        this.paperSheetOrientation = paperSheetOrientation;
    }

    public Set<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }
}
