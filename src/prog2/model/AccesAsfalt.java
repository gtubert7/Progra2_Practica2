package prog2.model;

/**
 * Classe abstracta per accessos d'asfalt.
 * @author Lautaro Frexas
 * @author Guillem Tubert
 */
public abstract class AccesAsfalt extends Acces {
    protected float metresQuadratsAsfalt;

    /**
     * Constructor sense estat
     * @param nom el nom de l'acces
     * @param accessibilitat l'accessibilitat en cotxe de l'acces
     * @param metresQuadratsAsfalt la quantitat de metres quadrats d'asfalt de l'acces
     */
    public AccesAsfalt(String nom, boolean accessibilitat, float metresQuadratsAsfalt) {
        super(nom, accessibilitat);
        this.metresQuadratsAsfalt = metresQuadratsAsfalt;
    }

    /**
     * Constructor sense estat
     * @param nom el nom de l'acces
     * @param accessibilitat l'accessibilitat en cotxe de l'acces
     * @param estat l'estat de l'acces (obert = true, false = tancat)
     * @param metresQuadratsAsfalt la quantitat de metres quadrats d'asfalt de l'acces
     */
    public AccesAsfalt(String nom, boolean accessibilitat, boolean estat, float metresQuadratsAsfalt) {
        super(nom, accessibilitat, estat);
        this.metresQuadratsAsfalt = metresQuadratsAsfalt;
    }

    /**
     * Metode que retorna la quantitat de metres quadrats d'asfalt que té l'acces
     * @return la quantitat de metres quadrats d'asfalt
     */
    public float getMetresQuadratsAsfalt() {return metresQuadratsAsfalt;}

    /**
     * Setter de metresQuadratsAsfalt
     * @param metresQuadratsAsfalt la quantitat de metres quadrats que volem assignar
     */
    public void setMetresQuadratsAsfalt(int metresQuadratsAsfalt) {this.metresQuadratsAsfalt = metresQuadratsAsfalt;}

    /**
     * Metode que retorna la informacio de l'acces com a string
     * @return la informacio de l'acces com a string
     */
    @Override
    public String toString() {
        return super.toString() + ", metresQuadratsAsfalt=" + metresQuadratsAsfalt;
    }
}