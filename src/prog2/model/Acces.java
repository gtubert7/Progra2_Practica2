package prog2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe abstracta per accessos.
 * @author Lautaro Frexas
 * @author Guillem Tubert
 */

public abstract class Acces implements InAcces, Serializable {
    private String nom;
    private boolean accessibilitat; //(accessible en cotxe)
    private boolean estat; // true = Obert, false = Tancat
    private List<Allotjament> allotjaments; //La llista d'allotjaments conectats a l'acces

    /**
     * Constructor de la classe Access (estat per defecte)
     * @param nom El nom de l'acces
     * @param accessibilitat L'accessibilitat de l'acces
     */
    public Acces(String nom, boolean accessibilitat) {
        this.nom = nom;
        this.accessibilitat = accessibilitat;
        this.estat = true; // Per defecte obert
        this.allotjaments = new ArrayList<>();
    }

    /**
     * Constructor de la classe Access (estat per parametre)
     * @param nom El nom de l'acces
     * @param accessibilitat L'accessibilitat de l'acces
     * @param estat L'estat de l'acces
     */
    public Acces(String nom, boolean accessibilitat, boolean estat) {
        this.nom = nom;
        this.accessibilitat = accessibilitat;
        this.estat = estat; // Per defecte obert
        this.allotjaments = new ArrayList<>();
    }

    /**
     * Metode que afegeix un allotjament a la llista d'allotjaments conectats a l'acces
     * @param allotjament L'allotjament conectat a l'acces
     */
    @Override
    public void afegirAllotjament(Allotjament allotjament) {allotjaments.add(allotjament);}

    /**
     * Metode que tanca l'acces (setter d'estat a fals)
     */
    @Override
    public void tancarAcces() {this.estat = false;}

    /**
     * Metode que obre l'acces (setter d'estat a true)
     */
    @Override
    public void obrirAcces() {this.estat = true;}

    /**
     * Metode que retorna el nom de l'acces
     * @return el nom de l'acces
     */
    public String getNom() {return nom;}

    /**
     * Metode que retorna l'estat de l'acces
     * @return l'estat de l'acces (true = obert, false = tancat)
     */
    public boolean getEstat() {return estat;}

    /**
     * Metode que retorna la llista d'allotjaments connectats a un acces
     * @return la llista d'accessos conectats a l'allotjament
     */
    public List<Allotjament> getAllotjaments() {
        return allotjaments;
    }

    /**
     * Metode abstracte que retorna l'accessibilitat d'un acces
     * @return l'accessibilitat de l'allotjament (true accessible, false no accessible)
     */
    @Override
    public abstract boolean isAccessibilitat();

    /**
     * Metode que retorna la informacio d'un access com a string intel·ligible
     * @return la informacio d'un access com a string intel·ligible
     */
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