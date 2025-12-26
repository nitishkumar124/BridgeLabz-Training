package level3;

import java.util.*;

public class Calculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter first number : ");
		double a = sc.nextDouble();

		System.out.print("Enter second number : ");
		double b = sc.nextDouble();

		System.out.print("Enter operator(+, -, /, *) : ");
		String op = sc.next();

		switch (op) {
		case "+":
			System.out.println("Result : " + (a + b));
			break;
		case "-":
			System.out.println("Result : " + (a - b));
			break;
		case "*":
			System.out.println("Result : " + (a * b));
			break;
		case "/":
			System.out.println("Result : " + (a / b));
			break;
		default:
			System.out.println("Invalid Operator.");

		}		

		sc.close();
	}
}
