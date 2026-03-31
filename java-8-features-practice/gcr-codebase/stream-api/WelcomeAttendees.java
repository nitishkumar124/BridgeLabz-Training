package stream_api;

import java.util.*;

public class WelcomeAttendees {

	public static void main(String[] args) {

		List<String> attendees = Arrays.asList("Rahul", "Anita", "Vikram", "Sneha", "Karan");

		attendees.forEach(name -> System.out.println("Welcome to the event, " + name + "!"));
	}
}
