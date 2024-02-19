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

    public List<Etel> getRendelesek() { 
        return rendelesek;
    }

    public void setAsztal(String asztal) {
        this.asztal = asztal;
    }

    public String getAsztal() {
        return asztal;
    }
}
