package week2;

import java.util.*;

public class VehicleRentalApplication {

	public static void main(String[] args) {
		RentalManager manager = new RentalManager();
		Car toyota = new Car("C001", "Toyota Camry", 50.0);
		manager.addVehicle(toyota);

		Customer user1 = new Customer("CUST101", "John Doe");

		RentalTransaction rental = new RentalTransaction("TXN_99", user1, toyota, 5);

		rental.printReceipt();

		manager.removeVehicle("C001");
		System.out.println("\nVehicle marked as 'Out on Rent'. Updated Inventory:");
		manager.showInventory();
	}
}

interface IRentable {
	double calculateRent(int days);
}

abstract class Vehicle {
	protected String model;
	protected String vehicleID;
	protected double perDayCharge;

	public Vehicle(String model, String vehicleID, double perDayCharge) {
		this.model = model;
		this.vehicleID = vehicleID;
		this.perDayCharge = perDayCharge;
	}

	public String getVehicleID() {
		return vehicleID;
	}

	public String getModel() {
		return model;
	}

	public abstract void displayVehicleDetails();

}

class Car extends Vehicle implements IRentable {
	public Car(String id, String model, double rate) {
		super(id, model, rate);
	}

	@Override
	public double calculateRent(int days) {
		return perDayCharge * days;
	}

	@Override
	public void displayVehicleDetails() {
		System.out.println("[Car] ID: " + vehicleID + " | Model: " + model);
	}
}

class Bike extends Vehicle implements IRentable {
	public Bike(String id, String model, double rate) {
		super(id, model, rate);
	}

	@Override
	public double calculateRent(int days) {
		return (perDayCharge * days) * 0.8;
	}

	@Override
	public void displayVehicleDetails() {
		System.out.println("[Bike] ID: " + vehicleID + " | Model: " + model);
	}
}

class Customer {
	private String name;
	private String customerID;

	public Customer(String name, String customerID) {
		this.name = name;
		this.customerID = customerID;
	}

	public String getName() {
		return name;
	}

	public String getCustomerID() {
		return customerID;
	}
}

class RentalManager {
	private List<Vehicle> inventory = new ArrayList<>();

	// CREATE
	public void addVehicle(Vehicle v) {
		inventory.add(v);
		System.out.println("Vehicle added successfully.");
	}

	// READ
	public void showInventory() {
		System.out.println("\n--- Current Inventory ---");
		for (Vehicle v : inventory) {
			v.displayVehicleDetails();
		}
	}

	// UPDATE
	public void updateVehicleModel(String id, String newModel) {
		for (Vehicle v : inventory) {
			if (v.getVehicleID().equals(id)) {
				v.model = newModel; // Possible because 'model' is protected
				System.out.println("Vehicle ID " + id + " updated.");
				return;
			}
		}
		System.out.println("Vehicle not found.");
	}

	// DELETE
	public void removeVehicle(String id) {
		inventory.removeIf(v -> v.getVehicleID().equals(id));
		System.out.println("Vehicle ID " + id + " removed.");
	}
}

class RentalTransaction {
	private String transactionID;
	private Customer customer;
	private Vehicle vehicle;
	private int rentalDays;

	public RentalTransaction(String transactionID, Customer customer, Vehicle vehicle, int days) {
		this.transactionID = transactionID;
		this.customer = customer;
		this.vehicle = vehicle;
		this.rentalDays = days;
	}

	public void printReceipt() {
		System.out.println("======= RENTAL RECEIPT =======");
		System.out.println("Transaction ID: " + transactionID);
		System.out.println("Customer: " + customer.getName());
		vehicle.displayVehicleDetails();

		if (vehicle instanceof IRentable) {
			double total = ((IRentable) vehicle).calculateRent(rentalDays);
			System.out.println("Rental Period: " + rentalDays + " days");
			System.out.println("Total Cost: $" + total);
		}
		System.out.println("==============================");
	}
}