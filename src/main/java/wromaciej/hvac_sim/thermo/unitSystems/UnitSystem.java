package wromaciej.hvac_sim.thermo.unitSystems;

import wromaciej.hvac_sim.thermo.quantities.base.AnyQuantity;
import wromaciej.hvac_sim.thermo.quantities.specific.SpecificEnthalpy;

import javax.measure.quantity.*;
import javax.measure.unit.ProductUnit;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public final class UnitSystem {


    private Map<AnyQuantity, Unit> allUnits;

    AnyQuantity anyQuantity;

    private final Unit<SpecificEnthalpy> specificEnthalpyUnit= Unit.valueOf("J").asType(SpecificEnthalpy.class);


    /**
     * Loading unit system from some DB or file or...
     */
    public static void loadUnitSystem(){}

    public Unit findObjectByInterface(AnyQuantity quantity){

        if (quantity.){

        }
    }

    public void addUnit(Quantity quantity, Unit unit){
        allUnits.put(new QuantityClass(quantity), unit);
    }

    public Unit getUnitOfQuantity(Quantity quantity){
        return allUnits.get(findObjectByInterface(quantity));
    }

    public UnitSystem() {
        allUnits=new HashMap<>();

    }
}
