package prog2.model;

/**
 * Subclasse BungalowPremium
 * @author FrexasLautaro
 * @author TubertGuillem
 */

public class BungalowPremium extends Bungalow{
    private boolean serveisExtra;
    private String codiWifi;

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
     * @param codiWifi el codi de la wifi
     * @param serveisExtra true = hi ha serveis extra, false no
     */
    public BungalowPremium(String nom_, String idAllotjament_, boolean estatAllotjament, String illuminacio, float mida, int habitacions, int placesPersones,
                           int placesParquing, boolean terrassa, boolean tv, boolean aireFred,
                           boolean serveisExtra, String codiWifi){
        //Fem servir super() per als estats heretats
        super(nom_, idAllotjament_,  estatAllotjament, illuminacio, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        setServeisExtra(serveisExtra);
        setCodiWifi(codiWifi);
    }

    /**
     * Retorna la disponibilitat de serveis extra
     * @return la disponibilitat de serveis extra
     */
    public boolean isServeisExtra(){return serveisExtra;}

    /**
     * Assigna la disponiblitat de serveis extra
     * @param serveisExtra disponiblitat de serveis extra
     */
    public void setServeisExtra(boolean serveisExtra){this.serveisExtra = serveisExtra;}

    /**
     * Retorna el codi de la wifi
     * @return el codi de la wifi
     */
    public String getCodiWifi(){return codiWifi;}

    /**
     * Assigna el codi de la wifi
     * @param codiWifi el codi a ser assignat
     */
    public void setCodiWifi(String codiWifi){this.codiWifi = codiWifi;}

    /**
     * Metode que retorna si l'allotjament funciona correctament
     * @return si l'allotjament funciona correctament
     */
    @Override
    public boolean correcteFuncionament() {
        int longitud = getCodiWifi().length();
        return super.correcteFuncionament() && 8 <= longitud && longitud <= 16;
    }
    /**
     * Metode que retorna la informacio de l'allotjament
     * @return String amb informacio sobre l'allotjament
     */
    public String toString(){
        return super.toString() + "BungalowPremium{serveisExtra=" + isServeisExtra() + ", codiWifi=" + getCodiWifi() + "}";
    }
}
