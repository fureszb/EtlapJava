package controller;

import java.util.List;
import javax.swing.DefaultListModel;
import model.Etel;

public class EtelController {

    private DefaultListModel<Etel> EtelekLista;

    public EtelController() {
        EtelekLista = new DefaultListModel<>();
        EtelekLista.addElement(new Etel("Babgulyás", 1700));
        EtelekLista.addElement(new Etel("Rántott sajt", 1900));
    }

    public String getEtelekLista() {
        
        String lista = "";
        for (int i = 0; i < EtelekLista.getSize(); i++) {
            lista += "\n"+ EtelekLista.getElementAt(i);
        }
        return lista;
    }
     public DefaultListModel<Etel> getLista(){
         return EtelekLista;
     }

    public void hozaadEtel(Etel etel) {
        EtelekLista.addElement(etel);
    }
}
