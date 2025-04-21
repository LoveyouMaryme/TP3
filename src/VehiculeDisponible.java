public class VehiculeDisponible {

    private Vehicule vehiculeDisponible;
    private int nbrVehiculeDisponible;

    public VehiculeDisponible(Vehicule vehiculeDisponible, int nbrVehiculeDisponible) {
        this.vehiculeDisponible = vehiculeDisponible;
        this.nbrVehiculeDisponible = nbrVehiculeDisponible;
    }

    public Vehicule getVehiculeDisponible() {
        return vehiculeDisponible;
    }

    public int getNbrVehiculeDisponible() {
        return nbrVehiculeDisponible;
    }

    public void setNbrVehiculeDisponible(int nbrVehiculeDisponible) {
        this.nbrVehiculeDisponible = nbrVehiculeDisponible;
    }
}
