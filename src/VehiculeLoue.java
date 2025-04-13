import java.time.LocalDateTime;

public class VehiculeLoue {

    public static final float TAUX_RABAIS = 0.20F;
    public static final byte NBR_JOUR_MINIMUM_RABAIS = 15;

    private Vehicule vehicule;
    private int nbrJourLocation;
    private int nbrVehiculeLoue;
    private LocalDateTime dateLocation;

    public VehiculeLoue(Vehicule vehicule, LocalDateTime dateLocation, int nbrVehiculeLoue, int nbrJourLocation) {
        this.vehicule = vehicule;
        this.dateLocation = dateLocation;
        this.nbrVehiculeLoue = nbrVehiculeLoue;
        this.nbrJourLocation = nbrJourLocation;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    public LocalDateTime getDateLocation() {
        return dateLocation;
    }

    public void setDateLocation(LocalDateTime dateLocation) {
        this.dateLocation = dateLocation;
    }

    public int getNbrVehiculeLoue() {
        return nbrVehiculeLoue;
    }

    public void setNbrVehiculeLoue(int nbrVehiculeLoue) {
        this.nbrVehiculeLoue = nbrVehiculeLoue;
    }

    public int getNbrJourLocation() {
        return nbrJourLocation;
    }

    public void setNbrJourLocation(int nbrJourLocation) {
        this.nbrJourLocation = nbrJourLocation;
    }

    public LocalDateTime calculerDateRetour(){

        LocalDateTime dateRetour;
        dateRetour = this.dateLocation.plusDays(this.nbrJourLocation);
        return dateRetour;
    }

    public float calculerRabais(){

        float montantRabais = 0.0F;

        if(this.nbrJourLocation > 15 &&
        this.vehicule.getType() == Vehicule.E &&
        ( this.vehicule.getType() == Vehicule.P || this.vehicule.getType() == Vehicule.I)){

            montantRabais = this.vehicule.getPrixLocationJour() * TAUX_RABAIS;
        }

        return montantRabais;
    }
}
