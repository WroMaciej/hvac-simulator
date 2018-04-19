package wromaciej.hvac_sim.thermo.bonds;

import org.junit.Test;
import wromaciej.hvac_sim.ids.IdGenerator;
import wromaciej.hvac_sim.ids.Ids;
import wromaciej.hvac_sim.thermo.devices.model.basic.Device;
import wromaciej.hvac_sim.thermo.devices.model.basic.Heater;
import wromaciej.hvac_sim.thermo.devices.model.basic.bonds.OutletBond;
import wromaciej.hvac_sim.thermo.matter.fluids.model.Fluid;
import wromaciej.hvac_sim.thermo.streams.model.FluidStream;

public class BondTest {

    @Test
    public void shouldAllowToBondInletDeviceToStreamOutlet(){
        //GIVEN
        IdGenerator idGenerator = new Ids();
        Fluid fluid = new Fluid();
        FluidStream fluidStream = new FluidStream(idGenerator.getUniqueId(), idGenerator, fluid);
        Heater heater = new Heater(idGenerator.getUniqueId(), idGenerator);

        //WHEN
        OutletBond<FluidStream, Device> outletBond = new OutletBond<>(idGenerator.getUniqueId(), heater);
        outletBond.connectTo(heater.getFluidInlet()); //IT WORKS
        outletBond.connectTo(heater.getFluidOutlet()); //IT DOES NOT WORK - GOOD

        fluidStream.getOutletBond().connectTo(heater.getFluidInlet()); //IT DOES NOT WORK - BAD


    }
}
