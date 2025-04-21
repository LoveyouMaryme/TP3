import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Université du Québec à Montréal (UQAM)
 * INF1120 - 010 - Hiver 2025
 * Travail pratique 3
 * <p>
 * GestionVehiculesDisponibles : Cette classe gère le nombre de véhicules
 * disponibles pour la location dans l'inventaire des véhicules.
 *
 * @author Love-Mary Victor, Sami Lies Mouzai
 * @since 31 mars 2025
 */
public class GestionVehiculesDisponibles {

    // Déclaration des constantes
    private static final String FIC_VEHICULES_DISPONIBLES = "InventaireVehicules.csv";
    private static VehiculeDisponible[] lesVehiculesDipsonibles = new VehiculeDisponible[6];

    private static final String MESS_NB_VEHICULES_DISPONIBLES = "Nombre de véhicules disponibles dans l'inventaire";
    private static final String GRANDEUR = "Grandeur";
    private static final String HYBRIDE = "Hybride";
    private static final char H = 'H';
    private static final String ELECTRIQUE = "Électrique";
    private static final char E = 'E';
    private static final String PETIT = "Petit";
    private static final char P = 'P';
    private static final String INTERMEDIAIRE = "Intermediaire";
    private static final char I = 'I';
    private static final String GRAND = "Grand";
    private static final char G = 'G';
    private static final String DECORATEUR = "*************************************************";
    private static final String BORDURE = "-----------------------------------------------------------";

    /**
     * Lire les données des différents véhicules disponibles dans le fichier
     * InventaireVehicules.csv et les insèrent dans le tableau {@code lesVehiculesDipsonibles}
     */
    public static void lireFichierVehiculesDisponibles() {

        FileReader fluxConnecteur;
        BufferedReader fluxTampon;
        String line;
        Vehicule autoCourante;
        char type;
        char grandeur;
        float prixLocationParJour;
        float prixAssuranceParJour;
        int nbrVoitureDisponible;


        try {
            fluxConnecteur = new FileReader(FIC_VEHICULES_DISPONIBLES);

            fluxTampon = new BufferedReader(fluxConnecteur);
            int nbrDeLigne = 0;
            while (fluxTampon.ready()) {


                line = fluxTampon.readLine();

                if (nbrDeLigne != 0) {

                    type = line.charAt(0);
                    grandeur = line.charAt(2);
                    String prixLocationParJourString = line.substring(4, 9);
                    prixLocationParJour = Float.parseFloat(prixLocationParJourString);
                    String prixAssuranceParJourString = line.substring(10, 15);
                    prixAssuranceParJour = Float.parseFloat(prixAssuranceParJourString);

                    if (line.length() != 17) {
                        String nbrVoitureDisponibleString = line.substring(16, 18);
                        nbrVoitureDisponible = Integer.parseInt(nbrVoitureDisponibleString);

                    } else {
                        String nbrVoitureDisponibleString = line.substring(16, 17);
                        nbrVoitureDisponible = Integer.parseInt(nbrVoitureDisponibleString);
                    }


                    autoCourante = new Vehicule(type, grandeur, prixLocationParJour, prixAssuranceParJour);

                    lesVehiculesDipsonibles[nbrDeLigne - 1] = new VehiculeDisponible(autoCourante, nbrVoitureDisponible);
                }

                nbrDeLigne++;


            }

            fluxTampon.close();
            fluxConnecteur.close();

        } catch (FileNotFoundException e) {
            System.out.println("Erreur : Fichier non trouvé ");
        } catch (IOException e) {
            System.out.println("Erreur d'entrée / sortie");
        }
    }

