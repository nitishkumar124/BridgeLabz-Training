package level2;

import java.util.Scanner;

public class QuotientAndRemainder {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter first number : ");
		int a = sc.nextInt(); 
		System.out.println("enter second number : ");
		int b = sc.nextInt(); 
		int quotient = a / b;
		int remainder = a % b;
		System.out.println("The quotient is " + quotient + " and Remainder is " + remainder + " of two number " + a + " and " + b);
	}

}
