package prog2.model;

public class CamiAsfalt extends AccesAsfalt {
    public CamiAsfalt(String nom, float metresQuadratsAsfalt) {
        super(nom, false, metresQuadratsAsfalt);
    }

    public CamiAsfalt(String nom, boolean estat, float metresQuadratsAsfalt) {
        super(nom, false,estat, metresQuadratsAsfalt);
    }

    @Override
    public boolean isAccessibilitat() {return false;}
}