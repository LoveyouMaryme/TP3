import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Formatter;

/**
 * Université du Québec à Montréal (UQAM)
 * INF1120 - 010 - Hiver 2025
 * Travail pratique 3
 *
 * Classe ApplicationPrincipale contient les méthodes d'affichage de menus, de saisies et de
 * validations. Également elle contient la méthode "main". Cette classe permet de tester toutes
 * les autres classes en créant des objets et en appelant leurs méthodes lors de l'application
 * des règles d'affaires liées aux différentes options du menu principal.
 *
 * @author Love-Mary Victor, Sami Lies Mouzai
 * @since 31 mars 2025
 *
 */

public class ApplicationPrincipale {

    public static final String MSG_ANNULATION = "\nLa location des véhicules de type %c et de grandeur %c est annulée...\n";

    // TOUTES LES CONSTANTES SONT DISTRIBUÉES DANS LES DIFFÉRENTES
    // CLASSES. ICI JE VEUX JUSTE VOIR LES CONSTANTES SUIVANTES :
    //  - LES VALEURS ENTIÈRES POUR VALIDER LE CHOIX DU MENU.
    //  - LES VALEURS ENTIÈRES POUR VALIDER LA SAISIE DU NOM, DU PRÉNOM, DU NUMÉRO DE TÉLÉPHONE DU LOCATAIRE .
    //  - LES VALEURS ENTIÈRES POUR VALIDER LA SAISIE DU NOMBRE DE JOURS DE LOCATION ET DU NOMBRE DE VÉHICULES À LOUER.


    // Il nous manque du nombre de véhicule à louer, validation pour nom et prenom


    public static final String FORMAT_TELEPHONE = "\\([0-9]{3}\\) [0-9]{3}-[0-9]{4}";
    public static final int MAXJOURSLOCATION = 30;
    public static final int MINJOURSLOCATION = 0;
    public static final String CHOIX_UN = "1. Facturer la location d'un véhicule";
    public static final String CHOIX_DEUX = "2. Afficher le nombre de véhicules hybrides et électriques loués";
    public static final String CHOIX_TROIS = "3. Afficher l'inventaire des véhicules";
    public static final String CHOIX_QUATRE = "4. Afficher toutes les factures";
    public static final String CHOIX_CINQ = "5. Quitter le programme";


    // Ceux qu'on a rajouté : should we not??

    public static final String FORMAT_PERMIS = "[A-Za-z]{1}[0-9]{4}-[0-9]{6}-[0-9]{2}";
    public static final String ENCADRE_TITRE = "---------------------------------------------------------------------------------";
    public static final String MESSAGE_BIENVENUE = "Bienvenue dans le système de facturation de Roulons des véhicules verts (RVV)";
    public static final String MESSAGE_MENU_CHOIX = "*** Menu de choix ***";



    public static final String MESSAGE_NOMBRE_VEHICULE_INVENTAIRE = "Nombre de véhicules disponibles dans l'inventaire";
    public static final String MESSAGE_NOMBRE_VEHICULE_LOUEE = "Nombre de véhicules loués par type et par grandeur";
    public static final String MESSAGE_REAFFICHER_MENU = "Appuyer sur <ENTREE> pour réafficher le menu...";

    public static final char OUI = 'O';
    public static final char NON = 'N';


