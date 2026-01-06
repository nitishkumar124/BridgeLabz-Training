package level1;

import java.util.*;

public class VehicleRentalSystem {
//	Description: Design a system to manage vehicle rentals:
//		Define an abstract class Vehicle with fields like vehicleNumber, type, and rentalRate.
//		Add an abstract method calculateRentalCost(int days).
//		Create subclasses Car, Bike, and Truck with specific implementations of calculateRentalCost().
//		Use an interface Insurable with methods calculateInsurance() and getInsuranceDetails().
//		Apply encapsulation to restrict access to sensitive details like insurance policy numbers.
//		Demonstrate polymorphism by iterating over a list of vehicles and calculating rental and insurance costs for each.

	public static void main(String[] args) {
		List<Vehicle> vehicles = new ArrayList<>();
		vehicles.add(new Car(101, "Sedan", 150));
		vehicles.add(new Bike(102, "Bike", 100));
		vehicles.add(new Truck(103, "Truck", 600));
		
		for (Vehicle v : vehicles) {
			v.displayDetails();
			System.out.println("Total Rent: $" + v.calculateRentalCost(5));
		}
	}
}

interface Insurable {
	double calculateInsurance();

	void getInsuranceDetails();
}

abstract class Vehicle {
	private int vehicleNumber;
	private String type;
	protected double rentalRate;

	Vehicle(int vehicleNumber, String type, double rentalRate) {
		this.vehicleNumber = vehicleNumber;
		this.type = type;
		this.rentalRate = rentalRate;
	}

	void displayDetails() {
		System.out.println('\n' + "Vehicle No.: " + vehicleNumber);
		System.out.println("Type: " + type);
		System.out.println("Rental Rate: " + rentalRate);
	}

	abstract double calculateRentalCost(int days);
}

class Car extends Vehicle implements Insurable {
	Car(int vehicleNumber, String type, double rentalRate) {
		super(vehicleNumber, type, rentalRate);
	}

	@Override
	public double calculateInsurance() {
		return 500;
	}

	public void getInsuranceDetails() {
		System.out.println("Car Insured.");
	}

	@Override
	double calculateRentalCost(int days) {
		return days * rentalRate;

	}
}

class Bike extends Vehicle implements Insurable {
	Bike(int vehicleNumber, String type, double rentalRate) {
		super(vehicleNumber, type, rentalRate);
	}

	@Override
	public double calculateInsurance() {
		return 150;
	}

	public void getInsuranceDetails() {
		System.out.println("Bike Insured.");
	}

	@Override
	double calculateRentalCost(int days) {
		return days * rentalRate;

	}
}

class Truck extends Vehicle implements Insurable {
	Truck(int vehicleNumber, String type, double rentalRate) {
		super(vehicleNumber, type, rentalRate);
	}

	@Override
	public double calculateInsurance() {
		return 1500;
	}

	public void getInsuranceDetails() {
		System.out.println("Truck Insured.");
	}

	@Override
	double calculateRentalCost(int days) {
		return days * rentalRate;

	}
}
