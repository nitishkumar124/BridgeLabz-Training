package level1;

import java.util.*;

public class RideHailingApp {
	public static void main(String[] args) {

		Vehicle1[] availableVehicles = { new Car1("C101", "Alice"), new Bike1("B202", "Bob"),
				new Auto("A303", "Charlie") };

		double tripDistance = 12.5;

		System.out.println("--- Trip Estimates for " + tripDistance + "km ---");
		for (Vehicle1 v : availableVehicles) {
			displayTripEstimate(v, tripDistance);
		}
	}

	public static void displayTripEstimate(Vehicle1 v, double distance) {
		v.getVehicleDetails();

		double fare = v.calculateFare(distance);
		System.out.printf("Estimated Fare: $%.2f%n", fare);
		System.out.println("------------------------------------");
	}
}

interface GPS {
	String getCurrentLocation();

	void updateLocation(String newLocation);
}

abstract class Vehicle1 {
	private String vehicleId;
	private String driverName;
	private double ratePerKm;

	public Vehicle1(String vehicleId, String driverName, double ratePerKm) {
		this.vehicleId = vehicleId;
		this.driverName = driverName;
		this.ratePerKm = ratePerKm;
	}

	public void getVehicleDetails() {
		System.out.println("Vehicle ID: " + vehicleId + " | Driver: " + driverName);
	}

	public abstract double calculateFare(double distance);

	public double getRatePerKm() {
		return ratePerKm;
	}
}

class Car1 extends Vehicle1 implements GPS {
	private String currentLocation = "Main Station";
	private final double BASE_FEE = 2.50;

	public Car1(String id, String driver) {
		super(id, driver, 1.20);
	}

	@Override
	public double calculateFare(double distance) {
		return BASE_FEE + (distance * getRatePerKm());
	}

	@Override
	public String getCurrentLocation() {
		return currentLocation;
	}

	@Override
	public void updateLocation(String loc) {
		this.currentLocation = loc;
	}
}

class Bike1 extends Vehicle1 {
	public Bike1(String id, String driver) {
		super(id, driver, 0.50);
	}

	@Override
	public double calculateFare(double distance) {
		return distance * getRatePerKm();
	}
}

class Auto extends Vehicle1 {
	public Auto(String id, String driver) {
		super(id, driver, 0.80);
	}

	@Override
	public double calculateFare(double distance) {
		return 1.00 + (distance * getRatePerKm());
	}
}
