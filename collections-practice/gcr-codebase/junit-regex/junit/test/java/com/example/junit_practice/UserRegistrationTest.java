package com.example.junit_practice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class UserRegistrationTest {

	private final UserRegistration registration = new UserRegistration();

	@Test
	void testSuccessfulRegistration() {
		assertTrue(registration.registerUser("JaneDoe", "jane@example.com", "SecurePass123"));
	}

	@ParameterizedTest
	@CsvSource({ "'', user@test.com, password123, Username cannot be empty",
			"JohnDoe, invalid-email, password123, Invalid email format",
			"JohnDoe, john@test.com, short, Password must be at least 8 characters" })
	void testInvalidInputsThrowException(String user, String email, String pass, String expectedMessage) {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			registration.registerUser(user, email, pass);
		});

		assertEquals(expectedMessage, exception.getMessage());
	}
}