package week3.online_exam_system;

public class Question {
	int id;
	String text;
	String correctAnswer;

	public Question(int id, String text, String correctAnswer) {
		this.id = id;
		this.text = text;
		this.correctAnswer = correctAnswer;
	}
}