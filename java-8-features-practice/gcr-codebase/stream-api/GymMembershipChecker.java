package stream_api;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

class GymMember {
    private String name;
    private LocalDate expiryDate;

    public GymMember(String name, LocalDate expiryDate) {
        this.name = name;
        this.expiryDate = expiryDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return name + " (Expires on: " + expiryDate + ")";
    }
}

public class GymMembershipChecker {

    public static void main(String[] args) {

        List<GymMember> members = Arrays.asList(
            new GymMember("Rahul", LocalDate.now().plusDays(10)),
            new GymMember("Anita", LocalDate.now().plusDays(45)),
            new GymMember("Vikram", LocalDate.now().plusDays(25)),
            new GymMember("Sneha", LocalDate.now().minusDays(5)),
            new GymMember("Karan", LocalDate.now().plusDays(30))
        );

        LocalDate today = LocalDate.now();
        LocalDate next30Days = today.plusDays(30);

        List<GymMember> expiringSoon =
            members.stream()
                   .filter(m ->
                       !m.getExpiryDate().isBefore(today) &&
                        m.getExpiryDate().isBefore(next30Days.plusDays(1))
                   )
                   .collect(Collectors.toList());

        expiringSoon.forEach(System.out::println);
    }
}
