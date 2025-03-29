package prog2.model;

/**
 * Classe que representa un camí de terra.
 */
public class CamiTerra extends AccesTerra {
    /**
     * Constructor de CamiTerra sense estat
     * @param nom el nom del cami
     * @param longitud la longitud del cami en m
     */
    public CamiTerra(String nom, float longitud) {
        super(nom, false, longitud);
    }

    /**
     * El constructor de CamiTerra amb estat
     * @param nom el nom de l'estat
     * @param estat true = obert, false = tancat
     * @param longitud la longitud del cami en m
     */
    public CamiTerra(String nom, boolean estat, float longitud) {
        super(nom, false, estat, longitud);
    }

    /**
     * Metode que retorna l'accessibilitat de l'acces
     * @return l'accessibilitat de l'acces
     */
    @Override
    public boolean isAccessibilitat() {return false;}
}