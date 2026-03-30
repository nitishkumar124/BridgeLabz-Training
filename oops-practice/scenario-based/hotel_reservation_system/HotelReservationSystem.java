package week2.hotel_reservation_system;

import java.util.*;

public class HotelReservationSystem {
	public static void main(String[] args) {
		HotelManager hotel = new HotelManager();

		// CRUD: Setup
		hotel.addRoom(new StandardRoom(101));
		hotel.addRoom(new DeluxeRoom(202));

		Guest guest1 = new Guest("Alice", "alice@email.com");
		PricingStrategy holidayPrice = new SeasonalPricing();

		try {
			// Check-in
			hotel.checkIn(202, guest1);

			// Attempt double booking (Triggers Exception)
			hotel.checkIn(202, new Guest("Bob", "bob@email.com"));

		} catch (RoomNotAvailableException e) {
			System.out.println("ALERT: " + e.getMessage());
		}

		// Check-out & Invoice Generation
		hotel.checkOut(202, holidayPrice);
	}
}