import java.util.LinkedHashSet;
import java.util.Set;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("UC5 - Preserve Insertion Order of Bogies");
        System.out.println("==========================================\n");

        // LinkedHashSet preserves insertion order and ensures uniqueness
        Set<String> formation = new LinkedHashSet<>();

        // 1. Attach bogies in order
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");

        // 2. Attempt to add a duplicate bogie (will be ignored)
        formation.add("Sleeper");

        // 3. Display the final formation
        System.out.println("Final Train Formation:");
        System.out.println(formation);

        System.out.println("\nNote:");
        System.out.println("LinkedHashSet preserves insertion order and removes duplicates automatically.");

        System.out.println("\nUC5 formation setup completed...");
    }
}