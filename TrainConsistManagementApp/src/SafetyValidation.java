import java.util.*;
import java.util.stream.*;

// Bogie Class (Goods)
class GoodsBogie {
    String type;    // e.g., Cylindrical, Box
    String cargo;   // e.g., Petroleum, Coal

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return type + " (" + cargo + ")";
    }
}

// Main Class
public class UC12_SafetyCheck {
    public static void main(String[] args) {

        // Step 1: Create goods bogies list
        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Box", "Coal"));
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));

        // Step 2–4: Stream → allMatch() → validation logic
        boolean isSafe = bogies.stream()
                .allMatch(b ->
                        // Rule: Cylindrical bogies can carry only Petroleum
                        !(b.type.equals("Cylindrical") && !b.cargo.equals("Petroleum"))
                );

        // Step 5: Display result
        if (isSafe) {
            System.out.println("✅ Train is SAFETY COMPLIANT");
        } else {
            System.out.println("❌ Train is NOT SAFE");
        }

        // Program continues...
    }
}