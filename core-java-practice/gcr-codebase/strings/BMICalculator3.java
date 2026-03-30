package level3;

import java.util.Scanner;

public class BMICalculator3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the number of players : ");
		int n = sc.nextInt();

		double[][] bmiInfo = new double[n][3]; // [0] -> weight, [1] -> height, [2] -> bmi
		String[] weightStatus = new String[n];

		for (int i = 0; i < n; i++) {
			int k = i + 1;
			double weight;
			double height;
			double bmi;
			while (true) {
				System.out.print("Enter weight (kg) for " + " player " + k + " : ");
				weight = sc.nextDouble();
				if (weight > 0) {
					bmiInfo[i][0] = weight;
					break;
				} else {
					System.out.println("Invalid input.");
				}
			}

			while (true) {
				System.out.print("Enter height (meters) for " + " player " + k + " : ");
				height = sc.nextDouble();
				if (height > 0) {
					bmiInfo[i][1] = height;
					break;
				} else {
					System.out.println("Invalid input.");
				}
			}
			bmi = weight / (height * height);
			bmiInfo[i][2] = bmi;

			if (bmi <= 18.4) {
				weightStatus[i] = "Underweight";
			} else if (bmi <= 24.9) {
				weightStatus[i] = "Normal";
			} else if (bmi <= 39.9) {
				weightStatus[i] = "Overweight";
			} else {
				weightStatus[i] = "Obese";
			}
		}

		System.out.println("ID | Weight | Height | BMI | Status");

		for (int i = 0; i < n; i++) {
			System.out.println((i + 1) + " | " +	bmiInfo[i][0] + " | " +	bmiInfo[i][1] + " | " +	bmiInfo[i][2] + " | " + weightStatus[i]);
		}
	}
}