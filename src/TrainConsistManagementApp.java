import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrainConsistManagementApp {

    static class GoodsBogie {
        String id;
        String shape; // "Cylindrical" or "Rectangular"
        String cargo; // "Petroleum", "Chemicals", "Coal", "Grain"

        GoodsBogie(String id, String shape, String cargo) {
            this.id = id;
            this.shape = shape;
            this.cargo = cargo;
        }

        @Override
        public String toString() {
            return String.format("[%s | %s | %s]", id, shape, cargo);
        }
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" UC12 - Safety Compliance Check (Goods) ");
        System.out.println("==========================================\n");

        List<GoodsBogie> inventory = new ArrayList<>();
        inventory.add(new GoodsBogie("GB-101", "Cylindrical", "Petroleum")); // Valid
        inventory.add(new GoodsBogie("GB-102", "Rectangular", "Coal"));      // Valid
        inventory.add(new GoodsBogie("GB-103", "Cylindrical", "Coal"));      // INVALID (Safety Risk)
        inventory.add(new GoodsBogie("GB-104", "Rectangular", "Petroleum")); // INVALID (Leak Risk)

        System.out.println("Inventory Before Safety Check:");
        inventory.forEach(System.out::println);

        // Filter valid bogies based on business safety rules
        List<GoodsBogie> safeBogies = inventory.stream()
                .filter(TrainConsistManagementApp::isSafetyCompliant)
                .collect(Collectors.toList());

        System.out.println("\nSafe & Compliant Bogies:");
        safeBogies.forEach(System.out::println);

        System.out.println("\nUC12 safety validation completed...");
    }

    /**
     * Business Rule:
     * 1. Cylindrical bogies MUST carry liquids (Petroleum/Chemicals).
     * 2. Rectangular bogies MUST carry solids (Coal/Grain).
     */
    public static boolean isSafetyCompliant(GoodsBogie bogie) {
        if (bogie.shape.equalsIgnoreCase("Cylindrical")) {
            return bogie.cargo.equals("Petroleum") || bogie.cargo.equals("Chemicals");
        } else if (bogie.shape.equalsIgnoreCase("Rectangular")) {
            return bogie.cargo.equals("Coal") || bogie.cargo.equals("Grain");
        }
        return false;
    }
}