package prog2.model;

/**
 * Classe que representa una carretera asfaltada.
 */
public class CarreteraAsfalt extends AccesAsfalt {
    private float pesMaximKg;

    public CarreteraAsfalt(String nom, float metresQuadratsAsfalt, float pesMaximKg) {
        super(nom, true, metresQuadratsAsfalt);
        this.pesMaximKg = pesMaximKg;
    }

    public CarreteraAsfalt(String nom, boolean estat, float metresQuadratsAsfalt, float pesMaximKg) {
        super(nom, true, estat, metresQuadratsAsfalt);
        this.pesMaximKg = pesMaximKg;
    }

    public float getPesMaximKg() {return pesMaximKg;}

    public void setPesMaximKg(int pesMaximKg) {this.pesMaximKg = pesMaximKg;}

    @Override
    public boolean isAccessibilitat() {return true;}

    @Override
    public String toString() {
        return super.toString() + ", pesMaximKg=" + pesMaximKg;
    }
}