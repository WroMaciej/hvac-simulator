package wromaciej.hvac_sim.simulation.general.view;

import wromaciej.hvac_sim.core.model.Company;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "papersheet")
@Table(name = "papersheet", schema = "simulation")
public class PaperSheet {

    @Id
    @Column(name = "id")
    private Integer paperSheetId;
    @Column(name = "size")
    private PaperSheetSize paperSheetSize;
    @Column(name = "orientation")
    private PaperSheetOrientation paperSheetOrientation;

    /**
     * How many pixels represents 1mm
     */
    @Column(name = "scale")
    private Double scale;


    @OneToMany
    private Set<Company> companies;

    public PaperSheet(Integer paperSheetId, PaperSheetSize paperSheetSize, PaperSheetOrientation paperSheetOrientation, Double scale, Set<Company> companies) {
        this.paperSheetId = paperSheetId;
        this.paperSheetSize = paperSheetSize;
        this.paperSheetOrientation = paperSheetOrientation;
        this.scale = scale;
        this.companies = companies;
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

    public Double getScale() {
        return scale;
    }

    public void setScale(Double scale) {
        this.scale = scale;
    }

    public Set<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }
}
