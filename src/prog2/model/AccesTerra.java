package prog2.model;

/**
 * Classe abstracta per accessos de terra.
 */
public abstract class AccesTerra extends Acces {
    protected float longitud;

    public AccesTerra(String nom, boolean accessibilitat, float longitud) {
        super(nom, accessibilitat);
        this.longitud = longitud;
    }

    public AccesTerra(String nom, boolean accessibilitat, boolean estat, float longitud) {
        super(nom, accessibilitat, estat);
        this.longitud = longitud;
    }

    public float getLongitud() {return longitud;}

    public void setLongitud(int longitud) {this.longitud = longitud;}

    @Override
    public String toString() {
        return super.toString() + ", longitud=" + longitud;
    }
}