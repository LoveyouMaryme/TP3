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

    private static final String NB_VEHICULES_DISPONIBLES = "Nombre de véhicules disponibles dans l'inventaire";
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

    public static final String NOM_ENTREPRISE = "Roulons des véhicules verts (RVV)";
    public static final String ADRESSE_ENTREPRISE = "1500 rue Matata, Hakuna, Québec Y0Z 6Y7";
    public static final String TELEPHONE_ENTREPRISE = "(438) 222-1111";

    /**
     * Lire les données des différents véhicules disponibles dans le fichier
     * InventaireVehicules.csv. Chaque ligne est composée :
     * - Type du véhicule
     * - Grandeur du véhicule
     * - Prix de la location du véhicule par jour
     * - Prix de l'assurance du véhicule par jour
     * - Nombre de véhicules disponibles
     * <p>
     * La première ligne dans ce fichier est la description des autres lignes et
     * elle doit être ignorée lors de la lecture. Les autres lignes de ce fichier
     * sont composées des données ci-dessus mentionnées séparées entre elles par
     * des points-virgules. Voir le fichier InventaireVehicules.csv pour plus de
     * détails.
     * <p>
     * Chacune de ces lignes doit être lue et découpée pour créer un objet de type
     * VehiculeDisponible, et cet objet doit être ajouté dans le tableau des véhicules
     * disponibles.
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
                    String prixAssuranceParJourString = line.substring(11, 15);
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
     * Obtenir le prix de la location du véhicule par jour. Cette méthode doit trouver
     * le véhicule dans le tableau des véhicules disponibles (lesVehiculesDipsonibles)
     * dont le type et la grandeur sont les mêmes que le type et de la grandeur du véhicule
     * passés en paramètres, ensuite elle doit retourner le prix de la location du véhicule
     * par jour.
     *
     * @param typeVehicule     le type du véhicule
     * @param grandeurVehicule la grandeur du véhicule
     * @return le prix de la location du véhicule par jour ou 0 si aucun véhicule trouvé
     */
    public static float obtenirPrixLocationVehParJour(char typeVehicule, char grandeurVehicule) {

        float prixLocationVehParJour = 0.0f;

        for (int i = 0; i < lesVehiculesDipsonibles.length; i++) {

            // C'est la même chose ici que la
            VehiculeDisponible courantVehiculeDisponible = lesVehiculesDipsonibles[i];
            Vehicule courantVehicule = courantVehiculeDisponible.getVehiculeDisponible();
            int nbrVehiculeDisponible = courantVehiculeDisponible.getNbrVehiculeDisponible();

            if (typeVehicule == courantVehicule.getType()
                    && grandeurVehicule == courantVehicule.getGrandeur()
                    && nbrVehiculeDisponible > 0) {

                prixLocationVehParJour = courantVehicule.getPrixLocationJour();
            }

        }

        return prixLocationVehParJour;
    }

    /**
     * Obtenir le prix de l'assurance du véhicule par jour. Cette méthode doit trouver
     * le véhicule dans le tableau des véhicules disponibles (lesVehiculesDipsonibles)
     * dont le type et la grandeur sont les mémes que le type et de la grandeur du véhicule
     * passés en paramètres, ensuite elle doit retourner le prix de l'assurance du véhicule
     * par jour. Si le paramètre "AssuranceEstZero" est true, le prix de l'assurance doit être
     * 0, sinon la méthode retourne le prix de l'assurance trouvé dans le tableau des véhicules
     * disponibles
     *
     * @param typeVehicule     le type du véhicule
     * @param grandeurVehicule la grandeur du véhicule
     * @param assuranceEstZero un indicateur pour savoir s'il faut calculer l'assurance ou la mettre
     *                         à 0 ou non
     * @return le prix de l'assurance du véhicule par jour ou 0 si aucun véhicule trouvé
     */
    public static float obtenirPrixAssuranceVehParJour(char typeVehicule, char grandeurVehicule,
                                                       boolean assuranceEstZero) {

        float prixAssuranceVehParJour = 0.0f;

        if (!assuranceEstZero) {

            for (int i = 0; i < lesVehiculesDipsonibles.length; i++) {

                VehiculeDisponible courantVehiculeDisponible = lesVehiculesDipsonibles[i];
                Vehicule courantVehicule = courantVehiculeDisponible.getVehiculeDisponible();

                int nbrVehiculeDisponible = courantVehiculeDisponible.getNbrVehiculeDisponible();

                if (typeVehicule == courantVehicule.getType()
                        && grandeurVehicule == courantVehicule.getGrandeur()
                        && nbrVehiculeDisponible > 0) {

                    prixAssuranceVehParJour = courantVehicule.getPrixAssuranceJour();
                }

            }

        }

        return prixAssuranceVehParJour;
    }

    /**
     * Diminuer le nombre de véhicules disponibles dans le tableau des véhicules disponibles.
     * <p>
     * La méthode doit trouver le véhicule dans le tableau des véhicules disponibles dont
     * le type et la grandeur sont les mêmes que le type et la grandeur passés en paramètres,
     * ensuite elle fait le nombre de véhicules disponibles moins le nombre de véhicules loués.
     * <p>
     * Elle retourne vrai si la diminution a été effectuée avec succès, sinon faux.
     *
     * @param typeVehicule     le type du véhicule
     * @param grandeurVehicule la grandeur du véhicule
     * @param nbVehiculesLoues le nombre de véhicules loués
     * @return vrai si la diminution est faite, sinon faux
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
     * Obtenir le nombre de véhicules disponibles. Cette méthode doit trouver le véhicule
     * dans le tableau des véhicules disponibles (lesVehiculesDipsonibles) dont le type et
     * la grandeur sont les mêmes que le type et de la grandeur du véhicule passés en
     * paramètres. Ensuite elle doit retourner le nombre de véhciules disponibles.
     *
     * @param typeVehicule     le type du véhicule
     * @param grandeurVehicule la grandeur du véhicule
     * @return le nombre de véhicules disponibles ou 0 si aucun véhicule trouvé
     */
    public static int obtenirNbVehiculesDisponibles(char typeVehicule, char grandeurVehicule) {


        int nbrVehiculesDisponbles = 0;

        for (int i = 0; i < lesVehiculesDipsonibles.length; i++) {

            VehiculeDisponible courantVehiculeDisponible = lesVehiculesDipsonibles[i];
            Vehicule courantVehicule = courantVehiculeDisponible.getVehiculeDisponible();


            if (typeVehicule == courantVehicule.getType()
                    && grandeurVehicule == courantVehicule.getGrandeur()) {

                nbrVehiculesDisponbles = courantVehiculeDisponible.getNbrVehiculeDisponible();

            }

        }

        return nbrVehiculesDisponbles;
    }

    /**
     * Vérifier la disponibilité des véhicules disponibles (lesVehiculesDipsonibles).
     * <p>
     * La méthode doit trouver le véhicule dans le tableau des véhicules disponibles
     * (lesVehiculesDipsonibles) dont le type et la grandeur sont les mêmes que le type
     * et de la grandeur du véhicule passés en paramètres. Ensuite elle doit retourner
     * vrai si le nombre de véhicules loués passé en paramètre (nbVehciculesLoues) est
     * inférieur ou égal au nombre de véhicules disponibles, sinon faux.
     *
     * @param typeVehicule      le type du véhicule
     * @param grandeurVehicule  la grandeur du véhicule
     * @param nbVehciculesLoues le nombre de véhicules dont la disponibilité doit être vérifiée
     * @return vrai si le nombre de véhicules passé en paramètre est inférieur ou égal au
     * nombre de véhicules disponibles, sinon faux.
     */
    public static boolean estDisponible(char typeVehicule,
                                        char grandeurVehicule, int nbVehciculesLoues) {

        boolean vehiculeEstDisponible = false;

        for (int i = 0; i < lesVehiculesDipsonibles.length; i++) {

            VehiculeDisponible courantVehiculeDisponible = lesVehiculesDipsonibles[i];
            Vehicule courantVehicule = courantVehiculeDisponible.getVehiculeDisponible();


            if (typeVehicule == courantVehicule.getType()
                    && grandeurVehicule == courantVehicule.getGrandeur()
                    && nbVehciculesLoues <= courantVehiculeDisponible.getNbrVehiculeDisponible()) {

                vehiculeEstDisponible = true;

            }

        }

        return vehiculeEstDisponible;
    }


    /**
     * Afficher les différents véhicules disponibles dans le tableau des véhicules disponibles.
     * Pour plus de détails sur l'affichage, voir les exemples de la trace d'exécution du
     * programme fournis avec l'énoncé du Travail pratique 3."
     */
    public static void afficher() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        System.out.println(BORDURE);
        System.out.println(NOM_ENTREPRISE);
        System.out.printf("%-30s%s%n", "Adresse :", ADRESSE_ENTREPRISE);
        System.out.printf("%-30s%s%n", "Téléphone :", TELEPHONE_ENTREPRISE);
        System.out.printf("%-30s%s%n", "Date et Heure :", now.format(formatter));
        System.out.println(BORDURE);
        System.out.println();

        System.out.println(NB_VEHICULES_DISPONIBLES);
        System.out.println(DECORATEUR);
        System.out.printf("%-15s%-15s%-15s%n", GRANDEUR, HYBRIDE, ELECTRIQUE);
        System.out.println(DECORATEUR);
        System.out.printf("%-17s%-17s%-17s%n", PETIT, obtenirNbVehiculesDisponibles(H, P), obtenirNbVehiculesDisponibles(E, P));
        System.out.printf("%-17s%-17s%-17s%n", INTERMEDIAIRE, obtenirNbVehiculesDisponibles(H, I), obtenirNbVehiculesDisponibles(E, I));
        System.out.printf("%-17s%-17s%-17s%n", GRAND, obtenirNbVehiculesDisponibles(H, G), obtenirNbVehiculesDisponibles(E, G));
        System.out.println();
        System.out.println(BORDURE);
    }

}
