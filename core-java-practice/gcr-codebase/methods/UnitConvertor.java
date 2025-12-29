package level2;

import java.util.*;

public class UnitConvertor {

	public static double convertKmToMiles(double km) {
		return km * 0.621371;
	}

	public static double convertMilesToKm(double miles) {
		return miles * 1.60934;
	}

	public static double convertMetersToFeet(double meters) {
		return meters * 3.28084;
	}

	public static double convertFeetToMeters(double feet) {
		return feet * 0.3048;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter distance in km : ");
		double n = sc.nextDouble();
		System.out.println(n + " km to miles : " + convertKmToMiles(n));
		
		System.out.print("Enter distance in miles : ");
		n = sc.nextDouble();
		System.out.println(n + " miles to km : " + convertMilesToKm(n));
		
		System.out.print("Enter distance in meters : ");
		n = sc.nextDouble();
		System.out.println(n + " meters to feet : " + convertMetersToFeet(n));
		
		System.out.print("Enter distance in feet : ");
		n = sc.nextDouble();
		System.out.println(n + " feet to meters : " + convertFeetToMeters(n));

		sc.close();
	}
}
