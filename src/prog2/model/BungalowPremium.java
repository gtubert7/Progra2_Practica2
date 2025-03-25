package prog2.model;

/**
 * Subclasse BungalowPremium
 * @author FrexasLautaro
 * @author TubertGuillem
 */

public class BungalowPremium extends Bungalow{
    private boolean serveisExtra;
    private String codiWifi;

    //Constructor de BungalowPremium
    public BungalowPremium(String nom_, String idAllotjament_, boolean estatAllotjament, String illuminacio, float mida, int habitacions, int placesPersones,
                           int placesParquing, boolean terrassa, boolean tv, boolean aireFred,
                           boolean serveisExtra, String codiWifi){
        //Fem servir super() per als estats heretats
        super(nom_, idAllotjament_,  estatAllotjament, illuminacio, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        setServeisExtra(serveisExtra);
        setCodiWifi(codiWifi);
    }

    //Fem else getters i els setters
    public boolean isServeisExtra(){return serveisExtra;}
    public void setServeisExtra(boolean serveisExtra){this.serveisExtra = serveisExtra;}

    public String getCodiWifi(){return codiWifi;}
    public void setCodiWifi(String codiWifi){this.codiWifi = codiWifi;}

    //Veiem si (a) les condicions de correcte funcionament del bungalow funcionen i (b) si la el codi del wifi es correcte
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
