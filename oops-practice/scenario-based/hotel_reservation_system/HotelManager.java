package week2.hotel_reservation_system;

import java.util.*;

class HotelManager {
	private List<Room> rooms = new ArrayList<>();

	public void addRoom(Room room) {
		rooms.add(room);
	}

	public void checkIn(int roomNumber, Guest guest) throws RoomNotAvailableException {
		for (Room r : rooms) {
			if (r.getRoomNumber() == roomNumber) {
				if (r.isOccupied())
					throw new RoomNotAvailableException("Room " + roomNumber + " is already occupied.");
				r.setOccupied(true);
				System.out.println("Check-in successful for: " + guest.getName());
				return;
			}
		}
		System.out.println("Room not found.");
	}

	public void checkOut(int roomNumber, PricingStrategy strategy) {
		for (Room r : rooms) {
			if (r.getRoomNumber() == roomNumber && r.isOccupied()) {
				double total = strategy.calculateBill(r.getPricePerDay());
				r.setOccupied(false);
				generateInvoice(r, total);
				return;
			}
		}
		System.out.println("No active booking found for Room " + roomNumber);
	}

	private void generateInvoice(Room room, double amount) {
		System.out.println("\n======= FINAL INVOICE =======");
		System.out.println("Room: " + room.getRoomNumber() + " (" + room.getRoomInfo() + ")");
		System.out.println("Total Charges: $" + amount);
		System.out.println("Payment Status: PAID");
		System.out.println("==============================\n");
	}
}
