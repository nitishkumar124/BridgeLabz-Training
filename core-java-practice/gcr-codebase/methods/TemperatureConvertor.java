package extras2;

import java.util.*;

public class TemperatureConvertor {

	static double convertFahrenheitToCelsius(double f) {
		return (f - 32) * (5.0 / 9);
	}

	static double convertCelsiusToFahrenheit(double c) {
		return (c + 32) * (9.0 / 5);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter temperature in fahrenheit : ");
		int f = sc.nextInt();
		System.out.print("Enter temperature in celsius : ");
		int c = sc.nextInt();

		System.out.println(f + " fahrenheit in celsius: " + convertFahrenheitToCelsius(f));
		System.out.println(f + " celsius in fahrenheit: " + convertCelsiusToFahrenheit(c));

		sc.close();
	}
}
