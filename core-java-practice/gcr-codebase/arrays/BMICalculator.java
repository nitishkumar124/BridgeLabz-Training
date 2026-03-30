package level2;

import java.util.*;

public class BMICalculator {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter the number of players in the team : ");
		int n = input.nextInt();

		double[] weight = new double[n];
		double[] height = new double[n];
		double[] bmi = new double[n];
		String[] status = new String[n];

		for (int i = 0; i < n; i++) {
			System.out.print("Enter weight (kg) for player " + (i + 1) + " : ");
			weight[i] = input.nextDouble();
			System.out.print("Enter height (meters) for player " + (i + 1) + " : ");
			height[i] = input.nextDouble();

			bmi[i] = weight[i] / (height[i] * height[i]);

			if (bmi[i] <= 18.4) {
				status[i] = "Underweight";
			} else if (bmi[i] <= 24.9) {
				status[i] = "Normal";
			} else if (bmi[i] <= 39.9) {
				status[i] = "Overweight";
			} else {
				status[i] = "Obese";
			}
		}

		System.out.println("Person | Height | Weight | BMI | Status");
		for (int i = 0; i < n; i++) {
			System.out.println((i + 1) + " | " + height[i] + " | " + weight[i] + " | " + bmi[i] + " | " + status[i]);
		}
	}
}
