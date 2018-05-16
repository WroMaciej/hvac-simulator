package wromaciej.hvac_sim.simulation.view;

public enum PaperSheetSize {
    A4(210, 297),
    A3(297, 420),
    A2(420, 594),
    A1(594, 841);

    private int width;
    private int height;

    PaperSheetSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
