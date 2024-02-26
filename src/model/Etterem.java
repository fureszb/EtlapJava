package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Etterem {

    public static final String HUF = "Ft";

    private ArrayList<Rendeles> rendelesek;

    private ArrayList<Etel> etlap;

    public Etterem() {

    }

    public ArrayList<Rendeles> getRendelesek() {
        return rendelesek;
    }

    public void rendeleseketKiir() {
        for (Rendeles rendeles : getRendelesek()) {
            System.out.println(rendeles.toString());
        }
    }

    public void etlapotFajbolFeltolt() {
        etlap = new ArrayList<>();
        try {
            List<String> sorok = Files.readAllLines(Paths.get("etelek.txt"));
            for (String sor : sorok) {
                String[] parts = sor.split("\\|");
                if (parts.length == 2) {
                    String nev = parts[0].trim();
                    int ar = Integer.parseInt(parts[1].trim());
                    etlap.add(new Etel(nev, ar));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void rendeleseketFajbolFeltolt() {
        rendelesek = new ArrayList<>();
        Map<String, Rendeles> rendelesekMap = new HashMap<>();
        String jelenlegiAsztal = null;

        try {
            List<String> sorok = Files.readAllLines(Paths.get("rendelesek.txt"));
            for (String sor : sorok) {
                if (sor.trim().isEmpty()) {
                    jelenlegiAsztal = null;
                } else if (jelenlegiAsztal == null) {
                    jelenlegiAsztal = sor;
                    rendelesekMap.putIfAbsent(jelenlegiAsztal, new Rendeles(jelenlegiAsztal));
                } else {
                    Rendeles jelenlegiRendeles = rendelesekMap.get(jelenlegiAsztal);
                    Etel etel = etelKereseseAzEtlapon(sor);
                    if (etel != null) {
                        jelenlegiRendeles.hozzaAd(etel);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        rendelesek.addAll(rendelesekMap.values());
    }

    private Etel etelKereseseAzEtlapon(String etelNev) {
        for (Etel etel : etlap) {
            if (etel.getNev().equals(etelNev)) {
                return etel;
            }
        }
        return null;
    }

}
