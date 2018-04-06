package wromaciej.hvac_sim.thermo.matter.fluids.service;

import thermoCP.CoolProp;
import wromaciej.hvac_sim.thermo.matter.fluids.parameters.*;
import wromaciej.hvac_sim.thermo.quantities.base.AirQuantity;
import wromaciej.hvac_sim.thermo.unitSystems.UnitSystem;

/**
 * ThermoCP library ADAPTER
 */
public class FluidData {

    public static void loadLibrary(){
        try{
            System.loadLibrary("CoolProp");
        }
        catch(UnsatisfiedLinkError e){
            throw new UnsatisfiedLinkError("Error: can`t find fluid data library");
        }
    }

    public static Parameter findParameter(ParameterType wantedParameterType, FluidName fluidName, Parameter knownParameter1, Parameter knownParameter2) {
        if (fluidName == FluidName.MOIST_AIR)
            return findAirParameterAtAtmosphericPressure(wantedParameterType, knownParameter1, knownParameter2);

        Parameter wantedParameter = new Parameter();
        wantedParameter.setParameterType(wantedParameterType);
        wantedParameter.setActualUnit(wantedParameterType.getUnitInThermoCP());
        wantedParameter.setValue(
                CoolProp.PropsSI(
                        wantedParameterType.getParameterSymbolInThermoCP(),
                        knownParameter1.getParameterType().getParameterSymbolInThermoCP(),
                        knownParameter1.getValueInThermoCPUnit(),
                        knownParameter2.getParameterType().getParameterSymbolInThermoCP(),
                        knownParameter2.getValueInThermoCPUnit(),
                        fluidName.enumToString()
                )
        );
        return wantedParameter;
    }

    public static Parameter findAirParameter(ParameterType wantedParameterType, Parameter<? extends AirQuantity> knownParameter1, Parameter<? extends AirQuantity> knownParameter2, Parameter<? extends AirQuantity> knownParameter3) {
        Parameter wantedParameter = new Parameter();
        wantedParameter.setParameterType(wantedParameterType);
        wantedParameter.setActualUnit(wantedParameterType.getUnitInThermoCP());
        wantedParameter.setValue(
                CoolProp.HAProps(
                        wantedParameterType.getParameterSymbolInThermoCP(),
                        knownParameter1.getParameterType().getParameterSymbolInThermoCP(),
                        knownParameter1.getValueInThermoCPUnit(),
                        knownParameter2.getParameterType().getParameterSymbolInThermoCP(),
                        knownParameter2.getValueInThermoCPUnit(),
                        knownParameter3.getParameterType().getParameterSymbolInThermoCP(),
                        knownParameter3.getValueInThermoCPUnit()
                )
        );
        return wantedParameter;
    }

    public static Parameter findAirParameterAtAtmosphericPressure(ParameterType wantedParameterType, Parameter<? extends AirQuantity> knownParameter1, Parameter<? extends AirQuantity> knownParameter2) {
        return findAirParameter(wantedParameterType, knownParameter1, knownParameter2, UnitSystem.getActualUnitSystem().getAtmosphericPressure());
    }

    public static Parameter findRefrigerantParameter(ParameterType wantedParameterType, FluidName fluidName, Parameter knownParameter1, Parameter knownParameter2){
        return findParameter(wantedParameterType, fluidName, knownParameter1, knownParameter2);
    }

    public FluidData() {
    }
}
