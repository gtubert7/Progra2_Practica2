package prog2.model;

import java.io.Serializable;
import java.util.InputMismatchException;

/**
 * Implementació de la classe abstracta Allotjament
 * @author FrexasLautaro
 * @author TubertGuillem
 */

public abstract class Allotjament implements InAllotjament, Serializable {
    private String nom;
    private String idAllotjament;
    private long estadaMinimaBAIXA;
    private long estadaMinimaALTA;
    private boolean estat; /*true si operatiu, false si no*/
    private String illuminacio;

    /**
     * Constructor d'Allotjament
     * @param nom el nom de l'allotjament
     * @param idAllotjament l'id de l'allotjament
     * @param estadaMinimaALTA l'estada minima requerida de l'allotjament en temporada alta
     * @param estadaMinimaBAIXA l'estada minima requerida de l'allotjament en temporada baixa
     * @param estatAllotjament l'estat de l'allotjament (true = operatiu, false = no operatiu)
     * @param illuminacio la il·luminacio de l'allotjament
     */
    public Allotjament(String nom, String idAllotjament, long estadaMinimaALTA, long estadaMinimaBAIXA, boolean estatAllotjament, String illuminacio){
        setNom(nom);
        setId(idAllotjament);
        setEstadaMinima(estadaMinimaALTA, estadaMinimaBAIXA);
        this.estat = estatAllotjament;
        setIlluminacio(illuminacio);
    }

    /**
     * Obté el nom de l'allotjament.
     * @return el nom de l'allotjament
     */
    public String getNom(){return nom;}

    /**
     * Estableix el nom de l'allotjament.
     * @param nom el nom a assignar.
     */
    public void setNom(String nom){this.nom = nom;}

    /**
     * Obté l'identificador únic de l'allotjament.
     * @return l'id de l'allotjament
     */
    public String getId() {return idAllotjament;}

    /**
     * Metode que assigna l'id de l'allotjament
     * @param id l'identificador a assignar.
     */
    public void setId(String id){idAllotjament = id;}

    /**
     * Metode que retorna l'estada minima
     * @param temp la temporada (ALTA o BAIXA).
     * @return l'estada minima depenent de la temporada
     */
    public long getEstadaMinima(Temp temp){
        switch (temp.ordinal()){ //depenent de quina temporada es, 0 i 1 per les posicions de l'enum a InAllotjament
            case(0):
                return estadaMinimaALTA;
            case(1):
                return estadaMinimaBAIXA;
        }
        return -1;
    }

    /**
     * Estableix l'estada mínima per a cada temporada
     * @param estadaMinimaALTA_ l'estada mínima en temporada alta.
     * @param estadaMinimaBAIXA_ l'estada mínima en temporada baixa.
     */
    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_){
        this.estadaMinimaALTA = estadaMinimaALTA_; //Canviem l'estada alta i baixa
        this.estadaMinimaBAIXA = estadaMinimaBAIXA_;
    }

    /**
     * Metode que retorna l'estat de l'allotjament (true = obert, false = tancat)
     * @return l'estat de l'allotjament
     */
    public boolean getEstat(){
        return estat;
    }

    /**
     * Metode que assigna l'estat de l'allotjament (true = obert, false = tancat)
     * @param estatAllotjament l'estat a assignar
     */
    public void setEstat(boolean estatAllotjament){
        this.estat = estatAllotjament;
    }

    /**
     * Metode que assigna la illuminacio de l'allotjament
     * @param illuminacio l'illuminacio a assignar
     */
    public void setIlluminacio(String illuminacio){
        this.illuminacio = illuminacio;
    }

    /**
     * Metode que retorna la illuminacio de l'allotjament
     * @return l'illuminacio de l'allotjament
     */
    public String getIlluminacio(){
        return illuminacio;
    }
    /**
     * Metode que retorna la informacio de l'allotjament com a string
     * @return String amb informacio sobre l'allotjament
     */
    public String toString(){
        String operatiu;
        if (getEstat()) operatiu = "Operatiu";
        else operatiu = "No operatiu";
        return ("Nom="+ getNom() + ", Id=" + getId() + ", estada mínima en temp ALTA: "+ getEstadaMinima(Temp.ALTA) + ", estada mínima en temp BAIXA: " + getEstadaMinima(Temp.BAIXA) + ", Estat: " + operatiu + ", Il·luminació: " + getIlluminacio() + "%.");
    }

    /**
     * Metode abstracte que retorna si l'allotjament funciona correctament
     * @return el funcionament de l'allotjament
     */
    public abstract boolean correcteFuncionament();

    /**
     * Metode que tanca l'allotjament
     * @param in Objecte de tipus Incidencia.
     */
    public void tancarAllotjament(Incidencia in){
        estat = false;
        illuminacio = in.getIluminacioAllotjament(); //Canvia depenent del tipus d'incidencia
    }

    /**
     * Metode que obre l'allotjament
     */
    public void obrirAllotjament(){
        estat = true;
        illuminacio = "100%";
    }
}