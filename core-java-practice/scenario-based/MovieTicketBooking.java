package practice_problems;

import java.util.*;

public class MovieTicketBooking {
	private static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int continueBooking = 1;
		while (continueBooking != 0) {
			processCustomer();
			System.out.print("Continue Booking Tickets? ( yes->1 / no->0 ): ");
			continueBooking = sc.nextInt();
			System.out.println();
		}

		System.out.println("\nBooking complete.");
	}

	public static void processCustomer() {

		System.out.println("Available Movies: 1. Action, 2. Comedy, 3. Sci-Fi");
		System.out.print("Enter choice (1-3) : ");
		int movieChoice = sc.nextInt();
		String movieTitle = getMovieTitle(movieChoice);

		System.out.print("Enter seat type (Gold/Silver): ");
		String seatType = sc.next().toLowerCase();
		int seatPrice = calculateSeatPrice(seatType);

		System.out.print("Would you like snacks? (yes/no): ");
		boolean wantsSnacks = sc.next().equalsIgnoreCase("yes");
		int snackPrice = 0;
		if (wantsSnacks) {
			snackPrice = calculateSnackPrice();
		}

		int totalBill = seatPrice + snackPrice;
		displayInvoice(movieTitle, seatType, seatPrice, snackPrice, totalBill);
	}

	public static String getMovieTitle(int choice) {
		switch (choice) {
		case 1:
			return "Action: Mad Max";
		case 2:
			return "Comedy: The Hangover";
		case 3:
			return "Sci-Fi: Interstellar";
		default:
			return "Unknown Movie";
		}
	}

	public static int calculateSeatPrice(String type) {
		if (type.equals("gold"))
			return 500;
		else
			return 300;
	}

	public static int calculateSnackPrice() {
		System.out.println("1. Popcorn (₹150) | 2. Coke (₹100) | 3. Combo (₹220)");
		System.out.print("Select snack: ");
		int choice = sc.nextInt();

		return switch (choice) {
		case 1 -> 150;
		case 2 -> 100;
		case 3 -> 220;
		default -> 0;
		};
	}

	public static void displayInvoice(String movie, String seat, int sPrice, int snkPrice, int total) {
		System.out.println("\n------- Ticket Reciept -------");
		System.out.println("Movie: " + movie);
		System.out.println("Seat:  " + seat.toUpperCase() + " (₹" + sPrice + ")");
		System.out.println("Snacks: ₹" + snkPrice);
		System.out.println("TOTAL BILL: ₹" + total);
	}

}