/**
 * Université du Québec à Montréal (UQAM)
 * INF1120 - 010 - Hiver 2025
 * Travail pratique 3
 * <p>
 * La classe {@code Locataire} représente un client qui loue un ou plusieurs véhicules.
 * Elle contient les informations personnelles du locataire, nécessaires pour identifier et contacter celui-ci.
 *
 * <p>Cette classe est utilisée pour relier un locataire à une location de véhicule.</p>
 *
 * @author Love-Mary Victor (VICL12559701), Sami Lies Mouzai (MOUS27039501)
 * @version : 23 Avril, 2025
 * @github : https://github.com/LoveyouMaryme/TP3
 */

public class Locataire {
    private String nom;
    private String prenom;
    private String numeroTelephone;
    private String numeroPermisConduire;



    /**
     * Constructeur pour créer un nouveau locataire avec toutes ses informations personnelles.
     *
     * @param nom                   Nom de famille du locataire
     * @param prenom               Prénom du locataire
     * @param numeroTelephone      Numéro de téléphone du locataire
     * @param numeroPermisConduire Numéro du permis de conduire du locataire
     */
    public Locataire(String nom, String prenom, String numeroTelephone, String numeroPermisConduire) {
        this.nom = nom;
        this.prenom = prenom;
        this.numeroTelephone = numeroTelephone;
        this.numeroPermisConduire = numeroPermisConduire;
    }

    /**
     * Retourne le nom de famille du locataire.
     *
     * @return le nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Retourne le prénom du locataire.
     *
     * @return le prénom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Retourne le numéro de téléphone du locataire.
     *
     * @return le numéro de téléphone
     */
    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    /**
     * Retourne le numéro de permis de conduire du locataire.
     *
     * @return le numéro de permis de conduire
     */
    public String getNumeroPermisConduire() {
        return numeroPermisConduire;
    }
}
