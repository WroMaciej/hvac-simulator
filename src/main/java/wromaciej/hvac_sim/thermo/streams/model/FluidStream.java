package wromaciej.hvac_sim.thermo.streams.model;

import wromaciej.hvac_sim.ids.IdGenerator;
import wromaciej.hvac_sim.thermo.matter.fluids.model.Fluid;

public class FluidStream extends MaterialStream {

    private Fluid specificParameters;

    public FluidStream(int id, IdGenerator idGenerator, Fluid specificParameters, Fluid specificParameters1) {
        super(id, idGenerator, specificParameters);
        this.specificParameters = specificParameters1;
    }
}
