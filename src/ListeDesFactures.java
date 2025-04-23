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
 * @author : Love-Mary Victor (VICL12559701), Sami Lies Mouzai (MOUS27039501)
 * @version : 23 Avril, 2025
 * @github : https://github.com/LoveyouMaryme/TP3
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
    private static Facture[] lesFactures = new Facture[NB_MAX_FACTURES];

    /**
     * Ajoute la facture courante à la prochaine position libre du tableau des factures.
     *
     * @param facture la facture courante à ajouter
     * @return {@code true} si la facture a été ajoutée, {@code false} si le tableau est plein.
     */
    public static boolean ajouterFacture(Facture facture) {

        boolean estAjoutee = false;

      /* On attribue la facture au premier emplacement vide du tableau et on s'assure de n'ajouter qu'une seule facture
      à la fois avec le booléen estAjoutee*/
        for (int i = 0; i < lesFactures.length; i++) {
            if (lesFactures[i] == null && !estAjoutee) {
                lesFactures[i] = facture;
                estAjoutee = true;
            }
        }
        return estAjoutee;
    }

    /**
     * Sauvegarde toutes les factures du tableau dans un fichier Factures.csv.
     * Les anciennes données sont écrasées s'il y a lieu.
     */
    public static void ecrireFacture() {
        FileWriter fluxConnecteur;
        BufferedWriter fluxTampon;

        try {
            fluxConnecteur = new FileWriter(FIC_FACTURES);
            fluxTampon = new BufferedWriter(fluxConnecteur);
            //Écriture
            fluxTampon.write(ENTETE);
            fluxTampon.newLine();
            for (Facture ligne : lesFactures) {
                if (ligne != null) {
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
     * Affiche toutes les factures enregistrées dans le tableau des factures.
     */
    public static void afficher() {

        boolean listeFactureVide = false;


        for (int i = 0; i < lesFactures.length && !listeFactureVide; i++) {
            if (lesFactures[i] != null) {
                listeFactureVide = false;
                lesFactures[i].afficherFacture();
                if (lesFactures[i + 1] != null) {
                    System.out.print(MSG_CONTINUER);
                    Clavier.lireFinLigne();
                }else{
                    listeFactureVide = true;
                }
            } else {
                listeFactureVide = true;
                System.out.println("Aucune facture à afficher...");
                System.out.println();
            }
        }
    }
}
