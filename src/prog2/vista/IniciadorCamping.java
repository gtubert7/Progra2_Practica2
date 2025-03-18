package prog2.vista;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class IniciadorCamping {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Definim el nom del càmping
        String nomCamping = "Green";

        // Creem un objecte de la vista i li passem el nom del càmping
        VistaCamping vistaCamping = new VistaCamping(nomCamping);

        // Inicialitzem l'execució de la vista
        vistaCamping.gestioCamping();
    }
}