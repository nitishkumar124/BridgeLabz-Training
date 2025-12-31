package level1;

public class Vehicle {

	static int registrationFee = 1500;

	String ownerName;
	String vehicleType;

	Vehicle(String ownerName, String vehicleType) {
		this.ownerName = ownerName;
		this.vehicleType = vehicleType;
	}

	void displayVehicleDetails() {
		System.out.println("owner: " + ownerName);
		System.out.println("vehicle type: " + vehicleType);
		System.out.println("registration fee: $" + registrationFee + '\n');
	}
	
	static void updateRegistrationFee(int newRegistrationFee) {
		registrationFee = newRegistrationFee;
		System.out.println("registration fee updated.\n" + "registration fee: $" + registrationFee);
	}

	public static void main(String[] args) {
		Vehicle v = new Vehicle("Aryansh", "HatchBack");
		v.displayVehicleDetails();
		Vehicle.updateRegistrationFee(2000);
	}
}
