import java.util.*;

// Step 1: Custom Runtime Exception
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

// Step 2: Goods Bogie Class
class GoodsBogie {
    String shape;   // Cylindrical / Rectangular
    String cargo;

    public GoodsBogie(String shape) {
        this.shape = shape;
    }

    // Assign cargo with safety validation
    public void assignCargo(String cargo) {
        try {
            // Rule: Petroleum only allowed in Cylindrical
            if (shape.equals("Rectangular") && cargo.equals("Petroleum")) {
                throw new CargoSafetyException(
                        "Unsafe assignment: Petroleum cannot be loaded in Rectangular bogie"
                );
            }

            this.cargo = cargo;
            System.out.println("✅ Cargo assigned: " + cargo + " → " + shape);

        } catch (CargoSafetyException e) {
            System.out.println("❌ Error: " + e.getMessage());

        } finally {
            System.out.println("ℹ Operation completed for bogie: " + shape);
        }
    }
}

// Main Class
public class UC15_ExceptionHandling {
    public static void main(String[] args) {

        // Step 1: Create bogies
        GoodsBogie b1 = new GoodsBogie("Cylindrical");
        GoodsBogie b2 = new GoodsBogie("Rectangular");

        // Step 2: Assign cargo
        b1.assignCargo("Petroleum");   // Valid
        b2.assignCargo("Coal");        // Valid
        b2.assignCargo("Petroleum");   // Invalid (will trigger exception)

        // Program continues safely
        System.out.println("\n🚆 System running normally after handling errors...");
    }
}