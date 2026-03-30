package level1;

import java.util.*;

public class HotelBooking {

	String guestName;
	String roomType;
	int nights;

	public HotelBooking() {
		this("Aryansh", "Single Bed", 2);
	}

	HotelBooking(String guestName, String roomType, int nights) {
		this.guestName = guestName;
		this.roomType = roomType;
		this.nights = nights;
	}

	HotelBooking(HotelBooking b) {
		this.guestName = b.guestName;
		this.roomType = b.roomType;
		this.nights = b.nights;
	}

	public static void main(String[] args) {

		HotelBooking b1 = new HotelBooking();
		HotelBooking b2 = new HotelBooking("Amit", "Presidential", 3);
		HotelBooking b3 = new HotelBooking(b2);
		
		System.out.println("Default Constructor:");
		System.out.println("Guest: " + b1.guestName + "\n");
		System.out.println("Parameterized Constructor:");
		System.out.println("Guest: " + b2.guestName + "\n");
		System.out.println("Copy Constructor:");
		System.out.println("Guest: " + b3.guestName);

	}
}
