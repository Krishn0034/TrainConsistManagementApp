public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" UC18 - Linear Search for Bogie ID ");
        System.out.println("==========================================\n");

        // 1. Unsorted list of IDs in the consist
        String[] consistIds = {"B-105", "B-202", "B-707", "B-303", "B-909"};
        String targetId = "B-707";

        System.out.println("Consist IDs: " + java.util.Arrays.toString(consistIds));
        System.out.println("Searching for: " + targetId);

        // 2. Perform Linear Search
        int resultIndex = findBogieIndex(consistIds, targetId);

        if (resultIndex != -1) {
            System.out.println("\nSUCCESS: Bogie found at position: " + resultIndex);
        } else {
            System.out.println("\nFAILURE: Bogie " + targetId + " not found in consist.");
        }
    }

    /**
     * Linear Search Implementation
     * Checks each element sequentially.
     * Time Complexity: O(n)
     */
    public static int findBogieIndex(String[] array, String target) {
        if (array == null || target == null) return -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(target)) {
                return i; // Target found, return the index
            }
        }
        return -1; // Target not found
    }
}