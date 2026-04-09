// Custom Runtime Exception for safety violations
class SafetyViolationException extends Exception {
    public SafetyViolationException(String message) {
        super(message);
    }
}

public class TrainConsistManagementApp {

    static class GoodsBogie {
        String id;
        String shape;
        String currentCargo = "Empty";

        GoodsBogie(String id, String shape) {
            this.id = id;
            this.shape = shape;
        }

        // Method that validates safety at runtime
        public void assignCargo(String cargo) throws SafetyViolationException {
            System.out.println("[System] Attempting to assign " + cargo + " to " + id + " (" + shape + ")...");

            if (shape.equals("Rectangular") && cargo.equals("Petroleum")) {
                throw new SafetyViolationException("CRITICAL: Rectangular bogies cannot carry liquid Petroleum!");
            }

            this.currentCargo = cargo;
            System.out.println("[System] Cargo assigned successfully.");
        }
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" UC15 - try-catch-finally Safety Check ");
        System.out.println("==========================================\n");

        GoodsBogie bogie = new GoodsBogie("GB-505", "Rectangular");

        try {
            // This will trigger the exception
            bogie.assignCargo("Petroleum");
        } catch (SafetyViolationException e) {
            System.err.println("[Error] Safety Policy Violated: " + e.getMessage());
        } finally {
            // This runs NO MATTER WHAT (success or failure)
            System.out.println("[Finally] Closing assignment logs and updating database status...");
            System.out.println("[Status] Current Cargo State: " + bogie.currentCargo);
        }

        System.out.println("\nUC15 structured handling completed...");
    }
}