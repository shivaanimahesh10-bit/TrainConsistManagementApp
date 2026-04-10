import java.util.*;

// Train Capacity Mapping Class
class TrainCapacity {
    private HashMap<String, Integer> bogieCapacityMap;

    public TrainCapacity() {
        bogieCapacityMap = new HashMap<>();
    }

    // Add bogie with capacity
    public void addBogie(String bogieName, int capacity) {
        bogieCapacityMap.put(bogieName, capacity);
        System.out.println("Mapped: " + bogieName + " -> " + capacity);
    }

    // Display all bogie capacities
    public void displayCapacities() {
        System.out.println("\n🚆 Bogie Capacity Details:");

        for (Map.Entry<String, Integer> entry : bogieCapacityMap.entrySet()) {
            System.out.println(
                    "Bogie: " + entry.getKey() +
                            " | Capacity: " + entry.getValue()
            );
        }
    }

    // Fast lookup (extra useful feature)
    public void getCapacity(String bogieName) {
        if (bogieCapacityMap.containsKey(bogieName)) {
            System.out.println("Capacity of " + bogieName + ": "
                    + bogieCapacityMap.get(bogieName));
        } else {
            System.out.println("Bogie not found: " + bogieName);
        }
    }
}

// Main Class
public class UC6_TrainConsist {
    public static void main(String[] args) {

        TrainCapacity train = new TrainCapacity();

        // Step 1: Insert mappings
        train.addBogie("Sleeper", 72);
        train.addBogie("AC Chair", 50);
        train.addBogie("First Class", 24);

        // Step 2: Display all mappings
        train.displayCapacities();

        // Step 3: Fast lookup example
        train.getCapacity("Sleeper");
    }
}
