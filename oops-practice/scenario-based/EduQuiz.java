package week2;

import java.util.*;

public class EduQuiz {
	static int calculateScore(String[] correct, String[] student) {
		int score = 0;
		for (int i = 0; i < correct.length; i++) {
			if (correct[i].equalsIgnoreCase(student[i])) {
				score++;
				System.out.println("Question " + (i + 1) + ": Correct");
			} else {
				System.out.println("Question " + (i + 1) + ": Incorrect");
			}
		}
		return score;
	}

	public static void main(String[] args) {
		String[] correctAnswers = { "A", "B", "C", "D", "A", "D", "C", "B", "A", "C" };
		String[] studentAnswers = { "a", "B", "d", "D", "A", "b", "C", "A", "A", "B" };
		int score = calculateScore(correctAnswers, studentAnswers);
		double percentage = (score / 10.0) * 100;
		System.out.println("Total Score: " + score + "/10");
		System.out.println("Percentage: " + percentage + "%");
		if (percentage >= 50) {
			System.out.println("Result: Pass");
		} else {
			System.out.println("Result: Fail");
		}
	}
}