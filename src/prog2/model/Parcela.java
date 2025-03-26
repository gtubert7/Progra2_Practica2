package prog2.model;

/**
 * Subclasse Parcela
 * @author FrexasLautaro
 * @author TubertGuillem
 */

public class Parcela extends Allotjament{
    private float metres;
    private boolean connexioElectrica;

    //El constructor de Parcela
    public Parcela(String nom_, String idAllotjament_, boolean estatAllotjament, String illuminacio, float metres, boolean connexioElectrica){
        super(nom_, idAllotjament_, 4, 2,  estatAllotjament, illuminacio);
        setMida(metres);
        setConnexioElectrica(connexioElectrica);
    }
    //Construim els getters i els setters
    public float getMida(){return metres;}
    public void setMida(float metres){this.metres = metres;}

    public boolean isConnexioElectrica(){return connexioElectrica;}
    public void setConnexioElectrica(boolean connexioElectrica){this.connexioElectrica = connexioElectrica;}

    //Revisem si funciona l'allotjament
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

