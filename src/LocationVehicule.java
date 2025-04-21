/**
 * La classe {@code LocationVehicule} représente un système de location de véhicules. Elle gère
 * les véhicules loués, permet d'ajouter des véhicules au système de location et de récupérer
 * des informations sur les véhicules loués.
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

    public void setLocataire(Locataire locataire) {
        this.locataire = locataire;
    }

    /**
     * Calcule et retourne le nombre total de véhicules loués jusqu'à présent.
     *
     * @return le nombre total de véhicules loués
     */
    public int obtenirNombreVehiculeLoue() {

        int nbrVehiculesLoues = 0;

        for (int i = 0; i < this.vehiculesLoues.length; i++) {

            if (this.vehiculesLoues[i] != null) {
                nbrVehiculesLoues++;
            }
        }
        return nbrVehiculesLoues;
    }

    /**
     * Ajoute un véhicule loué dans le système de location s'il y a une place libre et met à jour
     * le tableau des véhicules loués.
     *
     * @param vehiculeLoue Le véhicule loué à ajouter au système
     * @return {@code true} si le véhicule a été ajouté avec succès, {@code false} s'il n'y a plus de place.
     */
    public boolean ajouterVehicule(VehiculeLoue vehiculeLoue) {

        boolean vehiculeEstajoute = false;


        for (int i = 0; i < this.vehiculesLoues.length && !vehiculeEstajoute; i++) {

            if( vehiculesLoues[i] == null){
                vehiculesLoues[i] = vehiculeLoue;
                vehiculeEstajoute = true;
            }
        }


        return vehiculeEstajoute;
    }

    /**
     * Obtient la position d'un véhicule loué correspondant à un type et une grandeur spécifiques.
     *
     * @param type     Le type de véhicule recherché.
     * @param grandeur La grandeur du véhicule recherché.
     * @return L'indice de la place du véhicule loué correspondant ou -1 si aucun véhicule ne correspond.
     */
    public int obtenirPlaceVehiculeLoue(char type, char grandeur) {

        boolean voitureTrouve = false;
        int numeroPlaceLoue = -1;


        for (int i = 0; i <= this.vehiculesLoues.length - 1 && voitureTrouve != true; i++) {

            if (this.vehiculesLoues[i] != null) {

                Vehicule currentVehiculeLoue = this.vehiculesLoues[i].getVehicule();

                char typeVehicule = currentVehiculeLoue.getType();
                char grandeurVehicule = currentVehiculeLoue.getGrandeur();

                if (typeVehicule == type && grandeurVehicule == grandeur) {
                    numeroPlaceLoue = i;
                    voitureTrouve = true;
                }
            }
        }

        return numeroPlaceLoue;
    }


}