    /**
     * Retourne le prix de location par jour d'un véhicule donné selon son type et sa grandeur.
     *
     * @param typeVehicule     le type du véhicule
     * @param grandeurVehicule la grandeur du véhicule
     * @return le prix de la location du véhicule par jour ou 0 si aucun véhicule n'est trouvé
     */
    public static float obtenirPrixLocationVehParJour(char typeVehicule, char grandeurVehicule) {

        float prixLocationVehParJour = 0.0f;

        for (int i = 0; i < lesVehiculesDipsonibles.length; i++) {


            VehiculeDisponible courantVehiculeDisponible = lesVehiculesDipsonibles[i];
            Vehicule courantVehicule = courantVehiculeDisponible.getVehiculeDisponible();
            int nbrVehiculeDisponible = courantVehiculeDisponible.getNbrVehiculeDisponible();

            if (typeVehicule == courantVehicule.getType()
                    && grandeurVehicule == courantVehicule.getGrandeur()
                    && nbrVehiculeDisponible >= 0) {

                prixLocationVehParJour = courantVehicule.getPrixLocationJour();
            }

        }

        return prixLocationVehParJour;
    }

    /**
     * Retourne le prix de l'assurance par jour d'un véhicule donné selon son type et sa grandeur seulement si le locataire
     * a choisi une assurance.
     *
     * @param typeVehicule     le type du véhicule
     * @param grandeurVehicule la grandeur du véhicule
     * @param assuranceEstZero un indicateur pour savoir s'il faut calculer l'assurance ou la mettre
     *                         à 0 ou non
     * @return le prix de l'assurance du véhicule par jour ou 0 si aucun véhicule trouvé
     */
    public static float obtenirPrixAssuranceVehParJour(char typeVehicule, char grandeurVehicule,
                                                       char assuranceEstZero) {

        boolean voitureTrouve = false;
        float prixAssuranceVehParJour = 0.0f;

        if (assuranceEstZero != ApplicationPrincipale.NON) {

            for (int i = 0; i < lesVehiculesDipsonibles.length && voitureTrouve == false; i++) {

                VehiculeDisponible courantVehiculeDisponible = lesVehiculesDipsonibles[i];
                Vehicule courantVehicule = courantVehiculeDisponible.getVehiculeDisponible();

                int nbrVehiculeDisponible = courantVehiculeDisponible.getNbrVehiculeDisponible();

                if (typeVehicule == courantVehicule.getType()
                        && grandeurVehicule == courantVehicule.getGrandeur()) {
                    if (nbrVehiculeDisponible > 0) {
                        voitureTrouve = true;
                        prixAssuranceVehParJour = courantVehicule.getPrixAssuranceJour();
                    }

                }

            }

        }

        return prixAssuranceVehParJour;
    }

    /**
     * Diminue le nombre de véhicules disponibles dans le tableau des véhicules disponibles selon le type,
     * la grandeur et le nombre de véhicules.
     *
     * @param typeVehicule     le type du véhicule
     * @param grandeurVehicule la grandeur du véhicule
     * @param nbVehiculesLoues le nombre de véhicules loués
     * @return {@code true } si la diminution est faite avec succès, sinon {@code false}
     */
    public static boolean diminuerNbVehiculesDisponibles(char typeVehicule,
                                                         char grandeurVehicule, int nbVehiculesLoues) {


        boolean nbrVoitureDisponibleDiminue = false;

        for (int i = 0; i < lesVehiculesDipsonibles.length; i++) {

            VehiculeDisponible courantVehiculeDisponible = lesVehiculesDipsonibles[i];
            Vehicule courantVehicule = courantVehiculeDisponible.getVehiculeDisponible();

            int nbrVehiculeDisponible = courantVehiculeDisponible.getNbrVehiculeDisponible();

            if (typeVehicule == courantVehicule.getType()
                    && grandeurVehicule == courantVehicule.getGrandeur()
                    && nbrVehiculeDisponible > 0) {

                courantVehiculeDisponible.setNbrVehiculeDisponible(nbrVehiculeDisponible - nbVehiculesLoues);
                nbrVoitureDisponibleDiminue = true;
            }

        }

        return nbrVoitureDisponibleDiminue;
    }


