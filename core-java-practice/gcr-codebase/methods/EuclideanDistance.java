package level3;

import java.util.*;

public class EuclideanDistance {

	static double findEuclideandistance(double x1, double y1, double x2, double y2) {
		return Math.sqrt((Math.pow((x2 - x1), 2))) + Math.sqrt((Math.pow((y2 - y1), 2)));
	}

	static double[] findEquationOfLine(double x1, double y1, double x2, double y2) {
		double m = (y2 - y1) / (x2 - x1);
		double b = y1 - m * x1;
		return new double[] { m, b };
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter coordinates(x y) for point A : ");
		double x1 = sc.nextDouble();
		double y1 = sc.nextDouble();

		System.out.print("Enter coordinates(x y) for point B : ");
		double x2 = sc.nextDouble();
		double y2 = sc.nextDouble();

		sc.close();
	}
}
