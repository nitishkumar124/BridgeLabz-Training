package lambda_expressions;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Alert {
    String type;     // e.g., "VITAL", "ADMIN", "LAB"
    int urgency;     // 1 (Low) to 5 (Critical)
    String message;

    Alert(String type, int urgency, String message) {
        this.type = type;
        this.urgency = urgency;
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("[%s] Priority %d: %s", type, urgency, message);
    }
}

public class HospitalNotifications {
    public static void main(String[] args) {
        List<Alert> alertStream = Arrays.asList(
            new Alert("VITAL", 5, "Patient in Room 302: Heart rate high!"),
            new Alert("ADMIN", 1, "Shift schedule updated for next week."),
            new Alert("LAB", 3, "Blood test results ready for Room 105."),
            new Alert("VITAL", 4, "Oxygen saturation drop in Room 202."),
            new Alert("ADMIN", 2, "Cafeteria is now closed.")
        );

        // 1. Predicate for Critical Vitals Only (ER Doctor)
        Predicate<Alert> erFilter = a -> a.type.equals("VITAL") && a.urgency >= 4;

        // 2. Predicate for Administrative updates (Office Staff)
        Predicate<Alert> adminFilter = a -> a.type.equals("ADMIN");

        // 3. Predicate for All Clinical Alerts (Nurses)
        Predicate<Alert> clinicalFilter = a -> !a.type.equals("ADMIN");

        System.out.println("--- ER DOCTOR'S FEED ---");
        filterAndDisplay(alertStream, erFilter);

        System.out.println("\n--- NURSING STATION FEED ---");
        filterAndDisplay(alertStream, clinicalFilter);
    }

    public static void filterAndDisplay(List<Alert> alerts, Predicate<Alert> condition) {
        alerts.stream()
              .filter(condition)
              .forEach(System.out::println);
    }
}