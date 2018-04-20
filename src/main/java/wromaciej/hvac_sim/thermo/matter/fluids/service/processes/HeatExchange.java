package wromaciej.hvac_sim.thermo.matter.fluids.service.processes;

import wromaciej.hvac_sim.thermo.matter.fluids.model.Fluid;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.quantities.specific.PressureDifference;

public class PressureDropProcess {

    private int pressureIntervals;

    public PressureDropProcess(int pressureIntervals) {
        this.pressureIntervals = pressureIntervals;
    }

    public Fluid pressureDropProcess(Fluid process, Parameter<PressureDifference> pressureDrop, int intervals) {
        Fluid fluidAfterStep;
        for (int stepNumber = 0; stepNumber < intervals; stepNumber++) {
            Fluid
        }


    }

}