    /****************************************************************************************************
     AJOUTEZ TOUTES VOS MÉTHODES "public" et "static" SUIVANTES DÉFINIES DANS LE TRAVAIL PRATIQUE 2.
     1)  Affichage du message de bienvenue    --
     2)  Saisie et validation de l’option choisie par l’utilisateur    --
     3)  Saisie et validation du prénom du locataire     --
     4)  Saisie et validation du nom du locataire    --
     5)  Saisie et validation du numéro de téléphone du locataire    --
     6)  Saisie et validation du numéro de permis de conduire    --
     7)  Saisie et validation du type de véhicule    --
     8)  Saisie et validation de la grandeur du véhicule     --
     9)  Saisie et validation du nombre de jours de location    --
     10) Saisie et validation du mode de paiement    --
     11) Saisie et validation du type de la carte de crédit    --
     12) Saisie et validation du numéro de la carte de crédit    --
     13) Saisie et validation de la réponse de la question si le locataire veut une assurance--
     14) Saisie et validation du nombre de véhicules loués
     15) Saisie et validation de la réponse de la question si le locataire veut louer un autre
     type et une autre grandeur de véhicule
     16) Demander à l’utilisateur d’appuyer sur <ENTRÉE> pour réafficher le menu principal
     *********************************************************************************************************/


    /**
     * Affiche un message de bienvenue pour l'entreprise Roulons les Véhicules Verts (RVV) (1)
     */
    public static void afficherMessageBievenue() {
        System.out.println(ENCADRE_TITRE);
        System.out.println(MESSAGE_BIENVENUE);
        System.out.println(ENCADRE_TITRE);
    }

    /**
     * Affiche les quatre options du menu principal de l'application.
     */
    private static void afficherOptionsMenu() {

        System.out.println();
        System.out.println();
        System.out.println(MESSAGE_MENU_CHOIX);
        System.out.printf("%s\n%s\n%s\n%s\n%s\n",
                CHOIX_UN,
                CHOIX_DEUX,
                CHOIX_TROIS,
                CHOIX_QUATRE,
                CHOIX_CINQ);
        System.out.println();
        System.out.println();
    }

    /**
     * Demande à l'utilisateur de saisir un choix valide pour le menu.
     * Si l'utilisateur saisit un choix invalide, un message d'erreur est affiché
     * et les options sont de nouveau présentées.
     *
     * @return Le choix valide de l'utilisateur (entre 1 et 5).
     */

    public static byte lireChoixMenu() {

        byte choixUtilisateur;
        do {
            System.out.print("Entrez votre choix : ");
            try {
                choixUtilisateur = Clavier.lireByteLn();
            } catch (NumberFormatException e) {
                choixUtilisateur = -1;
            }


            if (choixUtilisateur < 1 | choixUtilisateur > 5) {

                System.out.println();
                System.out.println("L’option choisie est invalide!");
                afficherOptionsMenu();
            }

        } while (choixUtilisateur < 1 | choixUtilisateur > 5);

        System.out.println();
        return choixUtilisateur;
    }

    /**
     * Affiche l'en-tête contenant les informations de l'entreprise,
     * incluant le nom, l'adresse, le téléphone et la date/heure actuelle.
     */
    public static void afficherEnteteEntreprise() {
        afficherEnteteEntreprise(-1);
    }

    /**
     * Affiche l'en-tête contenant les informations de l'entreprise,
     * incluant optionnellement le numéro de facture.
     *
     * @param noFacture le numéro de la facture à afficher. Si inférieur ou égal à 0, il ne sera pas affiché.
     */
    public static void afficherEnteteEntreprise(int noFacture) {

        System.out.println(ENCADRE_TITRE);
        System.out.println(Facture.NOM_ENTREPRISE);
        System.out.printf("%-35s%s%n", "Adresse : ", Facture.ADRESSE_ENTREPRISE);
        System.out.printf("%-35s%s%n", "Téléphone : ", Facture.TELEPHONE_ENTREPRISE);
        System.out.printf("%-35s%s%n", "Date et Heure : ", DateFormat.getDateInstance().format(Facture.FORMATTER));
        if (noFacture > 0){
            System.out.printf("%-35s%s%n", "Facture No : ", noFacture);
        }
        System.out.println(ENCADRE_TITRE);

    }

