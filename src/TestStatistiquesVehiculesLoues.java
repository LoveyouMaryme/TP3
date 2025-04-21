import java.time.LocalDateTime;

public class TestStatistiquesVehiculesLoues {

    public static void main(String[] args) {

        // 🔌 Type E: Electric cars with all sizes
        Vehicule vehiculeEP = new Vehicule('E', 'P', 22.5f, 14.5f);
        VehiculeLoue locationEP1 = new VehiculeLoue(vehiculeEP, LocalDateTime.now(), 5, 5);
        VehiculeLoue locationEP2 = new VehiculeLoue(vehiculeEP, LocalDateTime.now(), 5, 5);
        VehiculeLoue locationEP3 = new VehiculeLoue(vehiculeEP, LocalDateTime.now(), 5, 5);
        StatistiquesVehiculesLoues.augmenterNbVehiculesLoues(locationEP1);
        StatistiquesVehiculesLoues.augmenterNbVehiculesLoues(locationEP2);
        StatistiquesVehiculesLoues.augmenterNbVehiculesLoues(locationEP3);

        Vehicule vehiculeEG = new Vehicule('E', 'G', 22.5f, 14.5f);
        VehiculeLoue locationEG = new VehiculeLoue(vehiculeEG, LocalDateTime.now(), 3, 5);
        StatistiquesVehiculesLoues.augmenterNbVehiculesLoues(locationEG);

        Vehicule vehiculeEI = new Vehicule('E', 'I', 22.5f, 14.5f);
        VehiculeLoue locationEI = new VehiculeLoue(vehiculeEI, LocalDateTime.now(), 4, 5);
        StatistiquesVehiculesLoues.augmenterNbVehiculesLoues(locationEI);

        // 🌱 Type H: Hybrid cars with all sizes
        Vehicule vehiculeHP = new Vehicule('H', 'P', 22.5f, 14.5f);
        VehiculeLoue locationHP = new VehiculeLoue(vehiculeHP, LocalDateTime.now(), 1, 5);
        StatistiquesVehiculesLoues.augmenterNbVehiculesLoues(locationHP);

        Vehicule vehiculeHI = new Vehicule('H', 'I', 22.5f, 14.5f);
        VehiculeLoue locationHI = new VehiculeLoue(vehiculeHI, LocalDateTime.now(), 2, 5);
        StatistiquesVehiculesLoues.augmenterNbVehiculesLoues(locationHI);

        Vehicule vehiculeHG = new Vehicule('H', 'G', 22.5f, 14.5f);
        VehiculeLoue locationHG = new VehiculeLoue(vehiculeHG, LocalDateTime.now(), 3, 5);
        StatistiquesVehiculesLoues.augmenterNbVehiculesLoues(locationHG);

        // 🖨️ Results
        System.out.println("Nombre de véhicules loués:");
        System.out.println("E-P: " + StatistiquesVehiculesLoues.obtenirNbVehiculesLoues('E', 'P'));
        System.out.println("E-G: " + StatistiquesVehiculesLoues.obtenirNbVehiculesLoues('E', 'G'));
        System.out.println("E-I: " + StatistiquesVehiculesLoues.obtenirNbVehiculesLoues('E', 'I'));

        System.out.println("H-P: " + StatistiquesVehiculesLoues.obtenirNbVehiculesLoues('H', 'P'));
        System.out.println("H-I: " + StatistiquesVehiculesLoues.obtenirNbVehiculesLoues('H', 'I'));
        System.out.println("H-G: " + StatistiquesVehiculesLoues.obtenirNbVehiculesLoues('H', 'G'));

        StatistiquesVehiculesLoues.afficherNbVehiculesLoues();
    }
}
