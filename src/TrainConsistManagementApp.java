import java.util.*;

// Coach Class
class Coach {
    protected String coachId;
    protected String coachType;

    public Coach(String coachId, String coachType) {
        this.coachId = coachId;
        this.coachType = coachType;
    }

    public String getCoachId() {
        return coachId;
    }

    @Override
    public String toString() {
        return coachId + " (" + coachType + ")";
    }
}

// Passenger Coach (Bogies)
class PassengerCoach extends Coach {
    private int capacity;

    public PassengerCoach(String coachId, String coachType, int capacity) {
        super(coachId, coachType);
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return coachId + " (" + coachType + ", Capacity: " + capacity + ")";
    }
}

// Train Class using LinkedList
class Train {
    private String trainName;
    private LinkedList<PassengerCoach> coaches;

    public Train(String trainName) {
        this.trainName = trainName;
        this.coaches = new LinkedList<>();
    }

    // Prevent duplicate IDs
    private boolean isDuplicate(String id) {
        for (PassengerCoach c : coaches) {
            if (c.getCoachId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    // Add at end
    public void addCoachAtEnd(PassengerCoach coach) {
        if (isDuplicate(coach.getCoachId())) {
            System.out.println("⚠ Duplicate Coach ID not allowed");
            return;
        }
        coaches.addLast(coach);
    }

    // Add at front
    public void addCoachAtFront(PassengerCoach coach) {
        if (isDuplicate(coach.getCoachId())) {
            System.out.println("⚠ Duplicate Coach ID not allowed");
            return;
        }
        coaches.addFirst(coach);
    }

    // Add at specific position
    public void addCoachAtPosition(int position, PassengerCoach coach) {
        if (isDuplicate(coach.getCoachId())) {
            System.out.println("⚠ Duplicate Coach ID not allowed");
            return;
        }

        if (position < 0 || position > coaches.size()) {
            System.out.println("❌ Invalid Position");
            return;
        }

        coaches.add(position, coach);
    }

    // Display
    public void displayTrain() {
        System.out.println("\n🚆 Train: " + trainName);
        System.out.println("Total Bogies: " + coaches.size());

        int i = 1;
        for (PassengerCoach c : coaches) {
            System.out.println(i++ + ". " + c);
        }
    }
}

// Main Class
public class TrainConsistAppUC2 {
    public static void main(String[] args) {

        Train train = new Train("Chennai Express");

        // Add bogies
        train.addCoachAtEnd(new PassengerCoach("B1", "Sleeper", 72));
        train.addCoachAtEnd(new PassengerCoach("B2", "AC", 48));

        // Add at front
        train.addCoachAtFront(new PassengerCoach("B0", "General", 90));

        // Add at specific position
        train.addCoachAtPosition(1, new PassengerCoach("B1A", "Chair Car", 60));

        // Duplicate test
        train.addCoachAtEnd(new PassengerCoach("B2", "AC", 48));

        // Display train
        train.displayTrain();
    }
}