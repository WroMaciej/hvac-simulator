package wromaciej.hvac_sim.simulation.general.view;

public class PaperSheet {
    private PaperSheetSize paperSheetSize;
    private PaperSheetOrientation paperSheetOrientation;

    /**
     * How many pixels represents 1mm
     */
    private double scale;

    public PaperSheet(PaperSheetSize paperSheetSize, PaperSheetOrientation paperSheetOrientation, double scale) {
        this.paperSheetSize = paperSheetSize;
        this.paperSheetOrientation = paperSheetOrientation;
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


}
