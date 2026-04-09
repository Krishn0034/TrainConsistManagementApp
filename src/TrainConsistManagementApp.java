import java.util.Arrays;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" UC19 - Binary Search (Optimized) ");
        System.out.println("==========================================\n");

        // 1. Dataset must be SORTED for Binary Search to work
        String[] consistIds = {"B-909", "B-105", "B-707", "B-202", "B-303"};
        Arrays.sort(consistIds);

        String targetId = "B-707";

        System.out.println("Sorted Consist IDs: " + Arrays.toString(consistIds));
        System.out.println("Searching for: " + targetId);

        // 2. Perform Binary Search
        int resultIndex = binarySearchBogie(consistIds, targetId);

        if (resultIndex != -1) {
            System.out.println("\nSUCCESS: Bogie found at sorted index: " + resultIndex);
        } else {
            System.out.println("\nFAILURE: Bogie " + targetId + " not found.");
        }
    }

    /**
     * Binary Search Implementation (Divide and Conquer)
     * Time Complexity: O(log n)
     */
    public static int binarySearchBogie(String[] array, String target) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = array[mid].compareTo(target);

            if (comparison == 0) {
                return mid; // Found!
            } else if (comparison < 0) {
                low = mid + 1; // Target is in the right half
            } else {
                high = mid - 1; // Target is in the left half
            }
        }
        return -1; // Not found
    }
}