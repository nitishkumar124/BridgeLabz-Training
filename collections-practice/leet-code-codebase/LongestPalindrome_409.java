package week4.part2;

import java.util.*;

public class LongestPalindrome_409 {

	public static void main(String[] args) {
		String s = "abccccdd";
		System.out.println("The length of the longest palindrome that can be built is: " + longestPalindrome(s));
	}

	public static int longestPalindrome(String s) {
		int[] hash = new int[256];
		for (int i = 0; i < s.length(); i++) {
			hash[s.charAt(i)]++;
		}
		int len = 0;
		int single = 0;
		for (int n : hash) {
			if (n % 2 == 0)
				len += n;
			if (n % 2 == 1) {
				single = 1;
				len += n - 1;
			}
		}
		return len + single;
	}
}
