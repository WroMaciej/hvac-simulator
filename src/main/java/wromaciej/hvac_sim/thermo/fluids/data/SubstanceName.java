package wromaciej.hvac_sim.thermo.fluids.data;

import java.util.Arrays;
import java.util.Collection;

public enum SubstanceName {
    AIR(Arrays.asList("air", "powietrze")),
    WATER(Arrays.asList("w", "water"));

    SubstanceName(Collection<String> possibleNames) {
        this.possibleNames = possibleNames;
    }

    private Collection<String> possibleNames;

    public boolean equalsName(String name) {
        return possibleNames.contains(name);
    }

    public static SubstanceName from(String name) {
        for(SubstanceName substanceName: SubstanceName.values()) {
            if(substanceName.equalsName(name))
                return substanceName;
        }
        return null;
    }


}