    /**
     * Affiche l'en-tête d'une table contenant l'inventaire des véhicules.
     *
     * @param disponible Détermine si l'affichage concerne les véhicules disponibles (true)
     *                   ou les véhicules loués (false).
     */
    private static void afficherEnteteInventaire(boolean disponible) {

        System.out.println(ENCADRE_TITRE);
        if (disponible) {
            System.out.println("\n" + MESSAGE_NOMBRE_VEHICULE_INVENTAIRE);
        } else {
            System.out.println("\n" + MESSAGE_NOMBRE_VEHICULE_LOUEE);
        }
        System.out.println("*************************************************");
        System.out.println("Grandeur          Hybride      Électrique");
        System.out.println("****************************************");
    }

    /**
     * Demande le prénom du locataire à l'utilisateur.
     * <p>
     * Si le prénom ne respecte pas les conditions (entre 2 et 30 caractères inclus),
     * un message d'erreur est affiché et la saisie est redemandée. (3)
     *
     * @return Le prénom valide saisi par l'utilisateur.
     */

    public static String lirePrenomUtilisateur() {
        String prenomLocataire;
        boolean estPrenomValide = false;

        do {
            System.out.print("Entrez le prénom du locataire (entre 2 et 30 caractères inclusivement): ");
            prenomLocataire = Clavier.lireString().trim();

            if (prenomLocataire.length() < 2 || prenomLocataire.length() > 30) {
                System.out.println();
                System.out.println("Le prénom est invalide!");
            } else {
                estPrenomValide = true;
            }

            System.out.println();

        } while (!estPrenomValide);
        return prenomLocataire;
    }

    /**
     * Demande le nom du locataire à l'utilisateur.
     * <p>
     * Si le nom ne respecte pas les conditions (entre 2 et 30 caractères inclus),
     * un message d'erreur est affiché et la saisie est redemandée. (4)
     *
     * @return Le nom valide saisi par l'utilisateur.
     */
    public static String lireNomLocataire() {
        String nomLocataire;
        boolean estNomValide = false;

        do {
            System.out.print("Entrez le nom du locataire (entre 2 et 30 caractères inclusivement):");
            nomLocataire = Clavier.lireString().trim();

            if (nomLocataire.length() < 2 || nomLocataire.length() > 30) {
                System.out.println();
                System.out.println("Le nom est invalide!");
            } else {
                estNomValide = true;
            }

            System.out.println();

        } while (!estNomValide);

        return nomLocataire;
    }

    /**
     * Demande le téléphone du locataire à l'utilisateur.
     * <p>
     * Si le téléphone ne respecte pas le format spécifié : (NNN) NNN-NNNN ,
     * un message d'erreur est affiché et la saisie est redemandée. (5)
     *
     * @return Le téléphone valide saisi par l'utilisateur.
     */
    public static String lireTelephone() {
        String telephone;
        boolean estTelephoneValide = false;

        do {
            System.out.print("Entrez le numéro de téléphone du locataire (Exemple : (514) 784-6589):");
            telephone = Clavier.lireString().trim();


            if (telephone.matches(FORMAT_TELEPHONE)) {
                estTelephoneValide = true;
            } else {
                System.out.println();
                System.out.println("Le numéro de téléphone est invalide!");
            }

            System.out.println();

        } while (!estTelephoneValide);
        return telephone;
    }


    /**
     * Demande le permis de conduire du locataire à l'utilisateur.
     * <p>
     * Si le permis de conduire ne respecte pas le format spécifié : ANNNN-NNNNNN-NN
     * un message d'erreur est affiché et la saisie est redemandée.
     *
     * @return Le permis de conduire valide saisi par l'utilisateur. (6)
     */
    public static String lirePermisConduire() {
        String numeroPermis;
        boolean estPermisValide = false;

        do {
            System.out.print("Entrez le numéro de permis de conduire du locataire (Exemple : D1234-567891-23): ");
            numeroPermis = Clavier.lireString().trim();

            if (numeroPermis.matches(FORMAT_PERMIS)) {
                estPermisValide = true;
            } else {
                System.out.println();
                System.out.println("Le numéro de permis de conduire est invalide!");
            }

            System.out.println();

        } while (!estPermisValide);

        return numeroPermis;
    }

