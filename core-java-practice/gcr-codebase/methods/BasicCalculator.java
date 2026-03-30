package extras2;

import java.util.*;

public class BasicCalculator {

	static double calculate(double a, double b, char op) {
		switch (op) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			return a / b;
		default:
			System.out.println("invalid input for operation");
		}
		return 0.0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter first number: ");
		double a = sc.nextDouble();
		System.out.print("Enter second number: ");
		double b = sc.nextDouble();
		System.out.print("choose and enter operation('+', '-', '*', '/') : ");
		char op = sc.next().charAt(0);

		double result = calculate(a, b, op);
		
		System.out.println("Result : " + result);

		sc.close();
	}
}
