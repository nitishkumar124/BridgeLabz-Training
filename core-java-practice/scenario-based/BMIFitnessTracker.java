package practice_problems;

import java.util.*;

public class BMIFitnessTracker {
//	Maya, a fitness coach, wants to record the BMI of her clients.
//	● Ask for height and weight.
//	● Use formula BMI = weight / (height * height)
//	● Print category using if-else: Underweight, Normal, Overweight.
//	Use clear variable names and comments to maintain code hygiene.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your height(in metres): ");
		double h = sc.nextDouble();
		System.out.print("Enter your weight(in kg): ");
		double w = sc.nextDouble();

		double bmi = w * 1.0 / (h * h);
		String category;

		if (bmi > 24.9)
			category = "Overweight";
		if (bmi > 18.4)
			category = "Normal";
		else
			category = "Underweight";
		
		System.out.println("Your BMI category : " + category);
		sc.close();
	}
}