    /**
     * Demande le type de véhicule choisi par l'utilisateur.
     * <p>
     * L'utilisateur doit entrer "H" (Hybride) ou "E" (Électrique), sans distinction de casse.
     * Si l'entrée est invalide, un message d'erreur est affiché et la saisie est redemandée.
     *
     * @return Le type de véhicule valide ('h' pour Hybride, 'e' pour Électrique). (7)
     */
    public static char lireTypeVehicule() {
        char choixType;
        boolean estTypeValide = false;

        do {
            System.out.println("Entrez le type du véhicule à louer");
            System.out.print("(H ou h pour Hybride, et E ou e pour Électrique) : ");
            choixType = Character.toUpperCase(Clavier.lireCharLn());


            if (choixType == Vehicule.H || choixType == Vehicule.E) {
                estTypeValide = true;
            } else {
                System.out.println();
                System.out.println("Le type de véhicule est invalide!");
            }


        } while (!estTypeValide);
        return choixType;
    }

    /**
     * Demande la grandeur de véhicule choisi par l'utilisateur.
     * L'utilisateur doit entrer "P" (Petit), "I" (Intermédiaire) ou "G" (Grand)
     * sans distinction de casse.
     * `<p>
     * Si l'entrée est invalide, un message d'erreur est affiché et la saisie est redemandée. (8)
     *
     * @return La grandeur de véhicule valide ("P" (Petit), "I" (Intermédiaire) ou "G" (Grand)).
     */
    public static char saisiGrandeurVehicule() {
        char choixGrandeur;
        boolean estGrandeurValide = false;

        do {
            System.out.println();
            System.out.println("Entrez la grandeur du véhicule à louer");
            System.out.print("(P ou p pour Petit, I ou i pour Intermédiaire, et G ou g pour Grand) :    ");
            choixGrandeur = Character.toUpperCase(Clavier.lireCharLn());

            if (choixGrandeur == Vehicule.P || choixGrandeur == Vehicule.I|| choixGrandeur == Vehicule.G) {
                estGrandeurValide = true;
            } else {
                System.out.println();
                System.out.println("La grandeur du véhicule est invalide!");
            }


        } while (!estGrandeurValide);

        System.out.println();
        return choixGrandeur;

    }

    /**
     * Demande à l'utilisateur de saisir le nombre de jours de location.
     * L'utilisateur doit entrer une valeur strictement supérieure à 0 et inférieure ou égale à 30. (9)
     * <p>
     * Si l'entrée est invalide, un message d'erreur est affiché et la saisie est redemandée.
     *
     * @return Le nombre de jours de location valide (1 à 30).
     */
    public static int lireNombreJourLocation() {
        int nombreJours;
        boolean estNbrJourValide = false;

        do {
            System.out.println("Entrez le nombre de jours de location");
            System.out.print("(supérieur à 0 et inférieur ou égal à 30) :    ");

            try {
                nombreJours = Clavier.lireInt();
            } catch (NumberFormatException e) {
                nombreJours = - 1;
            }
            System.out.println();

            if (nombreJours <= MINJOURSLOCATION || nombreJours > MAXJOURSLOCATION) {

                System.out.println("Le nombre de jours de location est invalide!");
            } else {
                estNbrJourValide = true;
            }


        } while (!estNbrJourValide);

        return nombreJours;
    }

