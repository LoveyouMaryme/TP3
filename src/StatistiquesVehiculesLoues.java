/**
 * Université du Québec à Montréal (UQAM)
 * INF1120 - 010 - Hiver 2025
 * Travail pratique 3
 * <p>
 * StatistiqueVentes : Cette classe contient le nombre de
 * véhicules hybrides et électriques loués
 *
 * @author Love-Mary Victor / Sami lies Mouzai
 * @since 31 mars 2025
 */
public class StatistiquesVehiculesLoues {

    // Déclaration des variables de classe
    private static VehiculeLoue[] lesVehiculesLoues = new VehiculeLoue[6];


    /**
     * Augmenter le nombre de véhicules loués par type et par grandeur de véhicule.
     * <p>
     * La méthode doit trouver le véhicule loué dans le tableau des véhicules loués
     * (lesVehiculesLoues) dont le type et la grandeur sont les mêmes que le type
     * et la grandeur du véhicule loué passé en paramètre, ensuite elle doit ajouter
     * le nombre de véhicules loués du véhicule loué passé en paramètre au nombre de véhicule
     * loué dans le tableau des véhicules loués.
     * <p>
     * Si aucun véhicule loué n'est trouvé dans le tableau des véhicules loués qui
     * correspond au véhicule loué passé en paramètre, le véhicule loué passé en
     * paramètre est ajouté dans le tableau des véhicules loués à la prochaine position
     * libre.
     *
     * @param vehiculeLoue le véhicule loué
     */
    public static void augmenterNbVehiculesLoues(VehiculeLoue vehiculeLoue) {

        boolean emplacementNonTrouve = false;
        int prochainEmplacement = 0;


        do {

                VehiculeLoue enregistrementLocation = lesVehiculesLoues[prochainEmplacement];

            if (enregistrementLocation == null) {
                lesVehiculesLoues[prochainEmplacement] = vehiculeLoue;
                emplacementNonTrouve = true;

            } else {
                Vehicule couranteLocation = enregistrementLocation.getVehicule();
                char typeCouranteLocation = couranteLocation.getType();
                char grandeurCouranteLocation = couranteLocation.getGrandeur();
                char typeNouvelleLocation = vehiculeLoue.getVehicule().getType();
                char grandeurNouvelleLocation = vehiculeLoue.getVehicule().getGrandeur();
                int nbrCourantVehiculeLoue = enregistrementLocation.getNbrVehiculeLoue();
                int nbrNouvelleVehiculeLoue = vehiculeLoue.getNbrVehiculeLoue();


                if (typeCouranteLocation == typeNouvelleLocation && grandeurCouranteLocation == grandeurNouvelleLocation) {
                    enregistrementLocation.setNbrVehiculeLoue(nbrCourantVehiculeLoue + nbrNouvelleVehiculeLoue);
                    emplacementNonTrouve = true;
                } else {
                    prochainEmplacement++;
                }
            }

        } while (!emplacementNonTrouve && prochainEmplacement != 6);


        System.out.println("Le nombre de vehicule loue` " + lesVehiculesLoues[prochainEmplacement].getVehicule().getType() + lesVehiculesLoues[prochainEmplacement].getVehicule().getGrandeur() + lesVehiculesLoues[prochainEmplacement].getNbrVehiculeLoue());

    }

    /**
     * Obtenir le nombre de véhicules loués.
     * <p>
     * La méthode doit trouver le véhicule loués dans le tableau des véhicules loués
     * (lesVehiculesLoues) dont le type et la grandeur sont les mêmes que le type
     * et la grandeur passés en paramètres. Ensuite elle doit retourner le nombre de
     * véhicules disponibles.
     *
     * @param typeVehicule     le type du véhicule loué
     * @param grandeurVehicule la grandeur du véhicule loué
     * @return le nombre de véhicules disponibles ou 0 si aucun véhicule trouvé
     */
    public static int obtenirNbVehiculesLoues(char typeVehicule, char grandeurVehicule) {

        boolean vehiculeTrouve = false;
        int emplacementVehicule = 0;
        int nbrVehiculesLoue = 0;
        do {

            if(lesVehiculesLoues[emplacementVehicule] != null ){
                VehiculeLoue vehiculeCourant = lesVehiculesLoues[emplacementVehicule];
                char vehiculeCourantType = vehiculeCourant.getVehicule().getType();
                char vehiculeCouranGrandeur = vehiculeCourant.getVehicule().getGrandeur();

                if(vehiculeCourantType == typeVehicule && vehiculeCouranGrandeur == grandeurVehicule){
                    vehiculeTrouve = true;
                    nbrVehiculesLoue = lesVehiculesLoues[emplacementVehicule].getNbrVehiculeLoue();
                }

                emplacementVehicule++;
            }
        }while(!vehiculeTrouve);

        return nbrVehiculesLoue;
    }


    /**
     * La méthode doit afficher le nombre de véhicules hybrides et électriques
     * loués par type et par grandeur. Pour plus de détails sur l'affichage,
     * voir les exemples de la trace d'exécution du programme fournis avec
     * l'énoncé du Travail pratique 3.
     */
    public static void afficherNbVehiculesLoues() {

        // À COMPLÉTER

    }

}
