package week9.smart_parking_slot_allocation_system;

abstract class Vehicle {
	private String vehicleNumber;

	public Vehicle(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public abstract String getType();
}
