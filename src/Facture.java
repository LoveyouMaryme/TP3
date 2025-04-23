import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Université du Québec à Montréal (UQAM)
 * INF1120 - 010 - Hiver 2025
 * Travail pratique 3
 * <p>
 * La classe {@code Facture} représente une facture générée lors de la location d'un ou plusieurs véhicules.
 * Elle contient des informations sur le client, les véhicules loués, le mode de paiement, ainsi que les montants associés (sous-total, TPS, TVQ, total).
 * Elle permet aussi l'affichage et la génération de la facture au format texte ou CSV.
 *
 * @author Love-Mary Victor (VICL12559701), Sami Lies Mouzai (MOUS27039501)
 * @version : 23 Avril, 2025
 * @github : https://github.com/LoveyouMaryme/TP3
 */

public class Facture {

    //Déclaration des constantes
    public static final char D = 'D';
    public static final char C = 'C';
    public static final String DEBIT = "Débit";
    public static final String CREDIT = "Crédit";
    public static final char V = 'V';
    public static final char M = 'M';
    public static final String VISA = "Visa";
    public static final String MASTERCARD = "MasterCard";
    public static final float TVQ = 0.09975f;
    public static final float TPS = 0.05f;
    public static final String NOM_ENTREPRISE = "Roulons des véhicules verts (RVV)";
    public static final String ADRESSE_ENTREPRISE = "1500 rue Matata, Hakuna, Québec Y0Z 6Y7";
    public static final String TELEPHONE_ENTREPRISE = "(438) 222-1111";
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    public static final String SYMBOL_DEVISE = "$";
    public static final String BORDURE = "--------------------------------------------------------";
    public static final String MSG_FIN = "Merci pour votre confiance!";


    //Déclaration des variables
    private static int compteurFacture = 0;
    private int noFacture;
    private char modePaiement;
    private char typeCredit;
    private String noCredit;
    private LocalDateTime dateFacture;
    private LocationVehicule locationVehicule;
    private float sousTotal;
    private float montantTPS;
    private float montantTVQ;
    private float montantTotal;


    /**
     * Constructeur de la classe Facture.
     *
     * @param dateFacture      Date à laquelle la facture est générée.
     * @param locationVehicule Objet contenant les informations sur la location de véhicules.
     * @param modePaiement     Mode de paiement utilisé ('D' pour Débit, 'C' pour Crédit).
     */
    public Facture(LocalDateTime dateFacture, LocationVehicule locationVehicule, char modePaiement) {
        this.dateFacture = dateFacture;
        this.locationVehicule = locationVehicule;
        this.modePaiement = modePaiement;
        this.noFacture = ++compteurFacture;
    }


    /**
     * Retourne la date de création de la facture.
     *
     * @return date de la facture
     */
    public LocalDateTime getDateFacture() {
        return dateFacture;
    }


    /**
     * Retourne l'objet de location associé à cette facture.
     *
     * @return location de véhicules
     */
    public LocationVehicule getLocationVehicule() {
        return locationVehicule;
    }

    /**
     * Retourne le mode de paiement ('D' ou 'C').
     *
     * @return caractère représentant le mode de paiement
     */
    public char getModePaiement() {
        return modePaiement;
    }

    /**
     * Retourne le type de carte de crédit utilisé ('V' ou 'M').
     *
     * @return caractère représentant le type de carte
     */
    public char getTypeCredit() {
        return typeCredit;
    }

    /**
     * Retourne le numéro de la carte de crédit.
     *
     * @return numéro de carte de crédit (partiellement masqué à l'affichage)
     */
    public String getNoCredit() {
        return noCredit;
    }

    /**
     * Retourne le montant du sous-total de la facture.
     *
     * @return montant avant taxes
     */
    public float getSousTotal() {
        return sousTotal;
    }

    /**
     * Retourne le montant de la TPS calculé.
     *
     * @return montant TPS
     */
    public float getMontantTPS() {
        return montantTPS;
    }

    /**
     * Retourne le montant de la TVQ calculé.
     *
     * @return montant TVQ
     */
    public float getMontantTVQ() {
        return montantTVQ;
    }

    /**
     * Retourne le montant total incluant les taxes.
     *
     * @return montant total de la facture
     */
    public float getMontantTotal() {
        return montantTotal;
    }

    /**
     * Définit le type de carte de crédit utilisée.
     *
     * @param typeCredit 'V' pour Visa ou 'M' pour MasterCard
     */
    public void setTypeCredit(char typeCredit) {
        this.typeCredit = typeCredit;
    }

    /**
     * Définit le numéro de la carte de crédit utilisée.
     *
     * @param noCredit numéro complet de carte de crédit
     */
    public void setNoCredit(String noCredit) {
        this.noCredit = noCredit;
    }

