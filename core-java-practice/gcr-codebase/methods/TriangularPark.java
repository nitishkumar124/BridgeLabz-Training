package level1;

import java.util.*;

public class TriangularPark {

	static double findRoundsToComplete5k(double s1, double s2, double s3) {
		return Math.round((5.0 / ((s1 + s2 + s3) / 1000)) * 100.0) / 100.0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter first side of the triangle(meters) : ");
		double s1 = sc.nextDouble();
		System.out.print("Enter second side of the triangle(meters) : ");
		double s2 = sc.nextDouble();
		System.out.print("Enter third side of the triangle(meters) : ");
		double s3 = sc.nextDouble();

		double rounds = findRoundsToComplete5k(s1, s2, s3);
		
		System.out.println("rounds to complete 5k : " + rounds);
		
		sc.close();
	}
}
