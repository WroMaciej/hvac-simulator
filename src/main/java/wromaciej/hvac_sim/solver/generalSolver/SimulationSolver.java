package wromaciej.hvac_sim.solver.generalSolver;

import org.springframework.stereotype.Service;
import wromaciej.hvac_sim.simulation.data.AllElements;
import wromaciej.hvac_sim.solver.internals.Solvable;
import wromaciej.hvac_sim.solver.result.SolverResult;
import wromaciej.hvac_sim.thermo.devices.model.basic.Device;
import wromaciej.hvac_sim.thermo.generals.Item;
import wromaciej.hvac_sim.thermo.matter.Matter;
import wromaciej.hvac_sim.thermo.streams.model.MatterStream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SimulationSolver {

    private AllElements allElements;

    public SimulationSolver(AllElements allElements) {
        this.allElements = allElements;
    }

    public SolverResult solve(AllElements allElements){
        return null;
    }


}
