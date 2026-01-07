package week2;

import java.util.*;

public class RideManagementSystem {
	public static void main(String[] args) {

		RideService service = new RideService();

		User user1 = new User(101, "User1");
		User user2 = new User(102, "User2");

		service.bookRide(user1, 20, false); // Normal pricing
		service.bookRide(user2, 30, true); // Peak pricing

		service.showRideHistory();
	}
}

class User {
	int userId;
	String name;

	public User(int userId, String name) {
		this.userId = userId;
		this.name = name;
	}
}

class Driver {
	int driverId;
	String name;
	boolean available;

	public Driver(int driverId, String name) {
		this.driverId = driverId;
		this.name = name;
		this.available = true;
	}
}

interface FareCalculator {
	double calculateFare(double distance);
}

class NormalFareCalculator implements FareCalculator {

	@Override
	public double calculateFare(double distance) {
		return distance * 10; // ₹10 per km
	}
}

class PeakFareCalculator implements FareCalculator {

	@Override
	public double calculateFare(double distance) {
		return distance * 15; // ₹15 per km
	}
}

class NoDriverAvailableException extends Exception {
	public NoDriverAvailableException(String message) {
		super(message);
	}
}

class Ride {
	User user;
	Driver driver;
	double distance;
	double fare;

	public Ride(User user, Driver driver, double distance, double fare) {
		this.user = user;
		this.driver = driver;
		this.distance = distance;
		this.fare = fare;
	}

	public void displayRide() {
		System.out.println(
				"User: " + user.name + ", Driver: " + driver.name + ", Distance: " + distance + " km, Fare: $" + fare);
	}
}

class RideService {

	List<Driver> drivers = new ArrayList<>();
	List<Ride> rideHistory = new ArrayList<>();

	public RideService() {
		drivers.add(new Driver(1, "Driver1"));
		drivers.add(new Driver(2, "Driver2"));
	}

	// Assign driver if available
	private Driver assignDriver() throws NoDriverAvailableException {
		for (Driver d : drivers) {
			if (d.available) {
				d.available = false;
				return d;
			}
		}
		throw new NoDriverAvailableException("Driver NOT available!");
	}

	// Book Ride
	public void bookRide(User user, double distance, boolean isPeakHour) {
		try {
			Driver driver = assignDriver();

			FareCalculator calculator;
			if (isPeakHour) {
				calculator = new PeakFareCalculator();
			} else {
				calculator = new NormalFareCalculator();
			}

			double fare = calculator.calculateFare(distance);

			Ride ride = new Ride(user, driver, distance, fare);
			rideHistory.add(ride);

			System.out.println("Ride booked!");
			ride.displayRide();

		} catch (NoDriverAvailableException e) {
			System.out.println("oops, " + e.getMessage());
		}
	}

	// Ride History
	public void showRideHistory() {
		System.out.println("\n--- Ride History ---");
		for (Ride ride : rideHistory) {
			ride.displayRide();
		}
	}
}