    /**
     * Récupère le nombre de véhicules disponibles selon le type et la grandeur donnés.
     *
     * @param typeVehicule     le type du véhicule
     * @param grandeurVehicule la grandeur du véhicule
     * @return le nombre de véhicules disponibles ou 0 si aucun véhicule n'est trouvé
     */
    public static int obtenirNbVehiculesDisponibles(char typeVehicule, char grandeurVehicule) {


        int nbrVehiculesDisponbles = 0;
        boolean vehiculeTrouve = false;

        for (int i = 0; i < lesVehiculesDipsonibles.length && vehiculeTrouve == false; i++) {

            VehiculeDisponible courantVehiculeDisponible = lesVehiculesDipsonibles[i];
            Vehicule courantVehicule = courantVehiculeDisponible.getVehiculeDisponible();


            if (typeVehicule == courantVehicule.getType()
                    && grandeurVehicule == courantVehicule.getGrandeur()) {

                nbrVehiculesDisponbles = courantVehiculeDisponible.getNbrVehiculeDisponible();
                vehiculeTrouve = true;

            }

        }

        return nbrVehiculesDisponbles;
    }

    /**
     * Vérifie la disponibilité des véhicules pour un type, une grandeur et un nombre donnés.
     *
     * @param typeVehicule      le type du véhicule
     * @param grandeurVehicule  la grandeur du véhicule
     * @param nbVehciculesLoues le nombre de véhicules dont la disponibilité doit être vérifiée
     * @return {@code true} si le nombre de véhicules passé en paramètre est inférieur ou égal au
     * nombre de véhicules disponibles, sinon {@code false}.
     */
    public static boolean estDisponible(char typeVehicule,
                                        char grandeurVehicule, int nbVehciculesLoues) {

        boolean vehiculeTrouve = false;
        boolean vehiculeEstDisponible = false;

        for (int i = 0; i < lesVehiculesDipsonibles.length && vehiculeTrouve == false; i++) {

            VehiculeDisponible courantVehiculeDisponible = lesVehiculesDipsonibles[i];
            Vehicule courantVehicule = courantVehiculeDisponible.getVehiculeDisponible();


            if (typeVehicule == courantVehicule.getType()
                    && grandeurVehicule == courantVehicule.getGrandeur()) {

                vehiculeTrouve = true;

                if (nbVehciculesLoues <= courantVehiculeDisponible.getNbrVehiculeDisponible()) {
                    vehiculeEstDisponible = true;
                } else {
                    System.out.println();
                    System.out.printf("Le nombre de véhicules à louer (%d) est supérieur au nombre de véhicules disponibles(%d)", nbVehciculesLoues, courantVehiculeDisponible.getNbrVehiculeDisponible());
                    System.out.println();
                    System.out.println();

                }
            }
        }


        return vehiculeEstDisponible;
    }


    /**
     * Affiche un tableau contenant tous les véhicules disponibles selon leur type et grandeur.
     */
    public static void afficher() {

        ApplicationPrincipale.afficherEnteteEntreprise();
        System.out.println();

        System.out.println(MESS_NB_VEHICULES_DISPONIBLES);

        System.out.println(DECORATEUR);
        System.out.printf("%-15s%-15s%-15s%n", GRANDEUR, HYBRIDE, ELECTRIQUE);
        System.out.println(DECORATEUR);
        System.out.printf("%-17s%-17s%-17s%n", PETIT, obtenirNbVehiculesDisponibles(H, P), obtenirNbVehiculesDisponibles(E, P));
        System.out.printf("%-17s%-17s%-17s%n", INTERMEDIAIRE, obtenirNbVehiculesDisponibles(H, I), obtenirNbVehiculesDisponibles(E, I));
        System.out.printf("%-17s%-17s%-17s%n", GRAND, obtenirNbVehiculesDisponibles(H, G), obtenirNbVehiculesDisponibles(E, G));
        System.out.println();
        System.out.println(BORDURE);
        System.out.println();
    }

}
