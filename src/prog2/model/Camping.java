package prog2.model;

import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Implementació de camping
 * @author FrexasLautaro
 * @author TubertGuillem
 */

public class Camping implements InCamping{

    private String nom;
    //Creem ArrayLists de cada tipus
    private ArrayList<Allotjament> llistaAllotjaments = new ArrayList<Allotjament>();
    private ArrayList<Client> llistaClients = new ArrayList<Client>();
    private LlistaReserves llistaReserves = new LlistaReserves();

    /**
     * Constructor de la classe camping
     * @param nom nom del camping
    * */
    public Camping(String nom){
        this.nom = nom;
    }

    /**
     * metode getter del nom
     * @return nom del camping
     */
    public String getNom(){
        return nom;
    }

    /**
     * metode que retorna la llista de reserves
     * @return la llista de reserves
     */
    public LlistaReserves getLlistaReserves(){
        return llistaReserves;
    }

    /**
     * metode que retorno la llista d'allotjaments
     * @return l'arraylist dels allotjaments
     */
    public ArrayList<Allotjament> getLlistaAllotjaments(){
        return llistaAllotjaments;
    }

    /**
     * metode que retorno la llista de clients
     * @return l'arraylist de clients
     */
    public ArrayList<Client> getLlistaClients(){
        return llistaClients;
    }

    /**
     * metode que retorna el nombre d'allotjaments
     * @return el nombre total d'allotjaments
     */
    public int getNumAllotjaments(){
        return getLlistaAllotjaments().size();
    }

    /**
     * metode que retorrna el nombre de reserves
     * @return el nombre total de reserves
     */
    public int getNumReserves(){
        return llistaReserves.getNumReserves();
    }

    /**
     * metode que retorna el nombre de clients
     * @return el nombre total de clients
     */
    public int getNumClients(){
        return getLlistaClients().size();
    }

    /**
     * Metode que afegeix un client now a la llista de clients
     * @param nom_ el nom del nou client.
     * @param dni_ el DNI del nou client.
     * @throws ExcepcioReserva si el dni no te 9 xifres
     */
    public void afegirClient(String nom_, String dni_) throws ExcepcioReserva{

        Client client = new Client(nom_, dni_); //Creem un client nou i l'afegim a la llista, igual per als altres metodes afegirX
        llistaClients.add(client);
    };

    /**
     * Metode que afegeix una nova parcela (allotjament) a la llista de parceles
     * @param nom_ el nom de la parcela.
     * @param idAllotjament_ l'identificador únic de l'allotjament.
     * @param metres la mida de la parcela.
     * @param connexioElectrica true si disposa de connexió elèctrica, false altrament.
     */
    public void afegirParcela(String nom_, String idAllotjament_, float metres, boolean connexioElectrica){
        Parcela parcela = new Parcela(nom_, idAllotjament_, metres, connexioElectrica);
        llistaAllotjaments.add(parcela);
    }

    /**
     * Metode que afegeix un nou bungalow a la llista d'allotjaments
     * @param nom_ el nom del bungalow.
     * @param idAllotjament_ l'identificador únic de l'allotjament.
     * @param mida la mida del bungalow.
     * @param habitacions el nombre d'habitacions del bungalow.
     * @param placesPersones el nombre màxim de places per a persones.
     * @param placesParquing el nombre de places de pàrquing disponibles.
     * @param terrassa true si disposa de terrassa, false altrament.
     * @param tv true si disposa de televisió, false altrament.
     * @param aireFred true si disposa d'aire condicionat, false altrament.
     */
    public void afegirBungalow(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                        int placesParquing, boolean terrassa, boolean tv, boolean aireFred){
        Bungalow bungalow = new Bungalow(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        llistaAllotjaments.add(bungalow);
    }

    /**
     *
     * Metode que afegeix un nou bungalow premium a la llista d'allotjaments
     * @param serveisExtra true si ofereix serveis extra.
     * @param codiWifi el codi de la xarxa Wi-Fi.
     * (Altres paràmetres igual que `afegirBungalow`)
     */
    public void afegirBungalowPremium(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                               int placesParquing, boolean terrassa, boolean tv, boolean aireFred,
                               boolean serveisExtra, String codiWifi){
        BungalowPremium bungalowPremium = new BungalowPremium(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);
        llistaAllotjaments.add(bungalowPremium);
    }

    /**
     * Metode que afegeix un glamping nou a la llista d'allotjaments
     * @param material el material del que està fet.
     * @param casaMascota true si accepta mascotes.
     * (Altres paràmetres igual que `afegirBungalow`)
     */
    public void afegirGlamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                        String material, boolean casaMascota){
        Glamping glamping = new Glamping(nom_, idAllotjament_, mida, habitacions, placesPersones, material, casaMascota);
        llistaAllotjaments.add(glamping);
    }

