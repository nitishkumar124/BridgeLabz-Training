package week2;

import java.util.*;

public class PalindromeNumber_9 {
	public static boolean isPalindrome(int x) {
		int num = 0;
		int temp = x;		
		while (temp > 0) {
			num += temp % 10;
			temp /= 10;
			num *= 10;			
		}
		num /= 10;
		return x == num;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the value of x : ");
		int x = sc.nextInt();
		boolean result = isPalindrome(x);
		System.out.println("Is Palindrome: " + result);
		sc.close();
	}
}