package wromaciej.hvac_sim.thermo;
import thermoCP.*;

/**parametry termodynamiczne czynników*/
public abstract class ThermoCPAdapter {

    public static final double RO=1.18; //gestosc powietrza w war standardowych kg/m3
    public static final double T_ABS=273.15;


    //klasa przechowująca nazwe czynnika, nazwe parametru i wartość parametru po konwersji dla CoolPack
    public static class ThermoParameter{
        public String fluidName;
        public String parameterName;
        public double value;
    }

    /**
     * szukanie parametru przez CoolProp dla powietrza
     * @param wantedParameter dghdgh
     * @param p1 gfsgsfg
     * @param v1
     * @param p2 gsf
     * @param v2
     * @param pGaugePa
     * @return
     */
    public static double findAirParameter(String wantedParameter, String p1, double v1, String p2, double v2, double pGaugePa){
        wantedParameter = convert("a",wantedParameter,0).parameterName;
        double r= CoolProp.HAProps(
                    wantedParameter,
                    convert("a",p1,0).parameterName, convert("a",p1,v1).value,
                    convert("a",p2,0).parameterName, convert("a",p2,v2).value,
                    "P",(pGaugePa/1000)+100);
        // consider using calculcateRBasingOn....
        switch (wantedParameter){
            case "T": r=r-T_ABS; break;
            case "Twb": r=r-T_ABS; break;
            case "Tdb": r=r-T_ABS; break;
            case "Tdp": r=r-T_ABS; break;
            case "P": r=r/100; break;
        }
        System.out.println("znaleziono parametr "+wantedParameter+" ="+r);
        return r;

    }

    //szukanie parametru przez CoolPack dla reszty czynnikow
    public static double findParameter(String wanted, String fluidName, String p1, double v1, String p2, double v2){
        wanted = convert(fluidName,wanted,0).parameterName;
        fluidName= convert(fluidName,null,0).fluidName;
        p1= convert(fluidName,p1,0).parameterName;
        v1= convert(fluidName,p1,v1).value;
        p2= convert(fluidName,p2,0).parameterName;
        v2= convert(fluidName,p2,v2).value;
        double r; //zmienne pomocnicze
        double r2;
        r=0;
        r2=0;


        try {
            if (convert(fluidName, null, 0).fluidName.equals("a")) {
                r = findAirParameter(wanted, p1, v1, p2, v2, 0); //jezeli to powietrze to licz jak dla powietrza
            } else {
                if (p1.equals("sh") || p1.equals("sc") || p2.equals("sh") || p2.equals("sc")) {
                    if (p1.equals("sh")) {
                        r = CoolProp.PropsSI("T", "Q", 1, p2, v2, fluidName); //r to temperatura nasycenia
                        r2 = CoolProp.PropsSI("P", "Q", 1, p2, v2, fluidName); //r2 to cisnienie nasycenia
                        //jesli przegrzanie>0
                        r = getR(wanted, fluidName, v1, v1, r, r2);
                    } else if (p2.equals("sh")) {
                        r = CoolProp.PropsSI("T", "Q", 1, p1, v1, fluidName); //r to temperatura nasycenia
                        r2 = CoolProp.PropsSI("P", "Q", 1, p1, v1, fluidName); //r2 to cisnienie nasycenia
                        //jesli przegrzanie>0
                        r = getR(wanted, fluidName, v1, v2, r, r2);
                    } else if (p1.equals("sc")) {
                        r = CoolProp.PropsSI("T", "Q", 0, p2, v2, fluidName); //r to temperatura nasycenia
                        r2 = CoolProp.PropsSI("P", "Q", 0, p2, v2, fluidName); //r2 to cisnienie nasycenia
                        //jesli przegrzanie>0
                        if (v1 > 0)
                            r = CoolProp.PropsSI(wanted, "T", r - v1, "P", r2, fluidName); //r to parametr poszukiwany
                        else r = CoolProp.PropsSI(wanted, "Q", 0, "P", r2, fluidName);
                    } else if (p2.equals("sc")) {
                        r = CoolProp.PropsSI("T", "Q", 0, p1, v1, fluidName); //r to temperatura nasycenia
                        r2 = CoolProp.PropsSI("P", "Q", 0, p1, v1, fluidName); //r2 to cisnienie nasycenia
                        //jesli przegrzanie>0
                        if (v1 > 0)
                            r = CoolProp.PropsSI(wanted, "T", r - v2, "P", r2, fluidName); //r to parametr poszukiwany
                        else r = CoolProp.PropsSI(wanted, "Q", 0, "P", r2, fluidName);
                    }

                } else
                    r = CoolProp.PropsSI(wanted, p1, v1, p2, v2, fluidName); //jezeli nie jest to dochlodzenie ani przegrzanie to licz normalnie
            }

        }
        catch(RuntimeException exception) {
            fluidName="water";
            p1="T";
            v1=10+T_ABS;
            p2="P";
            v2=100;
            r=CoolProp.PropsSI(wanted, p1, v1, p2, v2, fluidName); //jesli nie znaleziono plynu to uznaj ze jest to woda o temp 10C
        }

        r = calculateRBasingOnWantedParameter(wanted, r);
        return r;

    }

    private static double calculateRBasingOnWantedParameter(String wanted, double r) {
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

    private static double getR(String wanted, String fluidName, double v1, double v2, double r, double r2) {
        if (v1 > 0)
            r = CoolProp.PropsSI(wanted, "T", r + v2, "P", r2, fluidName); //r to parametr poszukiwany
        else r = CoolProp.PropsSI(wanted, "Q", 1, "P", r2, fluidName);
        return r;
    }

    //konwersja parametrow ze standarowych tego projektu na CoolProp
    public static ThermoParameter convert(String fluidName, String parameterName, double value){
        if (fluidName.length()>0) fluidName = fluidName.toLowerCase(); else fluidName="water";
        if (parameterName!=null) parameterName=parameterName.toLowerCase(); else parameterName="";
        char[] nameChar;
        nameChar = fluidName.toCharArray(); //tablica znakow

        if (nameChar[0]=='r') {
            nameChar[0]='R';
            fluidName=new String(nameChar);
        }

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
        //jeśli parametr to PRZEGRZANIE
        else if (parameterName.equals("sh") || parameterName.equals("superheating") || parameterName.equals("przegrzanie")) {
            parameterName="sh";
        }
        //jeśli parametr to DOCHLODZENIE
        else if (parameterName.equals("sc") || parameterName.equals("subcooling") || parameterName.equals("dochlodzenie")) {
            parameterName="sc";
        }

        ThermoParameter r=new ThermoParameter();
        r.fluidName=fluidName;
        r.value=value;
        r.parameterName=parameterName;
        return r;
    }
}
