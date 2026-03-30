package week2.online_examination_system;

import java.util.*;

public class Question {
	private int questionID;
	private String question;
	private String correctAnswer;
	private boolean isObjective;

	Question(int questionID, String question, String correctAnswer, boolean isObjective) {
		this.questionID = questionID;
		this.question = question;
		this.correctAnswer = correctAnswer;
		this.isObjective = isObjective;
	}

	public int getQuestionID() {
		return questionID;
	}

	public String getQuestion() {
		return question;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public boolean isObjective() {
		return isObjective;
	}
}
