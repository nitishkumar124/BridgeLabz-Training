package level2;

import java.util.*;

public class UnitConvertor2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter distance in yards : ");
		double n = sc.nextDouble();
		System.out.println(n + " yards to feet : " + convertYardsToFeet(n));

		System.out.print("Enter distance in feet : ");
		n = sc.nextDouble();
		System.out.println(n + " feet to yards : " + convertFeetToYards(n));

		System.out.print("Enter distance in meters : ");
		n = sc.nextDouble();
		System.out.println(n + " meters to inches : " + convertMetersToInches(n));

		System.out.print("Enter distance in inches : ");
		n = sc.nextDouble();
		System.out.println(n + " inches to meters : " + convertInchesToMeters(n));

		System.out.print("Enter distance in inches : ");
		n = sc.nextDouble();
		System.out.println(n + " inches to centimeters : " + convertInchesToCentimeters(n));

		sc.close();
	}

	public static double convertYardsToFeet(double yards) {
		return yards * 3;
	}

	public static double convertFeetToYards(double feet) {
		return feet * 0.333333;
	}

	public static double convertMetersToInches(double meters) {
		return meters * 39.3701;
	}

	public static double convertInchesToMeters(double inches) {
		return inches * 0.0254;
	}

	public static double convertInchesToCentimeters(double inches) {
		return inches * 2.54;
	}

}
