// Custom Exception Class
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

public class TrainConsistManagementApp {

    static class PassengerBogie {
        String type;
        int capacity;

        // Constructor that throws Custom Exception
        PassengerBogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.type = type;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return type + " (Seats: " + capacity + ")";
        }
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" UC14 - Custom Exception Handling ");
        System.out.println("==========================================\n");

        try {
            // 1. Valid Creation
            PassengerBogie validBogie = new PassengerBogie("Sleeper", 72);
            System.out.println("Successfully Created: " + validBogie);

            // 2. Invalid Creation (This will jump to the catch block)
            System.out.println("Attempting to create bogie with -10 seats...");
            PassengerBogie invalidBogie = new PassengerBogie("AC Chair", -10);

        } catch (InvalidCapacityException e) {
            System.err.println("ALERT: " + e.getMessage());
        }

        System.out.println("\nUC14 exception handling completed...");
    }
}