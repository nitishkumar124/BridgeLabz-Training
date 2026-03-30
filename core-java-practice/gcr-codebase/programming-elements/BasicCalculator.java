package level1;

import java.util.Scanner;

public class BasicCalculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter first number : ");
		float n1 = sc.nextFloat();
		System.out.println("enter second number : ");
		float n2 = sc.nextFloat();

		float product = n1 * n2;
		float quotient = n1 / n2;
		float sum = n1 + n2;
		float difference = n1 - n2;

		System.out.println("The addition, subtraction, multiplication and division value of 2 numbers " + n1 + " and "
				+ n2 + " is " + sum + ", " + difference + ", " + product + " and " + quotient);

	}

}
