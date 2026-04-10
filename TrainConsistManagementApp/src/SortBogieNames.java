import java.util.*;

public class UC17_ArraySort {
    public static void main(String[] args) {

        // Step 1: Create array of bogie types
        String[] bogieTypes = {"Sleeper", "AC Chair", "First Class", "General", "Cargo"};

        // Before sorting
        System.out.println("Before Sorting:");
        System.out.println(Arrays.toString(bogieTypes));

        // Step 2: Sort using Arrays.sort()
        Arrays.sort(bogieTypes);

        // Step 3: Display sorted result
        System.out.println("\nAfter Sorting (Alphabetical):");
        System.out.println(Arrays.toString(bogieTypes));

        // Program continues...
    }
}