    /**
     * Demande le mode de paiement du locataire à l'utilisateur.
     * <p>
     * L'utilisateur doit entrer "D" (Débit) ou "C" (Crédit) sans distinction de casse.
     * Un message d'erreur est affiché et la saisie est redemandée.
     *
     * @return Le mode de paiement valide saisi par l'utilisateur ("D" (Débit) ou "C" (Crédit))
     */
    public static char lireModePaiement() {
        char choixPaiement;
        boolean estModePaiementValide = false;

        do {
            System.out.println("Entrez le mode de paiement");
            System.out.print("(D ou d pour Débit, C ou c pour Crédit): ");
            choixPaiement = Character.toUpperCase(Clavier.lireCharLn());

            if (choixPaiement != Facture.D && choixPaiement != Facture.C) {
                System.out.println();
                System.out.println("Le mode de paiement est invalide!");
            } else {
                estModePaiementValide = true;
            }

            System.out.println();

        } while (!estModePaiementValide);
        return choixPaiement;
    }

    /**
     * Demande le type de carte de crédit du locataire à l'utilisateur.
     * <p>
     * L'utilisateur doit entrer "V" (Visa) ou "M" (MasterCard) sans distinction de casse
     * Un message d'erreur est affiché et la saisie est redemandée.
     *
     * @return Le type de carte de crédit valide saisi par l'utilisateur. (12)
     */
    public static char lireCarteCredit() {

        char choixCarteCredit;
        boolean estCarteCreditValide = false;

        do {
            System.out.println("Entrez le type de la carte de crédit");
            System.out.print("(V ou v pour Visa, et M ou m pour MasterCard): ");
            choixCarteCredit = Character.toUpperCase(Clavier.lireCharLn());

            if (choixCarteCredit != Facture.V && choixCarteCredit != Facture.M) {
                System.out.println();
                System.out.println("Le type de la carte de crédit est invalide!");
            } else {
                estCarteCreditValide = true;
            }

            System.out.println();

        } while (!estCarteCreditValide);
        return choixCarteCredit;
    }

    /**
     * Demande le numéro de carte de crédit du locataire à l'utilisateur.
     * <p>
     * Si le numéro de carte de crédit ne respecte pas le format spécifié : NNNN BNNN NNNN NNNN
     * Un message d'erreur est affiché et la saisie est redemandée.
     *
     * @return Le numéro de carte de crédit valide saisi par l'utilisateur. (12)
     */
    public static String saisiNumeroCarteCredit() {
        String numeroCarte;
        boolean estNumeroValide = false;

        do {
            System.out.print("Entrez le numéro de la carte de crédit (Exemple : 1234 5678 9123 4567) :");
            numeroCarte = Clavier.lireString().trim();

            if (numeroCarte.matches("[0-9]{1,4} [0-9]{1,4} [0-9]{1,4} [0-9]{1,4}")) {
                estNumeroValide = true;
            } else {
                System.out.println();
                System.out.println("Le numéro de la carte de crédit est invalide!");
            }

            System.out.println();

        } while (!estNumeroValide);
        return numeroCarte;
    }

    /**
     * Demande à l'utilisateur s'il souhaite souscrire une assurance.
     * L'utilisateur doit entrer "O" (Oui) ou "N" (Non), sans distinction de casse.
     * <p>
     * Si l'entrée est invalide, un message d'erreur est affiché et la saisie est redemandée.
     *
     * @return Le choix d'assurance valide ('o' pour Oui ou 'n' pour Non). (12)
     */
    public static char lireChoixAssurance() {
        char choixAssurance;
        boolean estChoixAssuranceValide = false;

        do {
            System.out.println("Désirez-vous prendre l'assurance");
            System.out.print("(O ou o pour Oui, N ou n pour Non) ? :    ");
            choixAssurance = Character.toUpperCase(Clavier.lireCharLn());

            if (choixAssurance != OUI && choixAssurance != NON) {
                System.out.println();
                System.out.println("La réponse est invalide!");
            } else {
                estChoixAssuranceValide = true;
            }

            System.out.println();

        } while (!estChoixAssuranceValide);
        return choixAssurance;
    }

