import java.util.regex.*;
import java.util.*;

// Main Class
public class UC11_Validation {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Step 1: Define Regex Patterns
        String trainRegex = "TRN-\\d{4}";
        String cargoRegex = "PET-[A-Z]{2}";

        // Step 2: Compile Patterns
        Pattern trainPattern = Pattern.compile(trainRegex);
        Pattern cargoPattern = Pattern.compile(cargoRegex);

        // Step 3: Take User Input
        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainInput = sc.nextLine();

        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoInput = sc.nextLine();

        // Step 4: Create Matchers
        Matcher trainMatcher = trainPattern.matcher(trainInput);
        Matcher cargoMatcher = cargoPattern.matcher(cargoInput);

        // Step 5: Validate using matches()
        if (trainMatcher.matches()) {
            System.out.println("✅ Valid Train ID");
        } else {
            System.out.println("❌ Invalid Train ID");
        }

        if (cargoMatcher.matches()) {
            System.out.println("✅ Valid Cargo Code");
        } else {
            System.out.println("❌ Invalid Cargo Code");
        }

        // Program continues...
        sc.close();
    }
}