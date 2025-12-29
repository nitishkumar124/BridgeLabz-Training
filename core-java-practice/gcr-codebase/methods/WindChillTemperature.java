package level1;

import java.util.*;

public class WindChillTemperature {

	public static double calculateWindChill(double temp, double windSpeed) {
		return 35.74 + 0.6215 * temp + (0.4275 * temp - 35.75) * Math.pow(windSpeed, 0.16);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter temperature : ");
		double temp = sc.nextDouble();
		System.out.print("Enter windSpeed : ");
		double windSpeed = sc.nextDouble();
		double windChill = calculateWindChill(temp, windSpeed);
		System.out.println("wind chill : " + windChill);
		sc.close();
	}
}
