package linked_list;

import java.util.*;

public class TicketReservationApp {
	public static void main(String[] args) {
		TicketReservationSystem system = new TicketReservationSystem();

		system.addTicket(1001, "John Doe", "Inception", "A12", "14:00");
		system.addTicket(1002, "Jane Smith", "Avatar 2", "B05", "17:30");
		system.addTicket(1003, "Alice Brown", "Inception", "A13", "14:00");

		system.displayTickets();
		System.out.println("\nSearching for movie 'Inception':");
		system.search("Inception");

		System.out.println("\nTotal tickets: " + system.getTotalTickets());

		system.removeTicket(1002);
		system.displayTickets();
	}
}

class Ticket {
	int ticketId;
	String customerName;
	String movieName;
	String seatNumber;
	String bookingTime;
	Ticket next;

	public Ticket(int id, String name, String movie, String seat, String time) {
		this.ticketId = id;
		this.customerName = name;
		this.movieName = movie;
		this.seatNumber = seat;
		this.bookingTime = time;
	}
}

class TicketReservationSystem {
	private Ticket head = null;
	private Ticket tail = null;
	private int ticketCount = 0;

	// Add ticket at the end
	public void addTicket(int id, String name, String movie, String seat, String time) {
		Ticket newTicket = new Ticket(id, name, movie, seat, time);
		if (head == null) {
			head = newTicket;
			tail = newTicket;
			tail.next = head; 
		} else {
			tail.next = newTicket;
			tail = newTicket;
			tail.next = head; 
		}
		ticketCount++;
		System.out.println("Ticket reserved for " + name + " (ID: " + id + ")");
	}

	// Remove ticket by ID
	public void removeTicket(int id) {
		if (head == null) {
			System.out.println("No reservations found.");
			return;
		}

		Ticket curr = head;
		Ticket prev = tail;

		do {
			if (curr.ticketId == id) {
				if (curr == head && curr == tail) {
					// Only one ticket exists
					head = tail = null;
				} else {
					prev.next = curr.next;
					if (curr == head)
						head = head.next;
					if (curr == tail)
						tail = prev;
				}
				ticketCount--;
				System.out.println("Ticket ID " + id + " has been cancelled.");
				return;
			}
			prev = curr;
			curr = curr.next;
		} while (curr != head);

		System.out.println("Ticket ID " + id + " not found.");
	}

	// Display current tickets
	public void displayTickets() {
		if (head == null) {
			System.out.println("The reservation list is empty.");
			return;
		}
		Ticket temp = head;
		System.out.println("\n--- Current Ticket Reservations ---");
		do {
			System.out.println("ID: " + temp.ticketId + " | Customer: " + temp.customerName + " | Movie: "
					+ temp.movieName + " | Seat: " + temp.seatNumber);
			temp = temp.next;
		} while (temp != head);
	}

	// Search by Name or Movie
	public void search(String query) {
		if (head == null)
			return;
		Ticket temp = head;
		boolean found = false;
		do {
			if (temp.customerName.equalsIgnoreCase(query) || temp.movieName.equalsIgnoreCase(query)) {
				System.out.println("Match Found -> ID: " + temp.ticketId + ", Customer: " + temp.customerName
						+ ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber);
				found = true;
			}
			temp = temp.next;
		} while (temp != head);
		if (!found)
			System.out.println("No records matching '" + query + "' found.");
	}

	// Total Booked Tickets
	public int getTotalTickets() {
		return ticketCount;
	}
}
