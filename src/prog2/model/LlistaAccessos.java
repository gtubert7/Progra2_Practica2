package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.io.Serializable;
import java.util.ArrayList;

public class LlistaAccessos implements InLlistaAccessos, Serializable {
    private ArrayList<Acces> accessos;

    public LlistaAccessos() {
        this.accessos = new ArrayList<>();
    }

    public void afegirAcces(Acces acc) throws ExcepcioCamping{
        if(accessos.contains(acc)){
            throw new ExcepcioCamping("L'acces ja esta afegit.");
        }
        accessos.add(acc);
    }

    public void buidar(){
        for(Acces acc : accessos){
            accessos.remove(acc);

        }
    }

    @Override
    public String llistarAccessos(boolean estat) throws ExcepcioCamping {
        StringBuilder sb = new StringBuilder();
        for (Acces acc : accessos) {
            if (acc.getEstat() == estat) {
                sb.append("Accés: ").append(acc.getNom()).append("\n");
            }
        }
        if (sb.isEmpty()) throw new ExcepcioCamping("No hi ha accessos amb aquest estat");
        return sb.toString();
    }

    public void actualitzaEstatAccessos() throws ExcepcioCamping{
        for (Acces acc : accessos) {
            if (acc.getAllotjaments().isEmpty()) {
                acc.tancarAcces();
            } else {
                acc.obrirAcces();
            }
        }
    }

    public int calculaAccessosAccessibles(){
        int count = 0;
        for (Acces acc : accessos) {
            if (acc.isAccessibilitat()) count++;
        }
        return count;
    }

    public float calculaMetresQuadratsAsfalt() {
        float total = 0;
        for (Acces acc : accessos) {
            if (acc instanceof AccesAsfalt) {
                total += ((AccesAsfalt) acc).getMetresQuadratsAsfalt();
            }
        }
        return total;
    }
}