    /**
     * Metode que afegeix un mobil home nou a la llista d'allotjaments
     * @param terrassaBarbacoa true si disposa de terrassa amb barbacoa.
     * (Altres paràmetres igual que `afegirBungalow`)
     */
    public void afegirMobilHome(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones,
                         boolean terrassaBarbacoa){
        MobilHome mobilHome = new MobilHome(nom_, idAllotjament_, mida, habitacions, placesPersones, terrassaBarbacoa);
        llistaAllotjaments.add(mobilHome);
    }

    /**
     * Metode que afegeix una reserva nova a a la llista de reserves
     * @param id_ l'identificador de l'allotjament.
     * @param dni_ el DNI del client que fa la reserva.
     * @param dataEntrada la data d'entrada.
     * @param dataSortida la data de sortida.
     * @throws ExcepcioReserva  si les dates d'entrada i sortida son incoherents, si l'allotjament no esta disponible, si la reserva es massa curta o si no es troben en client o l'allotjament
     */
    public void afegirReserva(String id_, String dni_, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva{
            Allotjament allotjament = buscarAllotjament(id_); //Mirem busquem l'allotjament i el client a les seves llistes corresponents
            Client client = buscarClient(dni_);

            llistaReserves.afegirReserva(allotjament, client, dataEntrada, dataSortida);

    }

    /**
     * Metode que calcula la mida de totes les parceles juntes
     * @return la mida total de totes les parceles
     */
    public float calculMidaTotalParceles(){
        float midaTotal = 0.0f;
        for (Allotjament allotjament: llistaAllotjaments){
            if (allotjament instanceof Parcela) //Revisem si aquest allotjament es una Parcela abans de fer servir un metode propi de la classe
                midaTotal += ((Parcela) allotjament).getMida(); //Sumem la mida al total
        }
        return midaTotal;
    }

    /**
     * metode que retorna la quantitat d'allotjaments operatius
     * @return el nombre total d'allotjaments operatius
     */
    public int calculAllotjamentsOperatius(){
        int allotjamentsOperatius = 0;
        for (Allotjament allotjament: llistaAllotjaments){
            if (allotjament.correcteFuncionament()) allotjamentsOperatius += 1; //Sumem cada allotjament que funciona be
        }
        return allotjamentsOperatius;
    }

    /**
     * Metode que busca l'estada minima mes curta
     * @return l'allotjament amb l'estada mes curta
     */
    public Allotjament getAllotjamentEstadaMesCurta(){
        Allotjament mesCurt = llistaAllotjaments.get(0); //Comparem el els valors, i veiem quin es mes baix

        for (Allotjament allotjament: llistaAllotjaments){
            if (allotjament.getEstadaMinima(InAllotjament.Temp.BAIXA) < mesCurt.getEstadaMinima(InAllotjament.Temp.BAIXA))
            //si el nou allotjament te una estada minima mes peitita que el "record" actual
                mesCurt = allotjament;
        }

        return mesCurt;
    }

    /**
     * mètode que retorna la temporada d'una reserva
     * @param data la data del primer dia de la reserva
     * @return la temporada en la qual cau la reserva
     */
    public static InAllotjament.Temp getTemporada(LocalDate data){
        int dia = data.getDayOfMonth(); //obtenim el dia
        int mes = data.getMonthValue(); //obtenim el mes
        //Mirem segons el primer dia de la reserva
        if (4 <= mes && mes <= 8) return InAllotjament.Temp.values()[0]; //Si cau entre abril i juliol es alta (posicio 0 a l'enum Temp
        else if (mes == 3 && dia >= 21) return InAllotjament.Temp.values()[0]; //Si cau a finals de març
        else if (mes == 9 && dia <= 20) return InAllotjament.Temp.values()[0]; //Si cau a principis de setembre
        else return InAllotjament.Temp.values()[1]; //Si no, retorna la posicio 1 de l'enum (baixa)
    }

    /**
     * Metode que busca l'allotjament amb l'id corresponent
     * @param id Identificador unic de l'allotjament
     * @return l'allotjament amb l'id corresponent
     * @throws ExcepcioReserva si l'id de l'allotjament és no existeix a la llista
     */
    public Allotjament buscarAllotjament(String id) throws ExcepcioReserva{
        for(Allotjament allotjament: llistaAllotjaments){ //Ciclem pels allotjaments
            if (allotjament.getId().equals(id)) return allotjament;
        }
        throw new ExcepcioReserva ("Aquest ID d'allotjament es invàlid"); //Si no es troba
    }

    /**
     * Metode que busca el client amb el dni corresponent
     * @param dni El dni del client
     * @return el client amb el dni corresponent
     * @throws ExcepcioReserva Si el dni no es a la llista de clients
     */
    public Client buscarClient(String dni) throws ExcepcioReserva{
        for(Client client: llistaClients){ //Ciclem pels clients
            if (client.getDni().equals(dni)) return client;
        }
        throw new ExcepcioReserva("Aquest DNI no és valid"); //Si no es troba
    }
}
