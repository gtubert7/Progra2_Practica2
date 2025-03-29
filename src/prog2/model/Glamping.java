package prog2.model;

/**
 * Subclasse Glamping
 * @author FrexasLautaro
 * @author TubertGuillem
 */

public class Glamping extends Casa {
    private String material;
    private boolean casaMascota;

    /**
     * Constructor d'Allotjament
     * @param nom_ el nom de l'allotjament
     * @param idAllotjament_ l'id de l'allotjament
     * @param estatAllotjament l'estat de l'allotjament (true = operatiu, false = no operatiu)
     * @param illuminacio la il·luminacio de l'allotjament
     * @param mida la mida de l'allotjament
     * @param habitacions el nombre d'habitacions a l'allotjament
     * @param placesPersones la quantitat de persones que poden allotjar-se a l'allotjament
     * @param material el material del glamping
     * @param casaMascota disponibilitat de casa de mascota
     */
    public Glamping(String nom_, String idAllotjament_, boolean estatAllotjament, String illuminacio, float mida, int habitacions, int placesPersones,
                    String material, boolean casaMascota){
        super(nom_, idAllotjament_, 5, 3, estatAllotjament, illuminacio, mida, habitacions, placesPersones);

        setMaterial(material);
        setCasaMascota(casaMascota);
    }

    /**
     * Retorna el material del glamping
     * @return el material del glamping
     */
    public String getMaterial(){return material;}
    /**
     * Assigna el material del glamping
     * @param material el material a ser assignar
     */
    public void setMaterial(String material){this.material = material;}

    /**
     * Retorna la disponibilitat de la casa de mascota
     * @return la disponibilitat de la casa de mascota
     */
    public boolean isCasaMascota(){return casaMascota;}

    /**
     * Assigna la disponibilitat de la casa de mascota
     * @param casaMascota la disponibilitat de la casa de mascota
     */
    public void setCasaMascota(boolean casaMascota){this.casaMascota = casaMascota;}

    /**
     * Metode que retorna si l'allotjament funciona correctament
     * @return el funcionament de l'allotjament
     */
    @Override
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
