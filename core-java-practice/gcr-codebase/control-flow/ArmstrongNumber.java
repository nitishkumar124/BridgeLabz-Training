package level3;

import java.util.*;

public class ArmstrongNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number : ");
		int n = sc.nextInt();
		int sum = 0;
		int originalNumber = n;
		
		while(n > 0) {
			int a = n % 10;
			double digitCube = Math.pow(a, 3);
			sum += digitCube;
			n /= 10;
		}
		
		if (originalNumber == sum) {
			System.out.println("Number is Armstrong.");
		} else {
			System.out.println("Not a armstrong number.");
		}

		sc.close();
	}
}
