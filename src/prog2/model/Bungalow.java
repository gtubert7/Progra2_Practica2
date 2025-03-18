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

    //Constructor de Bungalow
    public Bungalow(String nom_, String idAllotjament_, boolean estatAllotjament, String illuminacio, String mida, int habitacions, int placesPersones,
                    int placesParquing, boolean terrassa, boolean tv, boolean aireFred){
        //Fem servir super() per als estats heretats
        super(nom_, idAllotjament_, 7, 4,  estatAllotjament, illuminacio, mida, habitacions, placesPersones);

        setPlacesParquing(placesParquing);
        setTerrassa(terrassa);
        setTv(tv);
        setAireFred(aireFred);
    }

    //Fem els getters i els setters
    public int getPlacesParquing(){return placesParquing;}
    public void setPlacesParquing(int placesParquing){this.placesParquing = placesParquing;}

    public boolean isTerrassa(){return terrassa;}
    public void setTerrassa(boolean terrassa){this.terrassa = terrassa;}

    public boolean isTv(){return tv;}
    public void setTv(boolean tv){this.tv = tv;}

    public boolean isAireFred(){return aireFred;}
    public void setAireFred(boolean aireFred){this.aireFred = aireFred;}

    //Comprovem que hi ha aire fred
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

