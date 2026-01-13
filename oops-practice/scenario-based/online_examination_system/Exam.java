package week2.online_examination_system;

import java.util.*;

public class Exam {
	int examID;
	String subject;
	Question[] questions;
	int questionCount = 0;
	long endTime;

	Exam(int examID, String subject, int totalQuestions, long duration) {
		this.examID = examID;
		this.subject = subject;
		this.questions = new Question[totalQuestions];
		this.endTime = System.currentTimeMillis() + duration;
	}

	void addQuestion(Question question) {
		if (questionCount < questions.length) {
			questions[questionCount++] = question;
		}
	}

	void checkTime() throws ExamTimeExpiredException {
		if (System.currentTimeMillis() > endTime) {
			throw new ExamTimeExpiredException("Exam time is over.");
		}
	}
}
