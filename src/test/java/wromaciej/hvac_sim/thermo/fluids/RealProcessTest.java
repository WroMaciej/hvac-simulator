package wromaciej.hvac_sim.thermo.fluids;

import org.junit.Test;
import wromaciej.hvac_sim.thermo.matter.fluids.model.Fluid;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.FluidName;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.ParameterType;
import wromaciej.hvac_sim.thermo.matter.fluids.service.FluidData;
import wromaciej.hvac_sim.thermo.matter.fluids.service.FluidFactory;
import wromaciej.hvac_sim.thermo.matter.fluids.service.RealProcess;
import wromaciej.hvac_sim.thermo.quantities.specific.Efficiency;
import wromaciej.hvac_sim.thermo.quantities.specific.Pressure;
import wromaciej.hvac_sim.thermo.quantities.specific.Quality;

import javax.measure.quantity.Dimensionless;
import javax.measure.unit.NonSI;

import static org.junit.Assert.assertEquals;

public class RealProcessTest {

    static {
        //load library
        FluidData.loadLibrary();
    }

    @Test
    public void shouldReturnSameEndPointForIdealCompressionAndRealWith100PercentEfficiency(){
        //GIVEN
        Parameter<Pressure> startPointPressure = new Parameter(ParameterType.PRESSURE, NonSI.BAR, 8.0);
        Parameter<Quality> startPointQuality = new Parameter(ParameterType.QUALITY, Dimensionless.UNIT, 1.0);
        Fluid startPoint = FluidFactory.createFluid(FluidName.R134A, startPointPressure, startPointQuality );
        Parameter<Pressure> endPressure = new Parameter(ParameterType.PRESSURE, NonSI.BAR, 20.0);
        Parameter<Efficiency> compressionEfficiency = new Parameter(Dimensionless.UNIT, 1.0);
        //WHEN
        Fluid idealCompressionEndPoint = RealProcess.idealCompression(startPoint, endPressure);
        Fluid realCompressionEndPoint = RealProcess.compression(startPoint, endPressure, compressionEfficiency);
        //THEN
        assertEquals(idealCompressionEndPoint, realCompressionEndPoint);
    }
}
