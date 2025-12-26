package level1;

import java.util.Scanner;

public class CheckAndSumNNaturals {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of n:");
		int n = sc.nextInt();
		if (n > 0) {
			int sum = (n * (n + 1)) / 2;
			System.out.println("The sum of " + n + " natural number is " + sum);
		} else {
			System.out.println("The number " + n + " is not a natural number");
		}
	}
}