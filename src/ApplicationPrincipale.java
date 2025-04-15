//
//
//import java.time.LocalDateTime;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//import java.time.format.DateTimeFormatter;
///**
// * Université du Québec à Montréal (UQAM)
// * INF1120 - 010 - Hiver 2025
// * Travail pratique 3
// *
// * Classe ApplicationPrincipale contient les méthodes d'affichage de menus, de saisies et de
// * validations. Également elle contient la méthode "main". Cette classe permet de tester toutes
// * les autres classes en créant des objets et en appelant leurs méthodes lors de l'application
// * des règles d'affaires liées aux différentes options du menu principal.
// *
// * @author Love-Mary Victor, Sami Lies Mouzai
// * @since 31 mars 2025
// *
// */
//
//public class ApplicationPrincipale {
//
//   public static final String MSG_ANNULATION = "\n  La location des véhicules de type %c et de grandeur %c est annulée...\n";
//
//    // TOUTES LES CONSTANTES SONT DISTRIBUÉES DANS LES DIFFÉRENTES
//    // CLASSES. ICI JE VEUX JUSTE VOIR LES CONSTANTES SUIVANTES :
//    //  - LES VALEURS ENTIÈRES POUR VALIDER LE CHOIX DU MENU.
//    //  - LES VALEURS ENTIÈRES POUR VALIDER LA SAISIE DU NOM, DU PRÉNOM, DU NUMÉRO DE TÉLÉPHONE DU LOCATAIRE .
//    //  - LES VALEURS ENTIÈRES POUR VALIDER LA SAISIE DU NOMBRE DE JOURS DE LOCATION ET DU NOMBRE DE VÉHICULES À LOUER.
//
//   public static final int NUMERO_CHOIX_MAX = 5;
//   public static final int NUMBERO_CHOIX_MIN = 1;
//   public static final int MAX_CHAR_NOM_PRENOM = 30;
//   public static final int MIN_CHAR_NOM_PRENOM = 2;
//   public static final String FORMAT_TELEPHONE = "\\([0-9]{3}\\) [0-9]{3}-[0-9]{4}";
//   public static final String FORMAT_PERMIS = "[A-Za-z]{1}[0-9]{4}-[0-9]{6}-[0-9]{2}";
//   public static final int MAXJOURSLOCATION = 30;
//   public static final int MINJOURSLOCATION = 0;
//
//
//
//    /****************************************************************************************************
//     AJOUTEZ TOUTES VOS MÉTHODES "public" et "static" SUIVANTES DÉFINIES DANS LE TRAVAIL PRATIQUE 2.
//     1)  Affichage du message de bienvenue    --
//     2)  Saisie et validation de l’option choisie par l’utilisateur    --
//     3)  Saisie et validation du prénom du locataire     --
//     4)  Saisie et validation du nom du locataire    --
//     5)  Saisie et validation du numéro de téléphone du locataire    --
//     6)  Saisie et validation du numéro de permis de conduire    --
//     7)  Saisie et validation du type de véhicule    --
//     8)  Saisie et validation de la grandeur du véhicule     --
//     9)  Saisie et validation du nombre de jours de location    --
//     10) Saisie et validation du mode de paiement    --
//     11) Saisie et validation du type de la carte de crédit    --
//     12) Saisie et validation du numéro de la carte de crédit    --
//     13) Saisie et validation de la réponse de la question si le locataire veut une assurance--
//     14) Saisie et validation du nombre de véhicules loués
//     15) Saisie et validation de la réponse de la question si le locataire veut louer un autre
//         type et une autre grandeur de véhicule
//     16) Demander à l’utilisateur d’appuyer sur <ENTRÉE> pour réafficher le menu principal
//     *********************************************************************************************************/
//
//
//   /**
//    * Affiche un message de bienvenue pour l'entreprise Roulons les Véhicules Verts (RVV) (1)
//    */
//   public static void afficherMessageBievenue() {
////      System.out.println(ENCADRE_TITRE);
////      System.out.println(MESSAGE_BIENVENUE);
////      System.out.println(ENCADRE_TITRE);
//   }
//
//   /**
//    * Affiche les quatre options du menu principal de l'application.
//    */
//   private static void afficherOptionsMenu() {
//
//      System.out.println();
//      System.out.println();
////      System.out.println(MESSAGE_MENU_CHOIX);
////      System.out.printf("%s\n%s\n%s\n%s\n", CHOIX_UN, CHOIX_DEUX, CHOIX_TROIS, CHOIX_QUATRE);
//      System.out.println();
//      System.out.println();
//
//
//   }
//
//   /**
//    * Demande à l'utilisateur de saisir un choix valide pour le menu.
//    * Si l'utilisateur saisit un choix invalide, un message d'erreur est affiché
//    * et les options sont de nouveau présentées. (2)
//    *
//    * @return Le choix valide de l'utilisateur (entre 1 et 4).
//    */
//
//   public static byte lireChoixMenu() {
//
//      byte choixUtilisateur;
//      do {
//         System.out.print("Entrez votre choix : ");
//         choixUtilisateur = Clavier.lireByteLn();
//
//
//         if (choixUtilisateur < 1 | choixUtilisateur > 4) {
//
//            System.out.println();
//            System.out.println("L’option choisie est invalide!");
//            afficherOptionsMenu();
//         }
//
//      } while (choixUtilisateur < 1 | choixUtilisateur > 4);
//
//      return choixUtilisateur;
//   }
//
//   /**
//    * Affiche l'en-tête contenant les informations de l'entreprise,
//    * incluant le nom, l'adresse, le téléphone et la date/heure actuelle.
//    */
//   private static void afficherEnteteEntreprise() {
//
//
//      LocalDateTime now = LocalDateTime.now();
////      String dateNowFormatee = now.format(FORMATTER);
////
////      System.out.println("\n" + SEPARATEUR_LIGNE);
////      System.out.println(NOM_ENTREPRISE);
////      System.out.println("Adresse :       " + ADRESSE_ENTREPRISE);
////      System.out.println("Téléphone :     " + TELEPHONE_ENTREPRISE);
////      System.out.println("Date et Heure : " + dateNowFormatee);
//
//   }
//
//   /**
//    * Affiche l'en-tête d'une table contenant l'inventaire des véhicules.
//    *
//    * @param disponible Détermine si l'affichage concerne les véhicules disponibles (true)
//    *                   ou les véhicules loués (false).
//    */
//   private static void afficherEnteteInventaire(boolean disponible) {
//
////      System.out.println(SEPARATEUR_LIGNE);
////      if (disponible) {
////         System.out.println("\n" + MESSAGE_NOMBRE_VEHICULE_INVENTAIRE);
////      } else {
////         System.out.println("\n" + MESSAGE_NOMBRE_VEHICULE_LOUEE);
////      }
//      System.out.println("*************************************************");
//      System.out.println("Grandeur          Hybride      Électrique");
//      System.out.println("****************************************");
//   }
//
//   /**
//    * Demande le prénom du locataire à l'utilisateur.
//    * <p>
//    * Si le prénom ne respecte pas les conditions (entre 2 et 30 caractères inclus),
//    * un message d'erreur est affiché et la saisie est redemandée. (3)
//    *
//    * @return Le prénom valide saisi par l'utilisateur.
//    */
//
//   public static String lirePrenomUtilisateur() {
//      String prenomLocataire;
//      boolean estPrenomValide = false;
//
//      do {
//         System.out.print("Entrez le prénom du locataire (entre 2 et 30 caractères inclusivement): ");
//         prenomLocataire = Clavier.lireString().trim();
//
//         if (prenomLocataire.length() < 2 || prenomLocataire.length() > 30) {
//            System.out.println();
//            System.out.println("Le prénom est invalide!");
//         } else {
//            estPrenomValide = true;
//         }
//
//         System.out.println();
//
//      } while (!estPrenomValide);
//      return prenomLocataire;
//   }
//
//   /**
//    * Demande le nom du locataire à l'utilisateur.
//    * <p>
//    * Si le nom ne respecte pas les conditions (entre 2 et 30 caractères inclus),
//    * un message d'erreur est affiché et la saisie est redemandée. (4)
//    *
//    * @return Le nom valide saisi par l'utilisateur.
//    */
//   public static String lireNomLocataire() {
//      String nomLocataire;
//      boolean estNomValide = false;
//
//      do {
//         System.out.print("Entrez le nom du locataire (entre 2 et 30 caractères inclusivement):");
//         nomLocataire = Clavier.lireString().trim();
//
//         if (nomLocataire.length() < 2 || nomLocataire.length() > 30) {
//            System.out.println();
//            System.out.println("Le nom est invalide!");
//         } else {
//            estNomValide = true;
//         }
//
//         System.out.println();
//
//      } while (!estNomValide);
//
//      return nomLocataire;
//   }
//
//   /**
//    * Demande le téléphone du locataire à l'utilisateur.
//    * <p>
//    * Si le téléphone ne respecte pas le format spécifié : (NNN) NNN-NNNN ,
//    * un message d'erreur est affiché et la saisie est redemandée. (5)
//    *
//    * @return Le téléphone valide saisi par l'utilisateur.
//    */
//   public static String lireTelephone() {
//      String telephone;
//      boolean estTelephoneValide = false;
//
//      do {
//         System.out.print("Entrez le numéro de téléphone du locataire (Exemple : (514) 784-6589):");
//         telephone = Clavier.lireString().trim();
//
//
//         if (telephone.matches(FORMAT_TELEPHONE)) {
//            estTelephoneValide = true;
//         } else {
//            System.out.println();
//            System.out.println("Le numéro de téléphone est invalide!");
//         }
//
//         System.out.println();
//
//      } while (!estTelephoneValide);
//      return telephone;
//   }
//
//
//   /**
//    * Demande le permis de conduire du locataire à l'utilisateur.
//    * <p>
//    * Si le permis de conduire ne respecte pas le format spécifié : ANNNN-NNNNNN-NN
//    * un message d'erreur est affiché et la saisie est redemandée.
//    *
//    * @return Le permis de conduire valide saisi par l'utilisateur. (6)
//    */
//   public static String lirePermisConduire() {
//      String numeroPermis;
//      boolean estPermisValide = false;
//
//      do {
//         System.out.print("Entrez le numéro de permis de conduire du locataire (Exemple : D1234-567891-23): ");
//         numeroPermis = Clavier.lireString().trim();
//
//         if (numeroPermis.matches(FORMAT_PERMIS)) {
//            estPermisValide = true;
//         } else {
//            System.out.println();
//            System.out.println("Le numéro de permis de conduire est invalide!");
//         }
//
//         System.out.println();
//
//      } while (!estPermisValide);
//
//      return numeroPermis;
//   }
//
//   /**
//    * Demande le type de véhicule choisi par l'utilisateur.
//    * <p>
//    * L'utilisateur doit entrer "H" (Hybride) ou "E" (Électrique), sans distinction de casse.
//    * Si l'entrée est invalide, un message d'erreur est affiché et la saisie est redemandée.
//    *
//    * @return Le type de véhicule valide ('h' pour Hybride, 'e' pour Électrique). (7)
//    */
//   public static char lireTypeVehicule() {
////      char choixType;
////      boolean estTypeValide = false;
////
//////      do {
//////         System.out.println();
//////         System.out.println("Entrez le type du véhicule à louer");
//////         System.out.print("(H ou h pour Hybride, et E ou e pour Électrique) : ");
//////         choixType = Character.toLowerCase(Clavier.lireCharLn());
//////
//////
//////         if (choixType == VEHICULE_HYBRIDE || choixType == VEHICULE_ELECTRIQUE) {
//////            estTypeValide = true;
//////         } else {
//////            System.out.println();
//////            System.out.println("Le type de véhicule est invalide!");
//////         }
////
////
//////      } while (!estTypeValide);
////      return choixType;
//   }
//
//   /**
//    * Demande la grandeur de véhicule choisi par l'utilisateur.
//    * L'utilisateur doit entrer "P" (Petit), "I" (Intermédiaire) ou "G" (Grand)
//    * sans distinction de casse.
//    * `<p>
//    * Si l'entrée est invalide, un message d'erreur est affiché et la saisie est redemandée. (8)
//    *
//    * @return La grandeur de véhicule valide ("P" (Petit), "I" (Intermédiaire) ou "G" (Grand)).
//    */
//   public static char saisiGrandeurVehicule() {
//      char choixGrandeur;
//      boolean estGrandeurValide = false;
//
////      do {
////         System.out.println();
////         System.out.println("Entrez la grandeur du véhicule à louer");
////         System.out.print("(P ou p pour Petit, I ou i pour Intermédiaire, et G ou g pour Grand) :    ");
////         choixGrandeur = Character.toLowerCase(Clavier.lireCharLn());
////
////         if (choixGrandeur == VEHICULE_PETIT || choixGrandeur == VEHICULE_INTERMEDIAIRE || choixGrandeur == VEHICULE_GRAND) {
////            estGrandeurValide = true;
////         } else {
////            System.out.println();
////            System.out.println("La grandeur du véhicule est invalide!");
////         }
////
////
////      } while (!estGrandeurValide);
////
////      System.out.println();
////      return choixGrandeur;
//
//   }
//
//   /**
//    * Demande à l'utilisateur de saisir le nombre de jours de location.
//    * L'utilisateur doit entrer une valeur strictement supérieure à 0 et inférieure ou égale à 30. (9)
//    * <p>
//    * Si l'entrée est invalide, un message d'erreur est affiché et la saisie est redemandée.
//    *
//    * @return Le nombre de jours de location valide (1 à 30).
//    */
//   public static int lireNombreJourLocation() {
//      int nombreJours;
//      boolean estNbrJourValide = false;
//
//      do {
//         System.out.println("Entrez le nombre de jours de location");
//         System.out.print("(supérieur à 0 et inférieur ou égal à 30) :    ");
//         nombreJours = Clavier.lireInt();
//
//         if (nombreJours <= MINJOURSLOCATION || nombreJours > MAXJOURSLOCATION) {
//            System.out.println();
//            System.out.println("Le nombre de jours de location est invalide!");
//         } else {
//            estNbrJourValide = true;
//         }
//         System.out.println();
//
//      } while (!estNbrJourValide);
//
//      return nombreJours;
//   }
//
//   /**
//    * Demande le mode de paiement du locataire à l'utilisateur.
//    * <p>
//    * L'utilisateur doit entrer "D" (Débit) ou "C" (Crédit) sans distinction de casse.
//    * Un message d'erreur est affiché et la saisie est redemandée.
//    *
//    * @return Le mode de paiement valide saisi par l'utilisateur ("D" (Débit) ou "C" (Crédit))
//    */
//   public static char lireModePaiement() {
//      char choixPaiement;
//      boolean estModePaiementValide = false;
//
////      do {
////         System.out.println("Entrez le mode de paiement");
////         System.out.print("(D ou d pour Débit, C ou c pour Crédit): ");
////         choixPaiement = Character.toLowerCase(Clavier.lireCharLn());
////
////         if (choixPaiement != CARTE_DEBIT && choixPaiement != CARTE_CREDIT) {
////            System.out.println();
////            System.out.println("Le mode de paiement est invalide!");
////         } else {
////            estModePaiementValide = true;
////         }
////
////         System.out.println();
////
////      } while (!estModePaiementValide);
////      return choixPaiement;
//   }
//
//   /**
//    * Demande le type de carte de crédit du locataire à l'utilisateur.
//    * <p>
//    * L'utilisateur doit entrer "V" (Visa) ou "M" (MasterCard) sans distinction de casse
//    * Un message d'erreur est affiché et la saisie est redemandée.
//    *
//    * @return Le type de carte de crédit valide saisi par l'utilisateur. (12)
//    */
//   public static char lireCarteCredit() {
//
//      char choixCarteCredit;
//      boolean estCarteCreditValide = false;
//
////      do {
////         System.out.println("Entrez le type de la carte de crédit");
////         System.out.print("(V ou v pour Visa, et M ou m pour MasterCard): ");
////         choixCarteCredit = Character.toLowerCase(Clavier.lireCharLn());
////
////         if (choixCarteCredit != VISA_CARTE_CREDIT && choixCarteCredit != MC_CARTE_CREDIT) {
////            System.out.println();
////            System.out.println("Le type de la carte de crédit est invalide!");
////         } else {
////            estCarteCreditValide = true;
////         }
////
////         System.out.println();
////
////      } while (!estCarteCreditValide);
////      return choixCarteCredit;
//   }
//
//   /**
//    * Demande le numéro de carte de crédit du locataire à l'utilisateur.
//    * <p>
//    * Si le numéro de carte de crédit ne respecte pas le format spécifié : NNNN BNNN NNNN NNNN
//    * Un message d'erreur est affiché et la saisie est redemandée.
//    *
//    * @return Le numéro de carte de crédit valide saisi par l'utilisateur. (12)
//    */
//   public static String saisiNumeroCarteCredit() {
//      String numeroCarte;
//      boolean estNumeroValide = false;
//
//      do {
//         System.out.print("Entrez le numéro de la carte de crédit (Exemple : 1234 5678 9123 4567) :");
//         numeroCarte = Clavier.lireString().trim();
//
//         if (numeroCarte.matches("[0-9]{1,4} [0-9]{1,4} [0-9]{1,4} [0-9]{1,4}")) {
//            estNumeroValide = true;
//         } else {
//            System.out.println();
//            System.out.println("Le numéro de la carte de crédit est invalide!");
//         }
//
//         System.out.println();
//
//      } while (!estNumeroValide);
//      return numeroCarte;
//   }
//
//   /**
//    * Demande à l'utilisateur s'il souhaite souscrire une assurance.
//    * L'utilisateur doit entrer "O" (Oui) ou "N" (Non), sans distinction de casse.
//    * <p>
//    * Si l'entrée est invalide, un message d'erreur est affiché et la saisie est redemandée.
//    *
//    * @return Le choix d'assurance valide ('o' pour Oui ou 'n' pour Non). (12)
//    */
//   public static char lireChoixAssurance() {
//      char choixAssurance;
//      boolean estChoixAssuranceValide = false;
//
//      do {
//         System.out.println("Désirez-vous prendre l'assurance");
//         System.out.print("(O ou o pour Oui, N ou n pour Non) ? :    ");
//         choixAssurance = Character.toLowerCase(Clavier.lireCharLn());
//
////         if (choixAssurance != ASSURANCE_OUI && choixAssurance != ASSURANCE_NON) {
////            System.out.println();
////            System.out.println("La réponse est invalide!");
////         } else {
////            estChoixAssuranceValide = true;
////         }
////
////         System.out.println();
//
//      } while (!estChoixAssuranceValide);
//      return choixAssurance;
//   }
//
//
//   public static void main(String[] args) {
//
//      // Déclaration des variables
//      boolean sortie;
//      int choixMenu;
//      int nbVehiculesALouer;
//      char typeVehicule;
//      char grandeurVehicule;
//      char reponse = ' ';
//
////      Locataire locataire;
////      VehiculeLoue vehiculeLoue;
////      LocationVehicule locationVehicule;
////      LocalDateTime dateFacture;
////      Facture facture;
//
//      // AJOUTEZ LES VARIABLES LOCALES MANQUANTES
//      // *** À COMPLÉTER
//
//      // Lire les données des véhicules disponibles dans l'inventaire
//      GestionVehiculesDisponibles.lireFichierVehiculesDisponibles();
//
//      // APPELEZ LA MÉTHODE QUI AFFICHE LE MESSAGE DE BIENVENUE
//      afficherMessageBievenue();
//
//      /***************************************************
//       * Début du programme
//       **************************************************/
//
//      sortie = false;
//
//      do {
//
//         // APPELEZ LA MÉTHODE QUI SAISIT ET VALIDE L'OPTION CHOISIE PAR L'UTILISATEUR.
//
//         choixMenu = lireChoixMenu();
//
//         switch (choixMenu) {
//
//            case 1:
//
//               // CRÉEZ UN OBJET DE TYPE LocationVehicule AVEC LE CONSTRUCTEUR SANS PARAMÈTRE
//               // *** À COMPLÉTER
//               locationVehicule = null;
//
//               // CRÉEZ LA DATE DE LA FACTURE
//               // *** À COMPLÉTER
//               dateFacture = null;
//
//               // Saisir les données
//               do {
//
//                  // APPELEZ LA MÉTHODE QUI SAISIT ET VALIDE LE TYPE DU VÉHICULE.
//                  // *** À COMPLÉTER
//                  typeVehicule = ' ';
//
//                  // APPELEZ LA MÉTHODE QUI SAISIT ET VALIDE LA GRANDEUR DU VÉHICULE.
//                  // *** À COMPLÉTER
//                  grandeurVehicule = ' ';
//
//                  if (locationVehicule.obtenirPosition(typeVehicule, grandeurVehicule) != -1) {
//                     System.out.print("\n  Vous avez déjà loué un ou des véhicules de ce type et de cette grandeur...\n");
//
//                  } else {
//
//                     // APPELEZ LA MÉTHODE QUI SAISIT ET VALIDE LE NOMBRE DE VÉHICULES À LOUER.
//                     // *** À COMPLÉTER
//                      nbVehiculesALouer = 0 ;
//
//                     if (nbVehiculesALouer == 0) {
//                        System.out.printf(MSG_ANNULATION, typeVehicule, grandeurVehicule);
//
//                     } else {
//
//                        // APPELEZ LA MÉTHODE diminuerNbVehiculesDisponibles DE LA CLASSE GestionVehiculesDisponibles
//                        // POUR DIMINUER LE NOMBRE DE VÉHICULES À LOUER DE CE TYPE ET DE CETTE GRANDEUR DANS L'INVENTAIRE
//                        // *** À COMPLÉTER
//
//                        // APPELEZ LA MÉTHODE QUI SAISIT ET VALIDE LE NOMBRE DE JOURS DE LOCATION.
//                        // *** À COMPLÉTER
//
//                        // APPELEZ LA MÉTHODE QUI SAISIT ET VALIDE LA RÉPONSE DE LA QUESTION
//                        // SI L'UTILISATEUR DÉSIRE PRENDRE UNE ASSURANCE.
//                        // *** À COMPLÉTER
//
//                        // APPELEZ LA MÉTHODE obtenirPrixLocationVehParJour DE LA CLASSE GestionVehiculesDisponibles
//                        // POUR OBTENIR LE PRIX DE LA LOCATION PAR JOUR POUR CE TYPE ET DE CETTE GRANDEUR DE VÉHICULE.
//                        // *** À COMPLÉTER
//
//                        // APPELEZ LA MÉTHODE obtenirPrixAssuranceVehParJour DE LA CLASSE GestionVehiculesDisponibles
//                        // POUR OBTENIR LE PRIX DE L'ASSURANCE PAR JOUR POUR CE TYPE ET DE CETTE GRANDEUR DE VÉHICULE.
//                        // *** À COMPLÉTER
//
//                        // CRÉEZ UN OBJET DE TYPE vehicule AVEC LES PARAMÈTRES SUIVANTS :
//                        // LE TYPE DE VÉHICULE, LA GRANDEUR DU VÉHICULE, LE PRIX DE LA LOCATION PAR JOUR,
//                        // LE PRIX DE L'ASSURANCE PAR JOUR.
//                        // *** À COMPLÉTER
//
//                        // CRÉEZ UN OBJET DE TYPE vehiculeLoue AVEC LES PARAMÈTRES SUIVANTS :
//                        // LE VÉHICULE, LA DATE DE LA FACTURE + 3 HEURES, LE NOMBRE DE VÉHICULES À LOUER,
//                        // LE NOMBRE DE JOURS DE LOCATION,
//                        // *** À COMPLÉTER
//
//                        // APPELEZ LA MÉTHODE ajouterVehiculeLoue DE L'OBJET locationVehicule
//                        // POUR AJOUTER LE VÉHICULE LOUÉ DANS LE TABLEAU DES VÉHICULES LOUÉS
//                        // *** À COMPLÉTER
//
//                        // APPELEZ LA MÉTHODE augmenterNbVehiculesLoues DE LA CLASSE StatistiquesVehiculesLoues
//                        // POUR METTRE À JOUR LE NOMBRE DE VÉHICULES LOUÉS DE CE TYPE ET DE CETTE GRANDEUR DE VÉHICULE.
//                        // *** À COMPLÉTER
//
//                    }
//                 }
//
//                 // APPELEZ LA MÉTHODE QUI SAISIT ET VALIDE LA RÉPONSE DE LA QUESTION
//                 // SI LE LOCATAIRE DÉSIRE LOUER D'AUTRES VÉHICULES.
//                 // *** À COMPLÉTER
//
//                 // TANT QUE LE LOCATAIRE DÉSIRE LOUER D'AUTRES VÉHICULES
//                 // *** À COMPLETER LA BOUCLE WHILE CI-DESSOUS
//               } while (reponse == ' ');
//
//               if (locationVehicule.obtenirNbVehicules() > 0) {
//
//                  // APPELEZ LA MÉTHODE QUI SAISIT ET VALIDE LE PRÉNOM DU LOCATAIRE.
//                  // *** À COMPLÉTER
//
//                  // APPELEZ LA MÉTHODE QUI SAISIT ET VALIDE LE NOM DU LOCATAIRE.
//                  // *** À COMPLÉTER
//
//                  // APPELEZ LA MÉTHODE QUI SAISIT ET VALIDE LE NUMÉRO DE TÉLÉPHONE DU LOCATAIRE.
//                  // *** À COMPLÉTER
//
//                  // APPELEZ LA MÉTHODE QUI SAISIT ET VALIDE LE NUMÉRO DE PERMIS DE CONDUIRE DU LOCATAIRE.
//                  // *** À COMPLÉTER
//
//                  // CRÉEZ UN OBJET DE TYPE Locataire AVEC LES PARAMÈTRES SUIVANTS :
//                  // LE NOM, LE PRÉNOM, LE NUMÉRO DE TÉLÉPHONE ET LE NUMÉRO DE PERMIS DE CONDUIRE.
//                  // *** À COMPLÉTER
//
//                  // APPELEZ LA MÉTHODE setLocataire DE L'OBJET locationVehicule
//                  // AVEC LE PARAMÈTRE LOCATAIRE POUR modifier le locataire
//                  // *** À COMPLÉTER
//
//                  // APPELEZ LA MÉTHODE QUI SAISIT ET VALIDE LE MODE DE PAIEMENT.
//                  // *** À COMPLÉTER
//
//                  // CRÉEZ UN OBJET DE TYPE Facture AVEC LES PARAMÈTRES SUIVANTS :
//                  // LA DATE DE LA FACTURE, LOCATIONVEHICULE ET LE MODE DE PAIEMENT.
//                  // *** À COMPLÉTER
//
//                  // SI LE MODE DE PAIEMENT EST CRÉDIT
//                  // *** À COMPLÉTER LE IF
//                  //if ( ) {
//
//                      // APPELEZ LA MÉTHODE QUI SAISIT ET VALIDE LE TYPE DE LA CARTE DE CRÉDIT.
//                      // *** À COMPLÉTER
//
//                      // APPELEZ LA MÉTHODE QUI SAISIT ET VALIDE LE NUMÉRO DE LA CARTE DE CRÉDIT.
//                      // *** À COMPLÉTER
//
//                      // APPELEZ LA MÉTHODE setTypeCarteCredit DE DE L'OBJET facture
//                      // POUR MODIFIER LE TYPE DE LA CARTE DE CRÉDIT.
//                      // *** À COMPLÉTER
//
//                     // APPELEZ LA MÉTHODE setNumeroCarteCredit DE DE L'OBJET facture
//                     // POUR MODIFIER LE NUMÉRO DE LA CARTE DE CRÉDIT.
//                     // *** À COMPLÉTER
//
//                  //}
//
//                  // APPELEZ LES MÉTHODES DE L'OBJET facture DANS L'ORDRE SUIVANT :
//                  //    - Calcul du sous-total de la facture
//                  //    - Calcul du montant TPS
//                  //    - Calcul du montant TVQ
//                  //    - Calcul du montant total de la facture
//                  //    - Afficher la facture
//                  // *** À COMPLÉTER
//
//                  // APPELEZ LA MÉTHODE ajouterFacture DE LA CLASSE ListeDesFactures
//                  // POUR AJOUTER LA FACTURE COURANTE (l'objet facture) DANS LE TABLEAU
//                  // DES FACTURES.
//                  // *** À COMPLÉTER
//
//               }
//
//               // VOUS DEVEZ APPELER LA MÉTHODE DE PAUSE AVANT
//               // D'AFFICHER LE MENU PRINCIPAL.
//               // *** À COMPLÉTER
//
//               break;
//
//            case 2:
//                // APPELEZ LA MÉTHODE afficherNbVehiculesLoues DE LA CLASSE StatistiquesVehiculesLoues
//                // POUR AFFICHER LE NOMBRE DE VÉHICULES LOUÉS PAR TYPE ET GRANDEUR DE VÉHICULE
//                // *** À COMPLÉTER
//
//               // VOUS DEVEZ APPELER LA MÉTHODE DE PAUSE AVANT
//               // D'AFFICHER LE MENU PRINCIPAL.
//               // *** À COMPLÉTER
//
//               break;
//
//            case 3:
//               // APPELEZ LA MÉTHODE afficher DE LA CLASSE GestionVehiculesDisponibles
//               // POUR AFFICHER LA LISTE DES VÉHICULES DISPONIBLES
//               // *** À COMPLÉTER
//
//               // VOUS DEVEZ APPELER LA MÉTHODE DE PAUSE AVANT
//               // D'AFFICHER LE MENU PRINCIPAL.
//               // *** À COMPLÉTER
//
//               break;
//
//            case 4:
//
//               // APPELEZ LA MÉTHODE afficher DE LA CLASSE ListeDesFactures
//               // POUR AFFICHER TOUTES LES FACTURES CRÉÉES
//               // *** À COMPLÉTER
//
//               // VOUS DEVEZ APPELER LA MÉTHODE DE PAUSE AVANT
//               // D'AFFICHER LE MENU PRINCIPAL.
//               // *** À COMPLÉTER
//
//               break;
//
//            case 5:
//
//
//                // APPELEZ LA MÉTHODE ecrireFacture DE LA CLASSE ListeDesFactures
//                // POUR ÉCRIRE LES DONNÉES DE TOUTES LES FACTURES DANS LE FICHIER Factures.csv.
//                // *** À COMPLÉTER
//
//                // APPELEZ LE MESSAGE DE REMERCIEMENT
//                System.out.println("\n\n  Merci et à la prochaine ! ");
//
//               sortie = true;
//
//         }
//
//      } while (!sortie);
//
//   }
//}
