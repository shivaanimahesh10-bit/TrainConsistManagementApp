import java.util.*;
import java.util.stream.*;

// Bogie Class (from UC7)
class Bogie {
    String name;
    int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return name + " (Capacity: " + capacity + ")";
    }
}

// Main Class
public class UC8_StreamFiltering {
    public static void main(String[] args) {

        // Step 1: Create list of bogies (reuse UC7 idea)
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 50));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        // Step 2–4: Stream → Filter → Collect
        List<Bogie> filteredBogies = bogies.stream()
                .filter(b -> b.capacity > 60)   // condition
                .collect(Collectors.toList());

        // Step 5: Display filtered bogies
        System.out.println("🚆 Bogies with Capacity > 60:");

        for (Bogie b : filteredBogies) {
            System.out.println(b);
        }

        // Program continues...
    }
}