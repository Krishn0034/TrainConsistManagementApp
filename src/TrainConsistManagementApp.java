import java.util.regex.Pattern;

public class TrainConsistManagementApp {

    // Regex Rules:
    // Train ID: Starts with "TRN-", followed by exactly 4 digits
    private static final String TRAIN_ID_REGEX = "^TRN-\\d{4}$";

    // Cargo Code: 3 uppercase letters, a hyphen, and 2 uppercase letters (e.g., PET-AB)
    private static final String CARGO_CODE_REGEX = "^[A-Z]{3}-[A-Z]{2}$";

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" UC11 - Validate Train ID & Cargo Codes ");
        System.out.println("==========================================\n");

        // Sample Inputs
        String trainID = "TRN-1234";
        String cargoCode = "PET-AB";

        System.out.println("Validating Train ID: " + trainID + " -> " + isValidTrainID(trainID));
        System.out.println("Validating Cargo Code: " + cargoCode + " -> " + isValidCargoCode(cargoCode));

        // Invalid Examples
        System.out.println("Validating Invalid ID: TRN-123 -> " + isValidTrainID("TRN-123"));
        System.out.println("Validating Invalid Cargo: PET-ab -> " + isValidCargoCode("PET-ab"));

        System.out.println("\nUC11 validation completed...");
    }

    // Logic for Train ID validation
    public static boolean isValidTrainID(String id) {
        return id != null && Pattern.matches(TRAIN_ID_REGEX, id);
    }

    // Logic for Cargo Code validation
    public static boolean isValidCargoCode(String code) {
        return code != null && Pattern.matches(CARGO_CODE_REGEX, code);
    }
}