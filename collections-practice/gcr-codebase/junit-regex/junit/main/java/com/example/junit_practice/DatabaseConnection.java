package com.example.junit_practice;

public class DatabaseConnection {
	private boolean connected = false;

	public void connect() {
		connected = true;
		System.out.println("Connection opened.");
	}

	public void disconnect() {
		connected = false;
		System.out.println("Connection closed.");
	}

	public boolean isConnected() {
		return connected;
	}
}