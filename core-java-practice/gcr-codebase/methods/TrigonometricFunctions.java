package level1;

import java.util.*;

public class TrigonometricFunctions {

	public static double[] calculateTrigonometricFunctions(double angle) {
		double angleInRadians = Math.toRadians(angle);

		double sine = Math.sin(angleInRadians);
		double cosine = Math.cos(angleInRadians);
		double tangent = Math.tan(angleInRadians);

		return new double[] { sine, cosine, tangent };
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter angle in degrees : ");
		double angle = sc.nextDouble();
		
		double[] results = calculateTrigonometricFunctions(angle);
		
		double sine = results[0], cosine = results[1], tangent = results[2];
		
		System.out.println("Sine: " + sine);
        System.out.println("Cosine: " + cosine);
        System.out.println("Tangent: " + tangent);

		sc.close();
	}
}
