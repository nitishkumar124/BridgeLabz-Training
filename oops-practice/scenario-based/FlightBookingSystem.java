package week2;

import java.util.*;

//Flight Booking System (CRUD)Scenario:
//	 Simulate a basic flight booking system where users can search flights, book them,
//	and view booking details. 
//	 Problem Requirements:
//	● Use Array to store available flight data.
//	● Store user bookings in a List.
//	● Use String operations to allow case-insensitive flight search.
//	● Use methods for searching, booking, and displaying bookings.

public class FlightBookingSystem {
	public static void main(String[] args) {
		BookingSystem system = new BookingSystem();

		// 1. Search (Testing case-insensitivity)
		system.searchFlights("new york");
		system.searchFlights("LONDON");

		// 2. Book Flights
		system.bookFlight("AI101");
		system.bookFlight("LH303");

		// 3. View Bookings
		system.viewMyBookings();

		// 4. Cancel a Booking (Delete)
		system.cancelBooking("AI101");

		// Final Check
		system.viewMyBookings();
	}
}

class BookingSystem {
	// Requirements: Array for availability, List for bookings
	private Flight[] availableFlights;
	private List<Flight> userBookings;

	public BookingSystem() {
		// Pre-populating the Array (Fixed data)
		availableFlights = new Flight[] { new Flight("AI101", "New York", 500.0), new Flight("EK202", "Dubai", 700.0),
				new Flight("LH303", "London", 450.0), new Flight("SQ404", "Singapore", 600.0) };
		userBookings = new ArrayList<>();
	}

	// SEARCH: Case-insensitive search using String operations
	public void searchFlights(String query) {
		System.out.println("\n--- Search Results for '" + query + "' ---");
		boolean found = false;
		for (Flight f : availableFlights) {
			if (f.getDestination().equalsIgnoreCase(query)) {
				System.out.println(f);
				found = true;
			}
		}
		if (!found)
			System.out.println("No flights found for " + query);
	}

	// CREATE (Book): Add to List
	public void bookFlight(String fNumber) {
		for (Flight f : availableFlights) {
			if (f.getFlightNumber().equalsIgnoreCase(fNumber)) {
				userBookings.add(f);
				System.out.println("Successfully booked: " + fNumber);
				return;
			}
		}
		System.out.println("Error: Flight " + fNumber + " not found.");
	}

	// READ: View all bookings
	public void viewMyBookings() {
		System.out.println("\n--- Your Booking Details ---");
		if (userBookings.isEmpty()) {
			System.out.println("No active bookings.");
		} else {
			userBookings.forEach(System.out::println);
		}
	}

	// DELETE: Cancel a booking
	public void cancelBooking(String fNumber) {
		boolean removed = userBookings.removeIf(f -> f.getFlightNumber().equalsIgnoreCase(fNumber));
		if (removed) {
			System.out.println("Booking " + fNumber + " cancelled.");
		} else {
			System.out.println("Booking not found in your list.");
		}
	}
}

class Flight {
	private String flightNumber;
	private String destination;
	private double price;

	public Flight(String flightNumber, String destination, double price) {
		this.flightNumber = flightNumber;
		this.destination = destination;
		this.price = price;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public String getDestination() {
		return destination;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return String.format("Flight: %s | Destination: %s | Price: $%.2f", flightNumber, destination, price);
	}
}
