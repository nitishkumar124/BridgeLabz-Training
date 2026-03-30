package level3;

import java.util.*;

public class BMICalculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter weight(in kg) : ");
		double weight = sc.nextInt();
		System.out.print("Enter height(in cm) : ");
		double height = sc.nextInt();
		height /= 100;

		double bmi = weight / (height * height);

		if (bmi > 39.9) {
			System.out.println("BMI : " + bmi + "\nStatus : Obese");
		} else if (bmi > 25) {
			System.out.println("BMI : " + bmi + "\nStatus : Overweight");
		} else if (bmi > 18.5) {
			System.out.println("BMI : " + bmi + "\nStatus : Normal");
		} else {
			System.out.println("BMI : " + bmi + "\nStatus : Underweight");
		}

		sc.close();
	}
}
