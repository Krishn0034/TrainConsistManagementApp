import java.util.*;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // Welcome Banner
        System.out.println("===================================");
        System.out.println("=== Train Consist Management App ===");
        System.out.println("===================================\n");

        // Create dynamic list for train consist
        List<String> trainConsist = new ArrayList<>();

        // Initialization message
        System.out.println("Train initialized successfully...");

        // Display initial bogie count
        System.out.println("Initial Bogie Count : " + trainConsist.size());

        // Display current train consist
        System.out.println("Current Train Consist : " + trainConsist);

        System.out.println("\nSystem ready for operations...");
    }
}