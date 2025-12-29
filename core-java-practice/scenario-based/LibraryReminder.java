package practice_problems;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class LibraryReminder {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		System.out.println("--- Library Fine Calculator ---");

		for (int i = 1; i <= 5; i++) {
			System.out.println("Book #" + i + " :");

			System.out.print("Enter Due Date (dd-mm-yyyy): ");
			String d1 = scanner.nextLine();
			LocalDate dueDate = LocalDate.parse(d1, formatter);

			System.out.print("Enter Return Date (dd-mm-yyyy): ");
			String d2 = scanner.nextLine();
			LocalDate returnDate = LocalDate.parse(d2, formatter);

			int fine = calculateFine(returnDate, dueDate);
			displayFineDetails(fine);
			System.out.println();
		}

		scanner.close();
	}

	public static int calculateFine(LocalDate returnDate, LocalDate dueDate) {
		long daysLate = ChronoUnit.DAYS.between(returnDate, dueDate);
		if (daysLate >= 0) {
			return 0;
		}

		return (int) -daysLate * 5;
	}

	public static void displayFineDetails(int fine) {
		if (fine > 0) {
			System.out.println("Book returned LATE. Total Fine: ₹" + fine);
		} else {
			System.out.println("Returned on time. No fine.");
		}
	}
}
