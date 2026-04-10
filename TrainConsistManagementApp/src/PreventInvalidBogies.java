import java.util.*;

// Step 1: Custom Exception
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

// Step 2: Passenger Bogie Class
class PassengerBogie {
    String name;
    int capacity;

    // Constructor with validation
    public PassengerBogie(String name, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException(
                    "Invalid capacity for bogie: " + name + " (must be > 0)"
            );
        }
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return name + " (Capacity: " + capacity + ")";
    }
}

// Main Class
public class UC14_CustomException {
    public static void main(String[] args) {

        List<PassengerBogie> train = new ArrayList<>();

        try {
            // Valid bogies
            train.add(new PassengerBogie("Sleeper", 72));
            train.add(new PassengerBogie("AC Chair", 50));

            // Invalid bogie (will throw exception)
            train.add(new PassengerBogie("First Class", 0));

        } catch (InvalidCapacityException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }

        // Display valid bogies only
        System.out.println("\n🚆 Final Train Consist:");
        for (PassengerBogie b : train) {
            System.out.println(b);
        }

        // Program continues safely...
    }
}