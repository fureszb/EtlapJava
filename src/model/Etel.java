
package model;

public class Etel {
    private String nev;
    private int ar;

    public Etel(String nev, int ar) {
        this.nev = nev;
        this.ar = ar;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }
    
    @Override
    public String toString() {
        return nev + " | Ár: " + ar + " Ft";
    }
}
