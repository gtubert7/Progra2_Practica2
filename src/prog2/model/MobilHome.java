package prog2.model;

/**
 * Subclasse MobilHome
 * @author FrexasLautaro
 * @author TubertGuillem
 */

public class MobilHome extends Casa {
    private boolean terrassaBarbacoa;

    //Constructor de MobilHome
    public MobilHome(String nom_, String idAllotjament_, boolean estatAllotjament, String illuminacio, float mida, int habitacions, int placesPersones,
                     boolean terrassaBarbacoa){

        //Fem servir super() per als estats heretats
        super(nom_, idAllotjament_, 5, 3, estatAllotjament, illuminacio, mida, habitacions, placesPersones);
        setTerrassaBarbacoa(terrassaBarbacoa);
    }

    public boolean isTerrassaBarbacoa(){return terrassaBarbacoa;}
    public void setTerrassaBarbacoa(boolean terrassaBarbacoa){this.terrassaBarbacoa = terrassaBarbacoa;}

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