    /**
     * Retourne la description textuelle du mode de paiement (Débit ou Crédit).
     *
     * @return la description du mode de paiement
     */
    public String obtenirDescriptionModePaiement() {
        String modePaiement = null;

        if (this.getModePaiement() == D) {
            modePaiement = DEBIT;
        } else if (this.getModePaiement() == C) {
            modePaiement = CREDIT;
        }

        return modePaiement;
    }

    /**
     * Retourne la description textuelle du type de carte de crédit (Visa ou MasterCard).
     *
     * @return la description du type de carte de crédit
     */
    public String obtenirDescriptionCarteCredit() {
        String carteCredit = "";

        if (this.getTypeCredit() == V) {
            carteCredit = VISA;
        } else if (this.getTypeCredit() == M) {
            carteCredit = MASTERCARD;
        }

        return carteCredit;
    }

    /**
     * Calcule et met à jour le sous-total de la facture en fonction des véhicules loués.
     */
    public void calculerSousTotal() {
        float sousTotalFinal = 0;
        VehiculeLoue[] vehiculeLoues = getLocationVehicule().getVehiculesLoues();


        for (VehiculeLoue vehicule : vehiculeLoues) {
            if (vehicule != null) {

                float prixlocationjour = vehicule.getVehicule().getPrixAssuranceJour();
                int nbVehiculesLoues = vehicule.getNbrVehiculeLoue();
                int nbJourLocation = vehicule.getNbrJourLocation();
                float rabais = vehicule.calculerRabais();
                float prixAssuranceJour = vehicule.getVehicule().getPrixLocationJour();

                float montantLocation = (prixlocationjour - rabais) * nbJourLocation * nbVehiculesLoues;
                float montantAssurance = prixAssuranceJour * nbJourLocation * nbVehiculesLoues;
                float sousTotalVehicule = montantLocation + montantAssurance;

                sousTotalFinal = sousTotalFinal + sousTotalVehicule;
            }
        }
        this.sousTotal = sousTotalFinal;
    }

    /**
     * Calcule et met à jour le montant de la TPS basé sur le sous-total.
     */
    public void calculerMontantTPS() {
        this.montantTPS = this.sousTotal * TPS;
    }

    /**
     * Calcule et met à jour le montant de la TVQ basé sur le sous-total.
     */
    public void calculerMontantTVQ() {
        this.montantTVQ = this.sousTotal * TVQ;
    }

    /**
     * Calcule et met à jour le montant total de la facture incluant TPS et TVQ.
     */
    public void calculerMontantTotal() {
        this.montantTotal = montantTPS + montantTVQ + sousTotal;
    }

    /**
     * Affiche la facture détaillée.
     */
    public void afficherFacture() {

        VehiculeLoue[] vehiculeLoues = getLocationVehicule().getVehiculesLoues();

        ApplicationPrincipale.afficherEnteteEntreprise(noFacture);

        System.out.println();

        System.out.printf("%-35s%s %s%n", "Prénom et nom", getLocationVehicule().getLocataire().getPrenom(), getLocationVehicule().getLocataire().getNom());
        System.out.printf("%-35s%s%n", "Téléphone", getLocationVehicule().getLocataire().getNumeroTelephone());
        System.out.printf("%-35s%s%n", "Permis de conduire", getLocationVehicule().getLocataire().getNumeroPermisConduire());

        System.out.println();

        System.out.printf("%-35s%s%n", "Mode de paiement", obtenirDescriptionModePaiement());
        if (this.modePaiement == C) {
            System.out.printf("%-35s%s%n", "Type de la carte de crédit", obtenirDescriptionCarteCredit());
            System.out.printf("%-35s%s%s%n", "Numéro de la carte de crédit", "XXXX XXXX XXXX ", this.noCredit.substring(15, 19));
        }

        System.out.println();

        for (VehiculeLoue vehicule : vehiculeLoues) {
            if (vehicule != null) {

                System.out.printf("%-35s%s%n", "Type du véhicule ", vehicule.getVehicule().obtenirDescriptionVehicule());
                System.out.printf("%-35s%s%n", "Grandeur du véhicule ", vehicule.getVehicule().obtenirGrandeurVehicule());
                System.out.printf("%-35s%s%n", "Nombre de véhicules loués ", vehicule.getNbrVehiculeLoue());
                System.out.printf("%-35s%s%n", "Nombre de jours de location ", vehicule.getNbrJourLocation());
                System.out.printf("%-35s%s%n", "Date de location ", vehicule.getDateLocation().format(FORMATTER));
                System.out.printf("%-35s%s%n", "Date de retour ", vehicule.calculerDateRetour().format(FORMATTER));
                System.out.printf("%-35s%.2f%s%n", "Prix de la location par jour ", vehicule.getVehicule().getPrixLocationJour(), SYMBOL_DEVISE);
                System.out.printf("%-35s%.2f%s%n", "Prix de l'assurance par jour ", vehicule.getVehicule().getPrixAssuranceJour(), SYMBOL_DEVISE);
                System.out.printf("%-35s%.2f%s%n", "Montant de la location ", (vehicule.getVehicule().getPrixLocationJour() - vehicule.calculerRabais()) * vehicule.getNbrVehiculeLoue() * vehicule.getNbrJourLocation(), SYMBOL_DEVISE);
                System.out.printf("%-35s%.2f%s%n", "Montant de l'assurance ", vehicule.getVehicule().getPrixAssuranceJour() * vehicule.getNbrVehiculeLoue() * vehicule.getNbrJourLocation(), SYMBOL_DEVISE);

                if (vehicule.getNbrJourLocation() > 15) {
                    System.out.printf("%-35s%.2f%s%n", "Rabais sur le prix de location", vehicule.calculerRabais(), SYMBOL_DEVISE);
                }

                System.out.println();
            }
        }

        System.out.printf("%-35s%.2f%s%n", "Sous-total ", sousTotal, SYMBOL_DEVISE);
        System.out.printf("%-35s%.2f%s%n", "Montant TPS ", montantTPS, SYMBOL_DEVISE);
        System.out.printf("%-35s%.2f%s%n", "Montant TVQ ", montantTVQ, SYMBOL_DEVISE);
        System.out.printf("%-35s%.2f%s%n", "Montant Total ", montantTotal, SYMBOL_DEVISE);

        System.out.println(BORDURE);
        System.out.println(MSG_FIN);
        System.out.println();
    }

