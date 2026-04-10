import java.util.*;
import java.util.stream.*;

// Bogie Class
class Bogie {
    String name;
    int capacity;
    String category;

    public Bogie(String name, int capacity, String category) {
        this.name = name;
        this.capacity = capacity;
        this.category = category;
    }

    @Override
    public String toString() {
        return name + " (" + capacity + ")";
    }
}

// Main Class
public class UC9_Grouping {
    public static void main(String[] args) {

        // Step 1: Create list of bogies
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72, "Passenger"));
        bogies.add(new Bogie("AC Chair", 50, "Passenger"));
        bogies.add(new Bogie("First Class", 24, "Passenger"));
        bogies.add(new Bogie("Cargo", 100, "Goods"));
        bogies.add(new Bogie("Parcel", 80, "Goods"));

        // Step 2–4: Stream → Grouping
        Map<String, List<Bogie>> groupedBogies =
                bogies.stream()
                        .collect(Collectors.groupingBy(b -> b.category));

        // Step 5: Display grouped result
        System.out.println("🚆 Grouped Bogies:");

        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println("\nCategory: " + entry.getKey());

            for (Bogie b : entry.getValue()) {
                System.out.println(" - " + b);
            }
        }

        // Program continues...
    }
}
