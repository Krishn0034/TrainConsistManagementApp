import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TrainConsistManagementApp {

    // Bogie model class
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        public String getName() { return name; }

        @Override
        public String toString() {
            return "Bogie{name='" + name + "', capacity=" + capacity + "}";
        }
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" UC9 - Group Bogies by Type (groupingBy) ");
        System.out.println("==========================================\n");

        // 1. Create a list with multiple bogies of the same type
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("AC Chair", 56));

        System.out.println("Original Flat List of Bogies:");
        bogies.forEach(System.out::println);

        // 2. Group bogies by their name using Collectors.groupingBy
        Map<String, List<Bogie>> groupedBogies = groupBogiesByType(bogies);

        // 3. Display the structured grouped result
        System.out.println("\nGrouped Bogie Report:");
        groupedBogies.forEach((type, list) -> {
            System.out.println(type + ": " + list);
        });

        System.out.println("\nUC9 grouping operations completed...");
    }

    // Helper method for logic and JUnit testing
    public static Map<String, List<Bogie>> groupBogiesByType(List<Bogie> list) {
        return list.stream()
                .collect(Collectors.groupingBy(Bogie::getName));
    }
}