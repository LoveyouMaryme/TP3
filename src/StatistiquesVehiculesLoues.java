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
 * @author Love-Mary Victor (VICL12559701), Sami Lies Mouzai (MOUS27039501)
 * @version : 23 Avril, 2025
 * @github : https://github.com/LoveyouMaryme/TP3
 */
public class StatistiquesVehiculesLoues {

    // Déclaration des variables de classe
    private static VehiculeLoue[] lesVehiculesLoues = new VehiculeLoue[6];


    /**
     * Ajoute un enregistrement de véhicule loué par type et par grandeur
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

    }

    /**
     * Retourne le nombre de véhicules loués selon un type et une grandeur donnés.
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
     * Affiche un tableau contenant tous les véhicules loués jusqu'à présent.
     */
    public static void afficherNbVehiculesLoues() {

        ApplicationPrincipale.afficherEnteteEntreprise();

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
        System.out.println();

    }

}
