import java.util.Arrays;

public class TestGestionVehiculeDisponibles {
    public static void main(String[] args) {


        GestionVehiculesDisponibles.lireFichierVehiculesDisponibles();
        System.out.println();
        System.out.println(GestionVehiculesDisponibles.obtenirPrixAssuranceVehParJour('H', 'P', 'N'));




    }
}
