package prog2.model;

public class Incidencia {
    private int numIncidencia;
    private Allotjament allotjament;
    private String data;
    private TipusIncidencia tipusIncidencia;

    public Incidencia(int numIncidencia, Allotjament allotjament, String data, TipusIncidencia tipusIncidencia){
        setNumIncidencia(numIncidencia);
        setAllotjament(allotjament);
        setData(data);
        setTipusIncidencia(tipusIncidencia);
    }

    public int getNumIncidencia() {
        return numIncidencia;
    }
    public void setNumIncidencia(int numIncidencia) {
        this.numIncidencia = numIncidencia;
    }

    public Allotjament getAllotjament() {
        return allotjament;
    }
    public void setAllotjament(Allotjament allotjament) {
        this.allotjament = allotjament;
    }

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }

    public TipusIncidencia getTipusIncidencia() {
        return tipusIncidencia;
    }
    public void setTipusIncidencia(TipusIncidencia tipusIncidencia) {
        this.tipusIncidencia = tipusIncidencia;
    }

    public String getIluminacioAllotjament(){
        if (tipusIncidencia == TipusIncidencia.Reparacio) return "100%";
        else if (tipusIncidencia == TipusIncidencia.Neteja) return "50%";
        else return "0%";
    }
    @Override
    public String toString() {
        return "Incidencia{" +
                "numero=" + numIncidencia +
                ", allotjament=" + allotjament +
                ", data='" + data + '\'' +
                ", tipus=" + tipusIncidencia +
                ", iluminacio=" + getIluminacioAllotjament() +
                '}';
    }

    public static enum TipusIncidencia {
        Reparacio,
        Neteja,
        Tancament
    };
}

