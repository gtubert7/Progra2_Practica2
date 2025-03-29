package prog2.model;

/**
 * Subclasse abstracta Casa
 * @author FrexasLautaro
 * @author TubertGuillem
 */

public abstract class Casa extends Allotjament{
    private float mida;
    private int habitacions;
    private int placesPersones;
    /**
     * Constructor d'Allotjament
     * @param nom_ el nom de l'allotjament
     * @param idAllotjament_ l'id de l'allotjament
     * @param estadaMinimaALTA l'estada minima requerida de l'allotjament en temporada alta
     * @param estadaMinimaBAIXA l'estada minima requerida de l'allotjament en temporada baixa
     * @param estatAllotjament l'estat de l'allotjament (true = operatiu, false = no operatiu)
     * @param illuminacio la il·luminacio de l'allotjament
     * @param mida la mida de l'allotjament
     * @param habitacions el nombre d'habitacions a l'allotjament
     * @param placesPersones la quantitat de persones que poden allotjar-se a l'allotjament
     */
    Casa(String nom_, String idAllotjament_, long estadaMinimaALTA, long estadaMinimaBAIXA, boolean estatAllotjament, String illuminacio, float mida, int habitacions, int placesPersones){
        //Fem servir super() per als estats heretats
        super(nom_, idAllotjament_, estadaMinimaALTA, estadaMinimaBAIXA,  estatAllotjament, illuminacio);

        setMida(mida);
        setHabitacions(habitacions);
        setPlacesPersones(placesPersones);

    }

    /**
     * Metode que retorna la mida de l'allotjament
     * @return la mida de l'allotjament
     */
    public float getMida(){return mida;}

    /**
     * Metode que assigna la mida de l'allotjament
     * @param mida la mida a ser assignada
     */
    public void setMida(float mida){this.mida = mida;}

    /**
     * Metode que retorna la quantitat d'habitacions
     * @return la quantitat d'habitacions
     */
    public int getHabitacions(){return habitacions;}

    /**
     * Metode que assigna la quantitat d'habitacions
     * @param habitacions la quantitat a ser assignada
     */
    public void setHabitacions(int habitacions){this.habitacions = habitacions;}

    /**
     * Metode que retorna la quantitat de places de persones
     * @return la quantitat de places de persones
     */
    public int getPlacesPersones(){return placesPersones;}
    public void setPlacesPersones(int placesPersones){this.placesPersones = placesPersones;}
    /**
     * Metode que retorna la informacio de l'allotjament com a string
     * @return String amb informacio sobre l'allotjament
     */
    public String toString(){
        return super.toString() + "Casa{mida=" + getMida() + ", habitacions=" + getHabitacions() + ", placesPersones=" + getPlacesPersones() + "}";
    }
}
