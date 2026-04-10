import java.util.*;

// Main Class
public class UC6_TrainMapping {
    public static void main(String[] args) {

        // Step 1: Create HashMap
        HashMap<String, Integer> bogieCapacity = new HashMap<>();

        // Step 2: Insert mappings using put()
        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 50);
        bogieCapacity.put("First Class", 24);

        // Step 3: Iterate using entrySet()
        System.out.println("🚆 Bogie Capacity Details:");

        for (Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            System.out.println(
                    "Bogie: " + entry.getKey() +
                            " | Capacity: " + entry.getValue()
            );
        }

        // Program continues (no interruption)
    }
}
