package prog2.model;

public class CamiAsfalt extends AccesAsfalt {
    public CamiAsfalt(String nom, int metresQuadratsAsfalt) {
        super(nom, false, metresQuadratsAsfalt);
    }

    @Override
    public boolean isAccessibilitat() {return false;}
}