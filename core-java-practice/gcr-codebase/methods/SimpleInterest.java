package level1;

import java.util.*;

public class SimpleInterest {

	static double calculateSimpleInterest(double principal, double rate, double time) {
		double interest = principal * rate * time / 100;
		return interest;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter principal amount : ");
		double p = sc.nextDouble();
		System.out.print("Enter rate of interest : ");
		double r = sc.nextDouble();
		System.out.print("Enter number of years : ");
		double t = sc.nextDouble();
		
		double interest = calculateSimpleInterest(p, r, t);
		System.out.println("The Simple Interest is " + interest + " for Principal "+ p + ", Rate of Interest " + r + " and Time " + t + " years.");

		sc.close();
	}
}
