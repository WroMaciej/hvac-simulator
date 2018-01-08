package wromaciej.hvac_sim.thermo.fluids.data;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public enum SubstanceParameter {
    /**
     * Temperature in C
     */
    TEMPERATURE(Arrays.asList("t","temperature")),
    /**
     * Absolute pressure barA
     */
    PRESSURE(Arrays.asList("p","pressure")),
    /**
     * Specific enthalpy kJ/kg
     */
    ENTHALY(Arrays.asList("h","enthalpy")),
    /**
     * Specific entropy kJ/kgK
     */
    ENTROPY(Arrays.asList("s","entropy")),
    /**
     * Quality 0-1
     */
    QUALITY(Arrays.asList("q","quality")),
     /**
     * Density kg/m3
     */
    DENSITY(Arrays.asList("ro","density")),
    /**
     * Specific heat capacity in constant pressure cp kJ/kgK
     */
    HEAT_CAPACITY(Arrays.asList("cp","heat capacity")),
    /**
     * Relative humidity of AIR 0-1
     */
    RELATIVE_HUMIDITY(Arrays.asList("rh","humidity")),
    /**
     * absolute humidity of AIR kg_H2O/kgDRY
     */
    MOISTURE_CONTENT(Arrays.asList("x","moisture content")),
    /**
     * wetbulb temperature of AIR C
     */
    TEMPERATURE_WETBULB(Arrays.asList("twb","wetbulb")),
    /**
     * dewpoint of AIR C
     */
    TEMPERATURE_DEWPOINT(Arrays.asList("tdp","dewpoint")),
    /**
     * Subcooling of refrigerant K
     */

    SUBCOOLING(Arrays.asList("sc","subcooling")),
    /**
     * Superheating of refrigerant K
     */
    SUPERHEATING(Arrays.asList("sh","superheating"));

    private Collection<String> possibleNames;



    SubstanceParameter(Collection<String> possibleNames) {
        this.possibleNames = possibleNames;
    }

    public boolean equalsName(String name) {
        return possibleNames.contains(name);
    }

    public static SubstanceParameter from(String name) {
        for(SubstanceParameter substanceParameter: SubstanceParameter.values()) {
            if(substanceParameter.equalsName(name))
                return substanceParameter;
        }
        return null;
    }

}
