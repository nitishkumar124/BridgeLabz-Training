package week2.hotel_reservation_system;

import java.util.*;

public class RoomNotAvailableException extends Exception {
	public RoomNotAvailableException(String message) {
		super(message);
	}
}
