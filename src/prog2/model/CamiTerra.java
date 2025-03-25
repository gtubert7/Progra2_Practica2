package prog2.model;

/**
 * Classe que representa un camí de terra.
 */
public class CamiTerra extends AccesTerra {
    public CamiTerra(String nom, float longitud) {
        super(nom, false, longitud);
    }

    public CamiTerra(String nom, boolean estat, float longitud) {
        super(nom, false, estat, longitud);
    }

    @Override
    public boolean isAccessibilitat() {return false;}
}