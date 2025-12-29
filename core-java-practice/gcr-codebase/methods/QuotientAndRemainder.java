package level1;

import java.util.*;

public class QuotientAndRemainder {

	public static int[] findRemainderAndQuotient(int number, int divisor) {
		return new int[] { (number / divisor), (number % divisor) };
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number: ");
		int number = sc.nextInt();
		System.out.print("Enter divisor : ");
		int divisor = sc.nextInt();

		int[] results = findRemainderAndQuotient(number, divisor);
		int quotient = results[0], remainder = results[1];
		
		System.out.println("quotient : " + quotient);
		System.out.println("remainder : " + remainder);

		sc.close();
	}
}
