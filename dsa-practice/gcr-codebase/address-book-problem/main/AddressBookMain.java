package main;

import java.util.Scanner;

import model.Person;
import repository.AddressBookRepository;
import service.AddressBookService;
import service.AddressBookServiceImp;

public class AddressBookMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		AddressBookRepository repository = new AddressBookRepository();
		AddressBookService service = new AddressBookServiceImp(repository);

		System.out.println("Welcome to Address Book Program");

		System.out.print("Enter Address Book Name: ");
		String bookName = sc.nextLine();
		service.createAddressBook(bookName);

		while (true) {

			System.out.println("\n===== MENU =====");
			System.out.println("1. Add Contact");
			System.out.println("2. Edit Contact");
			System.out.println("3. Delete Contact");
			System.out.println("4. Exit");
			System.out.println("5. Search Person by City");
			System.out.println("6. Search Person by State");
			System.out.println("7. Count by City");
			System.out.println("8. Count by State");
			System.out.println("9. Sort by Name");
			System.out.println("10. Sort by City");
			System.out.println("11. Sort by State");
			System.out.println("12. Sort by Zip");

			System.out.print("Choose option: ");
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {

			case 1:
				Person person = createPerson(sc);
				service.addPerson(bookName, person);
				break;

			case 2:
				System.out.print("Enter First Name to Edit: ");
				String editName = sc.nextLine();

				Person updatedPerson = createPerson(sc);
				boolean edited = service.editPerson(bookName, editName, updatedPerson);

				if (edited) {
					System.out.println("Contact Updated Successfully");
				} else {
					System.out.println("Contact Not Found");
				}
				break;

			case 3:
				System.out.print("Enter First Name to Delete: ");
				String deleteName = sc.nextLine();

				boolean deleted = service.deletePerson(bookName, deleteName);

				if (deleted) {
					System.out.println("Contact Deleted Successfully");
				} else {
					System.out.println("Contact Not Found");
				}
				break;

			case 4:
				System.out.println("Exiting Address Book...");
				sc.close();
				return;

			case 5:
				System.out.print("Enter City: ");
				String city = sc.nextLine();

				service.searchByCity(city).forEach(p -> System.out.println(p.getFname() + " " + p.getLname()));
				break;

			case 6:
				System.out.print("Enter State: ");
				String state = sc.nextLine();

				service.searchByState(state).forEach(p -> System.out.println(p.getFname() + " " + p.getLname()));
				break;

			case 7:
				System.out.print("Enter City: ");
				String countCity = sc.nextLine();

				System.out.println("Total Persons: " + service.countByCity(countCity));
				break;

			case 8:
				System.out.print("Enter State: ");
				String countState = sc.nextLine();

				System.out.println("Total Persons: " + service.countByState(countState));
				break;

			case 9:
				service.sortByName(bookName).forEach(p -> System.out.println(p.getFname() + " " + p.getLname()));
				break;

			case 10:
				service.sortByCity(bookName).forEach(p -> System.out.println(p.getFname() + " - " + p.getCity()));
				break;

			case 11:
				service.sortByState(bookName).forEach(p -> System.out.println(p.getFname() + " - " + p.getState()));
				break;

			case 12:
				service.sortByZip(bookName).forEach(p -> System.out.println(p.getFname() + " - " + p.getZip()));
				break;

			default:
				System.out.println("Invalid Choice. Try again.");
			}
		}
	}

	private static Person createPerson(Scanner sc) {

		System.out.print("First Name: ");
		String firstName = sc.nextLine();

		System.out.print("Last Name: ");
		String lastName = sc.nextLine();

		System.out.print("Address: ");
		String address = sc.nextLine();

		System.out.print("City: ");
		String city = sc.nextLine();

		System.out.print("State: ");
		String state = sc.nextLine();

		System.out.print("Zip: ");
		String zip = sc.nextLine();

		System.out.print("Phone: ");
		String phone = sc.nextLine();

		System.out.print("Email: ");
		String email = sc.nextLine();

		return new Person(firstName, lastName, address, city, state, zip, phone, email);

	}
}
