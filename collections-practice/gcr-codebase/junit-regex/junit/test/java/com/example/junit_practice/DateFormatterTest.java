package com.example.junit_practice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.time.format.DateTimeParseException;
import static org.junit.jupiter.api.Assertions.*;

class DateFormatterTest {

	private final DateFormatter formatter = new DateFormatter();

	@ParameterizedTest
	@CsvSource({ "2026-01-28, 28-01-2026", "2000-12-31, 31-12-2000", "1995-05-05, 05-05-1995" })
	void testValidDateFormatting(String input, String expected) {
		assertEquals(expected, formatter.formatDate(input));
	}

	@Test
	void testLeapYearDate() {

		assertEquals("29-02-2024", formatter.formatDate("2024-02-29"));
	}

	@ParameterizedTest
	@ValueSource(strings = { "28-01-2026", "2026-13-01", "2026-01-32", "not-a-date" })
	void testInvalidDateThrowsException(String invalidDate) {
		assertThrows(DateTimeParseException.class, () -> {
			formatter.formatDate(invalidDate);
		});
	}
}