    /**
     * Saisie et validation du nombre de véhicules loués
     *
     * @return Le nombre de véhicules loués
     */
    public static int lireNombreVehiculesLoues() {
        int nombreVehiculesLoues;
        boolean nbVehiculesEstValide = false;

        do {
            System.out.println("Entrez le nombre de véhicules à louer");
            System.out.print("(0 à 5 inclusivement) : ");

            try {
                nombreVehiculesLoues = Clavier.lireInt();
            } catch (NumberFormatException e) {
                nombreVehiculesLoues = -1;
            }

            System.out.println();

            if (nombreVehiculesLoues >= 0 && nombreVehiculesLoues <= 5) {
                nbVehiculesEstValide = true;
            } else {
                System.out.println();
                System.out.println("Le nombre de véhicules à louer est invalide!");
                System.out.println();
            }
        } while (!nbVehiculesEstValide);
        return nombreVehiculesLoues;
    }

    /**
     * Saisie et validation de la réponse de la question si le locataire veut louer un autre
     * type et une autre grandeur de véhicule
     */

    public static char lireChoixAjouterVehicule() {
        char choixAjouter;
        boolean estValide = false;

        do {
            System.out.println("Désirez-vous louer d'autres véhicules");
            System.out.print("(O ou o pour Oui, N ou n pour Non) ? : ");
            choixAjouter = Character.toUpperCase(Clavier.lireCharLn());

            if (choixAjouter == OUI || choixAjouter == NON) {
                estValide = true;
            } else {
                System.out.println();
                System.out.println("La réponse est invalide!");
            }

            System.out.println();
        } while (!estValide);
        return choixAjouter;
    }

    /**
     * Pause le déroulement du programme et attend que l'utilisateur presse la touche Entrée
     * avant de continuer et réafficher le menu.
     */
    public static void Pause() {
        System.out.println();
        System.out.println(MESSAGE_REAFFICHER_MENU);
        Clavier.lireFinLigne();
    }



