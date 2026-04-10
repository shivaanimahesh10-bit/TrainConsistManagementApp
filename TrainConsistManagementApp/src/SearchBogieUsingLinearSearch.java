import java.util.*;

public class UC18_LinearSearch {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Step 1: Create array of bogie IDs
        String[] bogieIds = {"B1", "B3", "B7", "B2", "B9"};

        // Step 2: Take search input
        System.out.print("Enter Bogie ID to search: ");
        String key = sc.nextLine();

        // Step 3–5: Linear Search
        boolean found = false;

        for (int i = 0; i < bogieIds.length; i++) {
            if (bogieIds[i].equals(key)) {   // safe string comparison
                System.out.println("✅ Bogie Found at position: " + i);
                found = true;
                break;  // Early termination
            }
        }

        // Step 6: If not found
        if (!found) {
            System.out.println("❌ Bogie ID not found");
        }

        // Program continues...
        sc.close();
    }
}