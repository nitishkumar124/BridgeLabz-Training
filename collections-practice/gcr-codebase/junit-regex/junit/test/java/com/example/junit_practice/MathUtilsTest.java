package com.example.junit_practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

	private final MathUtils mathUtils = new MathUtils();

	@ParameterizedTest
	@ValueSource(ints = { 2, 4, 6, 8, 10 })
	void testIsEvenWithEvenNumbers(int number) {
		assertTrue(mathUtils.isEven(number), "Expected " + number + " to be even");
	}

	@ParameterizedTest
	@ValueSource(ints = { 1, 3, 7, 9, 15 })
	void testIsEvenWithOddNumbers(int number) {
		assertFalse(mathUtils.isEven(number), "Expected " + number + " to be odd");
	}
}