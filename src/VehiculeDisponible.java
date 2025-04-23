/**
 * Université du Québec à Montréal (UQAM)
 * INF1120 - 010 - Hiver 2025
 * Travail pratique 3
 * <p>
 *
 * La classe {@code VehiculeDisponible} représente un type de véhicule
 * ainsi que le nombre d’exemplaires disponibles à la location.
 *
 * Cette classe est utile pour gérer les stocks de véhicules dans une
 * application de location de véhicules.
 *
 * @author Love-Mary Victor (VICL12559701), Sami Lies Mouzai (MOUS27039501)
 * @version : 23 Avril, 2025
 * @github : https://github.com/LoveyouMaryme/TP3
 */

public class VehiculeDisponible {

    private Vehicule vehiculeDisponible;
    private int nbrVehiculeDisponible;

    /**
     * Constructeur permettant d’instancier un véhicule disponible avec son nombre d’exemplaires.
     *
     * @param vehiculeDisponible      Le véhicule concerné
     * @param nbrVehiculeDisponible   Le nombre de véhicules disponibles
     */
    public VehiculeDisponible(Vehicule vehiculeDisponible, int nbrVehiculeDisponible) {
        this.vehiculeDisponible = vehiculeDisponible;
        this.nbrVehiculeDisponible = nbrVehiculeDisponible;
    }

    /**
     * Retourne le véhicule concerné.
     *
     * @return le véhicule
     */
    public Vehicule getVehiculeDisponible() {
        return vehiculeDisponible;
    }

    /**
     * Retourne le nombre de véhicules disponibles.
     *
     * @return le nombre de véhicules disponibles
     */
    public int getNbrVehiculeDisponible() {
        return nbrVehiculeDisponible;
    }

    /**
     * Modifie le nombre de véhicules disponibles.
     *
     * @param nbrVehiculeDisponible le nouveau nombre de véhicules disponibles
     */
    public void setNbrVehiculeDisponible(int nbrVehiculeDisponible) {
        this.nbrVehiculeDisponible = nbrVehiculeDisponible;
    }
}
