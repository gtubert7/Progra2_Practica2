package prog2.model;

/**
 * Classe abstracta per accessos de terra.
 * @author Lautaro Frexas
 * @author Guillem Tubert
 */
public abstract class AccesTerra extends Acces {
    protected float longitud; //la longitud en metres de l'acces

    /**
     * Constructor de l'acces sense estat
     * @param nom el nom de l'acces
     * @param accessibilitat L'accessibilitat en cotxe de l'acces
     * @param longitud La longitud en metre de l'acces
     */
    public AccesTerra(String nom, boolean accessibilitat, float longitud) {
        super(nom, accessibilitat);
        this.longitud = longitud;
    }

    /**
     * Constructor de l'acces amb estat
     * @param nom el nom de l'acces
     * @param accessibilitat l'accessibilitat en cotxe de l'acces
     * @param estat l'estat de l'acces (true = obert, false, = tancat)
     * @param longitud la longitud en metres de l'acces
     */
    public AccesTerra(String nom, boolean accessibilitat, boolean estat, float longitud) {
        super(nom, accessibilitat, estat);
        this.longitud = longitud;
    }

    /**
     * Metode que retorna la longitud de l'acces en metres
     * @return la longitud de l'acces en metres
     */
    public float getLongitud() {return longitud;}

    /**
     * Metode que assigna la longitud de la variable longitud
     * @param longitud la quantitat que volem assignar
     */
    public void setLongitud(int longitud) {this.longitud = longitud;}

    /**
     * Metode que retorna la informacio de l'acces com a string
     * @return la informacio de l'acces com a string
     */
    @Override
    public String toString() {
        return super.toString() + ", longitud=" + longitud;
    }
}