    public static void main(String[] args) {

        // Déclaration des variables
        boolean sortie;
        int choixMenu;
        int nbVehiculesALouer;
        char typeVehicule;
        char grandeurVehicule;
        char reponse = ' ';
        int nbJoursLocation;
        char choixAssurance;

        Locataire locataire;
        VehiculeLoue vehiculeLoue;
        LocationVehicule locationVehicule;
        LocalDateTime dateFacture;
        Facture facture;

        boolean nbEstDisponible;

        GestionVehiculesDisponibles.lireFichierVehiculesDisponibles();

        afficherMessageBievenue();

        /***************************************************
         * Début du programme
         **************************************************/

        sortie = false;

        // Boucle principale qui s'exécute tant que le locataire n'a pas choisi l'option 4 pour quitter
        do {
            afficherOptionsMenu();
            choixMenu = lireChoixMenu();

            switch (choixMenu) {
                // Option 1. Facturer la location d'un véhicule
                case 1:

                    locationVehicule = new LocationVehicule();

                    dateFacture = LocalDateTime.now();

                    // On ajoute des véhicules à la transaction tant que le locataire souhaite continuer
                    do {

                        typeVehicule = lireTypeVehicule();

                        grandeurVehicule = saisiGrandeurVehicule();


                        //On vérifie que le locataire n'a pas déjà loué un véhicule du même type/grandeur dans la même transaction
                        if (locationVehicule.obtenirPlaceVehiculeLoue(typeVehicule, grandeurVehicule) != -1) {
                            System.out.print("Vous avez déjà loué un ou des véhicules de ce type et de cette grandeur...");
                            System.out.println();
                            System.out.println();

                        } else {
                            //on vérifie et valide qu'il y a assez de véhicules disponibles pour le locataire
                            do {
                                nbVehiculesALouer = lireNombreVehiculesLoues();
                                nbEstDisponible = GestionVehiculesDisponibles.estDisponible(typeVehicule, grandeurVehicule, nbVehiculesALouer);


                            } while (!nbEstDisponible);

                            // Si le locataire choisi 0, on annule la location pour ce type/grandeur de véhicule
                            if (nbVehiculesALouer == 0) {
                                System.out.printf(MSG_ANNULATION, typeVehicule, grandeurVehicule);
                                System.out.println();

                                //Si le locataire a donné au moins 1 véhicule de type/grandeur valide
                            } else {

                                GestionVehiculesDisponibles.diminuerNbVehiculesDisponibles(typeVehicule, grandeurVehicule, nbVehiculesALouer);

                                nbJoursLocation = lireNombreJourLocation();

                                choixAssurance = lireChoixAssurance();

                                float prixLocationParJour = GestionVehiculesDisponibles.obtenirPrixLocationVehParJour(typeVehicule, grandeurVehicule);

                                float prixAssuranceParJour = GestionVehiculesDisponibles.obtenirPrixAssuranceVehParJour(typeVehicule, grandeurVehicule, choixAssurance);


                                Vehicule vehicule = new Vehicule(typeVehicule, grandeurVehicule, prixLocationParJour, prixAssuranceParJour);

                                vehiculeLoue = new VehiculeLoue(vehicule, dateFacture.plusHours(3), nbVehiculesALouer, nbJoursLocation);

                                locationVehicule.ajouterVehicule(vehiculeLoue);

                                StatistiquesVehiculesLoues.augmenterNbVehiculesLoues(vehiculeLoue);
                            }
                        }

                        reponse = lireChoixAjouterVehicule();

                    } while (reponse == OUI);

                    //Si au moins 1 véhicule a été loué (ajouté au tableau), on prend les renseignements du locataire et crée une facture
                    if (locationVehicule.obtenirNombreVehiculeLoue() > 0) {

                        String prenom = lirePrenomUtilisateur();

                        String nom = lireNomLocataire();

                        String telephone = lireTelephone();

                        String permis = lirePermisConduire();

                        locataire = new Locataire(nom, prenom, telephone, permis);

                        locationVehicule.setLocataire(locataire);

                        char modePaiement = lireModePaiement();

                        facture = new Facture(dateFacture, locationVehicule, modePaiement);

                        // SI LE MODE DE PAIEMENT EST CRÉDIT
                        if (modePaiement == Facture.C) {

                            char typeCarteCredit = lireCarteCredit();

                            String numeroCarteCredit = saisiNumeroCarteCredit();

                            facture.setTypeCredit(typeCarteCredit);

                            facture.setNoCredit(numeroCarteCredit);
                        }

                        // On fait les calculs de montant sur la facture
                        facture.calculerSousTotal();
                        facture.calculerMontantTPS();
                        facture.calculerMontantTVQ();
                        facture.calculerMontantTotal();
                        facture.afficherFacture();

                        //La facture est complétée.
                        ListeDesFactures.ajouterFacture(facture);
                    }

                    Pause();

                    break;

                    //Option 2. Afficher le nombre de véhicules hybrides et électriques loués
                case 2:
                    // Affiche un tableau contenant tous les véhicules loués jusqu'à présent
                    StatistiquesVehiculesLoues.afficherNbVehiculesLoues();

                    Pause();

                    break;

                    //Option 3. Afficher l'inventaire des véhicules disponibles
                case 3:
                    // Affiche un tableau contenant tous les véhicules disponibles
                    GestionVehiculesDisponibles.afficher();

                    Pause();

                    break;

                    //Option 4. Afficher toutes les factures
                case 4:
                    // Déroule la liste de toutes les factures calculées jusqu'à présent
                    ListeDesFactures.afficher();

                    Pause();

                    break;

                    //Option 5. Quitter le programme
                    //Sauvegarde les factures dans un fichier Facture.csv puis ferme le programme
                case 5:

                    ListeDesFactures.ecrireFacture();

                    System.out.println("\n\n" + "Merci et à la prochaine ! ");

                    sortie = true;
            }

        } while (!sortie);

    }
}
