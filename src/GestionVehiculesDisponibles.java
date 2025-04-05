/**
 * Université du Québec à Montréal (UQAM) 
 * INF1120 - 010 - Hiver 2025
 * Travail pratique 3
 * 
 * GestionVehiculesDisponibles : Cette classe gère le nombre de véhicules
 * disponibles pour la location dans l'inventaire des véhicules.
 * 
 * @author Love-Mary Victor, Sami Lies Mouzai
 * @since 31 mars 2025
 *
 */
public class GestionVehiculesDisponibles {

   // Déclaration des constantes
   private static final String         FIC_VEHICULES_DISPONIBLES = "InventaireVehicules.csv";
   private static VehiculeDisponible[] lesVehiculesDipsonibles   = new VehiculeDisponible[6];

   /**
    * Lire les données des différents véhicules disponibles dans le fichier
    * InventaireVehicules.csv. Chaque ligne est composée : 
    *   - Type du véhicule 
    *   - Grandeur du véhicule 
    *   - Prix de la location du véhicule par jour 
    *   - Prix de l'assurance du véhicule par jour 
    *   - Nombre de véhicules disponibles
    * 
    * La première ligne dans ce fichier est la description des autres lignes et
    * elle doit être ignorée lors de la lecture. Les autres lignes de ce fichier
    * sont composées des données ci-dessus mentionnées séparées entre elles par
    * des points-virgules. Voir le fichier InventaireVehicules.csv pour plus de
    * détails.
    * 
    * Chacune de ces lignes doit être lue et découpée pour créer un objet de type
    * VehiculeDisponible, et cet objet doit être ajouté dans le tableau des véhicules
    * disponibles.
    * 
    */
   public static void lireFichierVehiculesDisponibles() {
      // À COMPLÉTER


   }

   /**
    * Obtenir le prix de la location du véhicule par jour. Cette méthode doit trouver
    * le véhicule dans le tableau des véhicules disponibles (lesVehiculesDipsonibles)
    * dont le type et la grandeur sont les mêmes que le type et de la grandeur du véhicule
    * passés en paramètres, ensuite elle doit retourner le prix de la location du véhicule
    * par jour.  
    *  
    * @param typeVehicule le type du véhicule
    * @param grandeurVehicule la grandeur du véhicule
    * @return le prix de la location du véhicule par jour ou 0 si aucun véhicule trouvé
    */
   public static float obtenirPrixLocationVehParJour(char typeVehicule, char grandeurVehicule) {

      // À COMPLÉTER

      return 0.0f;
   }

   /**
    * Obtenir le prix de l'assurance du véhicule par jour. Cette méthode doit trouver
    * le véhicule dans le tableau des véhicules disponibles (lesVehiculesDipsonibles)
    * dont le type et la grandeur sont les mémes que le type et de la grandeur du véhicule
    * passés en paramètres, ensuite elle doit retourner le prix de l'assurance du véhicule 
    * par jour. Si le paramètre "AssuranceEstZero" est true, le prix de l'assurance doit être
    * 0, sinon la méthode retourne le prix de l'assurance trouvé dans le tableau des véhicules
    * disponibles
    *
    * @param typeVehicule le type du véhicule
    * @param grandeurVehicule la grandeur du véhicule
    * @param assuranceEstZero un indicateur pour savoir s'il faut calculer l'assurance ou la mettre
    *        à 0 ou non
    * @return le prix de l'assurance du véhicule par jour ou 0 si aucun véhicule trouvé
    */
   public static float obtenirPrixAssuranceVehParJour(char typeVehicule, char grandeurVehicule,
         boolean assuranceEstZero) {
      
     // À COMPLÉTER

     return 0.0f;
   }
   
   /**
    * Diminuer le nombre de véhicules disponibles dans le tableau des véhicules disponibles. 
    * 
    * La méthode doit trouver le véhicule dans le tableau des véhicules disponibles dont 
    * le type et la grandeur sont les mêmes que le type et la grandeur passés en paramètres,
    * ensuite elle fait le nombre de véhicules disponibles moins le nombre de véhicules loués.
    * 
    * Elle retourne vrai si la diminution a été effectuée avec succès, sinon faux.
    *  
    * @param typeVehicule le type du véhicule
    * @param grandeurVehicule la grandeur du véhicule
    * @param nbVehiculesLoues le nombre de véhicules loués
    * @return vrai si la diminution est faite, sinon faux 
    */
   public static boolean diminuerNbVehiculesDisponibles(char typeVehicule, 
         char grandeurVehicule, int nbVehiculesLoues) {

      // À COMPLÉTER
      
      return false;
   }


   /**
    * Obtenir le nombre de véhicules disponibles. Cette méthode doit trouver le véhicule 
    * dans le tableau des véhicules disponibles (lesVehiculesDipsonibles) dont le type et 
    * la grandeur sont les mêmes que le type et de la grandeur du véhicule passés en 
    * paramètres. Ensuite elle doit retourner le nombre de véhciules disponibles. 
    *  
    * @param typeVehicule le type du véhicule
    * @param grandeurVehicule la grandeur du véhicule
    * @return le nombre de véhicules disponibles ou 0 si aucun véhicule trouvé
    */
   public static int obtenirNbVehiculesDisponibles(char typeVehicule, char grandeurVehicule) {

      // À COMPLÉTER

      return 0;
   }

   /**
    * Vérifier la disponibilité des véhicules disponibles (lesVehiculesDipsonibles).
    * 
    * La méthode doit trouver le véhicule dans le tableau des véhicules disponibles 
    * (lesVehiculesDipsonibles) dont le type et la grandeur sont les mêmes que le type 
    * et de la grandeur du véhicule passés en paramètres. Ensuite elle doit retourner
    * vrai si le nombre de véhicules loués passé en paramètre (nbVehciculesLoues) est 
    * inférieur ou égal au nombre de véhicules disponibles, sinon faux. 
    *  
    * @param typeVehicule le type du véhicule
    * @param grandeurVehicule la grandeur du véhicule
    * @param nbVehciculesLoues le nombre de véhicules dont la disponibilité doit être vérifiée
    * @return vrai si le nombre de véhicules passé en paramètre est inférieur ou égal au 
    * nombre de véhicules disponibles, sinon faux.
    */
   public static boolean estDisponible(char typeVehicule, 
         char grandeurVehicule, int nbVehciculesLoues) {

      // À COMPLÉTER

      return false;
   }
   
   
   /**
    * Afficher les différents véhicules disponibles dans le tableau des véhicules disponibles.
    * Pour plus de détails sur l'affichage, voir les exemples de la trace d'exécution du 
    * programme fournis avec l'énoncé du Travail pratique 3."
    */
   public static void afficher() {
      
      // À COMPLÉTER
     
   }
   
}
