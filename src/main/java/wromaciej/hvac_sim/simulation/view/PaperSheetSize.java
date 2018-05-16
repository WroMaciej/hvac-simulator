package wromaciej.hvac_sim.simulation.view;

public enum PaperSheetSize {
    A4(297, 210),
    A3(420, 297),
    A2(594, 420),
    A1(841, 594);

    private double width;
    private double height;

    PaperSheetSize(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
