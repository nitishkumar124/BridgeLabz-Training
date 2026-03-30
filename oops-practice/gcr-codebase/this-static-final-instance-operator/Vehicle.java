package level1;

import java.util.*;

public class Vehicle {

	static double registrationFee = 100;

	String ownerName;
	String vehicleType;
	final int registrationNumber;

	Vehicle(String ownerName, String vehicleType, int registrationNumber) {
		this.ownerName = ownerName;
		this.registrationNumber = registrationNumber;
		this.vehicleType = vehicleType;
	}

	static void updateRegistrationFee(double fee) {
		registrationFee = fee;
		System.out.println("Updated Registration Fee: " + registrationFee + '\n');
	}

	void displayVehicleRegistrationDetails() {
		System.out.println("Owner Name: " + ownerName);
		System.out.println("Registration Number: " + registrationNumber);
		System.out.println("Vehicle Type: " + vehicleType);
		System.out.println("Registration Fee: " + registrationFee + '\n');
	}

	public static void main(String[] args) {

		Vehicle v1 = new Vehicle("Aryansh", "Bike", 1245);
		Vehicle v2 = new Vehicle("Himanshu", "Car", 2645);

		if (v1 instanceof Vehicle)
			v1.displayVehicleRegistrationDetails();

		Vehicle.updateRegistrationFee(150);

		if (v2 instanceof Vehicle)
			v2.displayVehicleRegistrationDetails();

	}
}
