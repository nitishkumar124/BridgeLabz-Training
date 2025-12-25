package level2;

import java.util.Scanner;

public class IntegerOperations {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter first number : ");
		int a = sc.nextInt();
		System.out.println("enter second number : ");
		int b = sc.nextInt();
		System.out.println("enter third number : ");
		int c = sc.nextInt();
		
		int op1Result = a + b * c;
		int op2Result = a * b + c;
		int op3Result = c + a / b;
		int op4Result = a % b + c;
		System.out.println("a + b * c : " + op1Result);
		System.out.println("a * b + c : " + op2Result);
		System.out.println("c + a / b : " + op3Result);
		System.out.println("a % b + c : " + op4Result);
	}

}
