package week2;

import java.util.*;

public class ReportGenerator {
    public static void main(String[] args) {
        List<Student> classroom = new ArrayList<>();
        String[] subjects = {"Math", "Science", "English", "History"};

        try {
            // Add students
            classroom.add(new Student("Alice", subjects, new int[]{95, 88, 92, 90}));
            classroom.add(new Student("Bob", subjects, new int[]{70, 65, 80, 72}));

            // display results
            for (Student s : classroom) {
                s.displayReportCard();
            }

            // validate
            classroom.add(new Student("Charlie", subjects, new int[]{105, 50, 60, 70}));

        } catch (InvalidMarkException e) {
            System.out.println("ALERT: " + e.getMessage());
        }
    }
}

// Validate marks (0-100)
class InvalidMarkException extends Exception {
	public InvalidMarkException(String message) {
		super(message);
	}
}

class Student {
	private String name;
	// Store subjects and marks
	private String[] subjects;
	private int[] marks;

	public Student(String name, String[] subjects, int[] marks) throws InvalidMarkException {
		this.name = name;
		this.subjects = subjects;

		// Validation logic
		for (int mark : marks) {
			if (mark < 0 || mark > 100) {
				throw new InvalidMarkException("Mark " + mark + " is out of range (0-100) for " + name);
			}
		}
		this.marks = marks;
	}

	// Calculate average
	public double calculateAverage() {
		double total = 0;
		for (int mark : marks) {
			total += mark;
		}
		return total / marks.length;
	}

	// Grade assignment
	public String getGrade() {
		double avg = calculateAverage();
		if (avg >= 90)
			return "A+";
		if (avg >= 80)
			return "A";
		if (avg >= 70)
			return "B";
		if (avg >= 60)
			return "C";
		return "D/Fail";
	}

	public void displayReportCard() {
		System.out.println();
		System.out.println("       STUDENT REPORT CARD     ");
		System.out.println("==============================");
		System.out.println("Name: " + name);
		System.out.println("------------------------------");
		for (int i = 0; i < subjects.length; i++) {
			System.out.printf("%-15s : %d%n", subjects[i], marks[i]);
		}
		System.out.println("------------------------------");
		System.out.printf("Average Score   : %.2f%n", calculateAverage());
		System.out.println("Final Grade     : " + getGrade());
		System.out.println("");
	}
}