package com.example.junit_practice;

public class StringUtils {

	public String reverse(String str) {
		if (str == null)
			return null;
		return new StringBuilder(str).reverse().toString();
	}

	public boolean isPalindrome(String str) {
		if (str == null)
			return false;
		String cleanStr = str.replaceAll("\\s+", "").toLowerCase();
		String reversed = reverse(cleanStr);
		return cleanStr.equals(reversed);
	}

	public String toUpperCase(String str) {
		return (str == null) ? null : str.toUpperCase();
	}
}
