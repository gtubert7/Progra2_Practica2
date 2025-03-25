package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Implementació de camping
 * @author FrexasLautaro
 * @author TubertGuillem
 */

public class Camping implements InCamping {

    private String nom;
    //Creem ArrayLists de cada tipus
    private LlistaAllotjaments llistaAllotjaments;
    private LlistaIncidencies llistaIncidencies;
    private LlistaAccessos llistaAccessos;

    /**
     * Constructor de la classe camping
     *
     * @param nom nom del camping
     */
    public Camping(String nom) {
        this.nom = nom;
    }

    /**
     * metode getter del nom
     *
     * @return nom del camping
     */
    public String getNomCamping() {
        return nom;
    }

    /**
     * metode que retorno la llista d'allotjaments
     *
     * @return l'arraylist dels allotjaments
     */
    public LlistaAllotjaments getLlistaAllotjaments() {
        return llistaAllotjaments;
    }

    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        return llistaAllotjaments.llistarAllotjaments(estat);
    }

    public String llistarAccessos(String infoEstat) throws ExcepcioCamping {
        if (infoEstat.equalsIgnoreCase("obert")) return llistaAccessos.llistarAccessos(true);
        if (infoEstat.equalsIgnoreCase("tancat")) return llistaAccessos.llistarAccessos(false);
        if (infoEstat.equalsIgnoreCase("tots"))
            return llistaAccessos.llistarAccessos(true) + llistaAccessos.llistarAccessos(true);
        throw new ExcepcioCamping("Aquest estat no és vàlid");
    }

    public String llistarIncidencies() throws ExcepcioCamping {
        return llistaIncidencies.llistarIncidencies();
    }

    public void afegirIncidencia(int numIncidencia, String tipus, String idAllotjament, String data) throws ExcepcioCamping {
        Allotjament allotjament = llistaAllotjaments.getAllotjament(idAllotjament);
        llistaIncidencies.afegirIncidencia(numIncidencia, tipus, allotjament, data);
        llistaAccessos.actualitzaEstatAccessos();
    }

    public void eliminarIncidencia(int numIncidencia) throws ExcepcioCamping {
        Incidencia incidencia = llistaIncidencies.getIncidencia(numIncidencia);
        llistaIncidencies.eliminarIncidencia(incidencia);
        llistaAccessos.actualitzaEstatAccessos();

    }

    public int calculaAccessosAccessibles() {
        return llistaAccessos.calculaAccessosAccessibles();
    }

    public float calculaMetresQuadratsAsfalt() {
        return llistaAccessos.calculaMetresQuadratsAsfalt();
    }

    /**
     * Guarda l'estat actual del càmping en un fitxer.
     *
     * @param camiDesti Ruta del fitxer de destinació.
     * @throws ExcepcioCamping
     */
    public void save(String camiDesti) throws ExcepcioCamping {
        FileOutputStream fout = null;
        ObjectOutputStream oos = null;
        try {
            File fitxer = new File(camiDesti);
            fout = new FileOutputStream(fitxer);
            oos = new ObjectOutputStream(fout);
            oos.writeObject(this);
            oos.close();
            fout.close();
        } catch (IOException e) {
            System.out.println("No s'ha trobat el fitxer.");
        } finally {
            try {
                if (oos != null)
                    oos.close();
                if (fout != null)
                    fout.close();
            } catch (IOException e) {
                System.out.println("No s'ha pogut tancar el ostream.");
            }
        }
    }

    /**
     * Carrega l'estat d'un càmping des d'un fitxer.
     *
     * @param camiOrigen Ruta del fitxer d'origen.
     * @return Una instància de la classe Camping carregada des del fitxer.
     * @throws ExcepcioCamping
     */
    public static Camping load(String camiOrigen) throws ExcepcioCamping {
        Camping camping = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            File fitxer = new File(camiOrigen);
            fis = new FileInputStream(fitxer);
            ois = new ObjectInputStream(fis);
            camping = (Camping) ois.readObject();
            return camping;
        } catch (IOException e) {
            System.out.println("No s'ha trobat el fitxer.");
        } catch (ClassNotFoundException e) {
            System.out.println("Aquesta classe no existeix.");
        } finally {
            try {
                if (ois != null)
                    ois.close();
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                System.out.println("No s'ha pogut tancar el istream.");
            }
        }
        return camping;
    }

    public void inicialitzaDadesCamping() {
        try {
            llistaAccessos.buidar();

            float asfalt = 200;
            Acces Acc1 = new CamiAsfalt("A1", true, asfalt);
            llistaAccessos.afegirAcces(Acc1);

            asfalt = 800;
            float pesMaxim = 10000;
            Acces Acc2 = new CarreteraAsfalt("A2", true, asfalt, pesMaxim);
            llistaAccessos.afegirAcces(Acc2);

            float longitud = 100;
            Acces Acc3 = new CamiTerra("A3", true, longitud);
            llistaAccessos.afegirAcces(Acc3);

            longitud = 200;
            float amplada = 3;
            Acces Acc4 = new CarreteraTerra("A4", true, longitud, amplada);
            llistaAccessos.afegirAcces(Acc4);

            asfalt = 350;
            Acces Acc5 = new CamiAsfalt("A5", true, asfalt);
            llistaAccessos.afegirAcces(Acc5);

            asfalt = 800;
            pesMaxim = 12000;
            Acces Acc6 = new CarreteraAsfalt("A6", true, asfalt, pesMaxim);
            llistaAccessos.afegirAcces(Acc6);

            asfalt = 100;
            Acces Acc7 = new CamiAsfalt("A7", true, asfalt);
            llistaAccessos.afegirAcces(Acc7);

            asfalt = 800;
            pesMaxim = 10000;
            Acces Acc8 = new CarreteraAsfalt("A8", true, asfalt, pesMaxim);
            llistaAccessos.afegirAcces(Acc8);

            longitud = 50;
            Acces Acc9 = new CamiTerra("A9", true, longitud);
            llistaAccessos.afegirAcces(Acc9);

            longitud = 400;
            amplada = 4;
            Acces Acc10 = new CarreteraTerra("A10", true, longitud, amplada);
            llistaAccessos.afegirAcces(Acc10);

            longitud = 80;
            Acces Acc11 = new CamiTerra("A11", true, longitud);
            llistaAccessos.afegirAcces(Acc11);

            longitud = 800;
            amplada = 5;
            Acces Acc12 = new CarreteraTerra("A12", true, longitud, amplada);
            llistaAccessos.afegirAcces(Acc12);


            /* Pistes */
            llistaAllotjaments.buidar();


            // Afegir parcel·les:
            //------------------------------

            String nom = "Parcel·la Nord";
            String idAllotjament = "ALL1";
            float mida = 64.0f;
            boolean connexioElectrica = true;

            Parcela ALL1 = new Parcela(nom, idAllotjament, true, "100%", mida, connexioElectrica);
            llistaAllotjaments.afegirAllotjament(ALL1);

            nom = "Parcel·la Sud";
            idAllotjament = "ALL2";

            Parcela ALL2 = new Parcela(nom, idAllotjament, true, "100%", mida, connexioElectrica);
            llistaAllotjaments.afegirAllotjament(ALL2);

            // Afegir bungalows:
            //------------------------------

            nom = "Bungalow Nord";
            idAllotjament = "ALL3";
            mida = 22f;
            int habitacions = 2;
            int placesPersones = 4;
            int placesParquing = 1;
            boolean terrassa = true;
            boolean tv = true;
            boolean aireFred = true;

            Bungalow ALL3 = new Bungalow(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
            llistaAllotjaments.afegirAllotjament(ALL3);


            // Afegir bungalows premium:
            //------------------------------
            nom = "Bungallow Sud";
            idAllotjament = "ALL4";
            mida = 27f;
            habitacions = 2;
            placesPersones = 6;
            placesParquing = 1;
            terrassa = true;
            tv = true;
            aireFred = true;
            boolean serveisExtra = true;
            String codiWifi = "CampingDelMarBP1";

            BungalowPremium ALL4 = new BungalowPremium(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);
            llistaAllotjaments.afegirAllotjament(ALL4);

            // Afegir Glamping:
            //------------------------------

            nom = "Glamping Nord";
            idAllotjament = "ALL5";
            mida = 20f;
            habitacions = 1;
            placesPersones = 2;
            String material = "Tela";
            boolean casaMascota = true;

            Glamping ALL5 = new Glamping(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, material, casaMascota);
            llistaAllotjaments.afegirAllotjament(ALL5);


            // Afegir Mobil-Home:
            //------------------------------

            nom = "Mobil-Home Sud";
            idAllotjament = "ALL6";
            mida = 20f;
            habitacions = 2;
            placesPersones = 4;
            boolean terrassaBarbacoa = true;

            MobilHome ALL6 = new MobilHome(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, terrassaBarbacoa);
            llistaAllotjaments.afegirAllotjament(ALL6);

            /* Accés */
            Acc1.afegirAllotjament(ALL1);
            Acc1.afegirAllotjament(ALL2);
            Acc2.afegirAllotjament(ALL1);
            Acc2.afegirAllotjament(ALL2);
            Acc3.afegirAllotjament(ALL3);
            Acc4.afegirAllotjament(ALL3);
            Acc5.afegirAllotjament(ALL4);
            Acc6.afegirAllotjament(ALL4);
            Acc7.afegirAllotjament(ALL5);
            Acc7.afegirAllotjament(ALL6);
            Acc8.afegirAllotjament(ALL5);
            Acc8.afegirAllotjament(ALL6);
            Acc9.afegirAllotjament(ALL2);
            Acc10.afegirAllotjament(ALL2);
            Acc11.afegirAllotjament(ALL6);
            Acc12.afegirAllotjament(ALL6);

        } catch (ExcepcioCamping e) {
            System.out.println("Hi ha hagut algun error");
        }
    }

    /**
     * mètode que retorna la temporada d'una reserva
     *
     * @param data la data del primer dia de la reserva
     * @return la temporada en la qual cau la reserva
     */
    public static InAllotjament.Temp getTemporada(LocalDate data) {
        int dia = data.getDayOfMonth(); //obtenim el dia
        int mes = data.getMonthValue(); //obtenim el mes
        //Mirem segons el primer dia de la reserva
        if (4 <= mes && mes <= 8)
            return InAllotjament.Temp.values()[0]; //Si cau entre abril i juliol es alta (posicio 0 a l'enum Temp
        else if (mes == 3 && dia >= 21) return InAllotjament.Temp.values()[0]; //Si cau a finals de març
        else if (mes == 9 && dia <= 20) return InAllotjament.Temp.values()[0]; //Si cau a principis de setembre
        else return InAllotjament.Temp.values()[1]; //Si no, retorna la posicio 1 de l'enum (baixa)
    }
}

