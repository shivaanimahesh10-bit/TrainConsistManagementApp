import java.util.*;

// Train Class
class Train {
    private String trainName;
    private Set<String> bogieSet;   // Using Set interface

    public Train(String trainName) {
        this.trainName = trainName;
        this.bogieSet = new HashSet<>();  // HashSet implementation
    }

    // Add Bogie ID
    public void addBogie(String bogieId) {
        if (bogieSet.add(bogieId)) {
            System.out.println("Added: " + bogieId);
        } else {
            System.out.println("Duplicate ignored: " + bogieId);
        }
    }

    // Display Unique Bogies
    public void displayBogies() {
        System.out.println("\nTrain: " + trainName);
        System.out.println("Unique Bogie IDs:");

        for (String id : bogieSet) {
            System.out.println(id);
        }
    }
}

// Main Class
public class UC3_TrainConsist {
    public static void main(String[] args) {

        Train train = new Train("Chennai Express");

        // User input simulation
        train.addBogie("B1");
        train.addBogie("B2");
        train.addBogie("B3");
        train.addBogie("B2"); // duplicate
        train.addBogie("B1"); // duplicate

        // Display result
        train.displayBogies();
    }
}