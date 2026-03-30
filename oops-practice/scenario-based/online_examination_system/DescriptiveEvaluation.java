package week2.online_examination_system;

import java.util.*;

public class DescriptiveEvaluation implements EvaluationStrategy {
	public int evaluate(Exam exam, Student student) {
		int score = 0;

		for (int i = 0; i < exam.questionCount; i++) {
			Question q = exam.questions[i];
			if (!q.isObjective() && student.answers[i] != null) {
				score++;
			}
		}
		return score;
	}
}
