package week2.event_manager;

import java.util.*;

public class BookingPortal {
	public static void main(String[] args) {
		Ticket[] tickets = { new Ticket("Rock Concert", 150.0), new Ticket("Local Play", 45.0),
				new Ticket("Stadium Game", 300.0), new Ticket("Movie Night", 15.0), new Ticket("Jazz Club", 85.0) };

		TicketSorter sorter = new TicketSorter();
		sorter.quickSort(tickets, 0, tickets.length - 1);

		System.out.println("Top 5 Cheapest Tickets:");
		for (int i = 0; i < Math.min(tickets.length, 5); i++) {
			System.out.println(tickets[i]);
		}
	}
}