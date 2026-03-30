package week2.hotel_reservation_system;

import java.util.*;

public class DeluxeRoom extends Room {
	public DeluxeRoom(int roomNumber) {
		super(roomNumber, 250.);
	}

	@Override
	public String getRoomInfo() {
		return "Deluxe Room - Room Number: " + getRoomNumber() + ", Capacity: " + ", Price per Day: $" + getPricePerDay() + ", Occupied: " + isOccupied();
	}
}
