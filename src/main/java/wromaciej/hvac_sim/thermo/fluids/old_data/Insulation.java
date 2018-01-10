package wromaciej.hvac_sim.thermo.fluids.old_data;

public enum Insulation {
    MLI(1),
    BRICK(2),
    CONCRETE(3),
    POLYSTYRENE(4),
    ROCKWOOL(5),
    FIBERGLASS(6),
    OTHER(7,0.005)
    ;

    private String name; //nazwa wlasna izolacji
    // REVIEW: w przyszłości zainteresuj się tym: http://jscience.org/api/overview-summary.html#TUTORIAL
    // Dzięki temu nie będziesz musiał pamiętać w jakiej jednostce jest dane coś i będziesz po prostu dodawał cm do m
    // itp.
    private double thicknessMM; //glubosc izolacji mm
    private double lambda; //wspolczynnik przewodzenia W/mK

    private Insulation(double thicknessMM){
        this.thicknessMM=thicknessMM;
        this.name="NoName insualation";
        // REVIEW: możesz przyjąć lambdę w konstruktorze podobnie jak thickness
        switch (Insulation.this){
            case MLI            : this.lambda=0.001;
            case BRICK          : this.lambda=0.002;
            case CONCRETE       : this.lambda=0.003;
            case POLYSTYRENE    : this.lambda=0.004;
            case ROCKWOOL       : this.lambda=0.005;
            case FIBERGLASS     : this.lambda=0.006;
        }


    }
    private Insulation(double thicknessMM, double lambda){
        this.thicknessMM=thicknessMM;
        this.lambda=lambda;
        this.name="NoName insualation";
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public double getThicknessMM() {
        return thicknessMM;
    }

    public double getLambda() {
        return lambda;
    }
}
