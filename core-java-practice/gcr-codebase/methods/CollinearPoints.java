package level3;

import java.util.Scanner;

public class CollinearPoints {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter coordinates for Point A (x1 y1): ");
		double x1 = sc.nextDouble();
		double y1 = sc.nextDouble();

		System.out.println("Enter coordinates for Point B (x2 y2): ");
		double x2 = sc.nextDouble();
		double y2 = sc.nextDouble();

		System.out.println("Enter coordinates for Point C (x3 y3): ");
		double x3 = sc.nextDouble();
		double y3 = sc.nextDouble();

		checkBySlope(x1, y1, x2, y2, x3, y3);
		checkByArea(x1, y1, x2, y2, x3, y3);

		sc.close();
	}

	public static void checkBySlope(double x1, double y1, double x2, double y2, double x3, double y3) {
		double slopeLeft = (y2 - y1) * (x3 - x2);
		double slopeRight = (y3 - y2) * (x2 - x1);

		if (slopeLeft == slopeRight) {
			System.out.println("Slope Method: Points are Collinear.");
		} else {
			System.out.println("Slope Method: Points are NOT Collinear.");
		}
	}

	public static void checkByArea(double x1, double y1, double x2, double y2, double x3, double y3) {
		double area = 0.5 * Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));

		System.out.println("Area Method: Area is " + area);
		if (area == 0) {
			System.out.println("Area Method: Points are Collinear.");
		} else {
			System.out.println("Area Method: Points are NOT Collinear.");
		}
	}
}