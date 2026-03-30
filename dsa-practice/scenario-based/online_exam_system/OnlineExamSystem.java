package week3.online_exam_system;

import java.util.*;

public class OnlineExamSystem {
	public static void main(String[] args) {
		ExamProctor proctor = new ExamProctor();

		proctor.addQuestionToBank(new Question(101, "What is Java?", "Language"));
		proctor.addQuestionToBank(new Question(102, "Is String primitive?", "No"));
		proctor.addQuestionToBank(new Question(103, "What is the size of int?", "4 bytes"));

		proctor.answerQuestion(101, "Language");
		proctor.answerQuestion(102, "Yes");
		proctor.answerQuestion(103, "4 bytes");

		proctor.goBack();

		proctor.submitExam();
	}
}