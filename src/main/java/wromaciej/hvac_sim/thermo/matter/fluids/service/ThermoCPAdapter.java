package wromaciej.hvac_sim.thermo.matter.fluids.service;

import thermoCP.CoolProp;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.*;
import wromaciej.hvac_sim.thermo.unitSystems.UnitSystem;

public class ThermoCPAdapter {

    public static FluidParameter findFluidParameter(ParameterType wantedParameterType, FluidName fluidName, FluidParameter knownParameter1, FluidParameter knownParameter2){
        FluidParameter wantedParameter = new FluidParameter();
        wantedParameter.setParameterType(wantedParameterType);
        wantedParameter.setActualUnit(wantedParameterType.getUnitInThermoCP());
        wantedParameter.setValue(
                CoolProp.PropsSI(
                    wantedParameterType.getParameterSymbolInThermoCP(),
                    knownParameter1.getParameterType().getParameterSymbolInThermoCP(),
                    knownParameter1.getValueInThermoCPUnit(),
                    knownParameter2.getParameterType().getParameterSymbolInThermoCP(),
                    knownParameter2.getValueInThermoCPUnit() ,
                    fluidName.enumToString()
                )
        );
        return wantedParameter;
    }

    public static AirParameter findAirParameter(ParameterType wantedParameterType, FluidParameter knownParameter1, FluidParameter knownParameter2, FluidParameter knownParameter3){
        AirParameter wantedParameter = new AirParameter();
        wantedParameter.setParameterType(wantedParameterType);
        wantedParameter.setActualUnit(wantedParameterType.getUnitInThermoCP());
        wantedParameter.setValue(
                CoolProp.HAProps(
                        wantedParameterType.getParameterSymbolInThermoCP(),
                        knownParameter1.getParameterType().getParameterSymbolInThermoCP(),
                        knownParameter1.getValueInThermoCPUnit(),
                        knownParameter2.getParameterType().getParameterSymbolInThermoCP(),
                        knownParameter2.getValueInThermoCPUnit() ,
                        knownParameter3.getParameterType().getParameterSymbolInThermoCP(),
                        knownParameter3.getValueInThermoCPUnit()
                )
        );
        return wantedParameter;
    }

    public static AirParameter findAirParameterAtAtmosphericPressure(ParameterType wantedParameterType, AirParameter knownParameter1, AirParameter knownParameter2){
        return findAirParameter(wantedParameterType, knownParameter1, knownParameter2, UnitSystem.getActualUnitSystem().getAtmosphericTemperature());
    }
}
