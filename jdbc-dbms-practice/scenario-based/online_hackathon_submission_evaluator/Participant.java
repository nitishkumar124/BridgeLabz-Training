package week9.online_hackathon_submission_evaluator;
import java.time.LocalDateTime;
import java.util.Map;

public class Participant {
    private String name;
    private LocalDateTime submissionTime;
    private Map<Integer, Boolean> testResults;

    public Participant(String name, LocalDateTime submissionTime, Map<Integer, Boolean> testResults) {
        this.name = name;
        this.submissionTime = submissionTime;
        this.testResults = testResults;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getSubmissionTime() {
        return submissionTime;
    }

    public Map<Integer, Boolean> getTestResults() {
        return testResults;
    }

    public int calculateScore() {
        int score = 0;
        for (boolean passed : testResults.values()) {
            if (passed) score += 10;   // 10 points per test case
        }
        return score;
    }
}
