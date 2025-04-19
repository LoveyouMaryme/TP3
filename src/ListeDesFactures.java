import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Université du Québec à Montréal (UQAM)
 * INF1120 - 010 - Hiver 2025
 * Travail pratique 3
 * <p>
 * ListeDesFactures : Cette classe gère toutes les factures des différentes locations de
 * véhicules.
 *
 * @author Votre prénom / votre nom
 * @since 31 mars 2025
 */
public class ListeDesFactures {

    // Déclaration des constantes
    private static final String ENTETE = "Facture No;Date et Heure;"
            + "Prénom et nom;Téléphone;Permis de conduire;"
            + "Mode de paiement;Type de la carte de crédit;"
            + "Numéro de la carte de crédit;Type du véhicule;"
            + "Grandeur du véhicule;Nombre de véhicules loués;" + "Nombre de jours de location;"
            + "Date de location;Date de retour;Prix de la location par jour;"
            + "Rabais sur le prix de location;"
            + "Prix de l'assurance par jour;Montant de la location;"
            + "Montant de l'assurance;Sous-total; Montant TPS;" + "Montant TVQ;Montant total";

    private static final String FIC_FACTURES = "Factures.csv";
    private static final int NB_MAX_FACTURES = 50;
    private static final String MSG_CONTINUER = "Appuyer sur <ENTREE> pour continuer l'affichage des factures...";

    // Déclaration des variables de classee
    private static int nbFactures = 0;
    private static Facture[] lesFactures = new Facture[NB_MAX_FACTURES];

    /**
     * Ajouter la facture à la prochaine position libre du tableau des factures (lesFactures).
     * Cette position libre doit être inférieure à la taille du tableau des factures. Le nombre
     * courant de factures doit être incrémenter.
     *
     * @param facture la facture à ajouter
     * @return vrai si la facture a été ajouté, sinon faux
     */
    public static boolean ajouterFacture(Facture facture) {

        boolean added = false;

      /* On attribue la facture au premier emplacement vide du tableau et on s'assure de n'ajouter qu'une seule facture
      à la fois avec le boolean added*/
        for (int i = 0; i < lesFactures.length; i++) {
            if (lesFactures[i] == null && added == false) {
                lesFactures[i] = facture;
                added = true;
            }
        }
        return added;
    }

    /**
     * Écrire les données de toutes les factures dans le fichier Factures.csv.
     * <p>
     * Les données de chaque ligne doivent être separées entre elles par des
     * points-virgules. Chaque facture doit être affichée sur :
     * - une seule ligne si le tableau des véhicules loués contient un seul élément.
     * - 2 lignes si le tableau des véhicules loués contient 2 éléments.
     * - Ainsi de suite.
     * <p>
     * Les nouvelles données des factures doivent remplacer les anciennes données.
     * <p>
     * Pour plus de détails, voir l'exemple de Factures.csv fourni avec l'énoncé du travail
     * pratique 3.
     */
    public static void ecrireFacture() {
        FileWriter fluxConnecteur;
        BufferedWriter fluxTampon;

        try {
            fluxConnecteur = new FileWriter(FIC_FACTURES);
            fluxTampon = new BufferedWriter(fluxConnecteur);
            //Écriture
            for (Facture ligne : lesFactures) {
                if (ligne != null) {
                    fluxTampon.write(ENTETE);
                    fluxTampon.newLine();
                    fluxTampon.write(ligne.formaterFacture());
                    fluxTampon.newLine();
                }
            }
            fluxTampon.close();
            fluxConnecteur.close();
        } catch (IOException e) {
            System.out.println("IO EXCEPTION");
        }
    }

    /**
     * La méthode doit afficher toutes les factures qui sont dans le tableau des factures.
     * Pour plus de détails sur l'affichage, voir les exemples de la trace d'exécution du
     * programme fournis avec l'énoncé du Travail pratique 3.
     */
    public static void afficher() {
        for (int i = 0; i < lesFactures.length; i++) {
            if (lesFactures[i] != null) {
                lesFactures[i].afficherFacture();
                if (lesFactures[i + 1] != null) {
                    System.out.println(MSG_CONTINUER);
                }
                Clavier.lireFinLigne();
            }
        }
    }
}
