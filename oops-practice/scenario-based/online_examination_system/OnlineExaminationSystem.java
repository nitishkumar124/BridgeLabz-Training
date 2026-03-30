package week2.online_examination_system;

import java.util.*;

public class OnlineExaminationSystem {
	public static void main(String[] args) {
		try {

			Exam exam = new Exam(1, "Java", 10, 5);

			// Adding questions
			exam.addQuestion(new Question(1, "What is Java?", "A programming language", true));
			exam.addQuestion(new Question(2, "Explain OOP concepts.",
					"Encapsulation, Inheritance, Polymorphism, Abstraction", false));

			Student student = new Student(101, "Alice", exam.questionCount);

			exam.checkTime();

			student.submitAnswer(0, "A programming language");
			student.submitAnswer(1, "Encapsulation, Inheritance, Polymorphism, Abstraction");

			EvaluationStrategy objectiveEval = new ObjectiveEvaluation();
			EvaluationStrategy descriptiveEval = new DescriptiveEvaluation();

			int objectiveScore = objectiveEval.evaluate(exam, student);
			int descriptiveScore = descriptiveEval.evaluate(exam, student);

			// result output
			System.out.println("Student: " + student.getName());
			System.out.println("Objective Score: " + objectiveScore);
			System.out.println("Descriptive Score: " + descriptiveScore);
			System.out.println("Total Score: " + (objectiveScore + descriptiveScore));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
