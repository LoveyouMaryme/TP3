public class Locataire {
    private String nom;
    private String prenom;
    private String numeroTelephone;
    private String numeroPermisConduire;

    public Locataire(String nom, String prenom, String numeroTelephone, String numeroPermisConduire) {
        this.nom = nom;
        this.prenom = prenom;
        this.numeroTelephone = numeroTelephone;
        this.numeroPermisConduire = numeroPermisConduire;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public String getNumeroPermisConduire() {
        return numeroPermisConduire;
    }
}
