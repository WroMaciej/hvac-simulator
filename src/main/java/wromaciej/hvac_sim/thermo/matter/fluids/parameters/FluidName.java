package wromaciej.hvac_sim.thermo.matter.fluids.parameters;

import java.util.HashMap;
import java.util.Map;

public enum FluidName {

    MOIST_AIR("MoistAir"),
    ACETONE("Acetone"),
    AIR("Air"),
    AMMONIA("Ammonia"),
    ARGON("Argon"),
    BUTENE("1-Butene"),
    BENZENE("Benzene"),
    CARBONDIOXIDE("CarbonDioxide"),
    CARBONMONOXIDE("CarbonMonoxide"),
    CARBONYLSULFIDE("CarbonylSulfide"),
    CYCLOHEXANE("CycloHexane"),
    CYCLOPROPANE("CycloPropane"),
    CYCLOPENTANE("Cyclopentane"),
    D4("D4"),
    D5("D5"),
    D6("D6"),
    DEUTERIUM("Deuterium"),
    DICHLOROETHANE("Dichloroethane"),
    DIETHYLETHER("DiethylEther"),
    DIMETHYLCARBONATE("DimethylCarbonate"),
    DIMETHYLETHER("DimethylEther"),
    ETHANE("Ethane"),
    ETHANOL("Ethanol"),
    ETHYLBENZENE("EthylBenzene"),
    ETHYLENE("Ethylene"),
    ETHYLENEOXIDE("EthyleneOxide"),
    FLUORINE("Fluorine"),
    HFE143M("HFE143m"),
    HEAVYWATER("HeavyWater"),
    HELIUM("Helium"),
    HYDROGEN("Hydrogen"),
    HYDROGENCHLORIDE("HydrogenChloride"),
    HYDROGENSULFIDE("HydrogenSulfide"),
    ISOBUTANE("IsoButane"),
    ISOBUTENE("IsoButene"),
    ISOHEXANE("Isohexane"),
    ISOPENTANE("Isopentane"),
    KRYPTON("Krypton"),
    MD2M("MD2M"),
    MD3M("MD3M"),
    MD4M("MD4M"),
    MDM("MDM"),
    MM("MM"),
    METHANE("Methane"),
    METHANOL("Methanol"),
    METHYLLINOLEATE("MethylLinoleate"),
    METHYLLINOLENATE("MethylLinolenate"),
    METHYLOLEATE("MethylOleate"),
    METHYLPALMITATE("MethylPalmitate"),
    METHYLSTEARATE("MethylStearate"),
    NEON("Neon"),
    NEOPENTANE("Neopentane"),
    NITROGEN("Nitrogen"),
    NITROUSOXIDE("NitrousOxide"),
    NOVEC649("Novec649"),
    ORTHODEUTERIUM("OrthoDeuterium"),
    ORTHOHYDROGEN("OrthoHydrogen"),
    OXYGEN("Oxygen"),
    PARADEUTERIUM("ParaDeuterium"),
    PARAHYDROGEN("ParaHydrogen"),
    PROPYLENE("Propylene"),
    PROPYNE("Propyne"),
    R11("R11"),
    R113("R113"),
    R114("R114"),
    R115("R115"),
    R116("R116"),
    R12("R12"),
    R123("R123"),
    R1233ZD_E("R1233zd(E)"),
    R1234YF("R1234yf"),
    R1234ZE_E("R1234ze(E)"),
    R1234ZE_Z("R1234ze(Z)"),
    R124("R124"),
    R125("R125"),
    R13("R13"),
    R134A("R134a"),
    R13I1("R13I1"),
    R14("R14"),
    R141B("R141b"),
    R142B("R142b"),
    R143A("R143a"),
    R152A("R152A"),
    R161("R161"),
    R21("R21"),
    R218("R218"),
    R22("R22"),
    R227EA("R227EA"),
    R23("R23"),
    R236EA("R236EA"),
    R236FA("R236FA"),
    R245CA("R245ca"),
    R245FA("R245fa"),
    R32("R32"),
    R365MFC("R365MFC"),
    R40("R40"),
    R404A("R404A"),
    R407C("R407C"),
    R41("R41"),
    R410A("R410A"),
    R507A("R507A"),
    RC318("RC318"),
    SES36("SES36"),
    SULFURDIOXIDE("SulfurDioxide"),
    SULFURHEXAFLUORIDE("SulfurHexafluoride"),
    TOLUENE("Toluene"),
    WATER("Water"),
    XENON("Xenon"),
    CIS_2_BUTENE("cis-2-Butene"),
    M_XYLENE("m-Xylene"),
    N_BUTANE("n-Butane"),
    N_DECANE("n-Decane"),
    N_DODECANE("n-Dodecane"),
    N_HEPTANE("n-Heptane"),
    N_HEXANE("n-Hexane"),
    N_NONANE("n-Nonane"),
    N_OCTANE("n-Octane"),
    N_PENTANE("n-Pentane"),
    N_PROPANE("n-Propane"),
    N_UNDECANE("n-Undecane"),
    O_XYLENE("o-Xylene"),
    P_XYLENE("p-Xylene"),
    TRANS_2_BUTENE("trans-2-Butene"),;


        private String nameForThermoCP;

    private static final Map<String, FluidName> substanceEnumForGivenString = new HashMap<>();

    //Populate the lookup table on loading time
    static
    {
        for(FluidName fluidName : FluidName.values())
        {
            substanceEnumForGivenString.put(fluidName.enumToString(), fluidName);
        }
    }

    FluidName(String nameForThermoCP) {
        this.nameForThermoCP = nameForThermoCP;
    }

    public String enumToString(){
        return nameForThermoCP;
    }

    public static FluidName stringToEnum(String name){
        return substanceEnumForGivenString.get(name);

    }

}
