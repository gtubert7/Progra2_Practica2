package prog2.vista;

/**
 * Excepció personalitzada per errors relacionats amb el càmping.
 */
public class ExcepcioCamping extends Exception {

    /**
     * Constructor amb missatge personalitzat.
     * @param missatge Missatge d'error de l'excepció.
     */
    public ExcepcioCamping(String missatge) {
        super(missatge);
    }
}