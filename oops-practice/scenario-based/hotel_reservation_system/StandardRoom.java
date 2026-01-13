package week2.hotel_reservation_system;

import java.util.*;

public class StandardRoom extends Room {

	public StandardRoom(int roomNumber) {
		super(roomNumber, 100.0);
	}

	@Override
	public String getRoomInfo() {
		return "Standard Room - Room Number: " + getRoomNumber() + ", Price per Day: $"
				+ getPricePerDay() + ", Occupied: " + isOccupied();
	}
}
