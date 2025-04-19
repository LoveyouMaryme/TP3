/**
 * The LocationVehicule class represents a vehicle rental system. It manages
 * rented vehicles, provides functionality for adding vehicles to the rental
 * system, and allows querying the details of rented vehicles.
 */
public class LocationVehicule {


    public static final int MAX_NBR_VEHICULE_LOUE = 50;

    private Locataire locataire;
    private VehiculeLoue[] vehiculesLoues;

    public LocationVehicule() {
        this.vehiculesLoues = new VehiculeLoue[MAX_NBR_VEHICULE_LOUE];
    }

    public Locataire getLocataire() {
        return locataire;
    }

    public VehiculeLoue[] getVehiculesLoues() {
        return vehiculesLoues;
    }

    /**
     * Computes the total number of rented vehicles currently in the system.
     *
     * @return The total count of non-null entries in the array of rented vehicles.
     */
    public int obtenirNbVehicules() {

        int nbrVehiculesLoues = 0;

        for (int i = 0; i < this.vehiculesLoues.length; i++) {

            if (this.vehiculesLoues[i] != null) {
                nbrVehiculesLoues++;
            }
        }
        return nbrVehiculesLoues;
    }

    /**
     * Adds a rented vehicle to the rental system if space is available and updates the list of rented vehicles.
     *
     * @param vehiculeLoue The rented vehicle to be added to the system.
     * @return true if the vehicle is successfully added, false if there is no available space.
     */
    public boolean ajouterVehicule(VehiculeLoue vehiculeLoue) {

        int placeLibre;
        boolean vehiculeEstajoute = true;

        placeLibre = obtenirNbVehicules();

        if (placeLibre > MAX_NBR_VEHICULE_LOUE) {
            vehiculeEstajoute = false;
        }

        this.vehiculesLoues[placeLibre] = vehiculeLoue;

        return vehiculeEstajoute;
    }

    /**
     * Obtient la position d'un véhicule loué correspondant à un type et une grandeur spécifiques.
     *
     * @param type     Le type de véhicule recherché.
     * @param grandeur La grandeur du véhicule recherché.
     * @return L'indice de la place du véhicule loué correspondant ou -1 si aucun véhicule ne correspond.
     */
    public int obtenirPosition(char type, char grandeur) {

        int numeroPlaceLoue = -1;


        for (int i = 0; i <= this.vehiculesLoues.length - 1; i++) {

            if (this.vehiculesLoues[i] != null) {

                Vehicule currentVehiculeLoue = this.vehiculesLoues[i].getVehicule();

                char typeVehicule = currentVehiculeLoue.getType();
                char grandeurVehicule = currentVehiculeLoue.getType();

                if (typeVehicule == type && grandeurVehicule == grandeur) {
                    numeroPlaceLoue = i;
                }
            }
        }

        return numeroPlaceLoue;
    }


}
