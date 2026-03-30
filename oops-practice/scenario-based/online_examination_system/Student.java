package week2.online_examination_system;

import java.util.*;

public class Student {

	private int studentID;
	private String studentName;

	String[] answers;

	Student(int studentID, String studentName, int totalQuestions) {
		this.studentID = studentID;
		this.studentName = studentName;
		this.answers = new String[totalQuestions];
	}

	public String getName() {
		return studentName;
	}

	public void submitAnswer(int questionIndex, String answer) {
		answers[questionIndex] = answer;
	}

}
