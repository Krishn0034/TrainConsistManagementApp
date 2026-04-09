class EmptyConsistException extends Exception {
    public EmptyConsistException(String message) {
        super(message);
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" UC20 - Fail-Fast Search Validation ");
        System.out.println("==========================================\n");

        // Scenario: Empty train consist
        String[] emptyConsist = {};
        String targetId = "B-101";

        try {
            System.out.println("[System] Initiating search for " + targetId + "...");
            int index = secureSearch(emptyConsist, targetId);
            System.out.println("Result: Found at index " + index);
        } catch (EmptyConsistException e) {
            System.err.println("[Critical Error] " + e.getMessage());
        } finally {
            System.out.println("[System] Search operation lifecycle ended.");
        }
    }

    /**
     * Performs a search but validates the state of the array first.
     * Throws EmptyConsistException if the array is null or empty.
     */
    public static int secureSearch(String[] array, String target) throws EmptyConsistException {
        // Fail-Fast Validation
        if (array == null || array.length == 0) {
            throw new EmptyConsistException("Search aborted: The train consist is empty!");
        }

        // Standard Linear Search logic (from UC18)
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }
}