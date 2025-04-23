import java.time.LocalDateTime;

/**
 * Université du Québec à Montréal (UQAM)
 * INF1120 - 010 - Hiver 2025
 * Travail pratique 3
 * <p>
 * La classe {@code VehiculeLoue} représente une instance de location d’un véhicule.
 * Elle conserve les détails sur le véhicule loué, le nombre de jours de location,
 * le nombre de véhicules loués, ainsi que la date de début de location.
 *
 * @author : Love-Mary Victor (VICL12559701), Sami Lies Mouzai (MOUS27039501)
 * @version : 23 Avril, 2025
 * @github : https://github.com/LoveyouMaryme/TP3
 */

public class VehiculeLoue {

    public static final float TAUX_RABAIS = 0.20F;
    public static final byte NBR_JOUR_MINIMUM_RABAIS = 15;

    private Vehicule vehicule;
    private int nbrJourLocation;
    private int nbrVehiculeLoue;
    private LocalDateTime dateLocation;

    /**
     * Constructeur pour créer une nouvelle instance de {@code VehiculeLoue}.
     *
     * @param vehicule        Le véhicule loué
     * @param dateLocation    La date de début de location
     * @param nbrVehiculeLoue Le nombre de véhicules loués
     * @param nbrJourLocation Le nombre de jours de location
     */
    public VehiculeLoue(Vehicule vehicule, LocalDateTime dateLocation, int nbrVehiculeLoue, int nbrJourLocation) {
        this.vehicule = vehicule;
        this.dateLocation = dateLocation;
        this.nbrVehiculeLoue = nbrVehiculeLoue;
        this.nbrJourLocation = nbrJourLocation;
    }

    /**
     * Retourne le véhicule loué.
     *
     * @return le véhicule
     */
    public Vehicule getVehicule() {
        return vehicule;
    }

    /**
     * Retourne la date de début de la location.
     *
     * @return la date de location
     */
    public LocalDateTime getDateLocation() {
        return dateLocation;
    }


    /**
     * Retourne le nombre de véhicules loués.
     *
     * @return le nombre de véhicules loués
     */
    public int getNbrVehiculeLoue() {
        return nbrVehiculeLoue;
    }

    /**
     * Modifie le nombre de véhicules loués.
     *
     * @param nbrVehiculeLoue le nouveau nombre de véhicules loués
     */
    public void setNbrVehiculeLoue(int nbrVehiculeLoue) {
        this.nbrVehiculeLoue = nbrVehiculeLoue;
    }

    /**
     * Retourne le nombre de jours pour lesquels le véhicule est loué.
     *
     * @return le nombre de jours de location
     */
    public int getNbrJourLocation() {
        return nbrJourLocation;
    }


    /**
     * Calcule la date de retour prévue en ajoutant le nombre de jours de location à la date de départ.
     *
     * @return la date de retour
     */
    public LocalDateTime calculerDateRetour() {

        LocalDateTime dateRetour;
        dateRetour = this.dateLocation.plusDays(this.nbrJourLocation);
        return dateRetour;
    }

    /**
     * Calcule le montant du rabais applicable sur une location.
     *
     * @return Le montant du rabais
     */
    public float calculerRabais() {

        float montantRabais = 0.0F;

        if (this.nbrJourLocation > 15 &&
                this.vehicule.getType() == Vehicule.E &&
                (this.vehicule.getGrandeur() == Vehicule.P || this.vehicule.getGrandeur() == Vehicule.I)) {
            montantRabais = this.vehicule.getPrixLocationJour() * TAUX_RABAIS;
        }

        return montantRabais;
    }
}
