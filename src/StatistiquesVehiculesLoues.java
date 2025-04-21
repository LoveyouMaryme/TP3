import java.sql.SQLOutput;
import java.time.LocalDateTime;

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

        System.out.println("DEBUG - État du tableau des véhicules loués :");
        for (int i = 0; i < lesVehiculesLoues.length; i++) {
            System.out.println("[" + i + "] = " + lesVehiculesLoues[i]);
        }

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


            }

            emplacementVehicule++;
        }while(!vehiculeTrouve &&  emplacementVehicule != lesVehiculesLoues.length  );

        return nbrVehiculesLoue;
    }


    /**
     * La méthode doit afficher le nombre de véhicules hybrides et électriques
     * loués par type et par grandeur. Pour plus de détails sur l'affichage,
     * voir les exemples de la trace d'exécution du programme fournis avec
     * l'énoncé du Travail pratique 3.
     */
    public static void afficherNbVehiculesLoues() {

        LocalDateTime now = LocalDateTime.now();
        String dateNowFormatee = now.format(Facture.FORMATTER);

        System.out.println("\n" + Facture.BORDURE);
        System.out.println(Facture.NOM_ENTREPRISE);
        System.out.println("Adresse :       " + Facture.ADRESSE_ENTREPRISE);
        System.out.println("Téléphone :     " + Facture.TELEPHONE_ENTREPRISE);
        System.out.println("Date et Heure : " + dateNowFormatee); //maybe there's something to change here
        System.out.println("\n" + Facture.BORDURE);
        System.out.println();

        System.out.println("Nombre de véhicules loués par type et par grandeur");
        System.out.println("*************************************************");
        System.out.println("Grandeur          Hybride      Électrique");
        System.out.println("****************************************");

        System.out.printf("Petit %15d %15d", obtenirNbVehiculesLoues(Vehicule.H, Vehicule.P),  obtenirNbVehiculesLoues(Vehicule.E, Vehicule.P));
        System.out.printf("\nIntermédiaire %7d %15d", obtenirNbVehiculesLoues(Vehicule.H, Vehicule.I),  obtenirNbVehiculesLoues(Vehicule.E, Vehicule.I));
        System.out.printf("\nGrand %15d %15d\n\n",  obtenirNbVehiculesLoues(Vehicule.H, Vehicule.G),  obtenirNbVehiculesLoues(Vehicule.E, Vehicule.G));
        System.out.println(Facture.BORDURE);
        System.out.println();




    }

}
