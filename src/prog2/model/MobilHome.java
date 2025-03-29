package prog2.model;

/**
 * Subclasse MobilHome
 * @author FrexasLautaro
 * @author TubertGuillem
 */

public class MobilHome extends Casa {
    private boolean terrassaBarbacoa;

    /**
     * Constructor d'Allotjament
     * @param nom_ el nom de l'allotjament
     * @param idAllotjament_ l'id de l'allotjament
     * @param estatAllotjament l'estat de l'allotjament (true = operatiu, false = no operatiu)
     * @param illuminacio la il·luminacio de l'allotjament
     * @param mida la mida de l'allotjament
     * @param habitacions el nombre d'habitacions a l'allotjament
     * @param placesPersones la quantitat de persones que poden allotjar-se a l'allotjament
     * @param terrassaBarbacoa la disponibilitat de terrassa de barbacoa
     */
    public MobilHome(String nom_, String idAllotjament_, boolean estatAllotjament, String illuminacio, float mida, int habitacions, int placesPersones,
                     boolean terrassaBarbacoa){

        //Fem servir super() per als estats heretats
        super(nom_, idAllotjament_, 5, 3, estatAllotjament, illuminacio, mida, habitacions, placesPersones);
        setTerrassaBarbacoa(terrassaBarbacoa);
    }

    /**
     * Retorna la disponibilitat de terrassa de barbacoa
     * @return la disponibilitat de terrassa de barbacoa
     */
    public boolean isTerrassaBarbacoa(){return terrassaBarbacoa;}

    /**
     * Assigna la disponibilitat de terrassa de barbacoa
     * @param terrassaBarbacoa la disponibilitat de terrassa de barbacoa
     */
    public void setTerrassaBarbacoa(boolean terrassaBarbacoa){this.terrassaBarbacoa = terrassaBarbacoa;}

    /**
     * Metode que retorna si l'allotjament funciona correctament
     * @return funcionament de l'allotjament
     */
    @Override
    public boolean correcteFuncionament() {
        return isTerrassaBarbacoa();
    }
    /**
     * Metode que retorna la informacio de l'allotjament
     * @return String amb informacio sobre l'allotjament
     */
    public String toString(){
        return super.toString() + "MobilHome{terrassaBarbacoa=" + isTerrassaBarbacoa() + "}";
    }
}
