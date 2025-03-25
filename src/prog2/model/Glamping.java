package prog2.model;

/**
 * Subclasse Glamping
 * @author FrexasLautaro
 * @author TubertGuillem
 */

public class Glamping extends Casa {
    private String material;
    private boolean casaMascota;

    public Glamping(String nom_, String idAllotjament_, boolean estatAllotjament, String illuminacio, float mida, int habitacions, int placesPersones,
                    String material, boolean casaMascota){
        super(nom_, idAllotjament_, 5, 3, estatAllotjament, illuminacio, mida, habitacions, placesPersones);

        setMaterial(material);
        setCasaMascota(casaMascota);
    }
    //Fem els getters i els setters
    public String getMaterial(){return material;}
    public void setMaterial(String material){this.material = material;}

    public boolean isCasaMascota(){return casaMascota;}
    public void setCasaMascota(boolean casaMascota){this.casaMascota = casaMascota;}

    public boolean correcteFuncionament() {
        return isCasaMascota();
    }
    /**
     * Metode que retorna la informacio de l'allotjament
     * @return String amb informacio sobre l'allotjament
     */
    public String toString(){
        return super.toString() + "Glamping{material=" + getMaterial() + ", casaMascota=" + isCasaMascota() +"}";
    }
}
