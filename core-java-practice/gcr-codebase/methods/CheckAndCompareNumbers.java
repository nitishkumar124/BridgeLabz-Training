package level2;

import java.util.*;

public class CheckAndCompareNumbers {
//	Write a program to take user input for 5 numbers and check whether a number is positive or negative. Further for positive numbers check if the number is even or odd. Finally compare the first and last elements of the array and display if they are equal, greater, or less
//	Hint => 
//	Write a Method to Check whether the number is positive or negative
//	Write a Method to check whether the number is even or odd
//	Write a Method to compare two numbers and return 1 if number1 > number2 or 0 if both are equal or -1 if number1 < number2 
//	In the main program, Loop through the array using the length call the method isPositive() and if positive call method isEven() and print accordingly 
//	If the number is negative, print negative. 
//	Finally compare the first and last element of the array by calling the method compare() and display if they are equal, greater, or less

	static boolean isPositive(int n) {
		return n > 0;
	}

	static boolean isEven(int n) {
		return n % 2 == 0;
	}

	static int compare(int a, int b) {
		if (a > b)
			return 1;
		else if (a == b)
			return 0;
		return 1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] nums = new int[5];

		String[] order = { "first", "second", "third", "fourth", "fifth" };

		for (int i = 0; i < 5; i++) {
			int k = i + 1;
			System.out.println("enter " + order[i] + " number : ");
			int n = sc.nextInt();
			nums[i] = n;
		}

		for (int n : nums) {
			if (isPositive(n)) {
				System.out.println(n + " : Positive");
			} else
				System.out.println(n + " : Negative");

			if (isEven(n)) {
				System.out.println(n + " : Even");
			} else
				System.out.println(n + " : Odd");
		}

		System.out.println("comparison result of first and last : " + compare(nums[0], nums[4]));

		sc.close();
	}
}
