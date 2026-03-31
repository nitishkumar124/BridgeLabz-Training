package week9.smart_parking_slot_allocation_system;

public class ParkingApp {
	public static void main(String[] args) {
		ParkingManager manager = new ParkingManager(2);

		try {
			manager.parkVehicle(new Car("CAR-101"));
			manager.parkVehicle(new Bike("BIKE-201"));
			manager.parkVehicle(new Car("CAR-301")); // goes to waiting queue
		} catch (NoParkingSlotAvailableException e) {
			System.out.println(e.getMessage());
		}

		manager.freeSlot(1);
	}
}
