package week9.online_hackathon_submission_evaluator;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Boolean> r1 = Map.of(1, true, 2, true, 3, false);
        Map<Integer, Boolean> r2 = Map.of(1, true, 2, true, 3, true);

        Participant p1 = new Participant("Alice", LocalDateTime.now().minusHours(1), r1);
        Participant p2 = new Participant("Bob", LocalDateTime.now().minusHours(2), r2);

        List<Participant> participants = new ArrayList<>();
        participants.add(p1);
        participants.add(p2);

        try {
            HackathonEvaluator.evaluate(participants);
        } catch (LateSubmissionException e) {
            System.out.println(e.getMessage());
        }
    }
}
