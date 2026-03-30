package week2;

import java.util.*;

public class ResultProcessor {
	// Store scores of multiple users
	private List<Integer> scoreHistory = new ArrayList<>();

	// String[] for correct and user answers
	private String[] answerKey = { "A", "B", "D", "C", "A" };

	public static void main(String[] args) {
		ResultProcessor processor = new ResultProcessor();

		try {
			// Correct submission
			String[] user1 = { "A", "B", "C", "C", "A" };
			processor.processSubmission(user1);

			// Invalid submission
			String[] user2 = { "A", "B" };
			processor.processSubmission(user2);

		} catch (InvalidQuizSubmissionException e) {
			System.out.println("Submission Error: " + e.getMessage());
		}
	}

	public void processSubmission(String[] userAnswers) throws InvalidQuizSubmissionException {
		// Validate input
		if (userAnswers.length != answerKey.length) {
			throw new InvalidQuizSubmissionException(
					"Submitted " + userAnswers.length + " answers, but expected " + answerKey.length);
		}

		int score = calculateScore(userAnswers);
		String grade = determineGrade(score, answerKey.length);

		// Store scores
		scoreHistory.add(score);

		System.out.println("Quiz Processed!");
		System.out.println("Score: " + score + "/" + answerKey.length);
		System.out.println("Grade: " + grade);
		System.out.println("Total submissions stored: " + scoreHistory.size());
	}

	// compare answers and calculate score
	private int calculateScore(String[] userAnswers) {
		int currentScore = 0;
		for (int i = 0; i < answerKey.length; i++) {
			if (userAnswers[i].equalsIgnoreCase(answerKey[i])) {
				currentScore++;
			}
		}
		return currentScore;
	}

	// Grade
	private String determineGrade(int score, int total) {
		double percentage = ((double) score / total) * 100;
		if (percentage >= 90)
			return "A";
		if (percentage >= 75)
			return "B";
		if (percentage >= 50)
			return "C";
		return "F";
	}
}

// Custom Exception for validation
class InvalidQuizSubmissionException extends Exception {
	public InvalidQuizSubmissionException(String message) {
		super(message);
	}
}
