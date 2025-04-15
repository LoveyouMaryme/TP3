import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
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

    public Facture(LocalDateTime dateFacture, LocationVehicule locationVehicule, char modePaiement) {
        this.dateFacture = dateFacture;
        this.locationVehicule = locationVehicule;
        this.modePaiement = modePaiement;
        this.noFacture = ++compteurFacture;
    }

    public LocalDateTime getDateFacture() {
        return dateFacture;
    }

    public LocationVehicule getLocationVehicule() {
        return locationVehicule;
    }

    public char getModePaiement() {
        return modePaiement;
    }

    public char getTypeCredit() {
        return typeCredit;
    }

    public String getNoCredit() {
        return noCredit;
    }

    public float getSousTotal() {
        return sousTotal;
    }

    public float getMontantTPS() {
        return montantTPS;
    }

    public float getMontantTVQ() {
        return montantTVQ;
    }

    public float getMontantTotal() {
        return montantTotal;
    }

    public void setTypeCredit(char typeCredit) {
        this.typeCredit = typeCredit;
    }

    public void setNoCredit(String noCredit) {
        this.noCredit = noCredit;
    }

    public String obtenirDescriptionModePaiement() {
        String modePaiement = null;

        if (this.modePaiement == D) {
            modePaiement = DEBIT;
        } else if (this.modePaiement == C) {
            modePaiement = CREDIT;
        }

        return modePaiement;
    }

    public String obtenirDescriptionCarteCredit() {
        String carteCredit = null;

        if (this.typeCredit == V) {
            carteCredit = VISA;
        } else if (this.typeCredit == M) {
            carteCredit = MASTERCARD;
        }

        return carteCredit;
    }

    public void calculerSousTotal() {
        float sousTotalFinal = 0;
        VehiculeLoue[] vehiculeLoues = locationVehicule.getVehiculesLoues();


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

    public void calculerMontantTPS() {
        this.montantTPS = this.sousTotal * TPS;
    }

    public void calculerMontantTVQ() {
        this.montantTVQ = this.sousTotal * TVQ;
    }

    public void calculerMontantTotal() {
        this.montantTotal = montantTPS + montantTVQ + sousTotal;
    }

    //A compléter
    public void afficherFacture() {

        VehiculeLoue[] vehiculeLoues = locationVehicule.getVehiculesLoues();

        System.out.println(BORDURE);
        System.out.println(NOM_ENTREPRISE);
        System.out.printf("%-30s%s%n", "Adresse ", ADRESSE_ENTREPRISE);
        System.out.printf("%-30s%s%n", "Téléphone ", TELEPHONE_ENTREPRISE);
        System.out.printf("%-30s%s%n", "Date et Heure ", getDateFacture().format(formatter));
        System.out.printf("%-30s%s%n", "Facture No ", noFacture);
        System.out.println(BORDURE);

        System.out.println();

        System.out.printf("%-30s%s%n", "Prénom et nom", locationVehicule.getLocataire().getPrenom());
        System.out.printf("%-30s%s%n", "Téléphone", locationVehicule.getLocataire().getNumeroTelephone());
        System.out.printf("%-30s%s%n", "Permis de conduire", locationVehicule.getLocataire().getNumeroPermisConduire());

        System.out.println();

        System.out.printf("%-30s%s%n", "Mode de paiement", obtenirDescriptionModePaiement());
        if (this.modePaiement == C) {
            System.out.printf("%-30s%s%n", "Type de la carte de crédit", obtenirDescriptionCarteCredit());
            System.out.printf("%-30s%s%n", "Numéro de la carte de crédit ", this.noCredit);
        }

        System.out.println();

        for (VehiculeLoue vehicule : vehiculeLoues) {
            if (vehicule != null) {

                System.out.printf("%-30s%s%n", "Type du véhicule ", vehicule.getVehicule().obtenirDescriptionVehicule());
                System.out.printf("%-30s%s%n", "Grandeur du véhicule ", vehicule.getVehicule().obtenirGrandeurVehicule());
                System.out.printf("%-30s%s%n", "Nombre de véhicules loués ", vehicule.getNbrVehiculeLoue());
                System.out.printf("%-30s%s%n", "Nombre de jours de location ", vehicule.getNbrJourLocation());
                System.out.printf("%-30s%s%n", "Date de location ", vehicule.getDateLocation().format(formatter));
                System.out.printf("%-30s%s%n", "Date de retour ", vehicule.calculerDateRetour().format(formatter));
                System.out.printf("%-30s%.2f%s%n", "Prix de la location par jour ", vehicule.getVehicule().getPrixLocationJour(), SYMBOL_DEVISE);
                System.out.printf("%-30s%.2f%s%n", "Prix de l'assurance par jour ", vehicule.getVehicule().getPrixAssuranceJour(), SYMBOL_DEVISE);
                System.out.printf("%-30s%.2f%s%n", "Montant de la location ", vehicule.getVehicule().getPrixLocationJour() * vehicule.getNbrVehiculeLoue() * vehicule.getNbrJourLocation(), SYMBOL_DEVISE);
                System.out.printf("%-30s%.2f%s%n", "Montant de l'assurance ", vehicule.getVehicule().getPrixAssuranceJour() * vehicule.getNbrVehiculeLoue() * vehicule.getNbrJourLocation(), SYMBOL_DEVISE);

                System.out.println();
            }
        }

        System.out.printf("%-30s%.2f%s%n", "Sous-total ", sousTotal, SYMBOL_DEVISE);
        System.out.printf("%-30s%.2f%s%n", "Montant TPS ", montantTPS, SYMBOL_DEVISE);
        System.out.printf("%-30s%.2f%s%n", "Montant TVQ ", montantTVQ, SYMBOL_DEVISE);
        System.out.printf("%-30s%.2f%s%n", "Montant Total ", montantTotal, SYMBOL_DEVISE);

        System.out.println(BORDURE);
        System.out.println(MSG_FIN);
    }
}


