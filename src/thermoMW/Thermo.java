package thermoMW;
import thermoCP.*;

/**parametry termodynamiczne czynników*/
public abstract class Thermo {

    public static final double RO=1.18; //gestosc powietrza w war standardowych kg/m3
    public static final double T_ABS=273.15;


    //klasa przechowująca nazwe czynnika, nazwe parametru i wartość parametru po konwersji dla CoolPack
    public static class ThermoParameter{
        public String fluidName;
        public String parameterName;
        public double value;
    }

    //szukanie parametru przez CoolProp dla powietrza
    public static double findAirParameter(String wanted, String p1, double v1, String p2, double v2, double pGaugePa){
        double r;
        wanted =con("a",wanted,0).parameterName;
        r= CoolProp.HAProps(
                    wanted,
                    con("a",p1,0).parameterName,con("a",p1,v1).value,
                    con("a",p2,0).parameterName,con("a",p2,v2).value,
                    "P",(pGaugePa/1000)+100);
        switch (wanted){
            case "T": r=r-T_ABS; break;
            case "Twb": r=r-T_ABS; break;
            case "Tdb": r=r-T_ABS; break;
            case "Tdp": r=r-T_ABS; break;
            case "P": r=r/100; break;
        }
        System.out.println("znaleziono parametr "+wanted+" ="+r);
        return r;

    }

    //szukanie parametru przez CoolPack dla reszty czynnikow
    public static double findParameter(String wanted, String fluidName, String p1, double v1, String p2, double v2){
        wanted =con(fluidName,wanted,0).parameterName;
        double r;
        if (con(fluidName,null,0).fluidName.equals("a"))
        {
            r=findAirParameter(wanted, p1, v1, p2, v2, 0);
        }
        else r=CoolProp.PropsSI(wanted,
                con(fluidName,p1,0).parameterName,con(fluidName,p1,v1).value,
                con(fluidName,p2,0).parameterName,con(fluidName,p2,v2).value,
                con(fluidName,null,0).fluidName);
        switch (wanted){
            case "T": r=r-T_ABS; break;
            case "Twb": r=r-T_ABS; break;
            case "Tdb": r=r-T_ABS; break;
            case "Tdp": r=r-T_ABS; break;
            case "P": r=r/100000; break;
            case "H": r=r/1000; break;
            case "S": r=r/1000; break;
            case "C": r=r/1000; break;
        }
        return r;

    }

    //konwersja parametrow ze standarowych tego projektu na CoolProp
    public static ThermoParameter con(String fluidName, String parameterName, double value){
        if (fluidName!=null) fluidName = fluidName.toLowerCase(); else fluidName="";
        if (parameterName!=null) parameterName=parameterName.toLowerCase(); else parameterName="";

        //zmiana nazwy dla powietrza mokrego
        if (fluidName.equals("a") || fluidName.equals("powietrze")|| fluidName.equals("moistair")) fluidName="a";

        //jeśli parametr to TEMPERATURA
        if (parameterName.equals("t") || parameterName.equals("temperature") || parameterName.equals("tdb") || parameterName.equals("t_db") || parameterName.equals("temp") || parameterName.equals("temperatura")) {
            parameterName="T";
            value=value+T_ABS; //konwersja z C na K
        }
        //jeśli parametr to CISNIENIE
        if (parameterName.equals("p") || parameterName.equals("cisnienie")) {
            parameterName="P";
            if (fluidName.equals("a")) value=value*100; else value=value*100000;
        }
        //jeśli parametr to WILGOTNOSC WZGLEDNA
        else if (parameterName.equals("r") || parameterName.equals("rh") || parameterName.equals("relhum") || parameterName.equals("humidity") || parameterName.equals("relative humidity") || parameterName.equals("wilgotnosc wzgledna")) parameterName="R";
            //jeśli parametr to WILGOTNOSC BEZWZGLEDNA
        else if (parameterName.equals("w") || parameterName.equals("x") || parameterName.equals("omega") || parameterName.equals("humrat") || parameterName.equals("water content") || parameterName.equals("wilgotnosc bezwzgledna")) parameterName="W";
            //jeśli parametr to ENTALPIA POW SUCHEGO
        else if (parameterName.equals("h") || parameterName.equals("hda") || parameterName.equals("enthalpy") || parameterName.equals("entalpia") || parameterName.equals("i")) {
            parameterName="H";
            if (!fluidName.equals("a")) value=value*1000;
        }
        //jeśli parametr to ENTROPIA POW SUCHEGO
        else if (parameterName.equals("s") || parameterName.equals("entropy") || parameterName.equals("entropia") || parameterName.equals("sda")) {
            parameterName="S";
            if (!fluidName.equals("a")) value=value*1000;
        }
        //jeśli parametr to ENTALPIA POW MOKREGO
        else if (parameterName.equals("hw") || parameterName.equals("hha")) {
            parameterName="Hha";
        }
        //jeśli parametr to ENTROPIA POW MOKREGO
        else if (parameterName.equals("sw") || parameterName.equals("sha")) {
            parameterName="Sha";
        }
        //jeśli parametr to TEMPERATURA termometru mokrego
        else if (parameterName.equals("twb") || parameterName.equals("tm") || parameterName.equals("t_wb") || parameterName.equals("b") || parameterName.equals("wetbult")|| parameterName.equals("mokry")) {
            parameterName="Twb";
            value=value+T_ABS; //konwersja z C na K
        }
        //jeśli parametr to TEMPERATURA punktu rosy
        else if (parameterName.equals("tdp") || parameterName.equals("tr") || parameterName.equals("dewpoint") || parameterName.equals("rosa")) {
            parameterName="Tdp";
            value=value+T_ABS; //konwersja z C na K
        }
        //jeśli parametr to GESTOSC
        else if (parameterName.equals("d") || parameterName.equals("ro") || parameterName.equals("dmass") || parameterName.equals("gestosc")) {
            parameterName="DMASS";
        }
        //jeśli parametr to GESTOSC
        else if (parameterName.equals("v") || parameterName.equals("volume") || parameterName.equals("objetosc")) {
            parameterName="V";
        }
        //jeśli parametr to CIEPLO WLASCIWE
        else if (parameterName.equals("c") || parameterName.equals("cp") || parameterName.equals("cpmass") || parameterName.equals("cieplo wlasciwe")) {
            parameterName="C";
            if (!fluidName.equals("a")) value=value*1000;
        }
        //jeśli parametr to CIEPLO WLASCIWE
        else if (parameterName.equals("phase") ) {
            parameterName="PHASE";
        }
        //jeśli parametr to STOPIEN NASYCENIA X
        else if (parameterName.equals("q") || parameterName.equals("nasycenie")) {
            parameterName="Q";
        }

        ThermoParameter r=new ThermoParameter();
        r.fluidName=fluidName;
        r.value=value;
        r.parameterName=parameterName;
        return r;
    }
}
