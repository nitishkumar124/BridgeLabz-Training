package com.example.junit_practice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

public class StringUtilsTest {

	private final StringUtils utils = new StringUtils();

	@Test
	void testReverse() {
		assertEquals("olleh", utils.reverse("hello"));
		assertEquals("", utils.reverse(""));
		assertNull(utils.reverse(null));
	}

	@Test
	void testToUpperCase() {
		assertEquals("JAVA", utils.toUpperCase("java"));
		assertEquals("HELLO WORLD", utils.toUpperCase("Hello World"));
		assertNull(utils.toUpperCase(null));
	}

	@ValueSource(strings = { "radar", "Level", "Racecar", "madam" })
	void testIsPalindromeValid(String candidate) {
		assertTrue(utils.isPalindrome(candidate), () -> candidate + " should be a palindrome");
	}

	@Test
	void testIsPalindromeInvalid() {
		assertFalse(utils.isPalindrome("hello"));
		assertFalse(utils.isPalindrome(null));
	}
}
