package wromaciej.hvac_sim.thermo.devices.model.basic;

import wromaciej.hvac_sim.solver.result.SolverResult;
import wromaciej.hvac_sim.thermo.generals.Item;
import wromaciej.hvac_sim.ids.IdGenerator;

public abstract class Device extends Item {

    public Device(int id, IdGenerator idGenerator) {
        super(id, idGenerator);
    }

    public void update(){}

    @Override
    public SolverResult solve() {
        update();
        SolverResult solverResult = super.solve();
        update();
        return solverResult;
    }
}
