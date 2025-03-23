package prog2.model;

/**
 * Classe abstracta per accessos d'asfalt.
 */
public abstract class AccesAsfalt extends Acces {
    protected int metresQuadratsAsfalt;

    public AccesAsfalt(String nom, boolean accessibilitat, int metresQuadratsAsfalt) {
        super(nom, accessibilitat);
        this.metresQuadratsAsfalt = metresQuadratsAsfalt;
    }

    public int getMetresQuadratsAsfalt() {return metresQuadratsAsfalt;}

    public void setMetresQuadratsAsfalt(int metresQuadratsAsfalt) {this.metresQuadratsAsfalt = metresQuadratsAsfalt;}

    @Override
    public String toString() {
        return super.toString() + ", metresQuadratsAsfalt=" + metresQuadratsAsfalt;
    }
}