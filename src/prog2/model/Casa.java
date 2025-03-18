package prog2.model;

/**
 * Subclasse abstracta Casa
 * @author FrexasLautaro
 * @author TubertGuillem
 */

public abstract class Casa extends Allotjament{
    private String mida;
    private int habitacions;
    private int placesPersones;
    //Constructor de Casa
    Casa(String nom_, String idAllotjament_, long estadaMinimaALTA, long estadaMinimaBAIXA, boolean estatAllotjament, String illuminacio, String mida, int habitacions, int placesPersones){
        //Fem servir super() per als estats heretats
        super(nom_, idAllotjament_, estadaMinimaALTA, estadaMinimaBAIXA,  estatAllotjament, illuminacio);

        setMida(mida);
        setHabitacions(habitacions);
        setPlacesPersones(placesPersones);

    }

    //Construim els setters i els getters
    public String getMida(){return mida;}
    public void setMida(String mida){this.mida = mida;}

    public int getHabitacions(){return habitacions;}
    public void setHabitacions(int habitacions){this.habitacions = habitacions;}

    public int getPlacesPersones(){return placesPersones;}
    public void setPlacesPersones(int placesPersones){this.placesPersones = placesPersones;}
    /**
     * Metode que retorna la informacio de l'allotjament
     * @return String amb informacio sobre l'allotjament
     */
    public String toString(){
        return super.toString() + "Casa{mida=" + getMida() + ", habitacions=" + getHabitacions() + ", placesPersones=" + getPlacesPersones() + "}";
    }
}
