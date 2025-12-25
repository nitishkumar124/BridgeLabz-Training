package level2;

import java.util.Scanner;

public class FloatOperations {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter first number : ");
		double a = sc.nextInt();
		System.out.println("enter second number : ");
		double b = sc.nextInt();
		System.out.println("enter third number : ");
		double c = sc.nextInt();
		
		double op1Result = a + b * c;
		double op2Result = a * b + c;
		double op3Result = c + a / b;
		double op4Result = a % b + c;
		System.out.println("a + b * c : " + op1Result);
		System.out.println("a * b + c : " + op2Result);
		System.out.println("c + a / b : " + op3Result);
		System.out.println("a % b + c : " + op4Result);
	}

}
