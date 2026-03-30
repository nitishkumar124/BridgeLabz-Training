package level2;

import java.util.Scanner;

public class StudentGrades {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the number of students : ");
		int n = sc.nextInt();

		double[][] marks = new double[n][3];
		double[] percentages = new double[n];
		char[] grades = new char[n];

		for (int i = 0; i < n; i++) {
			int k = i + 1;
			String[] subjects = { "Physics", "Chemistry", "Maths" };
			for (int j = 0; j < 3; j++) {
				System.out.print("Enter marks for " + subjects[j] + " of student " + k + " : ");
				double m = sc.nextDouble();
				if (m < 0) {
					System.out.println("Invalid input.");
					j--;
				} else {
					marks[i][j] = m;
				}
			}

			percentages[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3.0;

			double p = percentages[i];
			if (p >= 80)
				grades[i] = 'A';
			else if (p >= 70)
				grades[i] = 'B';
			else if (p >= 60)
				grades[i] = 'C';
			else if (p >= 50)
				grades[i] = 'D';
			else if (p >= 40)
				grades[i] = 'E';
			else
				grades[i] = 'R';
		}

		System.out.println("Student | Phys | Chem | Math | Percentage | Grade");

		for (int i = 0; i < n; i++) {
			System.out.println((i + 1) + " | " +  marks[i][0] + " | " + marks[i][1] + " | " + marks[i][2] + " | " + percentages[i] + " | " + grades[i]);
		}
	}
}