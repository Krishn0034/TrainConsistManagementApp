import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {

    // Bogie model class
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " (" + capacity + " seats)";
        }
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" UC10 - Count Total Seats (reduce) ");
        System.out.println("==========================================\n");

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        System.out.println("Train Composition:");
        bogies.forEach(System.out::println);

        // Functional Aggregation using map and reduce
        int totalSeats = calculateTotalSeats(bogies);

        System.out.println("\n------------------------------------------");
        System.out.println("Total Seating Capacity: " + totalSeats);
        System.out.println("------------------------------------------");

        System.out.println("\nUC10 aggregation completed...");
    }

    // Static method for logic and JUnit testing
    public static int calculateTotalSeats(List<Bogie> list) {
        return list.stream()
                .map(b -> b.capacity)           // Transform Bogie to Integer
                .reduce(0, Integer::sum);       // Sum all integers, starting from 0
    }
}