package wromaciej.hvac_sim.solver.result;

public class SolverResult {
    private final String message;
    private final SolverResultType resultType;

    public SolverResult(String message, SolverResultType resultType) {
        this.message = message;
        this.resultType = resultType;
    }

    public String getMessage() {
        return message;
    }

    public SolverResultType getResultType() {
        return resultType;
    }
}
