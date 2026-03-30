package level1;

public class VehicleManagement {
	public static void main(String[] args) {
		ElectricVehicle ev = new ElectricVehicle();
		PetrolVehicle pv = new PetrolVehicle();

		ev.charge();
		pv.refuel();
	}
}

interface Refuelable {
	void refuel();
}

class Vehicle4 {
	String model;
}

class ElectricVehicle extends Vehicle4 {
	void charge() {
		System.out.println("Charging electric vehicle");
	}
}

class PetrolVehicle extends Vehicle4 implements Refuelable {
	public void refuel() {
		System.out.println("Refueling petrol vehicle");
	}
}