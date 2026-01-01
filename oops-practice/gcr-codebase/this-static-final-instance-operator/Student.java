package level1;

import java.util.*;

public class Student {

	static String universityName = "GLA University";
	static int totalStudents = 0;

	String name;
	final int rollNumber;
	char grade;

	Student(String name, int rollNumber, char grade) {
		this.name = name;
		this.rollNumber = rollNumber;
		this.grade = grade;
	}

	static void displayTotalStudents() {
		System.out.println("Total Students: " + totalStudents + "\n");
	}

	void updateGrade(char grade) {
		this.grade = grade;
	}

	void displayStudentDetails() {
		System.out.println("University Name: " + universityName);
		System.out.println("Roll Number: " + rollNumber);
		System.out.println("Name: " + name);
		System.out.println("Grade: " + grade + '\n');
	}

	public static void main(String[] args) {

		Student s1 = new Student("Aryansh", 01, 'A');
		Student s2 = new Student("Himanshu", 18, 'B');

		Student.displayTotalStudents();
		if (s1 instanceof Student)
			s1.displayStudentDetails();
		if (s2 instanceof Student)
			s2.displayStudentDetails();

		s2.updateGrade('A');
		s2.displayStudentDetails();

	}
}
