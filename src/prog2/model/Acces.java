package prog2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Acces implements InAcces, Serializable {
    private String nom;
    private boolean accessibilitat;
    private boolean estat; // true = Obert, false = Tancat
    private List<Allotjament> allotjaments;

    public Acces(String nom, boolean accessibilitat) {
        this.nom = nom;
        this.accessibilitat = accessibilitat;
        this.estat = true; // Per defecte obert
        this.allotjaments = new ArrayList<>();
    }
    public Acces(String nom, boolean accessibilitat, boolean estat) {
        this.nom = nom;
        this.accessibilitat = accessibilitat;
        this.estat = estat; // Per defecte obert
        this.allotjaments = new ArrayList<>();
    }

    @Override
    public void afegirAllotjament(Allotjament allotjament) {allotjaments.add(allotjament);}

    @Override
    public void tancarAcces() {this.estat = false;}

    @Override
    public void obrirAcces() {this.estat = true;}

    public String getNom() {return nom;}

    public boolean getEstat() {return estat;}

    public List<Allotjament> getAllotjaments() {
        return allotjaments;
    }

    @Override
    public abstract boolean isAccessibilitat();


    @Override
    public String toString() {
        return "Acces{" +
                "nom='" + nom + '\'' +
                ", accessibilitat=" + accessibilitat +
                ", estat=" + (estat ? "Obert" : "Tancat") +
                ", allotjaments=" + allotjaments +
                '}';
    }
}