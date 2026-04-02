public class TrainConsistManagementApp {import java.util.*;

    // Coach Class
    class Coach {
        private String coachId;
        private String coachType;

        public Coach(String coachId, String coachType) {
            this.coachId = coachId;
            this.coachType = coachType;
        }

        public String getCoachId() {
            return coachId;
        }

        public String getCoachType() {
            return coachType;
        }

        @Override
        public String toString() {
            return coachId + " (" + coachType + ")";
        }
    }

    // Train Class
    class Train {
        private String trainName;
        private List<Coach> coaches;

        public Train(String trainName) {
            this.trainName = trainName;
            this.coaches = new ArrayList<>();
        }

        // Add coach to train
        public void addCoach(Coach coach) {
            // Prevent duplicate coach IDs
            for (Coach c : coaches) {
                if (c.getCoachId().equals(coach.getCoachId())) {
                    System.out.println("⚠ Duplicate Coach ID not allowed: " + coach.getCoachId());
                    return;
                }
            }
            coaches.add(coach);
        }

        // Display consist summary
        public void displaySummary() {
            System.out.println("\n🚆 Train: " + trainName);
            System.out.println("Total Coaches: " + coaches.size());

            if (coaches.isEmpty()) {
                System.out.println("No coaches attached.");
                return;
            }

            System.out.println("Coach Sequence:");
            for (int i = 0; i < coaches.size(); i++) {
                System.out.println((i + 1) + ". " + coaches.get(i));
            }
        }
    }

    // Main Class
    public class TrainConsistApp {
        public static void main(String[] args) {

            // Initialize Train
            Train train = new Train("Chennai Express");

            // Add Coaches
            train.addCoach(new Coach("C1", "Sleeper"));
            train.addCoach(new Coach("C2", "AC"));
            train.addCoach(new Coach("C3", "General"));

            // Duplicate test
            train.addCoach(new Coach("C2", "AC"));

            // Display Summary
            train.displaySummary();
        }
    }
}
