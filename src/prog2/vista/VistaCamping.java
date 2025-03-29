package prog2.vista;
import java.util.Scanner;
import prog2.model.Camping;
import prog2.model.Menu;


public class VistaCamping {
    static private enum OpcionsMenu {MANIP_ALLOTJAMENTS, MANIP_ACCESSOS, MANIP_INCIDENCIES, GUARDAR_CAMPING, RECUPERAR_CAMPING, SORTIR_APLICACIO}
    static private enum OpcionsSubMenuAllotjaments {TOTS, OPERATIUS, NO_OPERATIUS, ENRERE}
    static private enum OpcionsSubMenuAccessos {LLISTA, NUM_ACCESSIBLES, NUM_METRES_QUADRATS, ENRERE}
    static private enum OpcionsSubMenuLlistaAccessos {OBERTS, TANCATS, ENRERE}
    static private enum OpcionsSubMenuIncidencies {INFO, AFEGIR, ELIMINAR, ENRERE}

    static private String[] llistaOpcionsMenu = {"Manipular allotjaments", "Manipular accessos", "Manipular incidencies", "Guardar càmping", "Recuperar càmping", "Sortir de l’aplicació"};
    static private String[] llistaOpcionsSubMenuAllotjaments = {"Veure tots els allotjaments", "Veure allotjaments operatius", "Veure allotjaments no operatius", "Anar enrere"};
    static private String[] llistaOpcionsSubMenuAccessos = {"Veure els accessos", "Mostrar el número total d’accessos que proporcionen accessibilitat amb cotxe", "Mostrar el número total de metres quadrats d’asfalt dels accessos asfaltats", "Anar enrere"};
    static private String[] llistaOpcionsSubMenuLlistaAccessos = {"Veure els accessos oberts", "Veure els accessos tancats", "Anar enrere"};
    static private String[] llistaOpcionsSubMenuIncidencies = {"Veure la informacio dels incidents", "Afegir un incident", "Eliminar un incident", "Anar enrere"};


    private Camping camping;

    public VistaCamping(String nomCamping) {
        camping = new Camping(nomCamping);
        camping.inicialitzaDadesCamping();
    }

    public void gestioCamping(Scanner sc) {
        String camiDesti;
        // Creem l'objecte per al menú. Li passem com a primer parà metre el nom del menú
        Menu<OpcionsMenu> menu = new Menu<OpcionsMenu>("Menu Principal", OpcionsMenu.values());

        // Assignem la descripció de les opcions
        menu.setDescripcions(llistaOpcionsMenu);

        // Obtenim una opció des del menú i fem les accions pertinents
        OpcionsMenu opcio = null;
        do {
            try {
                // Mostrem les opcions del menú
                menu.mostrarMenu();

                // Demanem una opcio
                opcio = menu.getOpcio(sc);

                // Fem les accions necessÃ ries
                switch (opcio) {
                    case MANIP_ALLOTJAMENTS:
                        // Mostrem un missatge indicant que s'ha triat aquesta opciÃ³
                        gestioCampingAllotjaments(sc);
                        break;
                    case MANIP_ACCESSOS:
                        // Mostrem un missatge indicant que s'ha triat aquesta opciÃ³
                        gestioCampingAccessos(sc);
                        break;
                    case MANIP_INCIDENCIES:
                        // Cridem el métode de gestió del menú secundari
                        gestioCampingIncidencies(sc);
                        break;
                    case GUARDAR_CAMPING:
                        System.out.println("On vols guardar les dades? ");
                        camiDesti = sc.nextLine();
                        camping.save(camiDesti);
                        break;
                    case RECUPERAR_CAMPING:
                        System.out.println("De quin fitxer vols recuperar les dades? ");
                        camiDesti = sc.nextLine();
                        camping = Camping.load(camiDesti);
                        break;
                    case SORTIR_APLICACIO:
                        System.out.println("Fins aviat!");
                        break;
                }
            } catch (ExcepcioCamping e) {
                System.out.println(e.getMessage());
            }
        } while (opcio != OpcionsMenu.SORTIR_APLICACIO);
    }

