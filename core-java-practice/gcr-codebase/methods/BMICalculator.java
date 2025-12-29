package level2;

import java.util.*;

public class BMICalculator {
//	An organization took up the exercise to find the Body Mass Index (BMI) of all the persons in the team of 10 members. For this create a program to find the BMI and display the height, weight, BMI and status of each individual
//	Hint => 
//	Take user input in double for the weight (in kg) of the person and height (in cm) for the person and and store it in the corresponding 2D array of 10 rows and 3 columns. The First Column storing the weight, the second column storing the height in cm and the third column is the BMI
//	Create a Method to find the BMI of every person and populate the array. Use the formula BMI = weight / (height * height). Note unit is kg/m^2. For this convert cm to meter
//	Create a Method to determine the BMI status using the logic shown in the figure below. and return the array of all the persons BMI Status.

	static String getBMIStatus(double bmi) {
		if (bmi > 39.9)
			return "Obese";
		else if (bmi > 24.9)
			return "Overweight";
		else if (bmi > 18.4)
			return "Normal";
		else
			return "Underweight";
	}

	static double calculateBMI(double weight, double height) {
		double hmeter = height / 100.0;
		double bmi = weight / (hmeter * hmeter);
		return roundOff(bmi);
	}

	static double roundOff(double n) {
		return Math.round(n * 100.0) / 100.0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double[][] data = new double[3][3]; // [0]->weight, [1]-> height, [2]->BMI

		for (int i = 0; i < 3; i++) {
			int k = i + 1;
			System.out.println("enter weight(in kg) for person " + k + " : ");
			double w = sc.nextDouble();
			System.out.println("enter height(in cm) for person " + k + " : ");
			double h = sc.nextDouble();

			data[i][0] = w;
			data[i][1] = h;
			data[i][2] = calculateBMI(w, h);
		}

		String[] bmiStatus = new String[3];

		for (int i = 0; i < 3; i++) {
			bmiStatus[i] = getBMIStatus(data[i][2]);
		}

		int i = 1;
		for (String status : bmiStatus) {
			System.out.println("Person " + i++ + " BMI Staus : " + status);
		}

		sc.close();
	}
}
