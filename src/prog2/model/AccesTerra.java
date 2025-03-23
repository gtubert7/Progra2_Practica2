package prog2.model;

/**
 * Classe abstracta per accessos de terra.
 */
public abstract class AccesTerra extends Acces {
    protected int longitud;

    public AccesTerra(String nom, boolean accessibilitat, int longitud) {
        super(nom, accessibilitat);
        this.longitud = longitud;
    }

    public int getLongitud() {return longitud;}

    public void setLongitud(int longitud) {this.longitud = longitud;}

    @Override
    public String toString() {
        return super.toString() + ", longitud=" + longitud;
    }
}