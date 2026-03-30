package level3;

import java.util.*;

public class StudentMarks {

	static double[][] generateStudentMarks(int n) {
		double[][] marks = new double[n][3];

		for (int i = 0; i < n; i++) {
			marks[i][0] = (int) (Math.random() * 90) + 10;
			marks[i][1] = (int) (Math.random() * 90) + 10;
			marks[i][2] = (int) (Math.random() * 90) + 10;
		}

		return marks;
	}

	static double[][] calculateResult(double[][] marks) {
		double[][] result = new double[marks.length][2]; // total marks, percentage
		int i = 0;
		for (double[] m : marks) {
			double marksObtained = m[0] + m[1] + m[2];
			result[i][0] = marksObtained; // marks obtained
			result[i][1] = Math.round((marksObtained / 3) * 100.0) / 100.0; // percentage
			i++;
		}
		return result;
	}

	static void displayResults(double[][] marks, double[][] result) {
		System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s%n", "Student", "Physics", "Chemistry", "Maths", "Total",
				"Percentage");
		for (int i = 0; i < marks.length; i++) {
			double[] m = marks[i];
			double[] r = result[i];
			System.out.printf("%-10d %-10.1f %-10.1f %-10.1f %-10.1f %.1f%n", (i + 1), m[0], m[1], m[2], r[0], r[1]);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of students : ");
		int n = sc.nextInt();
		double[][] marks = generateStudentMarks(n); // [0]->physics, [1]->chemistry, [2]->maths
		double[][] result = calculateResult(marks); // [0]->marks obtained, [1]->percentage

		displayResults(marks, result);
		sc.close();
	}
}
