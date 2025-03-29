package prog2.model;

/**
 * Classe que representa una carretera de terra.
 * @author Lautaro Frexas
 * @authro Guillem Tubert
 */
public class CarreteraTerra extends AccesTerra {
    private float amplada;

    /**
     * Constructor de CarreteraTerra sense estat
     * @param nom el nom de l'acces
     * @param longitud la longitud de l'acces
     * @param amplada l'amplada de l'acces
     */
    public CarreteraTerra(String nom, float longitud, float amplada) {
        super(nom, true, longitud);
        this.amplada = amplada;
    }
    /**
     * Constructor de CarreteraTerra amb estat
     * @param nom el nom de l'acces
     * @param estat true = obert, false = tancat
     * @param longitud la longitud de l'acces
     * @param amplada l'amplada de l'acces
     */
    public CarreteraTerra(String nom, boolean estat, float longitud, float amplada) {
        super(nom, true, estat, longitud);
        this.amplada = amplada;
    }

    /**
     * Retorna l'amplada de l'acces
     * @return l'amplada de l'acces
     */
    public float getAmplada() {return amplada;}

    /**
     * Assigna l'amplada de l'acces
     * @param amplada l'amplada de l'acces
     */
    public void setAmplada(int amplada) {this.amplada = amplada;}

    /**
     * Metode que retorna l'accessibilitat de l'acces
     * @return l'accessibilitat de l'acces
     */
    @Override
    public boolean isAccessibilitat() {return true;}

    /**
     * Metode que retorna la informacio de l'acces com a string
     * @return la informacio de l'acces com a string
     */
    @Override
    public String toString() {
        return super.toString() + ", amplada=" + amplada;
    }
}