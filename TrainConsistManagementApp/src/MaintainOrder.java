import java.util.*;

// Train Class
class Train {
    private String trainName;
    private LinkedHashSet<String> formation;  // Maintains order + uniqueness

    public Train(String trainName) {
        this.trainName = trainName;
        this.formation = new LinkedHashSet<>();
    }

    // Add Bogie
    public void addBogie(String bogie) {
        if (formation.add(bogie)) {
            System.out.println("Added: " + bogie);
        } else {
            System.out.println("Duplicate ignored: " + bogie);
        }
    }

    // Display Formation
    public void displayFormation() {
        System.out.println("\n🚆 Train: " + trainName);
        System.out.println("Final Formation (Insertion Order Preserved):");

        for (String bogie : formation) {
            System.out.print(bogie + " -> ");
        }
        System.out.println("END");
    }
}

// Main Class
public class UC5_TrainConsist {
    public static void main(String[] args) {

        Train train = new Train("Chennai Express");

        // Add bogies
        train.addBogie("Engine");
        train.addBogie("Sleeper");
        train.addBogie("Cargo");
        train.addBogie("Guard");

        // Intentional duplicate
        train.addBogie("Sleeper");

        // Display formation
        train.displayFormation();
    }
}
