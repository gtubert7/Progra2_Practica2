package prog2.model;


/**
 * Subclasse Bungalow
 * @author FrexasLautaro
 * @author TubertGuillem
 */

public class Bungalow extends Casa {
    private int placesParquing;
    private boolean terrassa;
    private boolean tv;
    private boolean aireFred;

    /**
     * Constructor d'Allotjament
     * @param nom_ el nom de l'allotjament
     * @param idAllotjament_ l'id de l'allotjament
     * @param estatAllotjament l'estat de l'allotjament (true = operatiu, false = no operatiu)
     * @param illuminacio la il·luminacio de l'allotjament
     * @param mida la mida de l'allotjament
     * @param habitacions el nombre d'habitacions a l'allotjament
     * @param placesPersones la quantitat de persones que poden allotjar-se a l'allotjament
     * @param placesParquing la quantitat de places de parquing
     * @param terrassa true = te terrassa, false = no en te
     * @param tv true = hi ha televisio, false = no
     * @param aireFred true = hi ha aire fred, false = no
     */
    public Bungalow(String nom_, String idAllotjament_, boolean estatAllotjament, String illuminacio, float mida, int habitacions, int placesPersones,
                    int placesParquing, boolean terrassa, boolean tv, boolean aireFred){
        //Fem servir super() per als estats heretats
        super(nom_, idAllotjament_, 7, 4,  estatAllotjament, illuminacio, mida, habitacions, placesPersones);

        setPlacesParquing(placesParquing);
        setTerrassa(terrassa);
        setTv(tv);
        setAireFred(aireFred);
    }

    /**
     * retorna la quantitat de places de parquing
     * @return la quantitat de places de parquing
     */
    public int getPlacesParquing(){return placesParquing;}

    /**
     * Assigna les places de parquing
     * @param placesParquing la quantitat de places
     */
    public void setPlacesParquing(int placesParquing){this.placesParquing = placesParquing;}

    /**
     * Retorna si l'allotjament té terrassa
     * @return existencia de terrassa
     */
    public boolean isTerrassa(){return terrassa;}

    /**
     * Assigna l'existencia de terrassa
     * @param terrassa el boolea a ser assignat
     */
    public void setTerrassa(boolean terrassa){this.terrassa = terrassa;}

    /**
     * Retorna si hi ha tv
     * @return si hi ha tv
     */
    public boolean isTv(){return tv;}

    /**
     * Assigna si hi ha tv
     * @param tv el boolea a ser assignat
     */
    public void setTv(boolean tv){this.tv = tv;}

    /**
     * Retorna si hi ha aire fred
     * @return si hi ha aire fred
     */
    public boolean isAireFred(){return aireFred;}

    /**
     * Assigna si hi ha aire fred
     * @param aireFred el boolea a ser assignat
     */
    public void setAireFred(boolean aireFred){this.aireFred = aireFred;}

    /**
     * Metode que retorna si l'allotjament funciona correctament
     * @return si l'allotjament funciona correctament
     */
    @Override
    public boolean correcteFuncionament(){
        return isAireFred();
    }

    /**
     * Metode que retorna la informacio de l'allotjament
     * @return String amb informacio sobre l'allotjament
     */
    public String toString(){
        return super.toString() + "Bungalow{placesParquing="+ getPlacesParquing() + ", terrassa=" + isTerrassa() + ", tv=" + isTv() + ", aireFred=" + isAireFred() +"}";
    }
}

