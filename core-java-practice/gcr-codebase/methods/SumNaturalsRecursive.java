package level2;

import java.util.*;

public class SumNaturalsRecursive {
//	Write a program to find the sum of n natural numbers using recursive method and compare the result with the formulae n*(n+1)/2 and show the result from both computations is correct. 
//	Hint => 
//	Take the user input number and check whether it's a Natural number
//	Write a Method to find the sum of n natural numbers using recursion
//	Write a Method to find the sum of n natural numbers using the formulae n*(n+1)/2 
//	Compare the two results and print the result

	static int findSumOfNNaturals(int n) {
		if (n <= 1)
			return 1;
		return n + findSumOfNNaturals(n - 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number : ");
		int n = sc.nextInt();

		if (n < 1) {
			System.out.println("enter a natural number.");
			return;
		}

		int sum = findSumOfNNaturals(n);
		System.out.println("sum of first " + n + " naturals : " + sum);

		sc.close();
	}
}
