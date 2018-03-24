package wromaciej.hvac_sim.thermo.matter.fluids.service;

import thermoCP.CoolProp;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.*;
import wromaciej.hvac_sim.thermo.quantities.base.AirQuantity;
import wromaciej.hvac_sim.thermo.quantities.base.AnyQuantity;
import wromaciej.hvac_sim.thermo.quantities.base.FluidQuantity;
import wromaciej.hvac_sim.thermo.quantities.specific.Temperature;
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

    public static FluidParameter findAirParameter(ParameterType wantedParameterType, FluidParameter<? extends AirQuantity> knownParameter1, FluidParameter<? extends AirQuantity> knownParameter2, FluidParameter<? extends AirQuantity> knownParameter3){

        FluidParameter wantedParameter = new FluidParameter();
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

    public static FluidParameter findAirParameterAtAtmosphericPressure(ParameterType wantedParameterType, FluidParameter<? extends AirQuantity> knownParameter1, FluidParameter<? extends AirQuantity> knownParameter2){
        return findAirParameter(wantedParameterType, knownParameter1, knownParameter2, UnitSystem.getActualUnitSystem().getAtmosphericPressure());
    }
}
