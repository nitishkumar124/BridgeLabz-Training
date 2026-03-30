package extras2;

import java.util.*;

public class GCDAndLCMCalculator {
	
	static int findGCD(int a, int b) {
		int gcd = a;
		while (gcd > 0) {
			if (a % gcd == 0 && b % gcd == 0) return gcd;
			gcd--;
		}
		return 1;
	}
	
	static int findLCM(int a, int b) {
		int lcm = 1;
		while (lcm <= (a * b)) {
			if (lcm % a == 0 && lcm % b == 0) return lcm;
			lcm++;
		}
		return lcm;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter first numer: ");
		int a = sc.nextInt();
		System.out.print("Enter second numer: ");
		int b = sc.nextInt();
		
		System.out.println("GCD of " + a + " and " + b + " : " + findGCD(a, b));
		System.out.println("LCM of " + a + " and " + b + " : " + findLCM(a, b));

		sc.close();
	}
}
