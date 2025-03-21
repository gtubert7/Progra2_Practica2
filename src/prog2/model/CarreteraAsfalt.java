package prog2.model;

/**
 * Classe que representa una carretera asfaltada.
 */
public class CarreteraAsfalt extends AccesAsfalt {
    private int pesMaximKg;

    public CarreteraAsfalt(String nom, int metresQuadratsAsfalt, int pesMaximKg) {
        super(nom, true, metresQuadratsAsfalt);
        this.pesMaximKg = pesMaximKg;
    }

    public int getPesMaximKg() {return pesMaximKg;}

    public void setPesMaximKg(int pesMaximKg) {this.pesMaximKg = pesMaximKg;}

    @Override
    public boolean isAccessibilitat() {return true;}

    @Override
    public String toString() {
        return super.toString() + ", pesMaximKg=" + pesMaximKg;
    }
}