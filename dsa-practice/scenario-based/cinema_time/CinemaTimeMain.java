package week3.cinema_time;

public class CinemaTimeMain {
	public static void main(String[] args) {

		CinemaManager cm = new CinemaManager();

		try {
			cm.addMovie("DDLJ", "18:30");
			cm.addMovie("Border", "05:15");
			cm.addMovie("Batman", "25:99");
		} catch (InvalidTimeFormatException e) {
			System.out.println(e.getMessage());
		}

		cm.displayAllMovies();
		cm.searchMovie("Bor");
		cm.generateReport();
	}
}
