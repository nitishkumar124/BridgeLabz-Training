package week9;

import java.util.*;

public class LongestPalindromicSubsequence_516 {
	public int longestPalindromeSubseq(String s) {
		int n = s.length();
		int[][] dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			dp[i][i] = 1;
		}
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i + 1; j < n; j++) {

				if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = 2 + dp[i + 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
				}
			}
		}

		return dp[0][n - 1];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the string : ");
		String s = sc.nextLine();
		LongestPalindromicSubsequence_516 solution = new LongestPalindromicSubsequence_516();
		int result = solution.longestPalindromeSubseq(s);
		System.out.println("Length of the longest palindromic subsequence: " + result);
		sc.close();
	}
}
