package prog2.model;

/**
 * Classe que representa una carretera de terra.
 */
public class CarreteraTerra extends AccesTerra {
    private int amplada;

    public CarreteraTerra(String nom, int longitud, int amplada) {
        super(nom, true, longitud);
        this.amplada = amplada;
    }

    public int getAmplada() {return amplada;}

    public void setAmplada(int amplada) {this.amplada = amplada;}

    @Override
    public boolean isAccessibilitat() {return true;}

    @Override
    public String toString() {
        return super.toString() + ", amplada=" + amplada;
    }
}