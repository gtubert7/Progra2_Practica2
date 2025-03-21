package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;
import java.util.Scanner;

public class LlistaIncidencies implements InLlistaIncidencies{
    private ArrayList<Incidencia> incidencies;

    public LlistaIncidencies(ArrayList<Incidencia> incidencies) {
        this.incidencies = new ArrayList<>();
    }

    public void afegirIncidencia(int num, String tipus, Allotjament allotjament, String data) throws ExcepcioCamping{
        //Comprovem si té incidència
        if (!allotjament.getEstat()){
            throw new ExcepcioCamping("L'allotjament ja té una incidència.");
        }
        //Provem si el tipus d'incidència és correcte
        Incidencia.TipusIncidencia tipusIncidencia;
        try {
            tipusIncidencia = Incidencia.TipusIncidencia.valueOf(tipus);
        } catch (IllegalArgumentException e) {
            throw new ExcepcioCamping("Tipus d'incidència no vàlid.");
        }
        //Creem la incidència corresponent
        Incidencia novaIncidencia = new Incidencia(num, allotjament, data, tipusIncidencia);
        //L'afegim a la llista
        incidencies.add(novaIncidencia);
        //Tanquem l'allotjament corresponent
        allotjament.setEstat(false);
    }

    public void eliminarIncidencia() throws ExcepcioCamping{
        if (incidencies.isEmpty()) {
            throw new ExcepcioCamping("No hi ha incidències per eliminar.");
        }

        Scanner scanner = new Scanner(System.in);

        //Mostrem les incidències que hi ha registrades
        llistarIncidencies();

        //Preguntem per la incidència a eliminar
        System.out.print("Introdueix el número de la incidència a eliminar: ");
        int index = scanner.nextInt();

        if (index < 0 || index >= incidencies.size()) {
            throw new ExcepcioCamping("Número d'incidència no vàlid.");
        }

        Incidencia in = incidencies.remove(index);
        in.getAllotjament().obrirAllotjament(); // Reobre l'allotjament afectat
        System.out.println("Incidència eliminada correctament.");
    }

    public String llistarIncidencies() throws ExcepcioCamping{
        if (incidencies.isEmpty()){
            throw new ExcepcioCamping("La llista d'incidències està buida.");
        }
        // StringBuilder per acumular la informació de les incidències
        StringBuilder sb = new StringBuilder();
        // Iterar sobre la llista d'incidències i acumular la informació
        for (Incidencia incidencia : incidencies) {
            sb.append(incidencia.toString()).append("\n"); // Afegim la informació de cada incidència
        }
        // Retornar la cadena amb totes les incidències
        return sb.toString();
    }

    @Override
    public Incidencia getIncidencia(int num) throws ExcepcioCamping {
        for (Incidencia incidencia : incidencies) {
            // Comprovar si el número d'incidència coincideix amb el paràmetre
            if (incidencia.getNumIncidencia() == num) {
                return incidencia; // Retornar la incidència trobada
            }
        }
        // Si no s'ha trobat la incidència, llançar una excepció
        throw new ExcepcioCamping("No existeix cap incidència amb el número " + num);
    }
}
