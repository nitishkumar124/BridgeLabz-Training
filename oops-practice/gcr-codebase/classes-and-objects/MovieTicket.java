package level2;

public class MovieTicket {
	String movieName;
	String seatNumber;
	double price;
	boolean booked = false;

	void bookTicket(String movie, String seat, double cost) {
		if (!booked) {
			movieName = movie;
			seatNumber = seat;
			price = cost;
			booked = true;
		} else {
			System.out.println("House full!!! sorry..... Ticket already booked");
		}
	}

	void display() {
		if (!booked) {
			System.out.println("Ticket have not booked yet....");
		} else {
			System.out.println("Ticket booked for movie: " + movieName);
			System.out.println("Seat Number: " + seatNumber);
			System.out.println("Price: $" + price);
		}
	}

	public static void main(String[] args) {
		MovieTicket m1 = new MovieTicket();
		m1.display();
		m1.bookTicket("Dragon", "A10", 120);
		m1.bookTicket("Dragon", "A10", 120);
		m1.display();

	}
}