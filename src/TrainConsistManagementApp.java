import java.util.Arrays;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" UC17 - Alphabetical Sort (Arrays.sort) ");
        System.out.println("==========================================\n");

        // 1. Create an array of bogie names
        String[] bogieNames = {
                "Sleeper",
                "AC Chair",
                "First Class",
                "General",
                "Cylindrical",
                "Rectangular"
        };

        System.out.println("Before Sorting:");
        System.out.println(Arrays.toString(bogieNames));

        // 2. Use Java's built-in Dual-Pivot Quicksort
        sortBogieNames(bogieNames);

        System.out.println("\nAfter Alphabetical Sorting:");
        System.out.println(Arrays.toString(bogieNames));

        System.out.println("\nUC17 sorting completed...");
    }

    /**
     * Sorts the provided array of names alphabetically.
     * Efficiency: O(n log n)
     */
    public static void sortBogieNames(String[] names) {
        if (names != null) {
            Arrays.sort(names);
        }
    }
}