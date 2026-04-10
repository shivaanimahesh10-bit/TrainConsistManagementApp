import java.util.*;

public class UC19_BinarySearch {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Step 1: Sorted array of bogie IDs (IMPORTANT)
        String[] bogieIds = {"B1", "B2", "B3", "B5", "B7", "B9"};

        // Step 2: Take search key
        System.out.print("Enter Bogie ID to search: ");
        String key = sc.nextLine();

        // Step 3: Initialize low & high
        int low = 0;
        int high = bogieIds.length - 1;

        boolean found = false;

        // Step 4–6: Binary Search Loop
        while (low <= high) {

            int mid = (low + high) / 2;

            int result = key.compareTo(bogieIds[mid]);

            if (result == 0) {
                System.out.println("✅ Bogie Found at position: " + mid);
                found = true;
                break;
            }
            else if (result < 0) {
                high = mid - 1;  // Search left half
            }
            else {
                low = mid + 1;   // Search right half
            }
        }

        // Step 7: If not found
        if (!found) {
            System.out.println("❌ Bogie ID not found");
        }

        // Program continues...
        sc.close();
    }
}