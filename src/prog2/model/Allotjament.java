package prog2.model;

import java.util.InputMismatchException;

/**
 * Implementació d'allotjament
 * @author FrexasLautaro
 * @author TubertGuillem
 */

public abstract class Allotjament implements InAllotjament{
    private String nom;
    private String idAllotjament;
    private long estadaMinimaBAIXA;
    private long estadaMinimaALTA;
    private boolean estat; /*true si operatiu, false si no*/
    private String illuminacio;

    //Constructor d'Allotjament
    public Allotjament(String nom, String idAllotjament, long estadaMinimaALTA, long estadaMinimaBAIXA, boolean estatAllotjament, String illuminacio){
        setNom(nom);
        setId(idAllotjament);
        setEstadaMinima(estadaMinimaALTA, estadaMinimaBAIXA);
        this.estat = estatAllotjament;
        setIlluminacio(illuminacio);
    }

    //Fem els getters i els setters
    public String getNom(){return nom;}
    public void setNom(String nom){this.nom = nom;}

    public String getId() {return idAllotjament;}
    public void setId(String id){idAllotjament = id;}

    public long getEstadaMinima(Temp temp){
        switch (temp.ordinal()){ //depenent de quina temporada es, 0 i 1 per les posicions de l'enum a InAllotjament
            case(0):
                return estadaMinimaALTA;
            case(1):
                return estadaMinimaBAIXA;
        }
        return -1;
    }
    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_){
        this.estadaMinimaALTA = estadaMinimaALTA_; //Canviem l'estada alta i baixa
        this.estadaMinimaBAIXA = estadaMinimaBAIXA_;
    }
    public boolean getEstat(){
        return estat;
    }
    public void setEstat(boolean estatAllotjament){
        this.estat = estatAllotjament;
    }

    public void setIlluminacio(String illuminacio){
        this.illuminacio = illuminacio;
    }

    public String getIlluminacio(){
        return illuminacio;
    }
    /**
     * Metode que retorna la informacio de l'allotjament
     * @return String amb informacio sobre l'allotjament
     */
    public String toString(){
        String operatiu;
        if (getEstat()) operatiu = "Operatiu";
        else operatiu = "No operatiu";
        return ("Nom="+ getNom() + ", Id=" + getId() + ", estada mínima en temp ALTA: "+ getEstadaMinima(Temp.ALTA) + ", estada mínima en temp BAIXA: " + getEstadaMinima(Temp.BAIXA) + ", Estat: " + operatiu + ", Il·luminació: " + getIlluminacio() + "%.");
    }

    public void tancarAllotjament(Incidencia in){
        estat = false;
        illuminacio = in.getIluminacioAllotjament();
    }


    public void obrirAllotjament(){
        estat = true;
        illuminacio = "100%";
    }
}