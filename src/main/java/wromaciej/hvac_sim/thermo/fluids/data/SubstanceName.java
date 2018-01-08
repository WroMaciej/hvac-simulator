package wromaciej.hvac_sim.thermo.fluids.data;

import java.util.Arrays;
import java.util.Collection;

public enum SubstanceName {
    //AIR(Arrays.asList("air", "powietrze")),
    //WATER(Arrays.asList("w", "water")),

    MOIST_AIR(Arrays.asList("a","Moist Air")),
    BUTENE(Arrays.asList("1-Butene")),
    ACETONE(Arrays.asList("Acetone")),
    AIR(Arrays.asList("Air")),
    AMMONIA(Arrays.asList("Ammonia")),
    ARGON(Arrays.asList("Argon")),
    BENZENE(Arrays.asList("Benzene")),
    CARBONDIOXIDE(Arrays.asList("CarbonDioxide")),
    CARBONMONOXIDE(Arrays.asList("CarbonMonoxide")),
    CARBONYLSULFIDE(Arrays.asList("CarbonylSulfide")),
    CYCLOHEXANE(Arrays.asList("CycloHexane")),
    CYCLOPROPANE(Arrays.asList("CycloPropane")),
    CYCLOPENTANE(Arrays.asList("Cyclopentane")),
    D4(Arrays.asList("D4")),
    D5(Arrays.asList("D5")),
    D6(Arrays.asList("D6")),
    DEUTERIUM(Arrays.asList("Deuterium")),
    DICHLOROETHANE(Arrays.asList("Dichloroethane")),
    DIETHYLETHER(Arrays.asList("DiethylEther")),
    DIMETHYLCARBONATE(Arrays.asList("DimethylCarbonate")),
    DIMETHYLETHER(Arrays.asList("DimethylEther")),
    ETHANE(Arrays.asList("Ethane")),
    ETHANOL(Arrays.asList("Ethanol")),
    ETHYLBENZENE(Arrays.asList("EthylBenzene")),
    ETHYLENE(Arrays.asList("Ethylene")),
    ETHYLENEOXIDE(Arrays.asList("EthyleneOxide")),
    FLUORINE(Arrays.asList("Fluorine")),
    HFE143M(Arrays.asList("HFE143m")),
    HEAVYWATER(Arrays.asList("HeavyWater")),
    HELIUM(Arrays.asList("Helium")),
    HYDROGEN(Arrays.asList("Hydrogen")),
    HYDROGENCHLORIDE(Arrays.asList("HydrogenChloride")),
    HYDROGENSULFIDE(Arrays.asList("HydrogenSulfide")),
    ISOBUTANE(Arrays.asList("IsoButane")),
    ISOBUTENE(Arrays.asList("IsoButene")),
    ISOHEXANE(Arrays.asList("Isohexane")),
    ISOPENTANE(Arrays.asList("Isopentane")),
    KRYPTON(Arrays.asList("Krypton")),
    MD2M(Arrays.asList("MD2M")),
    MD3M(Arrays.asList("MD3M")),
    MD4M(Arrays.asList("MD4M")),
    MDM(Arrays.asList("MDM")),
    MM(Arrays.asList("MM")),
    METHANE(Arrays.asList("Methane")),
    METHANOL(Arrays.asList("Methanol")),
    METHYLLINOLEATE(Arrays.asList("MethylLinoleate")),
    METHYLLINOLENATE(Arrays.asList("MethylLinolenate")),
    METHYLOLEATE(Arrays.asList("MethylOleate")),
    METHYLPALMITATE(Arrays.asList("MethylPalmitate")),
    METHYLSTEARATE(Arrays.asList("MethylStearate")),
    NEON(Arrays.asList("Neon")),
    NEOPENTANE(Arrays.asList("Neopentane")),
    NITROGEN(Arrays.asList("Nitrogen")),
    NITROUSOXIDE(Arrays.asList("NitrousOxide")),
    NOVEC649(Arrays.asList("Novec649")),
    ORTHODEUTERIUM(Arrays.asList("OrthoDeuterium")),
    ORTHOHYDROGEN(Arrays.asList("OrthoHydrogen")),
    OXYGEN(Arrays.asList("Oxygen")),
    PARADEUTERIUM(Arrays.asList("ParaDeuterium")),
    PARAHYDROGEN(Arrays.asList("ParaHydrogen")),
    PROPYLENE(Arrays.asList("Propylene")),
    PROPYNE(Arrays.asList("Propyne")),
    R11(Arrays.asList("R11")),
    R113(Arrays.asList("R113")),
    R114(Arrays.asList("R114")),
    R115(Arrays.asList("R115")),
    R116(Arrays.asList("R116")),
    R12(Arrays.asList("R12")),
    R123(Arrays.asList("R123")),
    R1233ZD_E(Arrays.asList("R1233zd(E)")),
    R1234YF(Arrays.asList("R1234yf")),
    R1234ZE_E(Arrays.asList("R1234ze(E)")),
    R1234ZE_Z(Arrays.asList("R1234ze(Z)")),
    R124(Arrays.asList("R124")),
    R125(Arrays.asList("R125")),
    R13(Arrays.asList("R13")),
    R134A(Arrays.asList("R134a")),
    R13I1(Arrays.asList("R13I1")),
    R14(Arrays.asList("R14")),
    R141B(Arrays.asList("R141b")),
    R142B(Arrays.asList("R142b")),
    R143A(Arrays.asList("R143a")),
    R152A(Arrays.asList("R152A")),
    R161(Arrays.asList("R161")),
    R21(Arrays.asList("R21")),
    R218(Arrays.asList("R218")),
    R22(Arrays.asList("R22")),
    R227EA(Arrays.asList("R227EA")),
    R23(Arrays.asList("R23")),
    R236EA(Arrays.asList("R236EA")),
    R236FA(Arrays.asList("R236FA")),
    R245CA(Arrays.asList("R245ca")),
    R245FA(Arrays.asList("R245fa")),
    R32(Arrays.asList("R32")),
    R365MFC(Arrays.asList("R365MFC")),
    R40(Arrays.asList("R40")),
    R404A(Arrays.asList("R404A")),
    R407C(Arrays.asList("R407C")),
    R41(Arrays.asList("R41")),
    R410A(Arrays.asList("R410A")),
    R507A(Arrays.asList("R507A")),
    RC318(Arrays.asList("RC318")),
    SES36(Arrays.asList("SES36")),
    SULFURDIOXIDE(Arrays.asList("SulfurDioxide")),
    SULFURHEXAFLUORIDE(Arrays.asList("SulfurHexafluoride")),
    TOLUENE(Arrays.asList("Toluene")),
    WATER(Arrays.asList("Water")),
    XENON(Arrays.asList("Xenon")),
    CIS_2_BUTENE(Arrays.asList("cis-2-Butene")),
    M_XYLENE(Arrays.asList("m-Xylene")),
    N_BUTANE(Arrays.asList("n-Butane")),
    N_DECANE(Arrays.asList("n-Decane")),
    N_DODECANE(Arrays.asList("n-Dodecane")),
    N_HEPTANE(Arrays.asList("n-Heptane")),
    N_HEXANE(Arrays.asList("n-Hexane")),
    N_NONANE(Arrays.asList("n-Nonane")),
    N_OCTANE(Arrays.asList("n-Octane")),
    N_PENTANE(Arrays.asList("n-Pentane")),
    N_PROPANE(Arrays.asList("n-Propane")),
    N_UNDECANE(Arrays.asList("n-Undecane")),
    O_XYLENE(Arrays.asList("o-Xylene")),
    P_XYLENE(Arrays.asList("p-Xylene")),
    TRANS_2_BUTENE(Arrays.asList("trans-2-Butene"));


    private Collection<String> possibleNames;

    SubstanceName(Collection<String> possibleNames) {
        this.possibleNames = possibleNames;
    }

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
