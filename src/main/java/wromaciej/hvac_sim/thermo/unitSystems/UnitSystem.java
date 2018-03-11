package wromaciej.hvac_sim.thermo.unitSystems;

import wromaciej.hvac_sim.thermo.quantities.specific.SpecificEnthalpy;

import javax.measure.quantity.*;
import javax.measure.unit.ProductUnit;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public final class UnitSystem {

    private class QuantityId <Q extends Quantity>{
        private Class<Q>  typeOfQuantity;

        public QuantityClass(Class<Q> typeOfQuantity) {
            this.typeOfQuantity = typeOfQuantity;
        }

        public Class<Q> getTypeOfQuantity() {
            return typeOfQuantity;
        }
    }

    private Map<Unit, Unit> allUnits;


    /**
     * Loading unit system from some DB or file or...
     */
    public static void loadUnitSystem(){}

    public QuantityClass findObjectByInterface(Quantity quantity){

        for (QuantityClass quantityClass: allUnits.keySet()){
            if (quantityClass.getTypeOfQuantity().equals(quantity)){
                return quantityClass;
            }
        }
        return null;
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
