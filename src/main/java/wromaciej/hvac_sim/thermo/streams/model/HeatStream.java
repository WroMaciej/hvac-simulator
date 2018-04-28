package wromaciej.hvac_sim.thermo.streams.model;

import wromaciej.hvac_sim.ids.IdGenerator;
import wromaciej.hvac_sim.solver.result.SolverResultType;
import wromaciej.hvac_sim.thermo.devices.model.basic.Device;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.quantities.extensive.HeatFlow;

public final class HeatStream extends AnyStream {
    private Parameter<HeatFlow> heatFlow;
    public final InletBond<HeatStream, Device> inletBond;
    public final OutletBond<HeatStream, Device> outletBond;



    public HeatStream(int id, IdGenerator idGenerator, Parameter<HeatFlow> heatFlow) {
        super(id, idGenerator);
        this.heatFlow = heatFlow;
        inletBond = new InletBond<>(idGenerator.getUniqueId(), this);
        outletBond = new OutletBond<>(idGenerator.getUniqueId(), this);
    }

    public Parameter<HeatFlow> getHeatFlow() {
        return heatFlow;
    }


    @Override
    public String display() {
        return null;
    }


    @Override
    public SolverResultType solve() {
        return null;
    }
}
