package practice_problems;
import java.util.*;
public class PowerCalculation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("base : ");
		double base = sc.nextDouble();
		System.out.print("exponent : ");
		double exponent = sc.nextDouble();

		double power = Math.pow(base, exponent) ;
		System.out.println("power : " + power);

	}

}
