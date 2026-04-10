import java.util.*;

public class UC16_BubbleSort {
    public static void main(String[] args) {

        // Step 1: Create array of capacities
        int[] capacities = {72, 50, 24, 90, 60};

        System.out.println("Before Sorting:");
        printArray(capacities);

        // Step 2–4: Bubble Sort Logic
        int n = capacities.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                // Compare adjacent elements
                if (capacities[j] > capacities[j + 1]) {

                    // Swap
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                }
            }
        }

        // Step 5: Display sorted array
        System.out.println("\nAfter Sorting:");
        printArray(capacities);

        // Program continues...
    }

    // Helper method to print array
    public static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}