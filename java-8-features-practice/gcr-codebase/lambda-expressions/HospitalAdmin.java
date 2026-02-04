package lambda_expressions;
import java.util.*;
import java.util.stream.Collectors;

class Patient {
    private String id;
    private String name;

    Patient(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() { return id; }
    public String getName() { return name; }
}

public class HospitalAdmin {
    public static void main(String[] args) {
        List<Patient> patients = Arrays.asList(
            new Patient("P-101", "Alice Smith"),
            new Patient("P-102", "Bob Johnson"),
            new Patient("P-103", "Charlie Davis"),
            new Patient("P-104", "Diana Prince")
        );

        System.out.println("--- Patient ID Verification List ---");

        // Step 1: Extract IDs using Method Reference (ClassName::methodName)
        // Step 2: Print each ID using Method Reference (Instance::methodName)
        patients.stream()
                .map(Patient::getId)          // Method reference to getter
                .forEach(System.out::println); // Method reference to println
    }
}