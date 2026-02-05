package stream_api;

import java.util.*;

public class EmailNotificationService {

	public static void main(String[] args) {

		List<String> emails = Arrays.asList("rahul@example.com", "anita@example.com", "vikram@example.com",
				"sneha@example.com");

		emails.forEach(email -> sendEmailNotification(email));
	}

	private static void sendEmailNotification(String email) {
		System.out.println("Notification email sent to: " + email);
	}
}
