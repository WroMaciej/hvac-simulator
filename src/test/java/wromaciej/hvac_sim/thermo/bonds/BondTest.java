package wromaciej.hvac_sim.thermo.bonds;

import org.junit.Test;
import wromaciej.hvac_sim.ids.IdGenerator;
import wromaciej.hvac_sim.ids.Ids;
import wromaciej.hvac_sim.thermo.devices.model.basic.Heater;
import wromaciej.hvac_sim.thermo.matter.fluids.model.Fluid;
import wromaciej.hvac_sim.thermo.streams.model.MatterStream;

public class BondTest {

    @Test
    public void shouldAllowToBondInletDeviceToStreamOutlet(){
        //GIVEN
        IdGenerator idGenerator = new Ids();
        Fluid fluid = new Fluid();
        MatterStream matterStream = new MatterStream(idGenerator.getUniqueId(), idGenerator, fluid);
        Heater heater = new Heater(idGenerator.getUniqueId(), idGenerator);



        //WHEN
        matterStream.outletBond.connectTo(heater.fluidInletBond);


    }
}
