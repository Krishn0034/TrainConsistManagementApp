import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " (" + capacity + ")";
        }
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" UC16 - Manual Bubble Sort Implementation ");
        System.out.println("==========================================\n");

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));
        bogies.add(new Bogie("AC Chair", 56));

        System.out.println("Before Manual Sorting:");
        bogies.forEach(System.out::println);

        // Perform Bubble Sort
        bubbleSort(bogies);

        System.out.println("\nAfter Bubble Sort (Ascending Capacity):");
        bogies.forEach(System.out::println);
    }

    /**
     * Manual Bubble Sort Algorithm
     * Time Complexity: O(n^2)
     */
    public static void bubbleSort(List<Bogie> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Compare adjacent bogie capacities
                if (list.get(j).capacity > list.get(j + 1).capacity) {
                    // Swap the bogies
                    Bogie temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }
}