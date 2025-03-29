package prog2.model;

/**
 * Subclasse Parcela
 * @author FrexasLautaro
 * @author TubertGuillem
 */

public class Parcela extends Allotjament{
    private float metres;
    private boolean connexioElectrica;

    /**
     * Constructor d'Allotjament
     * @param nom_ el nom de l'allotjament
     * @param idAllotjament_ l'id de l'allotjament
     * @param estatAllotjament l'estat de l'allotjament (true = operatiu, false = no operatiu)
     * @param illuminacio la il·luminacio de l'allotjament
     * @param metres els metres quadrats de l'allotjament
     * @param connexioElectrica la disponibilitat de connexio electrica
     */
    public Parcela(String nom_, String idAllotjament_, boolean estatAllotjament, String illuminacio, float metres, boolean connexioElectrica){
        super(nom_, idAllotjament_, 4, 2,  estatAllotjament, illuminacio);
        setMida(metres);
        setConnexioElectrica(connexioElectrica);
    }

    /**
     * Retorna la mida de la parcela en m2
     * @return la mida de la parcela en m2
     */
    public float getMida(){return metres;}

    /**
     * Assigna la mida de la parcela en m2
     * @param metres la mida de la parcela en m2
     */
    public void setMida(float metres){this.metres = metres;}

    /**
     * Retorna la disponibilitat de la connexio electrica
     * @return la disponibilitat de la connexio electrica
     */
    public boolean isConnexioElectrica(){return connexioElectrica;}

    /**
     * Assigna la disponibilitat de la connexio electrica
     * @param connexioElectrica la disponibilitat de la connexio electrica
     */
    public void setConnexioElectrica(boolean connexioElectrica){this.connexioElectrica = connexioElectrica;}

    /**
     * Metode que retorna si l'allotjament funciona correctament
     * @return el funcionament de l'allotjament
     */
    @Override
    public boolean correcteFuncionament(){
        return isConnexioElectrica();
    }

    /**
     * Metode que retorna la informacio de l'allotjament
     * @return String amb informacio sobre l'allotjament
     */
    public String toString(){
        return super.toString() + "Parcela{mida=" + getMida() + ", connexioElectrica=" + isConnexioElectrica() + "}";
    }
}

