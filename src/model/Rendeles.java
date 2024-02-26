package model;

import java.util.ArrayList;
import java.util.List;

public class Rendeles {

    private List<Etel> rendelesek;
    private String asztal;

    public Rendeles(String asztal) {
        this.rendelesek = new ArrayList<>();
        this.asztal = asztal;
    }

    public void hozzaAd(Etel etel) {
        rendelesek.add(etel);
    }

    public String getRendelesek() {
        String txt = "";
        for (Etel etel : rendelesek) {
            txt += etel.getNev() + "\n";
        }
        return txt;
    }

    public int getOsszesen() {
        int ar = 0;
        for (Etel etel : rendelesek) {
            ar += etel.getAr();
        }
        return ar;
    }

    public void setAsztal(String asztal) {
        this.asztal = asztal;
    }

    public String getAsztal() {
        return asztal;
    }

    @Override
    public String toString() {
        String txt = "\n" + getAsztal() + " asztal: " + "\n================\n";
        for (Etel etel : rendelesek) {
            txt += etel.getNev() + " | " + etel.getAr() + " Ft" + "\n";
        }
        txt += "-------------\nÖsszesen: " + getOsszesen() + " Ft\n";
        return txt;
    }

}
