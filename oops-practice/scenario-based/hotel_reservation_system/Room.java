package week2.hotel_reservation_system;

import java.util.*;

abstract public class Room {
	private int roomNumber;
	private boolean isOccupied = false;
	private double pricePerDay;

	Room(int roomNumber, double pricePerDay) {
		this.roomNumber = roomNumber;
		this.pricePerDay = pricePerDay;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public double getPricePerDay() {
		return pricePerDay;
	}

	public void setOccupied(boolean occupied) {
		isOccupied = occupied;
	}

	abstract public String getRoomInfo();
}
