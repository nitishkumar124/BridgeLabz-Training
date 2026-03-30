package week3;

import java.util.Scanner;

public class ValidPalindrome_125 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the string: ");
		String s = scanner.nextLine();

		boolean result = isPalindrome(s);
		System.out.println("Is it a valid palindrome? " + result);

		scanner.close();
	}

	public static boolean isPalindrome(String s) {
		if (s == null)
			return false;

		int left = 0;
		int right = s.length() - 1;

		while (left < right) {

			if (!Character.isLetterOrDigit(s.charAt(left))) {
				left++;
			}

			else if (!Character.isLetterOrDigit(s.charAt(right))) {
				right--;
			}

			else {
				if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
					return false;
				}
				left++;
				right--;
			}
		}

		return true;
	}
}