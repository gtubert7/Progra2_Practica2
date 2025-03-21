package prog2.model;

/**
 * Classe que representa un camí de terra.
 */
public class CamiTerra extends AccesTerra {
    public CamiTerra(String nom, int longitud) {
        super(nom, false, longitud);
    }

    @Override
    public boolean isAccessibilitat() {return false;}
}