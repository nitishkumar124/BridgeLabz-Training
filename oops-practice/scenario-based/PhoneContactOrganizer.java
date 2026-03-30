package week2;

import java.util.*;

public class PhoneContactOrganizer {

	public static void main(String[] args) throws InvalidPhoneNumberException {
		Scanner sc = new Scanner(System.in);
		ContactManager contacts = new ContactManager();
		contacts.addContact("Aryansh", "7845567889");
		contacts.addContact("Himanshu", "12");
		contacts.addContact("Himanshu", "1234567890");
		contacts.displayAll();
		contacts.deleteContact("1234567890");
		contacts.displayAll();
		sc.close();
	}
}

// Custom Exception for phone number validation
class InvalidPhoneNumberException extends Exception {
	public InvalidPhoneNumberException(String message) {
		super(message);
	}
}

class Contact {
	String name;
	String phoneNumber;

	public Contact(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
}

class ContactManager {
	private List<Contact> contacts = new ArrayList<>();

	public void addContact(String name, String phoneNumber) throws InvalidPhoneNumberException {
		try {
			// 1. Check length
			if (phoneNumber.length() != 10) {
				throw new InvalidPhoneNumberException("Phone number must be exactly 10 digits.");
			}

			// 2. Check for duplicates
			for (Contact c : contacts) {
				if (c.phoneNumber.equals(phoneNumber)) {
					System.out.println("Error: Contact number " + phoneNumber + " already exists.");
					return;
				}
			}

			contacts.add(new Contact(name, phoneNumber));
			System.out.println("Contact added successfully: " + name);

		} catch (InvalidPhoneNumberException e) {
			System.out.println(e.getMessage());
		}

	}

	// Delete contact
	public void deleteContact(String phoneNumber) {

		for (Contact c : contacts) {
			if (c.phoneNumber.equals(phoneNumber)) {
				contacts.remove(c);
				System.out.println("Contact number " + phoneNumber + " deleted.");
				return;
			}

		}
		System.out.println("Contact not found.");

	}

	// Search contact
	public void searchContact(String nameQuery) {
		System.out.println("\n" + "Searching for: " + nameQuery);
		for (Contact c : contacts) {
			if (c.name.toLowerCase().contains(nameQuery.toLowerCase())) {
				System.out.println("Found: " + c);
			}
		}
	}

	public void displayAll() {
		System.out.println("\n" + "Contact List:");
		for (Contact c : contacts)
			System.out.println("Name: " + c.name + "\n" + "Number: " + c.phoneNumber + "\n");
	}
}