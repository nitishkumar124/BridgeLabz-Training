package com.example.junit_practice;

import java.util.regex.Pattern;

public class UserRegistration {

	private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";

	public boolean registerUser(String username, String email, String password) {
		if (username == null || username.trim().isEmpty()) {
			throw new IllegalArgumentException("Username cannot be empty");
		}

		if (email == null || !Pattern.matches(EMAIL_REGEX, email)) {
			throw new IllegalArgumentException("Invalid email format");
		}

		if (password == null || password.length() < 8) {
			throw new IllegalArgumentException("Password must be at least 8 characters");
		}

		System.out.println("User " + username + " registered successfully!");
		return true;
	}
}