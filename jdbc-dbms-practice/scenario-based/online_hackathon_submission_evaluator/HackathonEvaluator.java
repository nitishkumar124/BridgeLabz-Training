package week9.online_hackathon_submission_evaluator;
import java.time.LocalDateTime;
import java.util.*;

public class HackathonEvaluator {

    private static final LocalDateTime DEADLINE = LocalDateTime.of(2026, 2, 16, 23, 59);

    public static void evaluate(List<Participant> participants) throws LateSubmissionException {
        for (Participant p : participants) {
            if (p.getSubmissionTime().isAfter(DEADLINE)) {
                throw new LateSubmissionException("Late submission by: " + p.getName());
            }
        }

        participants.sort(Comparator
                .comparingInt(Participant::calculateScore)
                .reversed());

        System.out.println("Leaderboard:");
        int rank = 1;
        for (Participant p : participants) {
            System.out.println(rank++ + ". " + p.getName() + " - Score: " + p.calculateScore());
        }
    }
}
