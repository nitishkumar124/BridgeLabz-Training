package com.example.junit_practice;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {

	private final TemperatureConverter converter = new TemperatureConverter();
	private final double DELTA = 0.001;

	@ParameterizedTest
	@CsvSource({ "0, 32", "100, 212", "-40, -40", "37, 98.6" })
	void testCelsiusToFahrenheit(double celsius, double expectedFahrenheit) {
		assertEquals(expectedFahrenheit, converter.celsiusToFahrenheit(celsius), DELTA);
	}

	@ParameterizedTest
	@CsvSource({ "32, 0", "212, 100", "-40, -40", "98.6, 37" })
	void testFahrenheitToCelsius(double fahrenheit, double expectedCelsius) {
		assertEquals(expectedCelsius, converter.fahrenheitToCelsius(fahrenheit), DELTA);
	}
}