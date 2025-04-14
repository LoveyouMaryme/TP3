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
        this.sousTotal = sousTotalFinal;
    }

    public void calculerMontantTPS(){
        this.montantTPS = this.sousTotal * TPS;
    }

    public void calculerMontantTVQ(){
        this.montantTVQ = this.sousTotal * TVQ;
    }

    public void calculerMontantTotal(){
        this.montantTotal = montantTPS + montantTVQ + sousTotal;
    }

    //A compléter
    public void afficherFacture(){
        System.out.println(NOM_ENTREPRISE);
    }

    // méthode de test
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        LocalDateTime now = LocalDateTime.now();
        String date = now.format(formatter);

        Vehicule vehicule1 = new Vehicule('E', 'P', 50.0f, 10.0f);

        // Création d’un véhicule loué
        VehiculeLoue vehiculeLoue1 = new VehiculeLoue(
                vehicule1,
                LocalDateTime.of(2025, 4, 10, 10, 0, 0),
                1, // Nombre de véhicules loués
                5  // Nombre de jours
        );

        LocationVehicule location = new LocationVehicule();
        location.ajouterVehicule(vehiculeLoue1);

        Facture facture = new Facture(LocalDateTime.now(), location, Facture.D);

        // Calculs
        facture.calculerSousTotal();
        facture.calculerMontantTPS();
        facture.calculerMontantTVQ();

        facture.afficherFacture();

    }
}

