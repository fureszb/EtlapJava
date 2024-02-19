package controller;

import model.Etel;
import model.Rendeles;

import java.util.HashMap;
import java.util.Map;


public class RendelesController {
    private Map<String, Rendeles> rendelesMap;

    public RendelesController() {
        rendelesMap = new HashMap<>();
    }

    public void ujRendeles(String asztal, Etel etel) {
        Rendeles rendeles = rendelesMap.getOrDefault(asztal, new Rendeles(asztal));
        rendeles.hozzaAd(etel);
        rendelesMap.put(asztal, rendeles);
    }


}
