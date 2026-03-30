package level2;

import java.util.*;

public class UnitConvertor3 {

	public static double convertFarhenheitToCelsius(double fahren) {
		return (fahren - 32) * 5 / 9;
	}

	public static double convertCelsiusToFahrenheit(double celsius) {
		return (celsius * 9 / 5) + 32;
	}

	public static double convertPoundsToKilograms(double pounds) {
		return pounds * 0.453592;
	}

	public static double convertKilogramsToPounds(double kg) {
		return kg * 2.20462;
	}

	public static double convertGallonsToLitres(double gallons) {
		return gallons * 3.78541;
	}

	public static double convertLitresToGallons(double litres) {
		return litres * 0.264172;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter temperature in fahrenheit : ");
		double n = sc.nextDouble();
		System.out.println(n + " fahrenheit to celsius : " + convertFarhenheitToCelsius(n));

		System.out.print("Enter temperature in celsius : ");
		n = sc.nextDouble();
		System.out.println(n + " celsius to fahrenheit : " + convertCelsiusToFahrenheit(n));

		System.out.print("Enter weight in pounds : ");
		n = sc.nextDouble();
		System.out.println(n + " pounds to kgs : " + convertPoundsToKilograms(n));

		System.out.print("Enter weight in kgs : ");
		n = sc.nextDouble();
		System.out.println(n + " kgs to pounds : " + convertKilogramsToPounds(n));

		System.out.print("Enter volume in gallons : ");
		n = sc.nextDouble();
		System.out.println(n + " gallons to litres : " + convertGallonsToLitres(n));

		System.out.print("Enter volume in litres : ");
		n = sc.nextDouble();
		System.out.println(n + " litres to gallons : " + convertLitresToGallons(n));

		sc.close();
	}

}
