package prog2.model;

/**
 * Classe que representa una carretera asfaltada.
 * @author Lautaro Frexas
 * @author Guillem Tubert
 */
public class CarreteraAsfalt extends AccesAsfalt {
    private float pesMaximKg;

    /**
     * Constructor de CarreteraAsfalt sense estat
     * @param nom el nom de la carretera
     * @param metresQuadratsAsfalt els metres quadrats d'asfalt
     * @param pesMaximKg el pes maxim en kg
     */
    public CarreteraAsfalt(String nom, float metresQuadratsAsfalt, float pesMaximKg) {
        super(nom, true, metresQuadratsAsfalt);
        this.pesMaximKg = pesMaximKg;
    }
    /**
     * Constructor de CarreteraAsfalt sense estat
     * @param nom el nom de la carretera
     * @param estat true = obert, false = tancat
     * @param metresQuadratsAsfalt els metres quadrats d'asfalt
     * @param pesMaximKg el pes maxim en kg
     */
    public CarreteraAsfalt(String nom, boolean estat, float metresQuadratsAsfalt, float pesMaximKg) {
        super(nom, true, estat, metresQuadratsAsfalt);
        this.pesMaximKg = pesMaximKg;
    }

    /**
     * Retorna el pes maxim en kg
     * @return el pes maxim en kg
     */
    public float getPesMaximKg() {return pesMaximKg;}

    /**
     * Assigna el pes maxim en kg
     * @param pesMaximKg el pes maxim en kg
     */
    public void setPesMaximKg(int pesMaximKg) {this.pesMaximKg = pesMaximKg;}

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
        return super.toString() + ", pesMaximKg=" + pesMaximKg;
    }
}