    /**
     * Formate la facture sous forme de chaîne de caractères (CSV) pour être exportée.
     *
     * @return une chaîne représentant la facture formatée
     */
    public String formaterFacture() {

        String factureString = "";
        String noCredit;

        if (getNoCredit() == null) {
            noCredit = "";
        } else {
            noCredit = getNoCredit();
        }

        factureString += noFacture + ";" + getDateFacture().format(FORMATTER) + ";" + getLocationVehicule().getLocataire().getPrenom() + " "
                + getLocationVehicule().getLocataire().getNom() + ";" + getLocationVehicule().getLocataire().getNumeroTelephone()
                + ";" + getLocationVehicule().getLocataire().getNumeroPermisConduire() + ";" + obtenirDescriptionModePaiement() + ";"
                + obtenirDescriptionCarteCredit() + ";" + noCredit + ";";

        VehiculeLoue[] vehiculeLoues = getLocationVehicule().getVehiculesLoues();

        for (int i = 0; i < vehiculeLoues.length; i++) {
            if (vehiculeLoues[i] != null) {
                int nbVehicules = getLocationVehicule().getVehiculesLoues().length;

                factureString = factureString + vehiculeLoues[i].getVehicule().obtenirDescriptionVehicule() + ";";
                factureString = factureString + vehiculeLoues[i].getVehicule().obtenirGrandeurVehicule() + ";";
                factureString = factureString + vehiculeLoues[i].getNbrVehiculeLoue() + ";";
                factureString = factureString + vehiculeLoues[i].getNbrJourLocation() + ";";

                factureString = factureString + vehiculeLoues[i].getDateLocation().format(FORMATTER) + ";";
                factureString = factureString + vehiculeLoues[i].calculerDateRetour().format(FORMATTER) + ";";

                factureString = factureString + String.format("%.2f", vehiculeLoues[i].getVehicule().getPrixLocationJour()) + ";";
                factureString = factureString + String.format("%.2f", vehiculeLoues[i].calculerRabais()) + ";";
                factureString = factureString + String.format("%.2f", vehiculeLoues[i].getVehicule().getPrixAssuranceJour()) + ";";
                factureString = factureString + String.format("%.2f", (vehiculeLoues[i].getVehicule().getPrixLocationJour() * vehiculeLoues[i].getNbrVehiculeLoue() * vehiculeLoues[i].getNbrJourLocation())) + ";"; //montant Location
                factureString = factureString + String.format("%.2f", (vehiculeLoues[i].getVehicule().getPrixAssuranceJour() * vehiculeLoues[i].getNbrVehiculeLoue() * vehiculeLoues[i].getNbrJourLocation())) + ";"; //montant Assurance

                /* On vérifie s'il reste d'autres locations à la prochaine boucle, si c'est le cas on prépare la chaîne
                / en ajoutant des champs vides */
                if (nbVehicules > 1 && vehiculeLoues[i + 1] != null) {
                    factureString = factureString + ";;;" + "\n" + ";;;;;;;;";
                }
            }
        }
        // On rajoute les champs des montants à la fin de la chaîne une fois qu'on a parcouru tous les véhicules loués
        factureString = factureString + String.format("%.2f", getSousTotal()) + ";";
        factureString = factureString + String.format("%.2f", getMontantTPS()) + ";";
        factureString = factureString + String.format("%.2f", getMontantTVQ()) + ";";
        factureString = factureString + String.format("%.2f", getMontantTotal()) + ";";

        return factureString;
    }
}


