package wromaciej.hvac_sim.simulation.view;

import javafx.geometry.Orientation;

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
        double actualWidth;
        if (paperSheetOrientation == PaperSheetOrientation.HORIZONTAL) actualWidth = paperSheetSize.getWidth();
        else actualWidth = paperSheetSize.getHeight();
        return actualWidth;
    }

    public double getPaperHeight() {
        double actualHeight;
        if (paperSheetOrientation == PaperSheetOrientation.HORIZONTAL) actualHeight = paperSheetSize.getHeight();
        else actualHeight = paperSheetSize.getHeight();
        return actualHeight;
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
