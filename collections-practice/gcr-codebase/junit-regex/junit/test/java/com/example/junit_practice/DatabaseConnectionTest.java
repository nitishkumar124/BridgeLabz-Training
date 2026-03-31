package com.example.junit_practice;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DatabaseConnectionTest {

	private DatabaseConnection dbConnection;

	@BeforeEach
	void setUp() {

		dbConnection = new DatabaseConnection();
		dbConnection.connect();
	}

	@AfterEach
	void tearDown() {

		if (dbConnection != null) {
			dbConnection.disconnect();
		}
	}

	@Test
	void testConnectionIsActive() {

		assertTrue(dbConnection.isConnected(), "Database should be connected before the test runs");
	}

	@Test
	void testDisconnectManually() {
		dbConnection.disconnect();
		assertFalse(dbConnection.isConnected(), "Database should be disconnected after calling disconnect()");
	}
}