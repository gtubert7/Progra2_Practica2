package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LlistaAllotjaments implements InLlistaAllotjaments{
    private ArrayList<Allotjament> allotjaments;

    public LlistaAllotjaments(){ allotjaments = new ArrayList<>();}

    public void afegirAllotjament(Allotjament allotjament) throws ExcepcioCamping {
        if (allotjaments.contains(allotjament)) {
            throw new ExcepcioCamping("L'allotjament ja existeix en la llista!");
        }
        allotjaments.add(allotjament);
    }

    public void buidar(){
        for (Allotjament allotjament : allotjaments) {
            allotjaments.remove(allotjament);
        }
    }

    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        if (!estat.equalsIgnoreCase("Operatiu") && !estat.equalsIgnoreCase("No Operatiu") && !estat.equalsIgnoreCase("Tots")) {
            throw new ExcepcioCamping("L'estat indicat no és vàlid. Ha de ser 'Operatiu', 'No Operatiu' o 'Tots'.");
        }

        boolean estatB = estat.equalsIgnoreCase("Operatiu");
        StringBuilder resultat = new StringBuilder();

        for (Allotjament allotjament : allotjaments) {
            if (allotjament.getEstat() == estatB || estat.equals("Tots")) {
                resultat.append(allotjament.toString()).append("\n");
            }
        }

        if (resultat.isEmpty()) {
            throw new ExcepcioCamping("No hi ha allotjaments amb l'estat '" + estat + "'.");
        }

        return resultat.toString();
    }

    public boolean containsAllotjamentOperatiu(){
        for (Allotjament allotjament : allotjaments) {
            if (allotjament.getEstat()) {
                return true;
            }
        }
        return false;
    }

    public boolean contains(Allotjament allotjament){
        for (Allotjament allotjament1 : allotjaments) {
            if (allotjament1.equals(allotjament)) {
                return true;
            }
        }
        return false;
    }

    public Allotjament getAllotjament(String id) throws ExcepcioCamping{
        for (Allotjament allotjament : allotjaments) {
            if (allotjament.getId().equals(id)) {
                return allotjament;
            }
        }
        throw new ExcepcioCamping("No hi ha allotjaments amb l'ID '" + id + "'.");
    }
}
