package level2;

import java.util.*;

public class GradeCalculator {

	static double[][] getMarks(int n) {
		double[][] marks = new double[n][3]; // [0] -> phy, [1] -> chem, [2]-> maths
		for (int i = 0; i < n; i++) {
			double phy = Math.round((Math.random() * 100) * 100.0) / 100.0;
			double chem = Math.round((Math.random() * 100) * 100.0) / 100.0;
			double maths = Math.round((Math.random() * 100) * 100.0) / 100.0;
			marks[i][0] = phy;
			marks[i][1] = chem;
			marks[i][2] = maths;
		}
		return marks;
	}

	static double[][] results(double[][] marks) {
		double[][] result = new double[marks.length][3]; // [0] -> total, [1] -> average, [2] -> percentage
		for (int i = 0; i < marks.length; i++) {
			double marksObtained = marks[i][0] + marks[i][1] + marks[i][2];
			double avg = Math.round((marksObtained / 3.0) * 100.0) / 100.0;
			double percent = avg;
			result[i][0] = marksObtained;
			result[i][1] = avg;
			result[i][2] = percent;
		}
		return result;
	}

	static char grade(double marks) {
		char grade;

		if (marks > 79)
			grade = 'A';
		else if (marks > 69)
			grade = 'B';
		else if (marks > 59)
			grade = 'C';
		else if (marks > 49)
			grade = 'D';
		else if (marks > 39)
			grade = 'E';
		else
			grade = 'R';

		return grade;
	}

	static void print(double[][] marks, double[][] result) {
		System.out.println("Student | physics | chemistry | maths | total | percent | grade");
		for (int i = 0; i < marks.length; i++) {
			char grade = grade(result[i][0]);
			int k = i + 1;
			System.out.println(k + " | " + marks[i][0] + " | " + marks[i][1] + " | " + marks[i][2] + " | "
					+ result[i][0] + " | " + result[i][1] + "% | " + grade);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the number of students : ");
		int n = sc.nextInt();

		double[][] marks = getMarks(n);
		double[][] result = results(marks);
		print(marks, result);

		sc.close();
	}
}