    public void gestioCampingAllotjaments(Scanner sc) throws ExcepcioCamping {
        Menu<OpcionsSubMenuAllotjaments> menuAllotjaments = new Menu<OpcionsSubMenuAllotjaments>("Manipular allotjaments", OpcionsSubMenuAllotjaments.values());
        menuAllotjaments.setDescripcions(llistaOpcionsSubMenuAllotjaments);
        OpcionsSubMenuAllotjaments opcio = null;
        do {
            menuAllotjaments.mostrarMenu();

            opcio = menuAllotjaments.getOpcio(sc);

            switch (opcio) {
                case TOTS:
                    System.out.println(camping.llistarAllotjaments("Tots"));
                    break;
                case OPERATIUS:
                    System.out.println(camping.llistarAllotjaments("operatiu"));
                    break;
                case NO_OPERATIUS:
                    System.out.println(camping.llistarAllotjaments("no operatiu"));
                    break;
                case ENRERE:
                    break;
            }

        } while (opcio != OpcionsSubMenuAllotjaments.ENRERE);

    }

    public void gestioCampingAccessos(Scanner sc) throws ExcepcioCamping {
        Menu<OpcionsSubMenuAccessos> menuAccessos = new Menu<OpcionsSubMenuAccessos>("Manipular accessos", OpcionsSubMenuAccessos.values());
        menuAccessos.setDescripcions(llistaOpcionsSubMenuAccessos);
        OpcionsSubMenuAccessos opcio = null;
        do {
            menuAccessos.mostrarMenu();

            opcio = menuAccessos.getOpcio(sc);

            switch (opcio) {
                case LLISTA:
                    gestioCampingLlistaAccessos(sc);
                    break;
                case NUM_ACCESSIBLES:
                    System.out.println("El nombre d'accessos accessibles a cotxe és: " + camping.calculaAccessosAccessibles());
                    break;
                case NUM_METRES_QUADRATS:
                    System.out.println("La suma de metres quadrats d’asfalt que tenen les carreteres asfaltades i els camins asfaltats és: " + camping.calculaMetresQuadratsAsfalt());
                    break;
                case ENRERE:
                    break;
            }

        } while (opcio != OpcionsSubMenuAccessos.ENRERE);

    }

    public void gestioCampingLlistaAccessos(Scanner sc) throws ExcepcioCamping {
        Menu<OpcionsSubMenuLlistaAccessos> menuLlistaAccessos = new Menu<OpcionsSubMenuLlistaAccessos>("Veure els accessos", OpcionsSubMenuLlistaAccessos.values());
        menuLlistaAccessos.setDescripcions(llistaOpcionsSubMenuLlistaAccessos);
        OpcionsSubMenuLlistaAccessos opcio = null;
        do {
            menuLlistaAccessos.mostrarMenu();

            opcio = menuLlistaAccessos.getOpcio(sc);

            switch (opcio) {
                case OBERTS:
                    System.out.println(camping.llistarAccessos("obert"));
                    break;
                case TANCATS:
                    System.out.println(camping.llistarAccessos("tancat"));
                case ENRERE:
                    break;
            }

        } while (opcio != OpcionsSubMenuLlistaAccessos.ENRERE);
    }

    public void gestioCampingIncidencies(Scanner sc) throws ExcepcioCamping{
        Menu<OpcionsSubMenuIncidencies> menuIncidencies = new Menu<OpcionsSubMenuIncidencies>("Manipular incidencies", OpcionsSubMenuIncidencies.values());
        menuIncidencies.setDescripcions(llistaOpcionsSubMenuIncidencies);
        OpcionsSubMenuIncidencies opcio;
        int numIncidencia;
        String tipus;
        String idAllotjament;
        String data;
        String camiDesti;
        do {
            menuIncidencies.mostrarMenu();
            opcio = menuIncidencies.getOpcio(sc);
            switch (opcio) {
                case INFO:
                    System.out.println(camping.llistarIncidencies());
                    break;
                case AFEGIR:
                    System.out.println("Introdueix el numero de la incidencia: ");
                    numIncidencia = sc.nextInt();
                    System.out.println("Introdueix el tipus d'incidencia: ");
                    tipus = sc.next();
                    System.out.println("Introdueix l'id de l'allotjament: ");
                    idAllotjament = sc.next();
                    sc.nextLine();
                    System.out.println("Introdueix la data de la incidencia: ");
                    data = sc.nextLine();

                    camping.afegirIncidencia(numIncidencia, tipus, idAllotjament, data);
                    break;
                case ELIMINAR:
                    System.out.println("Incidencies:");
                    camping.llistarIncidencies();
                    System.out.println("Quin és el nombre de la incidencia que vols eliminar?");
                    numIncidencia = sc.nextInt();
                    camping.eliminarIncidencia(numIncidencia);
                    break;
                case ENRERE:
                    break;
            }
        }while(opcio != OpcionsSubMenuIncidencies.ENRERE);
    }
}
