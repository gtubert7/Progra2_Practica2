package prog2.model;

/**
 * Classe abstracta per accessos d'asfalt.
 */
public abstract class AccesAsfalt extends Acces {
    protected float metresQuadratsAsfalt;

    public AccesAsfalt(String nom, boolean accessibilitat, float metresQuadratsAsfalt) {
        super(nom, accessibilitat);
        this.metresQuadratsAsfalt = metresQuadratsAsfalt;
    }
    public AccesAsfalt(String nom, boolean accessibilitat, boolean estat, float metresQuadratsAsfalt) {
        super(nom, accessibilitat, estat);
        this.metresQuadratsAsfalt = metresQuadratsAsfalt;
    }

    public float getMetresQuadratsAsfalt() {return metresQuadratsAsfalt;}

    public void setMetresQuadratsAsfalt(int metresQuadratsAsfalt) {this.metresQuadratsAsfalt = metresQuadratsAsfalt;}

    @Override
    public String toString() {
        return super.toString() + ", metresQuadratsAsfalt=" + metresQuadratsAsfalt;
    }
}