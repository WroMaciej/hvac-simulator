package wromaciej.hvac_sim.thermo.matter.fluids.service;

import thermoCP.CoolProp;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.FluidName;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.Parameter;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.ParameterType;

public class ThermoCPAdapter {

    public static Parameter findFluidParameter(ParameterType wantedParameterType, FluidName fluidName, Parameter knownParameter1, Parameter knownParameter2){
        Parameter wantedParameter = new Parameter();
        wantedParameter.setParameterType(wantedParameterType);
        wantedParameter.setActualUnit(wantedParameterType.getUnitInThermoCP());
        wantedParameter.setValue(
                CoolProp.PropsSI(
                wantedParameterType.getParameterSymbolInThermoCP(),
                knownParameter1.getParameterType().getParameterSymbolInThermoCP(),
                knownParameter1.getValueInThermoCPUnit(),
                knownParameter2.getParameterType().getParameterSymbolInThermoCP(),
                knownParameter2.getValueInThermoCPUnit() ,
                fluidName.enumToString()));

        return wantedParameter;
    }
}
