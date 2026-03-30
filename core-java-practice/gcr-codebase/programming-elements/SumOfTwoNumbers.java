package practice_problems;
import java.util.*;
public class SumOfTwoNumbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("what's the first number : ");
		int num1 = sc.nextInt();
		System.out.print("what's the second number : ");
		int num2 = sc.nextInt();
		int sum = num1 + num2;
		System.out.print("Sum of the two numbers : " + sum);
	}
}
