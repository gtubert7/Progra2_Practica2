package prog2.model;

/**
 * Classe que representa un camí d'asfalt.
 * @author Lautaro Frexas
 * @author GuillemTubert
 */
public class CamiAsfalt extends AccesAsfalt {
    /**
     * Constructor de CamiAsfalt sense estat
     * @param nom el nom del cami
     * @param metresQuadratsAsfalt La quantitat de metres quadrats d'asfalt
     */

    public CamiAsfalt(String nom, float metresQuadratsAsfalt) {
        super(nom, false, metresQuadratsAsfalt);
    }
    /**
     * Constructor de CamiAsfalt amb estat
     * @param nom el nom del cami
     * @param estat l'estat de l'acces (obert = true, false = tancat)
     * @param metresQuadratsAsfalt La quantitat de metres quadrats d'asfalt
     */
    public CamiAsfalt(String nom, boolean estat, float metresQuadratsAsfalt) {
        super(nom, false,estat, metresQuadratsAsfalt);
    }

    /**
     * Metode que retorna l'accessibilitat de l'acces
     * @return l'accessibilitat de l'acces
     */
    @Override
    public boolean isAccessibilitat() {return false;}
}