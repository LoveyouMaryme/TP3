public class Vehicule {

    //Déclaration des constantes
    public static final char H = 'H';
    public static final char E = 'E';
    public static final char P = 'P';
    public static final char I = 'I';
    public static final char G = 'G';

    public static final String HYBRIDE = "Hybride";
    public static final String ELECTRIQUE = "Électrique";
    public static final String PETIT = "Petit";
    public static final String INTERMEDIAIRE = "Intermédiaire";
    public static final String GRAND = "Grand";

    //Déclaration des attributs
    private char type;
    private char grandeur;
    private float prixLocationJour;
    private float prixAssuranceJour;


    /**
     * Constructeur pour créer un véhicule avec ses caractéristiques.
     *
     * @param type              Le type de véhicule.
     * @param grandeur          La grandeur du véhicule.
     * @param prixLocationJour  Le prix de location par jour.
     * @param prixAssuranceJour Le prix de l'assurance par jour.
     */
    public Vehicule(char type, char grandeur, float prixLocationJour, float prixAssuranceJour) {
        this.type = type;
        this.grandeur = grandeur;
        this.prixLocationJour = prixLocationJour;
        this.prixAssuranceJour = prixAssuranceJour;
    }

    /**
     * @return Le type de véhicule.
     */
    public char getType() {
        return type;
    }

    /**
     * @return La grandeur du véhicule.
     */
    public char getGrandeur() {
        return grandeur;
    }

    /**
     * @return Le prix de location par jour.
     */
    public float getPrixLocationJour() {
        return prixLocationJour;
    }

    /**
     * @return Le prix de l'assurance par jour.
     */
    public float getPrixAssuranceJour() {
        return prixAssuranceJour;
    }

    /**
     * Retourne la description textuelle du type de véhicule.
     *
     * @return La description du type de véhicule
     */
    public String obtenirDescriptionVehicule() {
        String description = null;

        if (this.type == H) {
            description = HYBRIDE;
        } else if (this.type == E) {
            description = ELECTRIQUE;
        }

        return description;
    }

    /**
     * Retourne la description textuelle de la grandeur du véhicule.
     *
     * @return La description de la grandeur du véhicule.
     */
    public String obtenirGrandeurVehicule() {
        String grandeur = null;

        if (this.grandeur == P) {
            grandeur = PETIT;
        } else if (this.grandeur == I) {
            grandeur = INTERMEDIAIRE;
        } else if (this.grandeur == G) {
            grandeur = GRAND;
        }

        return grandeur;
    }
}
