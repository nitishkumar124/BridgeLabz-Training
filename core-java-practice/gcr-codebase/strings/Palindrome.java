package level3;

import java.util.*;

public class Palindrome {

	static boolean isPalindrome(String s) {
		boolean check = true;

		int start = 0, end = s.length() - 1;

		while (start <= end) {
			if (s.charAt(start) != s.charAt(end))
				return false;
			
			start++;
			end--;
		}

		return check;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter some text : ");
		String s = sc.nextLine();

		if (isPalindrome(s)) {
			System.out.println("It's a Palindrome.");
		} else
			System.out.println("It's NOT a Palindrome.");

		sc.close();
	}
}
